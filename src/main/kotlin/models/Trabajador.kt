package models

import java.util.UUID

open class Trabajador(
    nombre: String,
    apellido: String,
    experiencia: Int
): Persona(nombre, apellido, experiencia) {

    override var salario: Int = 1200
    open var horasDiarias: Int = 8
    open lateinit var jefe: JefeTaller

    constructor(
        nombre: String,
        apellido: String,
        experiencia: Int,
        jefe: JefeTaller
    ): this(nombre, apellido, experiencia) {
        this.jefe = jefe
    }

    override fun toString(): String {
        return "Trabajador -> id: $id, nombre: $nombre $apellido, experiencia: $experiencia años, salario: $salario€, horas diarias: $horasDiarias horas. JEFE: $jefe"
    }

    override fun saludar() {
        super.saludar()
    }

    fun trabajar() {
        println("El trabajador $nombre $apellido está trabajando...")
    }

    open fun descansar() {
        println("El trabajador $nombre $apellido está descansando...")
    }

    fun comer() {
        println("El trabajador $nombre $apellido está comiendo...")
    }
}