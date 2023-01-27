package models

class JefeTaller(
    nombre: String,
    experiencia: Int
):Persona(nombre, experiencia) {
    private var personasACargo: Int = 0
    override var salario: Int = 2500
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