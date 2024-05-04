package com.hohoanghai.shoestore.fragment.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hohoanghai.shoestore.model.Shoe

class ListingViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>> = _shoes

    init {
        _shoes.value = mutableListOf()
    }

    fun addShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }
}