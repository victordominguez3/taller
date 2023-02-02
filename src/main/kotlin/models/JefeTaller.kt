package models

class JefeTaller(
    nombre: String,
    apellido: String,
    experiencia: Int
):Persona(nombre, apellido, experiencia){
    var personasACargo: Int = 0
    override var salario: Int = 2500
    override fun toString(): String {
        return "Jefe de Taller -> id: $id, nombre: $nombre $apellido, experiencia: $experiencia años, salario: $salario€, personas a cargo: $personasACargo personas"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is JefeTaller) return false
        return this.id == other.id && this.nombre == other.nombre && this.apellido == other.apellido && this.experiencia == other.experiencia && this.salario == other.salario
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    fun darLatigazos() {
        println("$nombre $apellido dando latigazos")
    }

    fun pagar(trabajador: Trabajador) {
        println("$nombre $apellido pagando a ${trabajador.nombre} ${trabajador.apellido} su nómina de ${trabajador.salario}€")
    }

    override fun saludar() {
        super.saludar()
    }
}