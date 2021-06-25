

package ddag

fun main(){


    val arr3 = IntArray(3)
    val arr2 = Array<Int>(3){0}
    val arr = Array<String>(5){""}
    val arr5 = arrayOfNulls<String>(5)
    val r = 1
    arr5[0] = r.toString()

    println(arr5.contentToString())

    val s = "12345"
    val srr = s.toCharArray()
    val arr1 = IntArray(s.length)

    for (i in srr.indices){
        arr1[i] = srr[i] -'0'
    }

   val arr4 = arr1.map { it+2 }.toIntArray()

    println(arr4.contentToString())

    val a  = 3
    var b = 4
    arr[0] = a.toString()
    arr[1] = b.toString()

    println(arr.contentToString())
}