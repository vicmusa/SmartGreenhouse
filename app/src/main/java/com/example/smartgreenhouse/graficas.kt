package com.example.smartgreenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class graficas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graficas)

        GraficaHumedad()
    }

    fun GraficaHumedad() {
        val grafhume = findViewById<Button>(R.id.grafhum)
        grafhume.setOnClickListener {
            val Intent = Intent(this, grafhumedad::class.java)
            startActivity(Intent)
        }

    }
}