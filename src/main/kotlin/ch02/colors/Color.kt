package ch02.colors

import ch02.colors.Color.BLUE
import ch02.colors.Color.GREEN
import ch02.colors.Color.INDIGO
import ch02.colors.Color.ORANGE
import ch02.colors.Color.RED
import ch02.colors.Color.VIOLET
import ch02.colors.Color.YELLOW

enum class Color(
    var r: Int,
    var g: Int,
    var b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    var rgb = ((r * 256 + g) * 256 + b)
    fun printColor() = println("$this is $rgb")

}

fun getMnemonic(color: Color) = when(color) {
    RED -> "Richard"
    ORANGE -> "Of"
    YELLOW -> "York"
    GREEN -> "Gave"
    BLUE -> "Battle"
    INDIGO -> "In"
    VIOLET -> "Vain"
}
fun main(){
    println(Color.BLUE.rgb)
    Color.GREEN.printColor()
    println(getMnemonic(Color.BLUE))
}