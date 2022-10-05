package com.udacity.shoestore.ui.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class HomeViewModel() : ViewModel() {
    private var shoeListMutableLiveDate = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> = shoeListMutableLiveDate

    init {
        shoeListMutableLiveDate.value = mutableListOf(Shoe("Shoe1", 38, "Shoe Store", "It's very good quality"))
    }

    fun addToList(name: String, size: String, company: String, description: String) {
        shoeListMutableLiveDate.value?.add(Shoe(name, size.toInt(), company, description))
    }
}