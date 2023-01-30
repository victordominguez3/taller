package factories

import PERSONAS
import models.*

object PlantillaFactory {

    val nombre = "Factoría de personas"

    val JEFES_TALLER = 1..10
    val CHAPISTAS = 11..40
    val ELECTRICISTAS = 41..50
    val TRABAJADORES = 51..100

    val nombres = arrayOf(
        "Lucas",
        "Sonia",
        "Pedro",
        "Jose Miguel",
        "Rebeca",
        "Natalia",
        "Lucía",
        "Fernando",
        "Víctor",
        "Juan",
        "Hernán",
        "Nuria",
        "Pablo",
        "Rosa",
        "Pedro"
    )
    val apellidos = arrayOf(
        "Pérez",
        "Martín",
        "Dominguez",
        "González",
        "Paz",
        "Maestre",
        "Poza",
        "Gulán",
        "Díaz",
        "Solis",
        "Fuente",
        "Gómez",
        "Mirlo",
        "Quintana",
        "Pérez"
    )
    val rangoExp = 1..10
    val rangoExpJefes = 11..20

    fun crearPlantilla(): Array<Persona?> {

        val plantilla = Array<Persona?>(PERSONAS) { null }

        rellenarPlantilla(plantilla)
        asignarJefes(plantilla)
        actualizarPersonasACargo(plantilla)

        return plantilla
    }

    private fun rellenarPlantilla(plantilla: Array<Persona?>) {

        var num = 0

        for (i in plantilla.indices) {
            if (i != 0) {
                num = (1..100).random()

                if (num in JEFES_TALLER) {
                    plantilla[i] = JefeTaller(nombres.random(), apellidos.random(), rangoExpJefes.random())
                }
                if (num in CHAPISTAS) {
                    plantilla[i] = Chapista(nombres.random(), apellidos.random(), rangoExp.random())
                }
                if (num in ELECTRICISTAS) {
                    plantilla[i] = Electricista(nombres.random(), apellidos.random(), rangoExp.random())
                }
                if (num in TRABAJADORES) {
                    plantilla[i] = Trabajador(nombres.random(), apellidos.random(), rangoExp.random())
                }
            } else plantilla[i] = JefeTaller(nombres.random(), apellidos.random(), rangoExpJefes.random()) //Con esto nos aseguramos de que mínimo se crea un jefe
        }
    }

    private fun asignarJefes(plantilla: Array<Persona?>) {

        for (i in plantilla) {
            if (i is Trabajador) {
                i.jefe = buscarJefe(plantilla)
            }
        }
    }

    private fun buscarJefe(plantilla: Array<Persona?>): JefeTaller {

        var num = -1

        do {
            num = (0 until PERSONAS).random()
            if (plantilla[num] is JefeTaller) {
                return plantilla[num] as JefeTaller
            }
        } while (num != -1) //Bucle infinito hasta que encuentre si o si un jefe

        return plantilla[0] as JefeTaller
    }

    private fun actualizarPersonasACargo(plantilla: Array<Persona?>) {

        for (i in plantilla) {
            if (i is Trabajador) {
                i.jefe.personasACargo++
            }
        }
    }

    fun crearPersona(): Persona {

        var tipo = elegirTipo()

        when (tipo) {
            "1" -> { return Trabajador(nombres.random(), apellidos.random(), rangoExp.random())}
            "2" -> { return Electricista(nombres.random(), apellidos.random(), rangoExp.random())}
            else -> { return Chapista(nombres.random(), apellidos.random(), rangoExp.random())
            }
        }
    }

    private fun elegirTipo(): String {

        var resp: String
        var respRegex = Regex("[1-3]")

        println("\n1. Trabajador")
        println("2. Electricista")
        println("3. Chapista")

        print("\nSeleccione un tipo: ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("Seleccione una acción válida: ")
            resp = readln()
        }

        return resp
    }
}