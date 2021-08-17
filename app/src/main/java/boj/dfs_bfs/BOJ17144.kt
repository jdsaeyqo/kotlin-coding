package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ17144 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer

    var n = 0
    var m = 0
    var T = 0

    lateinit var map: Array<IntArray>
    val q = LinkedList<Triple<Int,Int,Int>>()
    val airClean = arrayListOf<Pair<Int, Int>>()

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun main() {

        init()


        while (T != 0) {

            getDust()

            spread()

            clean()

            T--

        }


        println(getSum())

    }

    private fun getDust(){
        q.clear()

        for (i in map.indices){
            for(j in map[0].indices){
                if(map[i][j] != 0){
                    q.offer(Triple(i,j,map[i][j]))
                }
            }
        }

    }

    private fun getSum(): Int {

        var sum = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] != -1) {
                    sum += map[i][j]
                }
            }
        }
        return sum

    }

    private fun clean() {

        val up = airClean[0]
        val upX = up.first

        for (i in upX - 1 downTo 1) {
            map[i][0] = map[i - 1][0]
        }

        for (i in 0 until m - 1) {
            map[0][i] = map[0][i + 1]
        }

        for (i in 0 until upX) {
            map[i][m - 1] = map[i + 1][m - 1]
        }

        for (i in m - 1 downTo 2) {
            map[upX][i] = map[upX][i - 1]
        }
        map[upX][1] = 0


        val down = airClean[1]
        val downX = down.first

        for (i in downX + 1 until n - 1) {
            map[i][0] = map[i + 1][0]
        }
        for (i in 0 until m - 1) {
            map[n - 1][i] = map[n - 1][i + 1]
        }
        for (i in n - 1 downTo downX + 1) {
            map[i][m - 1] = map[i - 1][m - 1]
        }
        for (i in m - 1 downTo 2) {
            map[downX][i] = map[downX][i - 1]
        }
        map[downX][1] = 0
    }

    private fun spread() {

        while (q.isNotEmpty()) {

            val dust = q.poll()!!
            val cx = dust.first
            val cy = dust.second
            val amount = dust.third / 5
            var cnt = 0
            for (i in 0 until 4) {

                val nx = cx + dx[i]
                val ny = cy + dy[i]

                if (nx in 0 until n && ny in 0 until m) {
                    if (map[nx][ny] != -1) {
                        map[nx][ny] += amount
                        cnt++
                    }
                }

            }
            map[cx][cy] -= amount * cnt
        }
    }

    private fun init() {

        st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        m = st.nextToken().toInt()
        T = st.nextToken().toInt()

        map = Array(n) { IntArray(m) }

        repeat(n) { i ->
            st = StringTokenizer(br.readLine())
            repeat(m) { j ->
                map[i][j] = st.nextToken().toInt()
                if (map[i][j] == -1) {
                    airClean.add(Pair(i, j))
                }
            }
        }

    }
}

fun main() {
    val s = BOJ17144()
    s.main()
}