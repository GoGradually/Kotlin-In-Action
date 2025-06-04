package ch03

/**
 * 코틀린은 확장 함수를 지원한다. 이는 기존 라이브러리 클래스에 새로운 기능의 추가를 가능하게 한다.
 */
fun String.lastChar(): Char = this[this.length - 1]

val String.lastChar: Char
    get() = this[this.length - 1]

fun <T> Collection<T>.joinToStringV3(
    separator: String = ", ", prefix: String = "", postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/**
 * 다음과 같이 기존 라이브러리 클래스의 객체에 새로운 유틸리티 메소드를 추가할 수 있다.
 */
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("hello".lastChar())
    println("hello".lastChar)
    println(list.joinToStringV3())
}

// 확장 함수는 오버라이드 할 수 없다.