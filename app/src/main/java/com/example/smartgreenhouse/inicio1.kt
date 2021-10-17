package com.example.smartgreenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio1)

        gotoInicio2()
        omitir1()

    }

    fun gotoInicio2() {
        val vayainicio2 = findViewById<Button>(R.id.voyainicio2)
        vayainicio2.setOnClickListener {
            val Intent = Intent(this, inicio2::class.java)
            startActivity(Intent)
        }

    }

    fun omitir1() {
        val botonomitir1 = findViewById<Button>(R.id.omitir1)
        botonomitir1.setOnClickListener {
            val Intent = Intent(this, Principal::class.java)
            startActivity(Intent)
        }

    }
}

