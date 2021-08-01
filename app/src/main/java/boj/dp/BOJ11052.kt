package boj.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//12
//1 1 6 8 11 1 1 1 1 1 1 1
//25

class BOJ11052 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    fun main(){

        val n = br.readLine().toInt()

        val arr = IntArray(n+1)
        val dp = IntArray(n+1)
        st = StringTokenizer(br.readLine())

        for(i in 1..n){
            arr[i] = st.nextToken().toInt()
        }
        dp[1] = arr[1]
        for(i in 1..n){
            for(j in 1..i){
                dp[i] = Math.max(dp[i],dp[i-j] + arr[j])
            }
        }

        println(dp[n])

    }

}

fun main(){
    val s = BOJ11052()
    s.main()
}