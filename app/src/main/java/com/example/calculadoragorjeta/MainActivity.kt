package com.example.calculadoragorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextValorConta: EditText
    private lateinit var editTextPorcentagemGorjeta: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        editTextValorConta = findViewById(R.id.editTextValorConta)
        editTextPorcentagemGorjeta = findViewById(R.id.editTextPorcentagemGorjeta)
        buttonCalcular = findViewById(R.id.buttonCalcular)
        textViewResultado = findViewById(R.id.textViewResultado)

        
        buttonCalcular.setOnClickListener {
            calcularGorjeta()
        }
    }

    private fun calcularGorjeta() {
        val valorContaText = editTextValorConta.text.toString()
        val percentualGorjetaText = editTextPorcentagemGorjeta.text.toString()

        
        if (valorContaText.isNotEmpty() && percentualGorjetaText.isNotEmpty()) {
            val valorConta = valorContaText.toDoubleOrNull()
            val percentualGorjeta = percentualGorjetaText.toDoubleOrNull()

        
            if (valorConta != null && percentualGorjeta != null) {
                val gorjeta = valorConta * (percentualGorjeta / 100)
                val total = valorConta + gorjeta

                
                textViewResultado.text = "Gorjeta: R$ %.2f\nTotal: R$ %.2f".format(gorjeta, total)
            } else {
                textViewResultado.text = "Por favor, insira valores válidos."
            }
        } else {
            textViewResultado.text = "Por favor, preencha todos os campos."
        }
    }
}
