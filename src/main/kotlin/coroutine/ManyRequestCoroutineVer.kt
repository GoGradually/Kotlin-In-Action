package coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlin.system.measureTimeMillis

data class UserID(val nickname: String)

data class Credentials(val username: String, val password: String)

data class UserData(val fullName: String, val email: String)

suspend fun login(credentials: Credentials): UserID {
    delay(1000)
    return UserID(credentials.username)
}

suspend fun fetchUserData(userID: UserID): UserData {
    delay(1000)
    return UserData("Full Name of ${userID.nickname}", "sample@sample.net")
}

fun showData(data: UserData) {
    println("User Data: $data")
}

suspend fun showUserInfo(credentials: Credentials) {
    val userID = login(credentials)
    val userData = fetchUserData(userID)
    showData(userData)
}

fun main() = runBlocking {
    val millis = measureTimeMillis {
        runBlocking {
            for (i in 1..100_000) {
                val credentials = Credentials("user$i", "password$i")

                launch {
                    showUserInfo(credentials)
                }
            }
        }
    }
    println("Completed in $millis ms")
}