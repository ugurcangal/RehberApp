package com.ugurcangal.kisilerapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ugurcangal.kisilerapp.R
import com.ugurcangal.kisilerapp.databinding.FragmentPersonRegBinding

class PersonRegFragment : Fragment() {
    private lateinit var binding: FragmentPersonRegBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_reg, container, false)
        binding.personRegFragment = this
        binding.kisiKayitToolbarBaslik = "Kişi Kayıt"


        return binding.root
    }

    fun kayit(kisiAd: String, kisiTel: String){
        Log.e("Kişi Kayıt","$kisiAd - $kisiTel")
    }

}