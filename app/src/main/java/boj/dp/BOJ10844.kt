package boj.dp

class BOJ10844 {

    var n = 0
    lateinit var dp : Array<LongArray>

    fun main(){

        n = readLine()!!.toInt()
        dp = Array(n+1){LongArray(10)}

        for(i in 1..9){
            dp[1][i] = 1
        }

        for(i in 2..n){

            for(j in 0..9){

                if(j == 0){
                    dp[i][j] = dp[i-1][1] % 1000000000
                }else if(j == 9){
                    dp[i][j] = dp[i-1][8] % 1000000000
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % 1000000000
                }

            }

        }
        println(dp[n].sum() % 1000000000)

    }
}