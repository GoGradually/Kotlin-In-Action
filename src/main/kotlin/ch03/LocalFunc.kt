package ch03

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(string: String, target: String) {
        if (string.isEmpty()) {
            throw IllegalArgumentException("$target can't be empty")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")

    val (first, second) = 1 to "wa!"
    println("$first, $second")
    println("user ${user.id} saved")
}

fun main(){
    saveUser(User(1, "1", "2"))
}

