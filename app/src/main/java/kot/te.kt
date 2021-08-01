package kot

class abc{

    companion object{
        var s = 0
    }

    fun ca() : Int{
        s+=1

        return s
    }
}

fun main() {

    val a = abc()
    println(a.ca())

}

