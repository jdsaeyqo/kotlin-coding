package boj.dfs_bfs
import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ5569 {

    val br = BufferedReader(InputStreamReader(System.`in`))

    var n = 0
    var m = 0

    fun main(){

        val input = br.readLine().split(" ")
        n = input[0].toInt()
        m = input[1].toInt()

        val dp = Array(n+1){Array(m+1){Array(2){IntArray(2)}}}

        for(i in 2..n) dp[i][1][0][0] = 1
        for(i in 2..m) dp[1][i][1][0] = 1

        for(i in 2..n){
            for(j in 2..m){
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % 100000
                dp[i][j][0][1] = dp[i-1][j][1][0]
                dp[i][j][1][0]  = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % 100000
                dp[i][j][1][1] = dp[i][j-1][0][0]
            }
        }

        var ans = 0
        for(i in 0 until 2){
            for(j in 0 until 2){
                ans+=dp[n][m][i][j]
            }
        }

        println(ans%100000)

    }
}