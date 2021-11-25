package stanojevic.kotlin

fun Collection() {

    val test = Test("Premier", 1)

    test.apply {
        methode1()
    }

    val list = (1..10).toList()

    println(list.sum())

    println(list.sumOf { value -> value * 2 })

    val listChar = listOf("bonjour", "le", "Monde", "je", "m'appelle", "Toto", "j'habite", "en", "Bretagne")

    println(listChar.groupBy { it.first().uppercaseChar() })

    var array = arrayOf(1, null, 42, 3, 26)



    for(i in array) {
            println(i)

    }



}


class Test(value1: String, value2: Int){

    fun methode1(){
        println("Start Marche")
    }
    fun methode2(){
    }
    fun methode3(){
    }

}