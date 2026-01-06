package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun createValuesFlow(): Flow<Int> {
    return flow {
        emit(1)
        delay(500)
        emit(2)
    }
}

fun main() = runBlocking {
    val flow = createValuesFlow()
    log("start")
    flow.collect{
        log(it)
        delay(200)
    }
}