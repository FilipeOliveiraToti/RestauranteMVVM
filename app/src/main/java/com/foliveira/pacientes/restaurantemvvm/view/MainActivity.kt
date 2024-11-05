package com.foliveira.pacientes.restaurantemvvm.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.foliveira.pacientes.restaurantemvvm.R
import com.foliveira.pacientes.restaurantemvvm.viewmodel.MainActivityViewModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    private val mealChipGroup: ChipGroup by lazy { findViewById(R.id.cg_meals) }
    private val errorFeedback: TextView by lazy { findViewById(R.id.tv_error) }
    private val mealReadyTextView: TextView by lazy { findViewById(R.id.tv_meal_ready_title) }
    private val mealPhoto: ImageView by lazy { findViewById(R.id.iv_foto) }
    private val viewModel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupChipGroup()
    }

    private fun setupChipGroup() {
        val receitas = viewModel.getReceitas()

        receitas.forEach { receita ->
            val chip = Chip(this).apply {
                text = receita.titulo
            }
            chip.setOnClickListener {
                val receitaInfo = viewModel.getReceita(receita.id)

                if (receitaInfo.error != null) {
                    errorFeedback.visibility = View.VISIBLE
                    errorFeedback.text = receitaInfo.error
                    mealPhoto.visibility = View.GONE
                } else {
                    mealReadyTextView.visibility = View.VISIBLE
                    errorFeedback.visibility = View.GONE
                    mealPhoto.visibility = View.VISIBLE
                    mealPhoto.setImageResource(receitaInfo.foto)
                }
            }
            mealChipGroup.addView(chip)
        }
    }
}