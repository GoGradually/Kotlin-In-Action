package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun createValuesFlow(): Flow<Int> {
    return flow {
        emit(1)
        delay(1000)
        emit(2)
        delay(1000)
        emit(3)
        delay(1000)
    }
}

fun main() = runBlocking {
    val flow = createValuesFlow()
    log("start")
    delay(2000)
    flow.collect{
        log(it)
    }
}