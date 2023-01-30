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