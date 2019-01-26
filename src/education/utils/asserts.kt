package education.utils

import education.Coordinate2D
import kotlin.test.assertEquals

/**
 * Date: 11/18/2018
 * Time: 09:25
 */
fun assertArrayEquals(expected: LongArray, actual: LongArray) {
    Coordinate2D().coordString("u", 25)
    assertEquals(expected.size, actual.size, "Arrays have different size: ${expected.size} != ${actual.size}")
    var i = 0
    while (i < expected.size) {
        assertEquals(expected[i], actual[i], "Array elements at index: $i different: ${expected[i]} != ${actual[i]}")
        i++
    }
}