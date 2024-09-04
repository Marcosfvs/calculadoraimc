package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setContentView conecta o xml com o mainactivity

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {


            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()
            //.isNotEmpty é usado para checar se a string está vazia, pode usar: == "" como no JS

            if (pesoStr == "" || alturaStr == "") {
                Snackbar
                    .make(
                        edtPeso,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val peso: Float = pesoStr.toFloat()
                val altura: Float = alturaStr.toFloat()

                val altura2 = altura * altura
                val imc = peso / altura2
                //método para navegar para a próxima tela
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra(KEY_RESUL_IMC,imc)
                startActivity(intent)
            }

        }
    }
}
