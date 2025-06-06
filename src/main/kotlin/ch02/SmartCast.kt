package ch02

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int{
    if (e is Num){
        return e.value
    }
    else if (e is Sum){
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun main(){
    println(eval(Sum(
        Sum(
            Num(1),
            Num(2)
        ),
        Num(3)
    )))
}