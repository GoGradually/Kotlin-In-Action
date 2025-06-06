package ch05

fun alphabet(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) { //메소드를 호출하려는 수신 객체의 지정
        for (letter in 'a'..'z') {
            this.append(letter)
        }
        this.append("\nNow I know the alphabet!")
        this.toString()
    }
}

fun main() {
    val fruits = listOf("Apple", "Banana", "Cherry")
    val uppercaseFruit = mutableListOf<String>()
    val reversedLongFruits = fruits
        .map { it.uppercase() }
        .also { uppercaseFruit.addAll(it) }
        .filter { it.length > 5 }
        .also { println(it) }
        .reversed()
    println(uppercaseFruit)
    println(reversedLongFruits)
}

fun alphabet2() = StringBuilder().apply {
    for (letter in 'a'..'z') {
        this.append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

