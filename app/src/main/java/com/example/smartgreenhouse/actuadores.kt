package com.example.smartgreenhouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class actuadores : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actuadores)

        var database = FirebaseDatabase.getInstance().reference
        var aux = 0
        var aux1 = 0
        var aux2 = 0
        var aux3 = 0
        var aux4 = 0
        var aux5 = 0

        //Variables de textview
        val logicovent = findViewById<TextView>(R.id.logicovent)
        val logicoluz = findViewById<TextView>(R.id.logicoluz)
        val logicocale = findViewById<TextView>(R.id.logicocale)
        val logicoriego = findViewById<TextView>(R.id.logicoriego)
        val logicomicro = findViewById<TextView>(R.id.logicomicro)


        //Botones
        val Riego = findViewById<Button>(R.id.riego)
        val Ventiladores = findViewById<Button>(R.id.ventilador)
        val Calefaccion = findViewById<Button>(R.id.calefaccion)
        val manual = findViewById<Button>(R.id.manual)
        val Luz = findViewById<Button>(R.id.iluminacion)
        val aspersor = findViewById<Button>(R.id.aspersor)


        // Read from the database
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var kl =  StringBuilder()
                var kl2 = StringBuilder()
                var kl3 = StringBuilder()
                var kl4 = StringBuilder()
                var kl5 = StringBuilder()



                for (i in dataSnapshot.children){
                    var ventiladores = i.child("ventiladores").getValue()
                    var riego = i.child("riego").getValue()
                    var luz = i.child("luz").getValue()
                    var calefaccion = i.child("calefaccion").getValue()
                    var aspersor = i.child("aspersor").getValue()



                    if (ventiladores != null){

                        kl.append("$ventiladores\n")

                    }


                    if (riego != null){

                        kl2.append("$riego\n")

                    }

                    if (luz != null){

                        kl3.append("$luz\n")


                    }

                    if (calefaccion != null){

                        kl4.append("$calefaccion\n")


                    }

                    if (aspersor != null){

                        kl5.append("$aspersor\n")


                    }



                }



                logicovent.setText(kl)
                logicoriego.setText(kl2)
                logicoluz.setText(kl3)
                logicocale.setText(kl4)
                logicomicro.setText(kl5)




            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })


        // Envio los botones
        manual.setOnClickListener {
            aux3 = 1 - aux3

            if (aux3 == 0) {

                aux = 0
                aux1 = 0
                aux2 = 0

                database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4,aux5))

            }

            if (aux3 == 1) {
                database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))


            }
        }



        Riego.setOnClickListener {

            if (aux3 == 1) {
                aux = 1 - aux
                if (aux == 1) {
                    database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))

                }

                if (aux == 0) {

                    database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))


                }

            }
        }

        aspersor.setOnClickListener {

            if (aux3 == 1) {
                aux5 = 1 - aux5
                if (aux5 == 1) {
                    database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4,aux5))

                }

                if (aux5 == 0) {

                    database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))


                }

            }
        }


        Ventiladores.setOnClickListener {

            if (aux3 == 1) {

                aux2 = 1 - aux2
                if (aux2 == 1) {

                    database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))

                }

                if (aux2 == 0) {

                    database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))


                }
            }

        }

        Calefaccion.setOnClickListener {
            if (aux3 == 1) {

                aux1 = 1 - aux1
                if (aux1 == 1) {

                    database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))

                }

                if (aux1 == 0) {

                    database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))


                }
            }

        }


        Luz.setOnClickListener {

            aux4 = 1 - aux4
            if (aux4 == 1) {

                database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))

            }

            if (aux4 == 0) {

                database.child("comandos").setValue(Boton(aux, aux1, aux2, aux3, aux4, aux5))


            }
        }




    }


    }
