package com.example.components3.model

import androidx.annotation.DrawableRes

data class Heroe(
    var name: String,
    val realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
) {
}