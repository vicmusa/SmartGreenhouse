package com.example.smartgreenhouse

import android.graphics.Color
import android.icu.text.UnicodeSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.DropBoxManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.androidplot.xy.*
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.security.KeyStore
import java.sql.Date
import java.text.DateFormat
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.util.*
import kotlin.collections.ArrayList

class grafhumedad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafhumedad)

        //LLAMO LAS VARIABLES
        var database = FirebaseDatabase.getInstance().getReference("datos historicos") // Ejemplo (Sensores/Historicos)
        val listfecha = mutableListOf<Long>()
        val listluz = mutableListOf<String>()
        database.get().addOnCompleteListener {
            if(it.isSuccessful) {
                val result = it.getResult()
                for(i in result!!.children)
                {
                    val fecha =i.key.toString().toLong()
                    Log.e("AQUI", fecha.toString())
                    val luz  = i.child("humedad").value.toString()
                   // val x = i.child("NOMBRE DEL CHILD").tostring().toElvalorquequieres ejemplo toint, tofloat etc etc  tienes que repetir esto con todas las variables que vas a querer graficar
                    listfecha.add(fecha) // Creas listas como tantos valores tengas Fecha siempre tiene que existir
                    listluz.add(luz) // Esto es un ejemplo no me se los valores
                }

                Log.e("AQUI", listluz.toString())

                var entryluz : ArrayList<Entry> = arrayListOf()
                for((i, j) in listluz.withIndex())
                {
                    entryluz.add(Entry(i.toFloat(),j.toFloat())) // Este for lo tienes que repetir con todos los valores
                }

                val lineLuz = LineDataSet(entryluz, "Luz")
               /* lineTemp.color = ContextCompat.getColor(context, R.color.orange)
                lineHr.color = ContextCompat.getColor(context, R.color.red)
                lineSpo2.color = ContextCompat.getColor(context, R.color.blue)
                lineHr.setCircleColor(ContextCompat.getColor(context, R.color.alice_blue))
                lineTemp.setCircleColor(ContextCompat.getColor(context, R.color.alice_blue))
                lineSpo2.setCircleColor(ContextCompat.getColor(context, R.color.alice_blue))

                CON ESTA PARTE EDITAS LOS COLORES DE LA GRAFICA Y EL PUNTO DE LA GRAFICA*/


                val datasetLuz: ArrayList<ILineDataSet> = arrayListOf()
                datasetLuz.add(lineLuz)
                val graph = findViewById<LineChart>(R.id.graficaHume)
                val linedata = LineData(datasetLuz)
                graph.data = linedata
                graph.invalidate()
                val valorX = graph.xAxis

                var label = 4
                if(label< 5 )
                {
                    label = 2
                }
                valorX.labelCount = label
                valorX.position = XAxis.XAxisPosition.BOTTOM
                valorX.valueFormatter = object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        val fdate = DateFormat.getDateTimeInstance()
                        val date = fdate.format(Date((listfecha[value.toInt()] * 1000)))
                        return date.toString()
                    }
                }

            }
        }



    }
}