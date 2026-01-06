package structuredConcurrency

import coroutine.log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class ComponentWithScope(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    private val scope = CoroutineScope(dispatcher + SupervisorJob())

    fun start() {
        log("Starting!")
        scope.launch {
            while(true){
                delay(500.milliseconds)
                log("Component Working!")
            }
        }
        scope.launch {
            log("Doing a one-off task...")
            delay(500.milliseconds)
            log("Task finished!")
        }
    }

    fun stop() {
        log("Stopping!")
        scope.cancel()
    }
}

fun main(){
    val c = ComponentWithScope()
    c.start()
    Thread.sleep(2000)
    c.stop()
}