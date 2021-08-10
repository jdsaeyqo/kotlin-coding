package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min

class BOJ15686 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer
    var N = 0
    var M = 0
    lateinit var map: Array<IntArray>
    lateinit var copyMap: Array<IntArray>
    val chickenList = arrayListOf<Position>()
    val homeList = arrayListOf<Position>()

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    var ans = Integer.MAX_VALUE

    fun main() {

        init()

        val visit = BooleanArray(chickenList.size)
        comb(chickenList, visit, 0, chickenList.size, M)

        println(ans)

    }

    private fun comb(
        chickenList: ArrayList<Position>,
        visit: BooleanArray,
        start: Int,
        n: Int,
        r: Int
    ) {

        val tmpList = arrayListOf<Position>()
        val list = arrayListOf<ArrayList<Position>>()
        if (r == 0) {
            for (i in visit.indices) {
                if (visit[i]) {
                    tmpList.add(chickenList[i])
                }
            }
            list.add(tmpList)


            for (i in list.indices) {
                copy(list[i])
                ans = min(getDistance(list[i]),ans)
            }


        }

        for (i in start until n) {
            if (!visit[i]) {
                visit[i] = true
                comb(chickenList, visit, i + 1, n, r - 1)
                visit[i] = false
            }
        }

    }

    private fun getDistance(list: ArrayList<Position>) : Int {

        var result = 0
        homeList.forEach { home ->
            var tmpRes = Int.MAX_VALUE
            var a = 0
            var b = 0
            list.forEach{ chicken ->
                a = abs(home.x - chicken.x)
                b = abs(home.y - chicken.y)

                tmpRes = min(tmpRes,a+b)

            }
            result += tmpRes
        }

        return result
    }

    private fun copy(list: ArrayList<Position>) {

        copyMap.forEach {
            it.fill(0)
        }

        for (i in 0 until N) {
            for (j in 0 until N) {
                if (map[i][j] == 2) {
                    copyMap[i][j] = 0

                } else {
                    copyMap[i][j] = map[i][j]
                }
            }
        }

        list.forEach {
            copyMap[it.x][it.y] = 2
        }
    }


    private fun init() {

        st = StringTokenizer(br.readLine())
        N = st.nextToken().toInt()
        M = st.nextToken().toInt()

        map = Array(N) { IntArray(N) }
        copyMap = Array(N) { IntArray(N) }

        repeat(N) { i ->
            st = StringTokenizer(br.readLine())
            repeat(N) { j ->
                map[i][j] = st.nextToken().toInt()
                if (map[i][j] == 2) {
                    chickenList.add(Position(i, j))
                } else if (map[i][j] == 1) {
                    homeList.add(Position(i, j))
                }
            }
        }


    }

    data class Position(var x: Int = 0, var y: Int = 0)
}

fun main() {
    val s = BOJ15686()
    s.main()
}