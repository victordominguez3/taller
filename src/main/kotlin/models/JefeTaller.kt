package models

class JefeTaller(
    nombre: String,
    apellido: String,
    experiencia: Int
):Persona(nombre, apellido, experiencia) {
    var personasACargo: Int = 0
    override var salario: Int = 2500
    override fun toString(): String {
        return "Jefe de Taller -> id: $id, nombre: $nombre $apellido, experiencia: $experiencia años, salario: $salario€, personas a cargo: $personasACargo personas"
    }

    fun darLatigazos() {
        println("$nombre $apellido dando latigazos")
    }

    fun pagar() {

    }

    override fun saludar() {
        super.saludar()
    }
}