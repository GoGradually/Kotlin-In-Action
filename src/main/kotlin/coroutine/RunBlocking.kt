package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun doSomethingSlowly(){
    delay(500)
    println("I'm done!")
}

fun main() = runBlocking {
    doSomethingSlowly()
}


