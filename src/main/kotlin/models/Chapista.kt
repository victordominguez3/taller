package models

class Chapista(
    nombre: String,
    apellido: String,
    experiencia: Int
): Trabajador(nombre, apellido, experiencia) {

    override var salario: Int = 1700
    override var horasDiarias: Int = 7
    override lateinit var jefe: JefeTaller

    override fun toString(): String {
        return "Chapista -> id: $id, nombre: $nombre $apellido, experiencia: $experiencia años, salario: $salario€, horas diarias: $horasDiarias horas. JEFE: $jefe"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Chapista) return false
        return this.id == other.id && this.nombre == other.nombre && this.apellido == other.apellido && this.experiencia == other.experiencia && this.salario == other.salario
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun saludar() {
        super.saludar()
    }

    fun arreglarChapa() {
        println("El chapista $nombre $apellido está arreglando una chapa...")
    }

    override fun descansar() {
        super.descansar()
    }
}