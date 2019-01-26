package education

import java.io.File

/**
 * Date: 11/21/2018
 * Time: 20:46
 */
fun main(args: Array<String>) {
    val coord = Coordinate2D()
    val coord2 = Coordinate3D(100, 3200, 0)
    val coord3 = Coordinate2D(coord2)
    val f = File("abc")

    println("u: 25")
    println(Bicycle(5))
}

fun printCoordinate2D(coord: Coordinate2D) {
    println("${coord.toString()}")
}

class Bicycle(val weight: Int) {
    override fun toString(): String {
        return "weight: $weight"
    }
}

open class Coordinate2D(var x: Int, var y: Int) : Any() {
    constructor() : this(0, 0)
    constructor(coord: Coordinate2D) : this(coord.x, coord.y)

    open fun plus1() {
        this.x++
        this.y++
    }

    internal fun coordString(label: String, value: Int) = "$label: $value"

    override fun equals(other: Any?): Boolean {
        return other?.javaClass == javaClass
                && other is Coordinate2D && other.x == this.x && other.y == this.y
    }

    override fun toString(): String {
        return "${coordString("x", x)} ${coordString("y", y)}"
    }
}

class Coordinate3D(x: Int, y: Int, var z: Int) : Coordinate2D(x, y) {
    constructor() : this(0, 0, 0)
    constructor(coord: Coordinate3D) : this(coord.x, coord.y, coord.z)

    override fun equals(other: Any?): Boolean {
        if (!super.equals(other))
            return false
        other as Coordinate3D
        return other.z == this.z
    }

    override fun toString(): String {
        return "${super.toString()} ${coordString("z", z)}"
    }

    override fun plus1() {
        super.plus1()
        this.z++
    }
}