package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ16234 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer
    lateinit var map: Array<IntArray>
    lateinit var visit: Array<BooleanArray>
    val list = arrayListOf<Pair<Int, Int>>()
    var n = 0
    var L = 0
    var R = 0

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    fun main() {

        init()

        var day = 0
        while (true) {
            if (makeRoad()) day++
            else break

        }

        println(day)
    }

    private fun makeRoad(): Boolean {

        visit.forEach {
            it.fill(false)
        }

        var check = false
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visit[i][j]) {
                    if (bfs(i, j)) {
                        check = true
                    }
                }
            }
        }

        if (!check) return false
        return true
    }

    private fun bfs(x: Int, y: Int): Boolean {

        visit[x][y] = true
        var sum = map[x][y]
        var cnt = 1
        val q = LinkedList<Pair<Int, Int>>()

        q.offer(Pair(x, y))

        list.clear()

        while (q.isNotEmpty()) {

            val pos = q.poll()!!
            val cx = pos.first
            val cy = pos.second

            for (i in 0 until 4) {

                val nx = cx + dx[i]
                val ny = cy + dy[i]

                if (nx in 0 until n && ny in 0 until n) {
                    if (!visit[nx][ny] && Math.abs(map[cx][cy] - map[nx][ny]) in L..R) {
                        visit[nx][ny] = true
                        q.offer(Pair(nx, ny))
                        list.add(Pair(nx, ny))
                        sum += map[nx][ny]
                        cnt++
                    }
                }
            }
        }

        if (sum == map[x][y]) {
            return false
        }
        list.add(Pair(x,y))
        val avg = sum / cnt
        move(avg)
        return true


    }

    private fun move(people: Int) {

        list.forEach { position ->
            map[position.first][position.second] = people
        }

    }

    private fun init() {

        st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        L = st.nextToken().toInt()
        R = st.nextToken().toInt()

        map = Array(n) { IntArray(n) }
        visit = Array(n) { BooleanArray(n) }

        repeat(n){ i ->
            st = StringTokenizer(br.readLine())
            repeat(n){ j ->
                map[i][j] = st.nextToken().toInt()
            }
        }

    }

}

fun main(){
    println(BOJ16234().main())
}