package boj.datastructure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ10845 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    fun main() {

        val n = br.readLine().toInt()
        val q = LinkedList<Int>()

        repeat(n) {

            val str = br.readLine()

            if (str[0] == 'p') {
                if (str[1] == 'u') {
                    q.offer(str.split(" ")[1].toInt())
                } else {
                    if (q.isNotEmpty()) {
                        val pop = q.poll()!!
                        println(pop)
                    } else {
                        println(-1)
                    }
                }
            } else if (str[0] == 's') {
                println(q.size)
            } else if (str[0] == 'f') {
                if (q.isNotEmpty()) {
                    println(q.peek()!!)
                } else {
                    println(-1)
                }

            } else if (str[0] == 'b') {
                if (q.isNotEmpty()) {
                    println(q.peekLast()!!)
                } else {
                    println(-1)
                }

            } else {
                if (q.isEmpty()) {
                    println(1)
                } else {
                    println(0)
                }

            }

        }

    }
}
