package com.foliveira.pacientes.restaurantemvvm.view

import androidx.annotation.DrawableRes

data class ReceitaUI(
    val id: Int,
    val titulo: String,
    @DrawableRes val foto: Int,
    val error: String? = null
)
