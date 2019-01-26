package education

import education.utils.assertArrayEquals

fun main(args: Array<String>) {
    assertArrayEquals(LongArray(0), filter(LongArray(0)) { it != 0L })
    assertArrayEquals(LongArray(0), filter(LongArray(2)) { it != 0L })
    assertArrayEquals(longArrayOf(3), filter(longArrayOf(1, 2, 3)) { it > 2 })
    assertArrayEquals(longArrayOf(1, 2), filter(longArrayOf(1, 2, 3)) { it <= 2 })
    assertArrayEquals(longArrayOf(1, 3), filter(longArrayOf(1, 2, 3)) { it % 2 == 1L })
}

fun subarray(arr: LongArray, startIndex: Int, endIndex: Int): LongArray {
    return arr.copyOfRange(startIndex, endIndex)
}

fun filter(values: LongArray, matches: (Long) -> Boolean): LongArray {
    return values.filter(matches).toLongArray()
}

fun map(values: IntArray, project: (Long) -> Long): LongArray {
    return values.map { project(it.toLong()) }.toLongArray()
}


fun squares(values: IntArray): LongArray {
    return values.map { it.toLong() * it }.toLongArray()
}

fun reverse(str: String): String {
    val result = CharArray(str.length)
    var sourceIndex = str.length - 1
    var targetIndex = 0
    while (sourceIndex >= 0) {
        result[targetIndex] = str[sourceIndex]
        targetIndex++
        sourceIndex--
    }
    return String(result)
}

fun trim(str: String): String {
    return str.trim()
}

fun substring(str: String, startIndex: Int, endIndex: Int): String {
    val result = CharArray(endIndex - startIndex)
    var sourceIndex = startIndex
    var targetIndex = 0
    while (sourceIndex < endIndex) {
        result[targetIndex] = str[sourceIndex]
        sourceIndex++
        targetIndex++
    }
    return String(result)
}
