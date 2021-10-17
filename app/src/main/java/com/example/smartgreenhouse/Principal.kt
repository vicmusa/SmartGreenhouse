package com.example.smartgreenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        initEvents()
        initEvents1()
        initEvents2()
        initEvents3()
    }


    fun initEvents() {
        val boton = findViewById<Button>(R.id.menu)
        boton.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

    }

    fun initEvents1() {
        val boton1 = findViewById<Button>(R.id.rango)
        boton1.setOnClickListener {
            val Intent = Intent(this, rango::class.java)
            startActivity(Intent)
        }

    }


    fun initEvents2() {
        val boton2 = findViewById<Button>(R.id.grafica)
        boton2.setOnClickListener {
            val Intent = Intent(this, graficas::class.java)
            startActivity(Intent)
        }

    }


    fun initEvents3() {
        val boton3 = findViewById<Button>(R.id.actuadores)
        boton3.setOnClickListener {
            val Intent = Intent(this, actuadores::class.java)
            startActivity(Intent)
        }

    }

}






