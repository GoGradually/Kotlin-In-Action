package ch05

data class Person (val nickname: String, val age: Int)

fun main(){

    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    people.maxByOrNull { p: Person -> p.age}
}
