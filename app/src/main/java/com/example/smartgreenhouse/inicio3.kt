package com.example.smartgreenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inicio3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio3)

        gotoPrincipal()

    }

    fun gotoPrincipal() {
        val boton = findViewById<Button>(R.id.voyaprincipal)
        boton.setOnClickListener {
            val Intent = Intent(this, Principal::class.java)
            startActivity(Intent)
        }

    }


}