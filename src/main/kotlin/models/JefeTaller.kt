package models

import java.util.UUID

class JefeTaller(
    id: UUID,
    nombre: String,
    experiencia: Int,
    salario: Int = 2500,
    var personasACargo: Int
):Persona(id, nombre, experiencia, salario) {
    override fun toString(): String {
        return "Jefe de Taller -> id: $id, nombre: $nombre, experiencia: $experiencia años, salario: $salario€, personas a cargo: $personasACargo personas"
    }

    fun darLatigazos() {
        println("$nombre dando latigazos")
    }

    fun pagar() {

    }

    override fun saludar() {
        super.saludar()
    }
}