package com.ugurcangal.kisilerapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.ugurcangal.kisilerapp.R

fun Navigation.gecisYap(view :View, id: Int ){
    findNavController(view).navigate(id)
}

fun Navigation.gecisYap(view :View, id: NavDirections ){
    findNavController(view).navigate(id)
}