package com.hohoanghai.shoestore.fragment.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hohoanghai.shoestore.model.Shoe

class DetailViewModel : ViewModel() {
    val edtNameText = MutableLiveData<String>()
    val edtSizeText = MutableLiveData<String>()
    val edtCompanyText = MutableLiveData<String>()
    val edtDescriptionText = MutableLiveData<String>()

    fun onSave(): Shoe {
        return Shoe(
            edtNameText.value ?: "Default name",
            edtSizeText.value?.toDouble() ?: 0.0,
            edtCompanyText.value ?: "Default company",
            edtDescriptionText.value ?: "Default description"
        )
    }
}