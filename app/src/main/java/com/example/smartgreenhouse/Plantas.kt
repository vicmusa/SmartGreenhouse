package com.example.smartgreenhouse

import android.hardware.Sensor

class Plantas {
    var NombrePlanta=""
    var hum = 0
    var hum1 = 0
    var hum_re = 0
    var hum_re1 = 0
    var Ph = 0
    var temp_min = 0
    var temp_max = 0

    constructor(NombrePlanta:String, temp_min:Int, temp_max:Int,hum:Int, hum1:Int, hum_re:Int, hum_re1:Int ) {
        this.NombrePlanta = NombrePlanta
        this.hum = hum
        this.hum1 = hum1
        this.hum_re = hum_re
        this.hum_re1 = hum_re1
        this.temp_min = temp_min
        this.temp_max = temp_max
    }

}