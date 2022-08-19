package com.ugurcangal.kisilerapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.ugurcangal.kisilerapp.R
import com.ugurcangal.kisilerapp.databinding.FragmentPersonDetailsBinding

class PersonDetailsFragment : Fragment() {
    private lateinit var binding : FragmentPersonDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_details,container,false)
        binding.personDetailsFragment = this
        binding.kisiDetayToolbarBaslik = "Kişi Kayıt"

        val bundle : PersonDetailsFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.kisiNesnesi = gelenKisi

        return binding.root
    }

    fun guncelle(kisiId: Int, kisiAd: String, kisiTel: String){
        Log.e("Kişi Kayıt","$kisiId - $kisiAd - $kisiTel")
    }

}