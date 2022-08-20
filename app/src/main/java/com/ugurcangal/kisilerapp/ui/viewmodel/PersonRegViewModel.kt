package com.ugurcangal.kisilerapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ugurcangal.kisilerapp.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonRegViewModel @Inject constructor(var kRepo : KisilerDaoRepository) : ViewModel() {


    fun kayit(kisiAd: String, kisiTel: String){
        kRepo.kisiKayit(kisiAd, kisiTel)
    }
}