package education

import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Date: 1/13/2019
 * Time: 20:49
 */
fun main() {
    val myList = MyList("bar", "baz", "bar")
    assertFalse(myList.isEmpty())
    assertEquals(myList.size, 3)
    assertFalse(myList.contains("foo"))
    assertTrue(myList.contains("bar"))
    assertFalse(myList.containsAll(listOf("foo", "bar")))
    assertTrue(myList.containsAll(listOf("bar", "baz")))
    assertEquals(myList.indexOf("foo"), -1)
    assertEquals(myList.indexOf("bar"), 0)
    assertEquals(myList.lastIndexOf("foo"), -1)
    assertEquals(myList.lastIndexOf("bar"), 2)
    myList.addAll(2, listOf("owl", "bowl"))
    printList(myList)
}

class MyList<E>(vararg elements: E) : MutableList<E> {
    private var elements: Array<E> = Arrays.copyOf(elements, elements.size)

    private fun ensureCapacity(newSize: Int) {
        if (newSize > elements.size)
            elements = Arrays.copyOf(elements, Math.max(elements.size * 2, newSize))
    }

    override fun add(element: E): Boolean {
        ensureCapacity(size + 1)
        elements[this.size] = element
        this.size++
        return true
    }

    override fun add(index: Int, element: E) {
        if (index < 0 || index > this.size)
            throw IndexOutOfBoundsException()

        ensureCapacity(this.size + 1)
        if (index < this.size) {
            for (i in this.size - 1 downTo index)
                this.elements[i + 1] = this.elements[i]
        }
        this.elements[index] = element
        this.size++
    }

    override fun addAll(index: Int, elements: Collection<E>): Boolean {
        if (index < 0 || index > this.size)
            throw IndexOutOfBoundsException()

        ensureCapacity(this.size + elements.size)
        if (index < this.size) {
            for (i in this.size - 1 downTo index)
                this.elements[i + elements.size] = this.elements[i]
        }
        var i = index
        for (e in elements)
            this.elements[i++] = e
        this.size += elements.size
        return true
    }

    override fun addAll(elements: Collection<E>): Boolean = addAll(this.size, elements)

    override fun clear() {
        this.size = 0
    }

    override fun remove(element: E): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAt(index: Int): E {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(index: Int, element: E): E {
        val oldValue = elements[index]
        elements[index] = element
        return oldValue
    }

    override var size: Int = elements.size
        private set

    override fun contains(element: E): Boolean = indexOf(element) != -1

    override fun containsAll(elements: Collection<E>): Boolean = elements.all { contains(it) }

    override fun get(index: Int): E = elements[index]

    override fun indexOf(element: E): Int = elements.indexOf(element)

    override fun isEmpty(): Boolean = size == 0

    override fun iterator(): MutableIterator<E> = MyIterator(elements, size)

    override fun lastIndexOf(element: E): Int = elements.lastIndexOf(element)

    override fun listIterator(): MutableListIterator<E> = mutableListOf(*elements).listIterator()

    override fun listIterator(index: Int): MutableListIterator<E> = mutableListOf(*elements).listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> = mutableListOf(*elements).subList(fromIndex, toIndex)

    class MyIterator<E>(private val elements: Array<E>, private val size: Int) : MutableIterator<E> {
        override fun remove() {
            TODO("not implemented")
        }

        private var currentIndex = 0
        override fun hasNext() = currentIndex < size

        override fun next(): E = elements[currentIndex++]
    }
}


fun <E> concat(list: MutableList<E>, otherList: List<E>) {
    for (el in otherList)
        list.add(el)
}

fun <E> printList(l: List<E>) {
    for (item in l)
        println(item)
}
