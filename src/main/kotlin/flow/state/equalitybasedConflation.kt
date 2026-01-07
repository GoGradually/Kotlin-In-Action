package flow.state

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

enum class Direction { LEFT, RIGHT }

class DirectionSelector {
    private val _directions = MutableStateFlow<Direction>(Direction.LEFT)
    val directions = _directions.asStateFlow()

    fun selectDirection(direction: Direction) {
        _directions.update { direction }
    }
}

fun main() = runBlocking {
    val selector = DirectionSelector()

    launch {
        selector.directions.collect { direction ->
            println("Selected direction: $direction")
        }
    }
    delay(200.milliseconds)
    selector.selectDirection(Direction.RIGHT)
    delay(200.milliseconds)
    selector.selectDirection(Direction.RIGHT)
    delay(200.milliseconds)
    selector.selectDirection(Direction.LEFT)
    delay(200.milliseconds)
    selector.selectDirection(Direction.LEFT)
}