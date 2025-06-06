package ch04

interface Clickable{
    fun click()
    fun showOff() = println("I'm clicable!")
}

interface Focusable{
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

class Button: Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

}

fun main(args: Array<String>){
    val button = Button()
    button.showOff()
    button.click()
    button.setFocus(true)
}