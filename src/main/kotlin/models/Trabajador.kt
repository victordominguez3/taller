package models

import java.util.UUID

open class Trabajador(
    nombre: String,
    experiencia: Int
): Persona(nombre, experiencia) {

    override var salario: Int = 1200
    open var horasDiarias: Int = 8

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