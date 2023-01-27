package models

import java.util.UUID

abstract class Persona(
    val id: UUID = UUID.randomUUID(),
    val nombre: String,
    val experiencia: Int,
    val salario: Int
) {
    open fun saludar() {
        println("Soy $nombre, con id: $id, y tengo $experiencia años de experiencia.")
    }
}