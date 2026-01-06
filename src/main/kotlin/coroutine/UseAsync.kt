package coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

private var zeroTime = System.currentTimeMillis()
fun log(message: Any?) = println("[${System.currentTimeMillis() - zeroTime} ms] ${Thread.currentThread().name}: $message")

suspend fun slowlyAddNumbers(a: Int, b: Int): Int {
    log("Waiting to add $a and $b")
    delay(100.milliseconds * a) // Simulate a long-running computation
    return a + b
}

fun main() = runBlocking {
    log("starting async calculations")
    val myFirstDeferred = async { slowlyAddNumbers(2, 2) }
    val mySecondDeferred = async { slowlyAddNumbers(4, 4) }
    log("waiting for the deferred value to be available")
    log("The first result: ${myFirstDeferred.await()}")
    log("The second result: ${mySecondDeferred.await()}")
}