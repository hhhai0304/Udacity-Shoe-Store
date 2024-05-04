package com.hohoanghai.shoestore.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Instruction(val title: Int, val subtitle: Int, val image: Int) : Parcelable
