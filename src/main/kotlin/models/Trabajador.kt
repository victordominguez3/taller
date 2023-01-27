package models

import java.util.UUID

open class Trabajador(
    id: UUID,
    nombre: String,
    experiencia: Int,
    salario: Int = 1200,
    var horasDiarias: Int
): Persona(id, nombre, experiencia, salario) {

    override fun toString(): String {
        return "Trabajador -> id: $id, nombre: $nombre, experiencia: $experiencia años, salario: $salario€, horas diarias: $horasDiarias horas"
    }

    override fun saludar() {
        super.saludar()
    }

    fun trabajar() {
        println("El trabajador $nombre está trabajando...")
    }

    open fun descansar() {
        println("El trabajador $nombre está descansando...")
    }

    fun comer() {
        println("El trabajador $nombre está comiendo...")
    }
}