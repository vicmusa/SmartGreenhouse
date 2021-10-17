package com.example.smartgreenhouse

class Boton {

    var Riego = 0
    var Ventiladores=0
    var manual=0
    var Calefaccion = 0
    var Luz = 0
    var aspersor = 0

    constructor(Riego:Int,Calefaccion:Int,Ventiladores:Int, manual:Int, Luz:Int, aspersor: Int) {
        this.Riego = Riego
        this.Ventiladores= Ventiladores
        this.manual= manual
        this.Calefaccion = Calefaccion
        this.Luz = Luz
        this.aspersor = aspersor

    }

}