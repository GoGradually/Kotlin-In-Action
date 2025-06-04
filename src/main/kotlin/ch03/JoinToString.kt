package ch03


/**
 * 코틀린은 디폴트 파라미터 설정이 가능하다.
 */
fun <T> joinToStringV2(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String{
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(){
    val list = listOf(1, 2, 3)
    /**
     * 따라서 여러개의 생성자가 필요 없는 경우가 많다.
     */
    println(joinToStringV2(collection = list, separator = "; "))

}

