package models

import java.util.UUID

abstract class Persona(
    val nombre: String,
    val apellido: String,
    val experiencia: Int
) {
    val id: UUID = UUID.randomUUID()
    open var salario: Int = 0
    open fun saludar() {
        println("Soy $nombre $apellido, con id: $id, y tengo $experiencia años de experiencia.")
    }
}