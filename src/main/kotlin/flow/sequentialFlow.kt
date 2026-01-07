package flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

// private var zeroTime = System.currentTimeMillis()
// fun log(message: Any?) = println("[${System.currentTimeMillis() - zeroTime} ms] ${Thread.currentThread().name}: $message")

suspend fun getRandomNumber(): Int{
    delay(500.milliseconds)
    return Random.nextInt()
}

val randomNumbers = channelFlow {
    repeat(10) {
        launch { send(getRandomNumber()) }
    }
}

fun main() = runBlocking {
    log("start")
    randomNumbers.collect {
        log(it)
    }
}