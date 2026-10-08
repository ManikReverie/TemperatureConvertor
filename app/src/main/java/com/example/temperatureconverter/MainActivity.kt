package com.example.temperatureconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etTemperature: EditText
    private lateinit var btnToFahrenheit: Button
    private lateinit var btnToCelsius: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etTemperature = findViewById(R.id.etTemperature)
        btnToFahrenheit = findViewById(R.id.btnToFahrenheit)
        btnToCelsius = findViewById(R.id.btnToCelsius)
        tvResult = findViewById(R.id.tvResult)

        btnToFahrenheit.setOnClickListener {
            val inputText = etTemperature.text.toString()
            if (inputText.isEmpty()) {
                tvResult.text = "Please enter a temperature"
                return@setOnClickListener
            }

            val celsius = inputText.toDoubleOrNull()
            if (celsius == null) {
                tvResult.text = "Invalid input"
                return@setOnClickListener
            }

            val fahrenheit = (celsius * 9 / 5) + 32
            tvResult.text = "Result: %.2f °F".format(fahrenheit)
        }

        btnToCelsius.setOnClickListener {
            val inputText = etTemperature.text.toString()
            if (inputText.isEmpty()) {
                tvResult.text = "Please enter a temperature"
                return@setOnClickListener
            }

            val fahrenheit = inputText.toDoubleOrNull()
            if (fahrenheit == null) {
                tvResult.text = "Invalid input"
                return@setOnClickListener
            }

            val celsius = (fahrenheit - 32) * 5 / 9
            tvResult.text = "Result: %.2f °C".format(celsius)
        }
    }
}