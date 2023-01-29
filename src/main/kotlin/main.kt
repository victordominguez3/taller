import factories.PlantillaFactory
import models.*
import java.lang.Exception

const val PERSONAS = 50

fun main() {

    var resp: String
    val respRegex = Regex("[1-8]")
    var plantilla: Array<Persona?> = Array<Persona?>(PERSONAS) { null }

    plantilla = PlantillaFactory.crearPlantilla()
    println("SE HA CREADO UNA PLANTILLA ALEATORIA")

    do {
        menu()

        print("\nSeleccione una acción: ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("Seleccione una acción válida: ")
            resp = readln()
        }

        when (resp) {
            "1" -> plantilla = PlantillaFactory.crearPlantilla()
            "2" -> imprimirPlantilla(plantilla)
            "3" -> menuTipos(plantilla)
            "4" -> menuOrdenar(plantilla)
            "5" -> menuNominas(plantilla)
            "6" -> despedirPersona(plantilla)
            "7" -> contratarPersona(plantilla)
        }

    }while (resp != "8")

    println("\nGracias, vuelva pronto")
}

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

fun menuOrdenar(plantilla: Array<Persona?>) {

    var resp: String
    var respRegex = Regex("[1-3]")

    do {
        println("\n1.\tOrdenar por experiencia")
        println("2.\tOrdenar por salario")
        println("3.\tVolver atrás")

        print("\nSeleccione una acción: ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("Seleccione una acción válida: ")
            resp = readln()
        }

        when (resp) {
            "1" -> ordenarExperiencia(plantilla)
            "2" -> ordenarSalario(plantilla)
        }

    } while (resp != "3")
}

fun ordenarExperiencia(plantilla: Array<Persona?>) {

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

    imprimirPlantilla(plantillaOrdenada)
}

fun ordenarSalario(plantilla: Array<Persona?>) {

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

    imprimirPlantilla(plantillaOrdenada)
}

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

fun despedirPersona(plantilla: Array<Persona?>) {

    var jefe: JefeTaller
    var trabajador: Trabajador

    if (hayTrabajadores(plantilla)) {
        jefe = seleccionarJefe(plantilla) as JefeTaller
        trabajador = seleccionarTrabajador(plantilla, jefe) as Trabajador

        for (i in plantilla.indices) {
            if (plantilla[i] == trabajador) {
                plantilla[i] = null
                println("\nTRABAJADOR DESPEDIDO")
            }
        }

    } else println("\nNo hay trabajadores que despedir")

}

fun hayTrabajadores(plantilla: Array<Persona?>): Boolean {

    for (i in plantilla) {
        if (i is Trabajador) {
            return true
        }
    }

    return false
}

fun seleccionarJefe(plantilla: Array<Persona?>): Persona? {

    val numJefes = numJefesTaller(plantilla).toInt()
    var resp: Int = 0
    var cont = 1
    var arrayPos = Array<Int>(numJefes) {-1}

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
    } while (resp !in 1..numJefes)

    return plantilla[arrayPos[resp-1]]
}

fun seleccionarTrabajador(plantilla: Array<Persona?>, jefe: JefeTaller): Persona? {

    val numTrabajadores = numTrabajadoresDelJefe(plantilla, jefe)
    var resp: Int = 0
    var cont = 1
    var arrayPos = Array<Int>(numTrabajadores) {-1}

    println("\nPERSONAS A CARGO DEL $jefe")
    println()

    for (i in plantilla.indices) {
        if (plantilla[i] is Trabajador && (plantilla[i] as Trabajador).jefe == jefe) {
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

fun numTrabajadoresDelJefe(plantilla: Array<Persona?>, jefe: JefeTaller): Int {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i.jefe == jefe) {
            cont++
        }
    }
    return cont
}

fun contratarPersona(plantilla: Array<Persona?>) {

}

fun imprimirPlantilla(plantilla: Array<Persona?>) {

    println()

    for (i in plantilla) {
        if (i != null) {
            println(i)
        }
    }
}

fun verJefes(plantilla: Array<Persona?>) {

    println("\nHay " + numJefesTaller(plantilla) + " jefes de taller")
    println()

    for (i in plantilla) {
        if (i is JefeTaller) {
            println(i)
        }
    }
}

fun verTrabajadores(plantilla: Array<Persona?>) {

    println("\nHay " + numTrabajadores(plantilla) + " trabajadores")
    println()

    for (i in plantilla) {
        if (i is Trabajador) {
            println(i)
        }
    }
}

fun verTrabajadoresSinEspecialidad(plantilla: Array<Persona?>) {

    println("\nHay " + numTrabajadoresSinEspecialidad(plantilla) + " trabajadores sin especialidad")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            println(i)
        }
    }
}

fun verChapistas(plantilla: Array<Persona?>) {

    println("\nHay " + numChapistas(plantilla) + " chapistas")
    println()

    for (i in plantilla) {
        if (i is Chapista) {
            println(i)
        }
    }
}

fun verElectricistas(plantilla: Array<Persona?>) {

    println("\nHay " + numElectricistas(plantilla) + " electricistas")
    println()

    for (i in plantilla) {
        if (i is Electricista) {
            println(i)
        }
    }
}

fun verTrabajadoresNoChapistas(plantilla: Array<Persona?>) {

    println("\nHay " + numTrabajadoresNoChapistas(plantilla) + " trabajadores que no son chapistas")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista) {
            println(i)
        }
    }
}

fun verTrabajadoresNoElectricistas(plantilla: Array<Persona?>) {

    println("\nHay " + numTrabajadoresNoElectricistas(plantilla) + " trabajadores que no son electricistas")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Electricista) {
            println(i)
        }
    }
}

fun verSumatorio(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        suma += i!!.salario
    }

    println("\nLa suma de nóminas del taller es de $suma€")
}

fun verSumatorioJefesTaller(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is JefeTaller) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de los jefes del taller es de $suma€")
}

fun verSumatorioTrabajadoresSinEspecialidad(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de los trabajadores sin especialidad es de $suma€")
}

fun verSumatorioChapistas(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Chapista) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de los chapistas es de $suma€")
}

fun verSumatorioElectricistas(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Electricista) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de los electricistas es de $suma€")
}

fun verSumatorioTrabajadores(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Trabajador) {
            suma += i.salario
        }
    }

    println("\nLa suma de nóminas de todos los trabajadores es de $suma€")
}

fun numJefesTaller(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is JefeTaller) {
            cont++
        }
    }
    return "$cont"
}

fun numTrabajadores(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador) {
            cont++
        }
    }
    return "$cont"
}

fun numTrabajadoresSinEspecialidad(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            cont++
        }
    }
    return "$cont"
}

fun numChapistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Chapista) {
            cont++
        }
    }
    return "$cont"
}

fun numElectricistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Electricista) {
            cont++
        }
    }
    return "$cont"
}

fun numTrabajadoresNoChapistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista) {
            cont++
        }
    }
    return "$cont"
}

fun numTrabajadoresNoElectricistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Electricista) {
            cont++
        }
    }
    return "$cont"
}