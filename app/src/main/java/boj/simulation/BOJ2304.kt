package boj.simulation

import java.util.*
import java.io.*

class BOJ2304 {

    fun main() {

        val map: Array<IntArray>
        var n = 0
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st: StringTokenizer
        val leftStk = Stack<IntArray>()
        val rightStk = Stack<IntArray>()

        n = br.readLine().toInt()
        map = Array(n) { IntArray(2) }

        repeat(n) { i ->
            st = StringTokenizer(br.readLine())
            map[i][0] = st.nextToken().toInt()
            map[i][1] = st.nextToken().toInt()

        }

        map.sortBy { it[0] }

        var maxH = 0
        for (i in 0 until n) {
            if (map[i][1] > maxH) {
                maxH = map[i][1]
                leftStk.push(intArrayOf(map[i][0], map[i][1]))
            }
        }

        maxH = 0
        for (i in n - 1 downTo 0) {
            if (map[i][1] > maxH) {
                maxH = map[i][1]
                rightStk.push(intArrayOf(map[i][0], map[i][1]))
            }
        }

        var sum = (rightStk.peek()[0] - leftStk.peek()[0] + 1) * rightStk.peek()[1]
        var beforeLeft = leftStk.pop()[0]
        while (leftStk.isNotEmpty()) {
            val left = leftStk.peek()[0]
            val height = leftStk.peek()[1]
            sum += (beforeLeft - left) * height
            beforeLeft = left
            leftStk.pop()
        }

        var beforeRight = rightStk.pop()[0] +1
        while (rightStk.isNotEmpty()) {
            val right = rightStk.peek()[0] + 1
            val height = rightStk.peek()[1]
            sum += (right - beforeRight) * height
            beforeRight = right
            rightStk.pop()
        }

        println(sum)
    }
}

fun main(){
    BOJ2304().main()
}