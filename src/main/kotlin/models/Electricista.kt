package models

import java.util.*

class Electricista(
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

    override fun descansar() {
        super.descansar()
    }

    fun arreglarElectricidad() {
        println("El electricista $nombre está arreglando electricidad...")
    }
}