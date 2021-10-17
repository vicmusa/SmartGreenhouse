package com.example.smartgreenhouse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Autenticacion : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SmartGreenhouse)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autenticacion)


    val registrar = findViewById<Button>(R.id.registrar)
    val email = findViewById<EditText>(R.id.email)
    val contraseña = findViewById<EditText>(R.id.contraseña)
        val acceder = findViewById<Button>(R.id.acceder)

        registrar.setOnClickListener {
            if (email.text.isNotEmpty() && contraseña.text.isNotEmpty()) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.text.toString(),contraseña.text.toString()).addOnCompleteListener {
            if (it.isSuccessful){

                showHome(it.result?.user?.email?: "", ProviderType.BASIC)

            } else{

                showAlert1()
            }
        }

        }

    }

        acceder.setOnClickListener {
            if (email.text.isNotEmpty() && contraseña.text.isNotEmpty()) {

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(),contraseña.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){

                        showHome(it.result?.user?.email?: "", ProviderType.BASIC)

                    } else{

                        showAlert()
                    }
                }

            }

        }




    }

    private fun showAlert(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Contraseña incorrecta ")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun showAlert1(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("La contraseña tiene que tener al menos 6 caracteres ")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }


    private fun showHome(email: String, provider: ProviderType){
        val homeIntent = Intent(this,inicio1::class.java).apply {
            putExtra("email",email)
            putExtra("provider", provider.name)
        }

        startActivity(homeIntent)
    }
}