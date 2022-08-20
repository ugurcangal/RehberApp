package com.ugurcangal.kisilerapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurcangal.kisilerapp.data.entity.Kisiler
import com.ugurcangal.kisilerapp.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var kRepo : KisilerDaoRepository) : ViewModel() {


    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
        kisilerListesi = kRepo.kisileriGetir()
    }

    fun kisileriYukle(){
        kRepo.tumKisilieriAl()
    }

    fun search(searchWord : String){
        kRepo.kisiSearch(searchWord)
    }

    fun sil(kisiId: Int){
        kRepo.kisiSil(kisiId)
    }
}