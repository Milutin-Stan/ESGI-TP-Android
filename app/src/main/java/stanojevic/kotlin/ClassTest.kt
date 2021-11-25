package stanojevic.kotlin

fun testClass() {

    val a = A(1)

    println(a.attr2)
}

open class A(val attr1: String, val attr2: String){

    constructor(attr: Int) : this("1 $attr", "2 $attr")

    fun method(){}
}

open class A1(val attr: String){
    fun method(){}

}

class B(value: String) : A1(value){

}

enum class Colors(val hexa: String){
    red("0xFFFFF"),green("0xFFFFF"),blue("0xFFFFF")
}
