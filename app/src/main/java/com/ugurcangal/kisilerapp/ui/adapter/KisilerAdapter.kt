package com.ugurcangal.kisilerapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ugurcangal.kisilerapp.R
import com.ugurcangal.kisilerapp.data.entity.Kisiler
import com.ugurcangal.kisilerapp.databinding.CardDesignBinding
import com.ugurcangal.kisilerapp.ui.fragment.HomeFragmentDirections

class KisilerAdapter(var mContext: Context , var kisilerListesi : List<Kisiler>) :
    RecyclerView.Adapter<KisilerAdapter.CardTasarimHolder>() {

    inner class CardTasarimHolder(binding : CardDesignBinding) : RecyclerView.ViewHolder(binding.root){
     var binding : CardDesignBinding
     init {
         this.binding = binding
     }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding : CardDesignBinding = DataBindingUtil.inflate(layoutInflater,
            R.layout.card_design,parent,false)
        return CardTasarimHolder(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val kisi = kisilerListesi.get(position)
        holder.binding.kisiNesnesi = kisi
        holder.itemView.setOnClickListener {
            val gecis = HomeFragmentDirections.actionHomeFragmentToPersonDetailsFragment(kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        holder.binding.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${kisi.kisiAd} Silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    Log.e("Kişi Sil",kisi.kisiId.toString())
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }
}