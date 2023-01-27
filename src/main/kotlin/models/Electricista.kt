package models

import java.util.*

class Electricista(
    nombre: String,
    experiencia: Int
): Trabajador(nombre, experiencia) {

    override var salario: Int = 1800
    override var horasDiarias: Int = 8

    override fun toString(): String {
        return super.toString()
    }

    override fun saludar() {
        super.saludar()
    }

    override fun descansar() {
        super.descansar()
    }

    fun arreglarElectricidad() {
        println("El electricista $nombre está arreglando electricidad...")
    }
}