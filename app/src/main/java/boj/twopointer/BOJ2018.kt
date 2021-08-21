package boj.twopointer

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ2018 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun main() {

        val num = br.readLine().toInt()

        if (num == 1) {
            println(1)
            return
        }
        var ans = 0
        var s = 1
        var e = 2
        var sum = s + e

        while (!(s == e && e == num)) {
            if (sum < num) {
                e++
                sum += e
            } else if (sum == num) {
                ans++
                sum -= s
                s++
            } else {
                sum -= s
                s++

            }
        }

        println(ans + 1)


    }


}