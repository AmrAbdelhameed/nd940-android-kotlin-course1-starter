package com.udacity.shoestore.ui.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class HomeViewModel() : ViewModel() {
    private var shoeListMutableLiveDate = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> = shoeListMutableLiveDate

    init {
        shoeListMutableLiveDate.value = mutableListOf(Shoe("Shoe1", 38.toString(), "Shoe Store", "It's very good quality"))
    }

    fun addToList(shoe: Shoe) {
        shoeListMutableLiveDate.value?.add(
            Shoe(
                shoe.name,
                shoe.size,
                shoe.company,
                shoe.description
            )
        )
    }
}