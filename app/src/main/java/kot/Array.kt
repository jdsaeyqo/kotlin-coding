package kot

class _Array {

    fun arrayInit(){
        val strArray1 = arrayOfNulls<String>(5) //null로 초기화
        val strArray2 = Array<String>(5){""}
        val strArray3 = arrayOf("가","나","다")

        println(strArray1.contentToString())
        println(strArray2.contentToString())
        println(strArray3.contentToString())

        val charArray1 = CharArray(5) // ""으로 초기화
        val charArray2 = charArrayOf('가','1','나','2')

        println(charArray1.contentToString())
        println(charArray2.contentToString())

        val booleanArray1 = BooleanArray(5) //false로 초기화
        val booleanArray2 = booleanArrayOf(false,true)

        println(booleanArray1.contentToString())
        println(booleanArray2.contentToString())

        val intArray1 = IntArray(5) //0으로 초기화
        val intArray2 = intArrayOf(1,2,3,4,5)

        println(intArray1.contentToString())
        println(intArray2.contentToString())

        val doubleArray1 = DoubleArray(5) //0.0으로 초기화
        val doubleArray2 = doubleArrayOf(1.0,2.0,3.14)

        println(doubleArray1.contentToString())
        println(doubleArray2.contentToString())

        val longArray1 = LongArray(5) //0으로 초기화
        val longArray2 = longArrayOf(1,3,4,5)

        println(longArray1.contentToString())
        println(longArray2.contentToString())

    }

    fun sortArray(){
        val intArr = intArrayOf(2,4,1,3,5)
        println(intArr.contentToString())
        println(intArr.sortedDescending())
        println(intArr.reversed())

        val strArr = arrayOf("다","나","가","라")
        println(strArr.sorted())
        println(strArr.sortedDescending())
        println(strArr.reversed())

        val charArr = charArrayOf('c','b','a','d')
        println(charArr.sorted())
        println(charArr.sortedDescending())
        println(charArr.reversed())

    }

    fun doArray(){
        val intArr = intArrayOf(1,2,3,4,5)

        for (i in intArr.indices){
            if(intArr[i]==2) intArr[i] = 10
        }

        println(intArr.contentToString())
    }



}

fun main(){
    println(_Array().sortArray())
   println(_Array().doArray())
}