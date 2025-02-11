package ru.noxis.composeuitemplates.features.ecommerce_ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import ru.noxis.composeuitemplates.R
import ru.noxis.composeuitemplates.features.ecommerce_ui.data.Product

val blue = Color(0xFFD6FAFF)
val red = Color(0xFFFFE0E3)
val green = Color(0xFFCBEFC3)

val textColor = Color(0xFFB1B1B1)

val products = listOf(
    Product(
        0,
        R.drawable.nike_blue,
        "Nike Air Running",
        "Best of all in just on place. Find your perfect product only here",
        "$130.00",
        color = blue.toArgb(),
        "4.5"
    ),
    Product(
        1,
        R.drawable.nike_red,
        "Nike Air Running",
        "Best of all in just on place. Find your perfect product only here",
        "$130.00",
        color = red.toArgb(),
        "4.5"
    ),
    Product(
        2,
        R.drawable.nike_gree_and_black,
        "Nike Air Running",
        "Best of all in just on place. Find your perfect product only here",
        "$130.00",
        color = green.toArgb(),
        "4.5"
    )
)
