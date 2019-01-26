package education.kir

import education.utils.assertArrayEquals

/**
 * Date: 11/18/2018
 * Time: 09:14
 */

fun main(args: Array<String>) {
    assertArrayEquals(longArrayOf(2, 4, 8, 9, 10, 11, 16), qSort(longArrayOf(4, 16, 2, 10, 11, 9, 8)))
}

fun qSort(input: LongArray): LongArray {
    qSort(input, 0, input.size - 1)
    for (num in input)
        print("$num ")
    println(" ")
    return input
}

fun qSort(input:LongArray, startIndex: Int , endIndex: Int): LongArray {
    if (startIndex >= endIndex) return input
    val mid =  (endIndex + startIndex) / 2
    var i = startIndex
    var j = endIndex
    while (i < j) {
        while (input[i] < input[mid]) {
            i++
        }
        while (input[j] > input[mid]) {
            j--
        }
        if (i < j) {
            val y = input[i]
            input[i] = input[j]
            input[j] = y
        }
        i++
        j--
    }

    qSort(input, i, endIndex)
    qSort(input, startIndex, j)

    return input
}