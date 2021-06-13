package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object virus {

    var map: Array<IntArray> = arrayOf()
    var visit: BooleanArray = booleanArrayOf()

    var N: Int = 0
    var M: Int = 0
    var ans: Int = 0

    fun sol() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st: StringTokenizer


        N = br.readLine().toInt()

        map = Array(N + 1) {
            IntArray(
                N + 1
            ) { 0 }
        }
        visit = BooleanArray(N + 1) { false }

        M = br.readLine().toInt()


        for (i in 0 until M) {
            st = StringTokenizer(br.readLine())

            var x = st.nextToken().toInt()

            var y = st.nextToken().toInt()

            map[x][y] = 1
            map[y][x] = 1

        }

        dfs(1)
        print(ans)

        br.close()

    }

    private fun dfs(i: Int) {

        visit[i] = true

        for (j in 1..N) {

            if (map[i][j] == 1 && !visit[j]) {
                ans++
                dfs(j)
            }

        }

    }
}


fun main() {
   virus.sol()
}


