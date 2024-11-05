package com.foliveira.pacientes.restaurantemvvm.model

import androidx.annotation.DrawableRes

data class ReceitaModel(
    val id: Int,
    val titulo: String,
    @DrawableRes val foto: Int
)
