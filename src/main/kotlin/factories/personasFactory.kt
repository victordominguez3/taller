package factories

import models.Persona

object personasFactory {

    val nombre = "Factoría de personas"

    fun crearPersonaRandom(): Persona {
        val nombres = arrayOf(
            "Lucas Pérez",
            "Sonia Martín",
            "Pedro Domínguez",
            "Jose Miguel González",
            "Rebeca Paz",
            "Natalia Maestre",
            "Lucía Poza",
            "Fernando Gulán",
            "Víctor Díaz",
            "Juan Solis",
            "Hernán Fuente",
            "Nuria Gómez",
            "Pablo Mirlo",
            "Rosa Quintana",
            "Pedro Pérez"
        )
        return Persona(nombres.random(), (1..10).random())
    }
}