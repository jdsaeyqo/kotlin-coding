package boj.twopointer

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ3273 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer

    var cnt = 0

    fun main() {

        val n = br.readLine().toInt()
        val arr = IntArray(n)

        st = StringTokenizer(br.readLine())

        for (i in arr.indices) {
            arr[i] = st.nextToken().toInt()
        }

        val target = br.readLine().toInt()
        arr.sort()

        var start = 0
        var end = n-1
        var sum = 0

        while (start < end) {

            sum = arr[start]+arr[end]

            if( sum == target){
                cnt++

            }

            if (sum <= target){
                start++
            }
            else{
                end--
            }

        }


        println(cnt)

    }


}

fun main(){
    val s = BOJ3273()
    s.main()
}