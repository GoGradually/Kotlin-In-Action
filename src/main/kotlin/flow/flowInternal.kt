package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

val lettersFlow = flow {
    delay(300.milliseconds)
    emit("A")
    delay(300.milliseconds)
    emit("B")
}

fun main() = runBlocking {
    lettersFlow.collect { letter ->
        println(letter)
        delay(200.milliseconds)
    }
}