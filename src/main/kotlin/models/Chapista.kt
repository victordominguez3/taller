package models

import java.util.*

class Chapista(
    id: UUID,
    nombre: String,
    experiencia: Int,
    salario: Int = 1200,
    horasDiarias: Int
): Trabajador(id, nombre, experiencia, salario, horasDiarias) {

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