package programmers.heap

import java.util.*


class Solution1 {
    fun solution(operations: Array<String>): IntArray {

        val pq = LinkedList<Int>()

        operations.forEach { operation ->

            if (operation[0] == 'I') {
                val num = operation.substring(2).toInt()
                pq.offer(num)

            } else if (operation[0] == 'D' && pq.isNotEmpty()) {

                when (operation[2]) {

                    '1' -> {
                        val value = pq.max()
                        pq.remove(value!!)
                    }
                    '-' ->{
                        val value = pq.min()
                        pq.remove(value!!)
                    }

                }
            }
        }

        return if (pq.isEmpty()) {
            intArrayOf(0, 0)
        } else {
            intArrayOf(pq.max()!!,pq.min()!!)
        }

    }

}

fun main(){
    val s = Solution1().solution(arrayOf("I 7","I 5","I -5","D -1"))

    println(s.contentToString())
}