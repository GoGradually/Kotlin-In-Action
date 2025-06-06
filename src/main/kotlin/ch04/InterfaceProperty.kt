package ch04

interface User{
    val nickname: String
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser (val email:String) : User{
    override val nickname: String
        get() = email.substringBefore('@')

}
