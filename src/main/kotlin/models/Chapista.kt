package models

import java.util.*

class Chapista(
    nombre: String,
    experiencia: Int
): Trabajador(nombre, experiencia) {

    override var salario: Int = 1700
    override var horasDiarias: Int = 7

    override fun toString(): String {
        return super.toString()
    }

    override fun saludar() {
        super.saludar()
    }

    fun arreglarChapa() {
        println("El chapista $nombre está arreglando una chapa...")
    }

    override fun descansar() {
        super.descansar()
    }
}