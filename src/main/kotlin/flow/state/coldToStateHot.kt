package flow.state

import flow.shared.getTemperatures
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking

fun main(){
    val temps = getTemperatures()
    runBlocking {
        val tempState = temps.stateIn(this)
        println(tempState.value)
        delay(800)
        println(tempState.value)
    }
}