package ru.noxis.composeuitemplates.features.ecommerce_ui.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val image: Int,
    val productName: String,
    val productDescription: String,
    val price: String,
    val color: Int,
    val rating: String
): Parcelable

val size = (36..42).toList()