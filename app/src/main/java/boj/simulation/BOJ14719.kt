package boj.simulation

import java.io.*
import java.util.*

class BOJ14719 {

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        val H = st.nextToken().toInt()
        val W = st.nextToken().toInt()
        val map = IntArray(W)

        st = StringTokenizer(br.readLine())
        for (i in 0 until W) {
            map[i] = st.nextToken().toInt()
        }

        var height = 0
        var leftIdx = 0

        for (i in 0 until W) {
            if (map[i] > height) {
                height = map[i]
                leftIdx = i
            }
        }

        var sum = 0
        height = map[0]
        for (i in 0 until leftIdx) {
            if (map[i] > height) {
                height = map[i]
            } else if (map[i] < height) {
                sum += height - map[i]
            }
        }
        height = 0
        var rightIdx = 0

        for (i in W - 1 downTo 0) {
            if (map[i] > height) {
                height = map[i]
                rightIdx = i
            }
        }

        height = map[W - 1]
        for (i in W - 1 downTo rightIdx) {
            if (map[i] > height) {
                height = map[i]
            } else if (map[i] < height) {
                sum += height - map[i]
            }
        }

        if (leftIdx != rightIdx) {
            for (i in leftIdx..rightIdx) {
                sum += height - map[i]
            }
        }
        println(sum)
    }
}