package boj.perm_comb

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ11050 {

    val br = BufferedReader(InputStreamReader(System.`in`))

    var cnt = 0

    fun sol1() {

        val input = br.readLine().split(" ")
        val n = input[0].toInt()
        val r = input[1].toInt()

        val visit = BooleanArray(n)
        val arr = IntArray(n)
        for (i in 0 until n) {
            arr[i] = i
        }

        comb(n, r, 0, visit, arr)
        println(cnt)


    }

    private fun comb(n: Int, r: Int, start: Int, visit: BooleanArray, arr: IntArray) {

        if (r == 0) {
            cnt++
        }

        for (i in start until n) {
            if (!visit[i]) {
                visit[i] = true
                comb(n, r - 1, i + 1, visit, arr)
                visit[i] = false
            }
        }

    }

    private fun sol2() {

        val br = BufferedReader(InputStreamReader(System.`in`))

        val input = br.readLine().split(" ")
        val n = input[0].toInt()
        val r = input[1].toInt()

        val answer = factorial(n) / (factorial(r) * factorial(n - r))

        println(answer)

    }

    private fun factorial(x: Int): Int {
        var r = 1;
        for (i in x downTo 1) r *= i
        return r
    }

}
