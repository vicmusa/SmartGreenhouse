package com.example.smartgreenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio2)

        gotoInicio3()
        omitir2()
    }

    fun gotoInicio3() {
        val boton = findViewById<Button>(R.id.voyainicio3)
        boton.setOnClickListener {
            val Intent = Intent(this, inicio3::class.java)
            startActivity(Intent)
        }

    }

    fun omitir2() {
        val botonomitir2 = findViewById<Button>(R.id.omitir2)
        botonomitir2.setOnClickListener {
            val Intent = Intent(this, Principal::class.java)
            startActivity(Intent)
        }

    }
}