package boj.dp

import java.io.BufferedReader
import java.io.InputStreamReader


class cnt(var zero: Int, var one: Int) {

    override fun toString(): String {
        return "$zero $one"
    }

}

fun main() {



        val br = BufferedReader(InputStreamReader(System.`in`))
        val T = br.readLine().toInt()


        for (i in 0 until T) {

            val n = br.readLine().toInt()

            val dp : Array<cnt?> = arrayOfNulls(n+1)

            dp[0] = cnt(1, 0)

            if (n == 0) {
                println(dp[0])

            } else {

                dp[1] = cnt(0, 1)

                if (n == 1) {
                    println(dp[n])

                } else {

                    for (j in 2 until dp.size) {
                        dp[j] = cnt(
                            dp[j - 2]!!.zero + dp[j - 1]!!.zero,
                            dp[j - 2]!!.one + dp[j - 1]!!.one
                        )
                    }
                    println(dp[n])
                }
            }
        }
    }



