package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

val letters = flow {
        emit(1)
        delay(500)
        emit(2)
}

fun main() = runBlocking {
    log("start")
    letters.collect{
        log(it)
        delay(200)
    }
    letters.collect{
        log(it)
        delay(200)
    }
    log("end")
}