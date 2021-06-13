package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object Connection{

    var N = 0
    var M = 0
    var cnt = 0

    var map : Array<IntArray> = arrayOf()
    var visit = booleanArrayOf()

    fun sol(){

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st : StringTokenizer

        st = StringTokenizer(br.readLine())

        N = st.nextToken().toInt()
        M = st.nextToken().toInt()

        map = Array(N+1){IntArray(N+1){0} }
        visit = BooleanArray(N+1)

        for ( i in 0 until M){
            st = StringTokenizer(br.readLine())

            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()

            map[x][y] = 1
            map[y][x] = 1


        }

                for (i in 1 until N+1){
                    if(!visit[i]){
                        dfs(i)
                        cnt++
                }

                }




        println(cnt)

    }

    private fun dfs(x: Int) {

        visit[x] = true

        for (i in 1 until N+1){
            if(x != i && map[x][i] == 1 && !visit[i]){
                    dfs(i)
                }

        }

    }

}

fun main() {
    Connection.sol()
}