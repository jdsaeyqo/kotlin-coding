package boj.dp
import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ11727 {
    val br = BufferedReader(InputStreamReader(System.`in`))

    fun main(){

        val n = br.readLine().toInt()
        val dp = IntArray(1001)
        dp[1] = 1

        for(i in 2..n){
            if( i % 2 == 0 ){
                dp[i] = (dp[i-1]*2 + 1) % 10007
            }else{
                dp[i] = (dp[i-1]*2 - 1) % 10007
            }
        }
        println(dp[n])

    }

}