package programmers.graph.dfs_bfs

import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0

        val arr = Array(n + 1) { arrayListOf<Int>()}
        var visit = BooleanArray(n + 1)

        for (i in edge.indices) {
            arr[edge[i][0]].add(edge[i][1])
            arr[edge[i][1]].add(edge[i][0])
        }


        val q = LinkedList<Int>()

        q.add(1)
        visit[0] = true
        visit[1] = true


        while (q.isNotEmpty()) {

            val size = q.size

            for (i in 0 until size) {
                val node = q.poll()!!

                for (j in arr[node]) {
                    if (!visit[j]) {
                        visit[j] = true
                        q.add(j)
                    }
                }

            }
            answer = size
        }

        return answer
    }
}

fun main() {

    val s = Solution()
    val v = s.solution(
        6, arrayOf(
            intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2), intArrayOf(1, 3),
            intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(5, 2)
        )
    )

    println(v)
}