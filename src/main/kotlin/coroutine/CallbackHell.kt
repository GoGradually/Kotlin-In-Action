package coroutine

import coroutine.ThreadVer.UserData
import coroutine.ThreadVer.UserID
import coroutine.ThreadVer.Credentials


class AsyncCallbackHell {
    fun loginAsync(credentials: Credentials, callback: (UserID) -> Unit): UserID {
        Thread.sleep(1000)
        return UserID(credentials.username)
    }

    fun fetchUserDataAsync(userID: UserID, callback: (UserData) -> Unit): UserData {
        Thread.sleep(1000)
        return UserData("Full Name of ${userID.nickname}", "sample@sample.net")
    }

    fun showData(data: UserData) {
        println("User Data: $data")
    }

    fun showUserInfo(credentials: Credentials) {
        val userID = loginAsync(credentials) { userID ->
            fetchUserDataAsync(userID) { userData ->
                showData(userData)
            }
        }
    }

}

