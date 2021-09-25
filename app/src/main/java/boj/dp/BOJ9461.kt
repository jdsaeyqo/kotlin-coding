package boj.dp

import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))

lateinit var dp : LongArray

class BOJ9461 {

    fun sol(){

        dp = LongArray(101)

        dp[1] = 1
        dp[2] = 1
        dp[3] = 1

        for(i in 4..100){
            dp[i] = dp[i-2] + dp[i-3]
        }

        val tc = br.readLine().toInt()

        repeat(tc){
            val num = br.readLine().toInt()
            println(dp[num])

        }

    }

}

fun main(){

    BOJ9461().sol()

}