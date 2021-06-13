package boj.dp

import java.io.BufferedReader
import java.io.InputStreamReader



fun main() {

    val type = arrayOf(3,5)
    var dp = intArrayOf()

    val br = BufferedReader(InputStreamReader(System.`in`))

    val target = br.readLine().toInt()

    dp = IntArray(target+1)
    dp.fill(Integer.MAX_VALUE)
    dp[0] = 0

    for (i in type.indices){

        for(j in type[i] until dp.size){
            if(dp[j - type[i]] != Integer.MAX_VALUE){
                dp[j] = Math.min(dp[j] , dp[j- type[i]] + 1)
            }
        }


    }

    if(dp[target] != Integer.MAX_VALUE){
        println(dp[target])
    }else{
        println(-1)
    }


}