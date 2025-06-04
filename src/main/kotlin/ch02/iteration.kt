package ch02


fun main(){
    val binaryReps = mutableMapOf<Char, String>()
    for (char in 'A'..'F'){
        val binary = char.code.toString(radix = 2)
        binaryReps[char] = binary
    }

    for ((char, binary) in binaryReps){
        println("$char = $binary")
    }

    val list = listOf("10", "11", "1001")
    for ((index, value) in list.withIndex()){
        println("$index: $value")
    }

    for (i in 10 downTo 0 step 2) {
        print("$i ") // 출력: 10 8 6 4 2 0
    }
}