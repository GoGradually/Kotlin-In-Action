package coroutine

import coroutine.ThreadVer.UserData
import coroutine.ThreadVer.UserID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class UseFuture {
    private val ioExecutor: Executor = Executors.newFixedThreadPool(8)

    fun loginAsync(credentials: ThreadVer.Credentials): CompletableFuture<UserID> {
        return CompletableFuture.supplyAsync({
            Thread.sleep(1000)
            UserID(credentials.username)
        }, ioExecutor)
    }

    fun fetchUserDataAsync(userID: UserID): CompletableFuture<UserData> {
        return CompletableFuture.supplyAsync({
            Thread.sleep(1000)
            UserData("Full Name of ${userID.nickname}", "sample@sample.net")
        }, ioExecutor)
    }

    fun showData(data: UserData) {
        println("User Data: $data")
    }

    fun showUserInfo(credentials: ThreadVer.Credentials) {
        loginAsync(credentials).thenCompose { userID ->
            fetchUserDataAsync(userID)
        }.thenAccept { userData ->
            showData(userData)
        }
    }
}