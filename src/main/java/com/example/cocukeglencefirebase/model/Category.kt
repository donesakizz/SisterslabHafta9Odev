package com.example.cocukeglencefirebase.model

import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.parcelize.Parcelize


@IgnoreExtraProperties
@Parcelize
data class Category (val categoryName: String? = "") : Parcelable{

}