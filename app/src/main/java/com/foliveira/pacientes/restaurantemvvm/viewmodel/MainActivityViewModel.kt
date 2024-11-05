package com.foliveira.pacientes.restaurantemvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.foliveira.pacientes.restaurantemvvm.model.ReceitasRepository
import com.foliveira.pacientes.restaurantemvvm.view.ReceitaInfoUI
import com.foliveira.pacientes.restaurantemvvm.view.ReceitaUI

class MainActivityViewModel() : ViewModel() {

    private val repository = ReceitasRepository()

    fun getReceitas(): List<ReceitaInfoUI> {
        return repository.getReceitas().map {
            ReceitaInfoUI(it.id, it.titulo)
        }
    }

    fun getReceita(id: Int): ReceitaUI {
        return repository.getReceita(id)?.let {
            ReceitaUI(it.id, it.titulo, it.foto)
        } ?: ReceitaUI(id, "", 0, "Receita não encontrada")
    }
}