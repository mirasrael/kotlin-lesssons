package education

/**
 * Date: 11/18/2018
 * Time: 10:32
 */
fun main(args: Array<String>) {
    val list = (0..9 step 2).toMutableList()
    printList(list, list.indices)

    list.add(0, -11)
    list.add(11)

    val subList = list.subList(2, list.size - 1)
    subList.add(0, -22)
    subList.add(22)

    val subSubList = subList.subList(2, subList.size - 1)
    subSubList.add(0, -33)
    subSubList.add(33)

    printList(subList, subList.indices)
    printList(list, list.indices)
}

fun printList(a: List<Int>, indices: IntRange) {
    for (index in indices) {
        print(a[index])
        print(' ')
    }
    println()
}