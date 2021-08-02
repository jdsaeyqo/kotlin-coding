package boj.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ14501 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var n = 0

    fun main(){
        n = br.readLine().toInt()
        val timeArr = IntArray(n+1)
        val costArr = IntArray(n+1)
        val dp = IntArray(n+1)


        for(i in 1..n){
            st = StringTokenizer(br.readLine())
            timeArr[i] = st.nextToken().toInt()
            costArr[i] = st.nextToken().toInt()

        }


        for(i in 1..n){
            if(i+timeArr[i] <= n+1){
                dp[i] = costArr[i]
                for(j in 1 until i){
                    if(j + timeArr[j] <= i){
                        dp[i] = Math.max(dp[j]+costArr[i],dp[i])
                    }
                }

            }
        }

        dp.sortDescending()
        println(dp[0])

    }

}

fun main(){
    val s = BOJ14501()
    s.main()
}