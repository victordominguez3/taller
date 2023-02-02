package models

class Electricista(
    nombre: String,
    apellido: String,
    experiencia: Int
): Trabajador(nombre, apellido, experiencia) {

    override var salario: Int = 1800
    override var horasDiarias: Int = 8
    override lateinit var jefe: JefeTaller

    override fun toString(): String {
        return "Electricista -> id: $id, nombre: $nombre $apellido, experiencia: $experiencia años, salario: $salario€, horas diarias: $horasDiarias . JEFE: $jefe"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Electricista) return false
        return this.id == other.id && this.nombre == other.nombre && this.apellido == other.apellido && this.experiencia == other.experiencia && this.salario == other.salario
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun saludar() {
        super.saludar()
    }

    override fun descansar() {
        super.descansar()
    }

    fun arreglarElectricidad() {
        println("El electricista $nombre $apellido está arreglando electricidad...")
    }
}