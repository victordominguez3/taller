import factories.PlantillaFactory
import models.*
import java.lang.Exception

/**
 * Funcion que muestra por pantalla el menú
 */

fun menu() {

    println("\n---------- GESTIÓN DE LA PLANTILLA DE UN TALLER ----------")
    println("1.\tCrear otra plantilla")
    println("2.\tVer plantilla entera")
    println("3.\tVer plantilla por tipos")
    println("4.\tOrdenar plantilla")
    println("5.\tVer sumario de nóminas")
    println("6.\tDespedir a una persona")
    println("7.\tContratar a una persona")
    println("8.\tSalir")

}

/**
 * Funcion MENU para elegir el tipo de lista
 * @param plantilla Array<Persona?>
 */

fun menuTipos(plantilla: Array<Persona?>) {

    var resp: String
    var respRegex = Regex("[1-8]")

    do {
        println("\n1.\tVer jefes del taller")
        println("2.\tVer trabajadores del taller")
        println("3.\tVer trabajadores sin especialidad del taller")
        println("4.\tVer chapistas del taller")
        println("5.\tVer electricistas del taller")
        println("6.\tVer trabajadores que no son chapistas del taller")
        println("7.\tVer trabajadores que no son electricistas del taller")
        println("8.\tVolver atrás")

        print("\nSeleccione una acción: ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("Seleccione una acción válida: ")
            resp = readln()
        }

        when (resp) {
            "1" -> verJefes(plantilla)
            "2" -> verTrabajadores(plantilla)
            "3" -> verTrabajadoresSinEspecialidad(plantilla)
            "4" -> verChapistas(plantilla)
            "5" -> verElectricistas(plantilla)
            "6" -> verTrabajadoresNoChapistas(plantilla)
            "7" -> verTrabajadoresNoElectricistas(plantilla)
        }

    } while (resp != "8")

}

/**
 * Funcion MENU para elegir el tipo de ordenación y ver la lista ordenada
 * @param plantilla Array<Persona?>
 */

fun menuOrdenar(plantilla: Array<Persona?>) {

    var resp: String
    var respRegex = Regex("[1-5]")

    do {
        println("\n1.\tOrdenar por experiencia de menor a mayor")
        println("2.\tOrdenar por experiencia de mayor a menor")
        println("3.\tOrdenar por salario de menor a mayor")
        println("4.\tOrdenar por salario de mayor a menor")
        println("5.\tVolver atrás")

        print("\nSeleccione una acción: ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("Seleccione una acción válida: ")
            resp = readln()
        }

        when (resp) {
            "1" -> imprimirPlantilla(ordenarExperiencia(plantilla))
            "2" -> imprimirPlantilla(ordenarExperiencia(plantilla).reversedArray())
            "3" -> imprimirPlantilla(ordenarSalario(plantilla))
            "4" -> imprimirPlantilla(ordenarSalario(plantilla).reversedArray())
        }

    } while (resp != "5")
}

/**
 * Función que ordena la plantilla de menor a mayor por experiencia
 * @param plantilla Array<Persona?>
 * @return Plantilla ordenada por experiencia
 */

fun ordenarExperiencia(plantilla: Array<Persona?>): Array<Persona?> {

    val plantillaOrdenada = plantilla
    var min = 0
    var guardar: Persona?

    for (i in 0 until plantillaOrdenada.size - 1) {
        min = i
        for (j in i+1 until plantillaOrdenada.size) {
            if (plantillaOrdenada[i] != null && plantillaOrdenada[j] != null && plantillaOrdenada[j]!!.experiencia < plantillaOrdenada[min]!!.experiencia) {
                min = j

            }
        }
        guardar = plantillaOrdenada[i]
        plantillaOrdenada[i] = plantillaOrdenada[min]
        plantillaOrdenada[min] = guardar
    }

    return plantillaOrdenada
}

/**
 * Función que ordena la plantilla de menor a mayor por salario
 * @param plantilla Array<Persona?>
 * @return Plantilla ordenada por salario
 */

fun ordenarSalario(plantilla: Array<Persona?>): Array<Persona?> {

    val plantillaOrdenada = plantilla
    var min = 0
    var guardar: Persona?

    for (i in 0 until plantillaOrdenada.size - 1) {
        min = i
        for (j in i+1 until plantillaOrdenada.size) {
            if (plantillaOrdenada[i] != null && plantillaOrdenada[j] != null && plantillaOrdenada[j]!!.salario < plantillaOrdenada[min]!!.salario) {
                min = j
            }
        }
        guardar = plantillaOrdenada[i]
        plantillaOrdenada[i] = plantillaOrdenada[min]
        plantillaOrdenada[min] = guardar
    }

    return plantillaOrdenada
}

/**
 * Función MENU para elegir el tipo de sumatorio de nóminas
 * @param plantilla Array<Persona?>
 */

fun menuNominas(plantilla: Array<Persona?>) {

    var resp: String
    var respRegex = Regex("[1-7]")

    do {
        println("\n1.\tVer el sumatorio de las nóminas del taller")
        println("2.\tVer el sumatorio de las nóminas de los jefes del taller")
        println("3.\tVer el sumatorio de las nóminas de los trabajadores sin especialidad")
        println("4.\tVer el sumatorio de las nóminas de los chapistas")
        println("5.\tVer el sumatorio de las nóminas de los electricistas")
        println("6.\tVer el sumatorio de las nóminas de todos los trabajadores")
        println("7.\tVolver atrás")

        print("\nSeleccione una acción: ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("Seleccione una acción válida: ")
            resp = readln()
        }

        when (resp) {
            "1" -> verSumatorio(plantilla)
            "2" -> verSumatorioJefesTaller(plantilla)
            "3" -> verSumatorioTrabajadoresSinEspecialidad(plantilla)
            "4" -> verSumatorioChapistas(plantilla)
            "5" -> verSumatorioElectricistas(plantilla)
            "6" -> verSumatorioTrabajadores(plantilla)
        }

    } while (resp != "7")

}

/**
 * Función para despedir un trabajador y ssacarlo de la plantilla
 * @param plantilla Array<Persona?>
 */

fun despedirPersona(plantilla: Array<Persona?>) {

    var jefe: JefeTaller
    var trabajadorADespedir: Trabajador

    if (hayTrabajadores(plantilla)) {
        jefe = seleccionarJefe(plantilla) as JefeTaller
        trabajadorADespedir = seleccionarTrabajadorADespedir(plantilla, jefe) as Trabajador

        for (i in plantilla.indices) {
            if (plantilla[i]!!.equals(trabajadorADespedir)) {
                plantilla[i] = null
                jefe.personasACargo--
                println("\nTRABAJADOR DESPEDIDO")
            }
        }

    } else println("\nNo hay trabajadores que despedir")

}

/**
 * Función que devuelve si existen Trabajadores en la plantilla
 * @param plantilla Array<Persona?>
 * @return Boolean (True = Hay trabajadores, False = No hay Trabajadores)
 */

fun hayTrabajadores(plantilla: Array<Persona?>): Boolean {

    for (i in plantilla) {
        if (i is Trabajador) {
            return true
        }
    }

    return false
}

/**
 * Función que sirve para seleccionar un jefe para despedir un trabajador a su cargo
 * @param plantilla Array<Persona?>
 * @return El jefe que va a despedir
 */

fun seleccionarJefe(plantilla: Array<Persona?>): Persona? {

    val numJefes = numJefesTaller(plantilla).toInt()
    var resp: Int = 0
    var cont = 1
    var arrayPos = Array<Int>(numJefes) {-1} //Guardamos en un array las posiciones de los jefes

    println()

    for (i in plantilla.indices) {
        if (plantilla[i] is JefeTaller) {
            println("$cont ${plantilla[i]}")
            arrayPos[cont-1] = i
            cont++
        }
    }

    do {
        try {
            print("\nSeleccione un jefe: ")
            resp = readln().toInt()
            while (resp !in 1..numJefes) {
                print("Seleccione una acción válida: ")
                resp = readln().toInt()
            }
        } catch (e: Exception) {
            println("Debe introducir un número")
        }
        if ((plantilla[arrayPos[resp-1]] as JefeTaller).personasACargo == 0) {
            println("\nEl jefe seleccionado no tiene personas a cargo")
            resp = 0
        }
    } while (resp !in 1..numJefes)

    return plantilla[arrayPos[resp-1]]
}

/**
 * Función que sirve para elegir el trabajador que un jefe dado va a despedir
 * @param plantilla Array<Persona?>
 * @param jefe JefeTaller
 * @return El trabajador a despedir
 */

fun seleccionarTrabajadorADespedir(plantilla: Array<Persona?>, jefe: JefeTaller): Persona? {

    val numTrabajadores = numTrabajadoresDelJefe(plantilla, jefe)
    var resp: Int = 0
    var cont = 1
    var arrayPos = Array<Int>(numTrabajadores) {-1}

    println("\nPERSONAS A CARGO DEL $jefe")
    println()

    for (i in plantilla.indices) {
        if (plantilla[i] is Trabajador && (plantilla[i] as Trabajador).jefe.equals(jefe)) {
            println("$cont ${plantilla[i]}")
            arrayPos[cont-1] = i
            cont++
        }
    }

    do {
        try {
            print("\nSeleccione un trabajador: ")
            resp = readln().toInt()
            while (resp !in 1..numTrabajadores) {
                print("Seleccione una acción válida: ")
                resp = readln().toInt()
            }
        } catch (e: Exception) {
            println("Debe introducir un número")
        }
    } while (resp !in 1..numTrabajadores)

    return plantilla[arrayPos[resp-1]]
}

/**
 * Función que nos devuelve el número de trabajadores que tiene un jefe a su cargo
 * @param plantilla Array<Persona?>
 * @param jefe JefeTaller
 * @return Número de trabajadores
 */

fun numTrabajadoresDelJefe(plantilla: Array<Persona?>, jefe: JefeTaller): Int {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i.jefe.equals(jefe)) {
            cont++
        }
    }
    return cont
}

/**
 * Función que sirve para contratar una persona y añadirla a la plantilla
 * @param plantilla Array<Persona?>
 */

fun contratarPersona(plantilla: Array<Persona?>) {

    var jefe: JefeTaller
    var persona: Persona
    var contratado: Boolean = false

    if (hayPlazasLibres(plantilla)) {
        jefe = seleccionarJefe(plantilla) as JefeTaller
        persona = PlantillaFactory.crearPersona()
        for (i in plantilla.indices) {
            if (!contratado && plantilla[i] == null) {
                plantilla[i] = persona
                contratado = true
            }
        }
        if (persona is Trabajador) persona.jefe = jefe
        jefe.personasACargo++
        println("\nPERSONA CONTRATADA")
        println(persona)

    } else println("\nNo hay plazas libres")

}

/**
 * Función que nos dice si hay plazas libres o no
 * @param plantilla Array<Persona?>
 * @return Boolean (True = Hay plaza libre, False = No hay plazas libres)
 */

fun hayPlazasLibres(plantilla: Array<Persona?>): Boolean {

    for (i in plantilla) {
        if (i == null) return true
    }
    return false
}

/**
 * Función que muestra por pantalla la plantilla
 * @param plantilla Array<Persona?>
 */

fun imprimirPlantilla(plantilla: Array<Persona?>) {

    println()

    for (i in plantilla) {
        if (i != null) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Jefes de la plantilla
 * @param plantilla Array<Persona?>
 */

fun verJefes(plantilla: Array<Persona?>) {

    println("\nHay " + numJefesTaller(plantilla) + " jefes de taller")
    println()

    for (i in plantilla) {
        if (i is JefeTaller) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Trabajadores de la plantilla
 * @param plantilla Array<Persona?>
 */

fun verTrabajadores(plantilla: Array<Persona?>) {

    println("\nHay " + numTrabajadores(plantilla) + " trabajadores")
    println()

    for (i in plantilla) {
        if (i is Trabajador) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Trabjadores sin especialidad de la plantilla
 * @param plantilla Array<Persona?>
 */

fun verTrabajadoresSinEspecialidad(plantilla: Array<Persona?>) {

    println("\nHay " + numTrabajadoresSinEspecialidad(plantilla) + " trabajadores sin especialidad")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Chapistas de la plantilla
 * @param plantilla Array<Persona?>
 */

fun verChapistas(plantilla: Array<Persona?>) {

    println("\nHay " + numChapistas(plantilla) + " chapistas")
    println()

    for (i in plantilla) {
        if (i is Chapista) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Electricistas de la plantilla
 * @param plantilla Array<Persona?>
 */

fun verElectricistas(plantilla: Array<Persona?>) {

    println("\nHay " + numElectricistas(plantilla) + " electricistas")
    println()

    for (i in plantilla) {
        if (i is Electricista) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Trabjadores no chapistas de la plantilla
 * @param plantilla Array<Persona?>
 */

fun verTrabajadoresNoChapistas(plantilla: Array<Persona?>) {

    println("\nHay " + numTrabajadoresNoChapistas(plantilla) + " trabajadores que no son chapistas")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Trabjadores no electricistas de la plantilla
 * @param plantilla Array<Persona?>
 */

fun verTrabajadoresNoElectricistas(plantilla: Array<Persona?>) {

    println("\nHay " + numTrabajadoresNoElectricistas(plantilla) + " trabajadores que no son electricistas")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Electricista) {
            println(i)
        }
    }
}

/**
 * Función que sirve para ver el sumatorio de nóminas de todo el taller
 * @param plantilla Array<Persona?>
 */

fun verSumatorio(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i != null ) suma += i.salario
    }

    println("\nLa suma de nóminas del taller es de $suma€")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de los Jefes
 * @param plantilla Array<Persona?>
 */

fun verSumatorioJefesTaller(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is JefeTaller) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de los jefes del taller es de $suma€")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de los Trabajadores sin especialidad
 * @param plantilla Array<Persona?>
 */

fun verSumatorioTrabajadoresSinEspecialidad(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de los trabajadores sin especialidad es de $suma€")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de los Chapistas
 * @param plantilla Array<Persona?>
 */

fun verSumatorioChapistas(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Chapista) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de los chapistas es de $suma€")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de los Electricistas
 * @param plantilla Array<Persona?>
 */

fun verSumatorioElectricistas(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Electricista) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de los electricistas es de $suma€")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de todos los Trabajadores
 * @param plantilla Array<Persona?>
 */

fun verSumatorioTrabajadores(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Trabajador) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de todos los trabajadores es de $suma€")
}

/**
 * Funcion que nos devuelve una cadena con el número de Jefes de taller
 * @param plantilla Array<Persona?>
 * @return String
 */

fun numJefesTaller(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is JefeTaller) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Trabajadores
 * @param plantilla Array<Persona?>
 * @return String
 */

fun numTrabajadores(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Trabjadores sin especialidad
 * @param plantilla Array<Persona?>
 * @return String
 */

fun numTrabajadoresSinEspecialidad(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Chapistas
 * @param plantilla Array<Persona?>
 * @return String
 */

fun numChapistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Chapista) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Electricistas
 * @param plantilla Array<Persona?>
 * @return String
 */

fun numElectricistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Electricista) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Trabjadores no chapistas
 * @param plantilla Array<Persona?>
 * @return String
 */

fun numTrabajadoresNoChapistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Trabajadores no electricistas
 * @param plantilla Array<Persona?>
 * @return String
 */

fun numTrabajadoresNoElectricistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Electricista) {
            cont++
        }
    }
    return "$cont"
}