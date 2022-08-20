package com.ugurcangal.kisilerapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurcangal.kisilerapp.R
import com.ugurcangal.kisilerapp.data.entity.Kisiler
import com.ugurcangal.kisilerapp.databinding.FragmentHomeBinding
import com.ugurcangal.kisilerapp.ui.adapter.KisilerAdapter
import com.ugurcangal.kisilerapp.ui.viewmodel.HomeViewModel
import com.ugurcangal.kisilerapp.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() , androidx.appcompat.widget.SearchView.OnQueryTextListener{
    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.homeFragment = this

        binding.homeToolbarBaslik = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val adapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter = adapter
        }


        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as androidx.appcompat.widget.SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return binding.root
    }

    fun fabTikla(view:View){
        Navigation.gecisYap(view, R.id.action_homeFragment_to_personRegFragment)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        viewModel.search(p0!!)
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        viewModel.search(p0!!)
        return true
    }


    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

}