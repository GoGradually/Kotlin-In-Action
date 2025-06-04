package gogradually.ch1

data class Person(val name: String, val age: Int? = null)

fun main(){
    val persons = listOf(Person("Alice", 29), Person("Bob"))
    val maxAgePerson = persons.maxBy {
        it.age ?: 0
    }
    println("가장 나이가 많은 사람: $maxAgePerson")
}