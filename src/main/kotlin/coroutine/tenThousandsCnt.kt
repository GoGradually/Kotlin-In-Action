package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration.Companion.seconds

fun main() = runBlocking {
    var counter = 0
    val mutex = Mutex()
    repeat(10_000) {
        launch(Dispatchers.Default) {
            mutex.withLock {
                counter++
            }
        }
    }
    delay(1.seconds)
    println("Counter = $counter")
}