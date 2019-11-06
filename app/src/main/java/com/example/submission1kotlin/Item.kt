package com.example.submission1kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (
    val name: String?,
    val desc: String?,
    val image: Int? ) : Parcelable