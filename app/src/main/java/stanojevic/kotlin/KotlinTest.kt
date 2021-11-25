package stanojevic.kotlin

import androidx.core.util.rangeTo
import java.text.DecimalFormat

fun main(){
     println("Hello World")

     val var1: Any ? = null
     val var2 = "Hello World"
     var var3: String? = "Hello World"
     var3 = "Blabla"
     var3 = null

     if (var1 != null) {
         var1.toString()
     }

     var1?.toString()

     //var1!!.toString() forcer le code

     when (var1) {
         0, 1 -> println("cas 1")
         2 -> println("cas 2")
         in 0..5 -> println("cas3")
         !in 0..5 -> println("cas4")
         is String -> println("cas 5")
        // method() == 1 -> println("cas 6")
         else -> 7
     }

     "Hello".isEmpty()


     //LES EXOS INTERNET
///////////////////////////////////////////////////////////////////////////////////////////////////
     //1) Les variables

     //1)
    val valExo: String = "Start"

    //2)
    var varExo: String = "Start"

    //3
    //pour la variable de type var on nous previen si elle n'est jamais utilisée

    //4)
    //valExo = "Test"
    varExo = "Test"
    //La variable de type val ne peut pas etre changé

    //5)
    //varExo = 3;

     //6)
     var a: Number = 3
     varExo += "$a"
     println(varExo)

     ///////////////////////////////

    //2)La nullabilité

     //1)
     var valExo2: String ="Start"
     var varExo2: String? = "start"

     //2) Non visuelement on remarque rien

     //3)
     //valExo2 = null
     // varExo2 = null
     //la deuxieme variable peut etre null allors que la premiere non

     //4)
     //varExo2.uppercase()
     //On nous autorise pas a le faire car la variable peut etre null

     //5)
     println(varExo2?.uppercase())
     println(varExo2!!.uppercase())

     //6)

     //7) un operateur qui permets de verifier la premiere valeur si elle est fausse on mets la valleur par defaut

     //8
     var varExo22: String? = null
     println( varExo22 ?: "default" )

     ///////////////////

     //3) Calculatrice TVA

    println("Saisissez vontre montant HT :")
    var number: Int ?= readLine()?.toInt()
    tvaCalculator(number)

    ///////////////////////////////////////////////////////////

    //4)
    println(2.isEven())
    println(3.isEven())

    //Une extension de fonction permets de faire des fonctions avec des primitives (Double.isEven)

    println("Entrez un char: ")
    var voyelle: String? = readLine()

    when(voyelle){
        "a","A" -> println("$voyelle est une voyelle")
        "e","E" -> println("$voyelle est une voyelle")
        "i","I" -> println("$voyelle est une voyelle")
        "o","O" -> println("$voyelle est une voyelle")
        "u","U" -> println("$voyelle est une voyelle")
        "y","Y" -> println("$voyelle est une voyelle")
        else -> println("$voyelle n'est pas une voyelle")
    }

    var range = (1..100) + (1..100).reversed()
    for(i in range ) print(i)

    println("")
    /////////////////////////////////////////////////////////////

    //Exo 5

    helloESGI()

    //Unit est un equivalent de void

    println(multip(5))

    //6 de racoursir le code


}
fun String.isEmpty(): Boolean {
    return length == 0
}

fun tvaCalculator(number: Int?){
    var tva: Double = 0.00;
    var format = DecimalFormat("##.##")
    var tax = arrayOf(2.1, 5.5, 10.00, 20.00)
    println("Results:")

    for(i in 0..tax.size-1 ) {
        tva = tax[i].tvaCalcul(number!!.toDouble())
        var show = format.format(tva)
        println("TVA ${tax[i]}% : $show€")
    }
}

fun Double.tvaCalcul(number: Double,): Double {
    return (this / number) + number
}

fun Int.isEven(): Boolean{
    return this % 2 == 0
}
fun helloESGI():Unit{
    return println("Hello ESGI")
}
fun multip(int: Int):Int = int*5
