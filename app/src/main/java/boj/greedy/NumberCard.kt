package boj.greedy

//5
//6 3 2 10 -10
//8
//10 9 -5 2 3 4 5 -10
//1 0 0 1 1 0 0 1


import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var st : StringTokenizer

var N = 0
var M = 0

lateinit var cardArr : IntArray

var sb = StringBuilder()

fun main(){

    N = br.readLine().toInt()
    cardArr = IntArray(N)


    st = StringTokenizer(br.readLine())
    for(i in 0 until N){
        cardArr[i] = st.nextToken().toInt()
    }
    cardArr.sort()


    M = br.readLine().toInt()

    st = StringTokenizer(br.readLine())

    for(i in 0 until M){

        val k = st.nextToken().toInt()

       val a = cardArr.binarySearch(k)

        if(a < 0){
            sb.append("${0} ")
        }else{
            sb.append("${1} ")
        }

        //이진 탐색 구현
//        var left = 0
//        var right: Int = N - 1
//        while (left <= right) {
//            val mid = (left + right) / 2
//            val n: Int = cardArr.get(mid)
//            if (n == k) {
//                sb.append("${1} ")
//                break
//            }
//            if (n > k) {
//                right = mid - 1
//            } else {
//                left = mid + 1
//            }
//            if (left > right) {
//                sb.append("${0} ")
//                break
//            }
//        }

    }

    println(sb.toString())

}

