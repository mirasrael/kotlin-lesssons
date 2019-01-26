package education

/**
 * Date: 10/6/2018
 * Time: 09:09
 */
fun main(args: Array<String>) {
    println("КАЛЬКУЛЯТОР")
    println("""
Для того, чтобы воспользоваться калькулятором введите начальное число, нажмите ENTER,
затем введите операцию (-, +, *, /), нажмите ENTER и введите следующее число.
Для завершения вместо операции введите =
""")
    var result = readDouble()

    while (true) {
        var operator = readLine()!!
        while (!(operator == "+" || operator == "-" || operator == "*" || operator == "/" || operator == "=")) {
            println("Я не знаю такой оператор: $operator")
            operator = readLine()!!
        }

        if (operator == "=") {
            break
        }

        val operand = readDouble()

        when (operator) {
            "+" -> result += operand
            "-" -> result -= operand
            "*" -> result *= operand
            "/" -> result /= operand
        }

        println(result)
    }

    println("Финальный результат: $result")
}

fun readDouble(): Double {
    while (true) {
        val x = readLine()!!.toDoubleOrNull()
        if (x != null) return x
        println("Введите число")
    }
}