package com.ugurcangal.kisilerapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ugurcangal.kisilerapp.R
import com.ugurcangal.kisilerapp.databinding.FragmentPersonRegBinding
import com.ugurcangal.kisilerapp.ui.viewmodel.PersonDetailsViewModel
import com.ugurcangal.kisilerapp.ui.viewmodel.PersonRegViewModel
import com.ugurcangal.kisilerapp.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonRegFragment : Fragment() {
    private lateinit var binding: FragmentPersonRegBinding
    private lateinit var viewModel: PersonRegViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonRegViewModel by viewModels()
        viewModel = tempViewModel
    }

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
        viewModel.kayit(kisiAd, kisiTel)
        findNavController().navigate(R.id.action_personRegFragment_to_homeFragment)
        Toast.makeText(context,"Kayıt Başarılı!",Toast.LENGTH_SHORT).show()
    }

}