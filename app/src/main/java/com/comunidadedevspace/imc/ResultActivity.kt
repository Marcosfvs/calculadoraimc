package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESUL_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result_imc = intent.getFloatExtra(KEY_RESUL_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result_imc.toString()

        var result_classificacao = ""

        when {
            result_imc <= 18.5f -> {
                result_classificacao = "MAGREZA"
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.perigo))
            }

            18.5f < result_imc && result_imc <= 24.9f -> {
                result_classificacao = "NORMAL"
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.normal))
            }

            24.9f < result_imc && result_imc <= 29.9f -> {
                result_classificacao = "OBESIDADE I"
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.alerta))
            }

            29.9f < result_imc && result_imc < 39.9f -> {
                result_classificacao = "OBESIDADE II"
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.perigo))
            }

            else -> {
                result_classificacao = "OBESIDADE GRAVE"
                tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.perigo))
            }
        }
        tvClassificacao.text = result_classificacao
    }
}
