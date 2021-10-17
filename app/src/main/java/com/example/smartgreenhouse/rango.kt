package com.example.smartgreenhouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class rango : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rango)

        //datos

        val NombreDeLaPlanta = findViewById<EditText>(R.id.nombre)
        val Humedad_suelo_min = findViewById<EditText>(R.id.hum_suelo_min)
        val Humedad_suelo_max = findViewById<EditText>(R.id.hum_suelo_max)
        val Humedad_min = findViewById<EditText>(R.id.hum_min)
        val Humedad_max = findViewById<EditText>(R.id.hum_max)
        val Temperaturamin = findViewById<EditText>(R.id.temp_min)
        val Temperaturamax = findViewById<EditText>(R.id.temp_max)
        val Insertar = findViewById<Button>(R.id.Insertar)


        var database = FirebaseDatabase.getInstance().reference

        // Read from the database
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue().toString()
                // Temperatura.setText(value);


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

        Insertar.setOnClickListener {



            if (NombreDeLaPlanta.text.isNotEmpty() && Humedad_min.text.isNotEmpty() && Humedad_max.text.isNotEmpty()
                && Humedad_suelo_min.text.isNotEmpty() && Humedad_suelo_max.text.isNotEmpty() && Temperaturamax.text.isNotEmpty()
                && Temperaturamax.text.isNotEmpty()
            ) {
                var NombrePlanta = NombreDeLaPlanta.text.toString()
                var humre = Humedad_min.text.toString().toInt()
                var humre1 = Humedad_max.text.toString().toInt()
                var hum = Humedad_suelo_min.text.toString().toInt()
                var hum1 = Humedad_suelo_max.text.toString().toInt()
                var temp = Temperaturamin.text.toString().toInt()
                var temp1 = Temperaturamax.text.toString().toInt()

                if (hum < hum1 && humre < humre1 && temp < temp1 ) {


                    if (temp + 3 < temp1){



                        if (humre + 5 < humre1) {

                            if (hum + 5 < hum1) {

                                database.child("datos")
                                    .setValue(Plantas(NombrePlanta,
                                        temp,
                                        temp1,
                                        hum,
                                        hum1,
                                        humre,
                                        humre1))
                                showAlert1()
                            }

                            else {
                                Toast.makeText(this, "El rango en la humedad del suelo tiene que ser mas amplio", Toast.LENGTH_LONG).show()
                            }

                        }

                        else {

                            Toast.makeText(this, "El rango en la humedad tiene que ser mas amplio", Toast.LENGTH_LONG).show()
                        }
                    }


                    else {

                        Toast.makeText(this, "El rango en la temperatura tiene que ser mas amplio", Toast.LENGTH_LONG).show()

                    }
                }

                else {

                    Toast.makeText(this, "Las variables maximas no pueden ser inferior a las minimas", Toast.LENGTH_SHORT).show()
                }

            }
            else {

                showAlert()

            }
        }


    }

    private fun showAlert(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Introduzca todas las variables ")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }

    private fun showAlert1(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Listo!")
        builder.setMessage("todas las variables han sido registradas")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }


}

