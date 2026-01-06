package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val sem = Semaphore(permits = 3)

    val elapsed = measureTimeMillis {
        val jobs = (1..10).map { id ->
            launch(Dispatchers.Default) {
                sem.withPermit {
                    println("start: $id on ${Thread.currentThread().name}")
                    delay(500) // 실제 작업(예: 외부 API 호출)
                    println("end  : $id")
                }
            }
        }
        jobs.joinAll()
    }

    println("done in ${elapsed}ms")
}