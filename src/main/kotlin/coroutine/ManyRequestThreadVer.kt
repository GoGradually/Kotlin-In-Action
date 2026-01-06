package coroutine

import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class ThreadVer {
    data class UserID(val nickname: String)

    data class Credentials(val username: String, val password: String)

    data class UserData(val fullName: String, val email: String)

    fun login(credentials: Credentials): UserID {
        Thread.sleep(1000)
        return UserID(credentials.username)
    }

    fun fetchUserData(userID: UserID): UserData {
        Thread.sleep(1000)
        return UserData("Full Name of ${userID.nickname}", "sample@sample.net")
    }

    fun showData(data: UserData) {
        println("User Data: $data")
    }

    fun showUserInfo(credentials: Credentials) {
        val userID = login(credentials)
        val userData = fetchUserData(userID)
        showData(userData)
    }

    fun main() {
        val millis = measureTimeMillis {
            for (i in 1..100000) {
                thread {
                    val credentials = Credentials("user$i", "password$i")
                    showUserInfo(credentials)
                }
            }
        }

        println("Completed in $millis ms")
    }
}
fun main() {
    val app = ThreadVer()
    app.main()
}