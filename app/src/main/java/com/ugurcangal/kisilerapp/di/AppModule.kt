package com.ugurcangal.kisilerapp.di

import android.content.Context
import androidx.room.Room
import com.ugurcangal.kisilerapp.data.repo.KisilerDaoRepository
import com.ugurcangal.kisilerapp.room.KisilerDao
import com.ugurcangal.kisilerapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerDaoRepository(kDao : KisilerDao) : KisilerDaoRepository{
        return KisilerDaoRepository(kDao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context : Context) : KisilerDao{
        val vt = Room.databaseBuilder(context, Veritabani::class.java, "rehber.sqlite")
            .createFromAsset("rehber.sqlite").build()
        return vt.getKisilerDao()
    }


}