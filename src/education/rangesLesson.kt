package education

/**
 * Date: 11/18/2018
 * Time: 09:38
 */
fun main(args: Array<String>) {
    val array = intArrayOf(2, 12, 3, 5, 2, 3, 6, 8, 2, 4)

    // 0..9               - [0, 9]
    // 0 until 10         - [0, 10)
    // 0..9 step 2        - [0, 9] с шагом 2
    // 9 downTo 0         - от 9 до 0 с шагом -1
    // 9 downTo 0 step 2  - от 9 до 0 с шагом -2

    for (index in 8 downTo 1 step 2) {
        print("${array[index]} ")
    }
}

fun printArr(a: IntArray, indices: IntRange) {
    for (index in indices) {
        print(a[index])
        print(' ')
    }
    println()
}