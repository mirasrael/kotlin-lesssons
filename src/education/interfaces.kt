package education

interface OpenableThing {
    fun open()
}

interface CloseableThing {
    fun close()
}

class Box<T> : OpenableThing, CloseableThing {
    private var item: T? = null

    override fun open() = println("Box opened!")
    override fun close() = println("Box closed!")
    fun put(item: T) {
        this.item = item
    }

    fun get(): T? = this.item
}

open class Window : OpenableThing {
    override fun open() = println("Window opened!")
}

class FramedWindow : Window() {
    override fun open() = println("Framed Window opened!")
}

class Shop : OpenableThing {
    override fun open() = println("Shop was opened!")
}

class Door : OpenableThing {
    override fun open() = println("Door is now open")
}

/**
 * Date: 1/13/2019
 * Time: 21:18
 */
fun main() {
    val things = arrayOf(Box<Any>(), Window(), Shop(), FramedWindow(), Door())
    doWithOpened(Box<Any>()) { box -> box.put(Window()) }
    openAll(things)
    val a: MutableList<String> = mutableListOf("String")
    val ai: MutableList<Int> = a as MutableList<Int>
    ai[0] = 12
    println(a[0] + 5)
}

fun <E> doWithOpened(thing: E, action: (thing: E) -> Unit) where E : OpenableThing, E : CloseableThing {
    thing.open()
    action(thing)
    thing.close()
}

fun openAll(things: Array<OpenableThing>) {
    for (thing in things) {
        thing.open()
    }
}
