package flow.shared

import flow.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

class RadioStation {
    private val _messageFlow = MutableSharedFlow<Int>() // 새 가변 공유 플로우를 비공개 프로퍼티로 생성한다.
    val messageFlow = _messageFlow.asSharedFlow() // 공유 플로우에 대한 읽기 전역 뷰를 제공한다.

    fun beginBroadcasting(scope: CoroutineScope) {
        scope.launch {
            while (true) {
                delay(500)
                val number = Random.nextInt(0..10)
                log("Emitting $number!")
                _messageFlow.emit(number)
            }
        }
    }
}

fun main() {
    runBlocking {
        log("start")
        val radioStation = RadioStation()
        radioStation.beginBroadcasting(this)
        delay(600.milliseconds)

        launch {
            radioStation.messageFlow.collect {
                log("B collecting $it!")
            }
        }
        radioStation.messageFlow.collect {
            log("A collecting $it!")
        }
    }
}