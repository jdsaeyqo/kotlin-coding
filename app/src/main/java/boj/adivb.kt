package boj


fun main() {


    var arr = intArrayOf(0,1,2,3,4,5)

    val arr1 = arr.map {
        it+1
    }.toIntArray().contentToString()

    println(arr1)



}