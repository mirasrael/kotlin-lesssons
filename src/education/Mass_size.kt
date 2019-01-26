package education

fun Igra_new() {
    var s = 1
    var r: String? = ""
    var name = "никакой"
    var f = true
    println("Введите размер доски для Игры")
    val size = readLine()!!.toInt()
    var d = Array<Array<String>>(size, { Array(size, { " " }) })
    println("Ходит первый игрок 'Крестик',введите номер ячейки от 1 до ${size * size}")
    while (f && s <= size * size) {
        var k = Idiot(size)
        var x = cell(size, k)
        var y = (k - size * x) - 1
        r = Read(d, size, x, y, s)
        if (r == "X") {
            name = "первый"
            f = false
        } else {
            if (r == "O") {
                name = "второй"
                f = false
            }
        }
        s++
    }
    println("Победил $name игрок")
}

fun Idiot(size: Int): Int {
    var x = 0
    x = readLine()!!.toInt()
    while (x !in 1..size * size) {
        println("неверно введен номер ячейки, повторите ввод")
        x = readLine()!!.toInt()
    }
    return x
}

fun cell(size: Int, k: Int): Int {
    var j = 1
    var x = 0
    while (j <= size) {
        if (size * j >= k) {
            x = j
            j = size + 1
        } else j++
    }
    x--
    return x
}

fun writeln(a: Array<Array<String>>, size: Int) {
    for (i in 0 until size) {
        for (j in 0 until size) {
            print(a[i][j])
            if (j < size - 1) {
                print("|")
            }
        }
        stol(i, size)
    }
}

fun graf(a: Array<Array<String>>, x: Int, y: Int) {
    a[x][y] = "\u001B[7m${a[x][y]}\u001B[0m"
}

fun prowstb_1(a: Array<Array<String>>, size: Int, y: Int): String? {
    var k = 0
    var b: String? = null
    var j = 0
    while (j != size) {
        if (a[y][y] == a[j][y]) {
            k += 1
        }
        j++
    }
    println("$k по столбцу")
    if (k == size) {
        b = a[y][y]
        println("b=$b по столбцу")
        for (i in 0 until size) {
            graf(a, i, y)
        }
        writeln(a, size)
    }
    return b
}



fun prowstr_1(a: Array<Array<String>>, size: Int, x: Int): String? {
    fun check(element: String): Boolean {
        return element == a[x][0]
    }

    val b = if (a[x].all(::check)) a[x][0] else null
    for (it in a[x]) {

    }


    if (b != null) {
        for (i in 0 until size) {
            graf(a, x, i)
        }
        writeln(a, size)
    }
    return b
}

fun prowd_1(a: Array<Array<String>>, size: Int): String? {
    var i = 0
    var k = 1
    var b: String? = null
    while (i != size - 1) {
        if (a[i][i] == a[i + 1][i + 1]) {
            k++
        }
        i++
    }
    if (k == size) {
        b = a[0][0]
    }
    return b
}

fun prowd_2(a: Array<Array<String>>, size: Int): String? {
    var i = 0
    var j = 0
    var k = 1
    var b: String? = null
    j = size - 1
    while (i != j) {
        if (a[i][j - i] == a[i + 1][j - i - 1]) {
            k++
        }
        i++
    }
    if (k == size) {
        b = a[0][j]
    }
    return b
}

fun stol(i: Int, x: Int) {
    println()
    if (i < x - 1) {
        for (k in 1..x) {
            print("-")
            if (k < x) {
                print("+")
            }
        }
    }
    println()
}

fun Read(d: Array<Array<String>>, size: Int, x: Int, y: Int, s: Int): String? {
    var r: String? = ""
    if (s % 2 == 0) {
        d[x][y] = "O"
    } else {
        d[x][y] = "X"
    }
    writeln(d, size)
    r = prowstr_1(d, size, x) ?: prowstb_1(d, size, y) ?: prowd_1(d, size) ?: prowd_2(d, size)
    return r
}

fun main(argc: Array<String>) {
    Igra_new()
}

