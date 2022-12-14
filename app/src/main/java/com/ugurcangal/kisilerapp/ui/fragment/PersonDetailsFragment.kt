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
import androidx.navigation.fragment.navArgs
import com.ugurcangal.kisilerapp.R
import com.ugurcangal.kisilerapp.databinding.FragmentPersonDetailsBinding
import com.ugurcangal.kisilerapp.ui.viewmodel.PersonDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailsFragment : Fragment() {
    private lateinit var binding : FragmentPersonDetailsBinding
    private lateinit var viewModel: PersonDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonDetailsViewModel by viewModels()
        viewModel = tempViewModel
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
        viewModel.guncelle(kisiId, kisiAd, kisiTel)
        findNavController().navigate(R.id.action_personDetailsFragment_to_homeFragment)
        Toast.makeText(context,"Kayıt Güncellendi!", Toast.LENGTH_SHORT).show()
    }

}