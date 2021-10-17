package com.example.smartgreenhouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.*


enum class ProviderType{
    BASIC
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonhoja()
        botonph()



        var database = FirebaseDatabase.getInstance().reference




        //Views
        val phsuelo = findViewById<TextView>(R.id.phsuelo)
        val humrela = findViewById<TextView>(R.id.humerela)
        val humsue = findViewById<TextView>(R.id.humsuelo)
        val tem = findViewById<TextView>(R.id.temprela)
        val temhoja = findViewById<TextView>(R.id.temhoja)
        val iluminancia = findViewById<TextView>(R.id.iluminancia)



        // Read from the database
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var sb =  StringBuilder()
                var cl = StringBuilder()
                var cl1 = StringBuilder()
                var cl2 = StringBuilder()
                var cl3 = StringBuilder()
                var cl4 = StringBuilder()



                    for (i in dataSnapshot.children){
                        var Ph = i.child("Ph").getValue()
                        var humedad = i.child("humedad").getValue()
                        var temperatura = i.child("temperatura").getValue()
                        var humedadDelSuelo = i.child("humedad del suelo").getValue()
                        var Lux = i.child("Lux").getValue()
                        var temphoja = i.child("temperatura de la hoja").getValue()

                        if (Ph != null){

                            sb.append("$Ph\n")

                        }

                        if (humedad != null){

                            cl.append("$humedad\n")

                        }

                        if (temperatura != null){

                            cl1.append("$temperatura\n")


                        }

                        if (humedadDelSuelo != null){

                            cl2.append("$humedadDelSuelo\n")


                        }

                        if (Lux != null){

                            cl3.append("$Lux\n")

                        }

                        if (temphoja != null){

                            sb.append("$temphoja\n")

                        }



                    }



                phsuelo.setText(sb)
                humrela.setText(cl)
                humsue.setText(cl2)
                tem.setText(cl1)
                iluminancia.setText(cl3)
                temhoja.setText(cl4)



            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }
        })

    }

    fun botonhoja() {
        val infohoja = findViewById<Button>(R.id.infohojatemp)
        infohoja.setOnClickListener {
            val Intent = Intent(this, Informaciontemphoja::class.java)
            startActivity(Intent)
        }

    }


    fun botonph() {
        val infoph = findViewById<Button>(R.id.infoph)
        infoph.setOnClickListener {
            val Intent = Intent(this, informacionph::class.java)
            startActivity(Intent)
        }

    }
}








