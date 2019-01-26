package education.utils

import java.util.*

/**
 * Date: 11/18/2018
 * Time: 09:26
 */
fun printArray(a: IntArray) {
    var i = 0
    while (i < a.size) {
        print(a[i++])
        print(' ')
    }
    println()
}

fun printArray(a: LongArray) {
    var i = 0
    while (i < a.size) {
        print(a[i++])
        print(' ')
    }
    println()
}

fun randomArray(n: Int): LongArray {
    val r = Random()
    val a = LongArray(n)
    var i = 0
    while (i < n) {
        a[i++] = r.nextLong()
    }
    return a
}

fun swap(input: LongArray, index1: Int, index2: Int) {
    val tmp = input[index1]
    input[index1] = input[index2]
    input[index2] = tmp
}
