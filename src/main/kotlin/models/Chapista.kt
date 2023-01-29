package models

import java.util.*

class Chapista(
    nombre: String,
    apellido: String,
    experiencia: Int
): Trabajador(nombre, apellido, experiencia) {

    override var salario: Int = 1700
    override var horasDiarias: Int = 7
    override lateinit var jefe: JefeTaller

    override fun toString(): String {
        return "Chapista -> id: $id, nombre: $nombre $apellido, experiencia: $experiencia años, salario: $salario€, horas diarias: $horasDiarias horas. JEFE: $jefe"
    }

    override fun saludar() {
        super.saludar()
    }

    fun arreglarChapa() {
        println("El chapista $nombre $apellido está arreglando una chapa...")
    }

    override fun descansar() {
        super.descansar()
    }
}