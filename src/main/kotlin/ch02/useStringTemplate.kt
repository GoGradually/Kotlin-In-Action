package ch02

fun main(args: Array<String>) {
    val input = readln()
    val name = input.ifBlank { "kotlin" }
    println("hello, $name!")
}