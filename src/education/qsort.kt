package education

import education.utils.assertArrayEquals
import education.utils.printArray
import education.utils.swap


/**
 * Date: 11/15/2018
 * Time: 21:45
 */
fun main(args: Array<String>) {
    assertArrayEquals(longArrayOf(), qSort(longArrayOf()))
    assertArrayEquals(longArrayOf(1), qSort(longArrayOf(1)))
    assertArrayEquals(longArrayOf(1, 2), qSort(longArrayOf(2, 1)))
    assertArrayEquals(longArrayOf(1, 2, 3), qSort(longArrayOf(2, 3, 1)))
    assertArrayEquals(longArrayOf(1, 1, 1, 1, 3, 3, 3), qSort(longArrayOf(3, 1, 1, 3, 1, 3, 1)))
    assertArrayEquals(longArrayOf(1, 2, 3, 4, 8, 9, 16), qSort(longArrayOf(4, 16, 2, 3, 1, 9, 8)))
    assertArrayEquals(longArrayOf(2, 4, 8, 9, 10, 11, 16), qSort(longArrayOf(4, 16, 2, 10, 11, 9, 8)))
    assertArrayEquals(longArrayOf(1, 1, 1, 3, 3), qSort(longArrayOf(1, 3, 1, 3, 1)))
}

fun qSort(input: LongArray): LongArray = qSort(input, 0, input.size - 1)

fun qSort(input: LongArray, startIndex: Int, endIndex: Int): LongArray {
    printArray(input)
    println("qSort(input, $startIndex, $endIndex)")

    if (startIndex >= endIndex) return input
    
    val mid = input[(endIndex + startIndex) / 2]
    var i = startIndex
    var j = endIndex
    while (i < j) {
        while (input[i] < mid) {
            i++
        }
        while (input[j] > mid) {
            j--
        }
        if (i < j) {
            swap(input, i, j)
            if (input[i] < mid) {
                i++
            } else {
                j--
            }
        }
    }
    assert(i == j)

    qSort(input, startIndex, i - 1)
    qSort(input, i + 1, endIndex)

    return input
}
