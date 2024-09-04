package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESUL_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val result_imc = intent.getFloatExtra(KEY_RESUL_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result_imc.toString()

        var result_classificacao:String = ""
        if (result_imc  <= 18.5f){
            result_classificacao = "MAGREZA"
        } else if (18.5f < result_imc  && result_imc  <= 24.9f) {
            result_classificacao = "NORMAL"
        } else if (24.9f < result_imc  && result_imc  <= 29.9f){
            result_classificacao ="OBESIDADE I"
        } else if (29.9f < result_imc  && result_imc  < 39.9f){
            result_classificacao = "OBESIDADE II"
        } else {
            result_classificacao = "OBESIDADE GRAVE"
        }

        tvClassificacao.text = result_classificacao

    }
}