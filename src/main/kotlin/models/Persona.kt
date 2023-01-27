package models

import java.util.UUID

open class Persona(
    val nombre: String,
    val experiencia: Int
) {
    val id: UUID = UUID.randomUUID()
    open var salario: Int = 0
    open fun saludar() {
        println("Soy $nombre, con id: $id, y tengo $experiencia años de experiencia.")
    }
}