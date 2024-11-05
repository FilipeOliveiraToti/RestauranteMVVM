package com.foliveira.pacientes.restaurantemvvm.model

import com.foliveira.pacientes.restaurantemvvm.R

class ReceitasRepository {

    fun getReceitas(): List<ReceitaInfoModel> {
        return receitas.map {
            ReceitaInfoModel(it.id, it.titulo)
        }
    }

    fun getReceita(id: Int): ReceitaModel? {
        return receitas.find { it.id == id }
    }


    private val receitas = listOf(
        ReceitaModel(
            id = 1,
            titulo = "Lasanha à Bolonhesa",
            foto = R.drawable.lasanha
        ),
        ReceitaModel(
            id = 2,
            titulo = "Risoto de Camarão",
            foto = R.drawable.risoto
        ),
        ReceitaModel(
            id = 3,
            titulo = "Pad Thai",
            foto = R.drawable.pad_thai
        ),
        ReceitaModel(
            id = 4,
            titulo = "Sopa de Tomate com Manjericão",
            foto = R.drawable.sopatomate
        ),
        ReceitaModel(
            id = 5,
            titulo = "Bolo de Chocolate Simples",
            foto = R.drawable.bolo
        )
    )
}