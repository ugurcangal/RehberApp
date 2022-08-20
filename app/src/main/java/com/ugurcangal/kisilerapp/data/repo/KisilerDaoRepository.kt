package com.ugurcangal.kisilerapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ugurcangal.kisilerapp.data.entity.Kisiler
import com.ugurcangal.kisilerapp.room.KisilerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisilerDaoRepository(var kDao: KisilerDao) {
    var kisilerListesi : MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }


    fun kisileriGetir() : MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }

    fun kisiKayit(kisiAd: String, kisiTel: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0,kisiAd, kisiTel)
            kDao.kisiEkle(yeniKisi)
        }
    }

    fun kisiGuncelle(kisiId: Int, kisiAd: String, kisiTel: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenKisi = Kisiler(kisiId,kisiAd, kisiTel)
            kDao.kisiGuncelle(guncellenenKisi)
        }
    }

    fun kisiSearch(searchWord : String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kDao.kisiArama(searchWord)
        }
    }

    fun kisiSil(kisiId: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenKisi = Kisiler(kisiId,"","")
            kDao.kisiSil(silinenKisi)
            tumKisilieriAl()
        }
    }

    fun tumKisilieriAl(){
       val job = CoroutineScope(Dispatchers.Main).launch {
           kisilerListesi.value = kDao.tumKisiler()
       }
    }
}