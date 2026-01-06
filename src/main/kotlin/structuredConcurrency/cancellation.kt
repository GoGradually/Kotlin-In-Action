package structuredConcurrency

import coroutine.log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    val job = launch {
        try {
            for (i in 1..10) {
                log("작업 중... $i")
                delay(100)  // 일시 중단 지점에서 취소를 체크
            }
        } finally {
            // 취소 신호를 받으면 이 블록이 실행됨
            log("정리 작업 수행 (코루틴 취소됨)")
        }
    }

    delay(350)       // 일정 시간 후 작업 취소
    log("코루틴 취소 요청")
    job.cancel()     // 코루틴 취소 시도
    job.join()       // 코루틴이 완전히 종료될 때까지 대기
    log("메인 종료")
}