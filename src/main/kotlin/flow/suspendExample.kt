package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


private var zeroTime = System.currentTimeMillis()
fun log(message: Any?) = println("[${System.currentTimeMillis() - zeroTime} ms] ${Thread.currentThread().name}: $message")

suspend fun createValuesSuspend(): List<Int> {
    return buildList {
        add(1)
        delay(1000)
        add(2)
        delay(1000)
        add(3)
        delay(1000)
    }
}

fun main() = runBlocking {
    val list = createValuesSuspend()
    list.forEach{
        log(it)
    }
}