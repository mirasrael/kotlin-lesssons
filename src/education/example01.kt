package education

fun main(args: Array<String>) {
    val charArray = CharArray(3)
    charArray[0] = 'c'
    charArray[1] = 'b'
    charArray[2] = 'a'
    charArray[2] = charArray[0]
    
    println(String(charArray))
}
