package stanojevic.kotlin


fun Exo6() {

    //1

    val user = User("Kevin","Hearth")
    val user2 = User("Kevin","Hearth")
    println(user.prenom)

    println(user == user2)

    val weather = Weather(5.2222f, "Paris")
    val localWeather = LocalWeather(weather)

    println(weather.toString())

    println(weather.isCold())

    println(localWeather.lieu)

    println(localWeather.isHot())

    var localWeather2 = object : LocalWeather(localWeather){

        override fun isHot(): Boolean {
            return this.temperature > 40
        }
    }

    localWeather2.temperature = 50f

    println(localWeather2.isHot())

    val listOf = listOf(1,2,3) //immutable
    val listOf2 = mutableListOf(1,2,3)//muttable
    listOf2.add(4)

    setOf(1,2,3,4,2)//supprime les doubles

    mapOf("clé" to "valeur")//version mutable existe



}

data class User(val nom: String, val prenom: String)

open class Weather(var temperature: Float, val lieu: String){

    constructor(weather: Weather): this(weather.temperature,weather.lieu)

    companion object {
        const val cold = 0
    }

    override fun toString(): String {
        return "Temeperature de ${this.lieu} : ${this.temperature}"
    }

    fun isCold(): Boolean{
        return this.temperature < cold
    }

    open fun isHot(): Boolean{
        return this.temperature >25
    }
}

open class LocalWeather(weather: Weather): Weather(weather){

    override fun isHot(): Boolean{
        return this.temperature >32
    }
}




