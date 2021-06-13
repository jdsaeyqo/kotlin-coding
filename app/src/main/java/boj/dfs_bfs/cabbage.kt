package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object Cabbage {

    var tc = 0
    var row = 0
    var col = 0
    var cab = 0
    var cnt = 0

    var map : Array<IntArray> = arrayOf()
    var visit :Array<BooleanArray> = arrayOf()
    var dx = arrayOf(1,0,-1,0)
    var dy = arrayOf(0,1,0,-1)

    fun sol(){

        val br = BufferedReader(InputStreamReader(System.`in`))
        var st : StringTokenizer


        tc = br.readLine().toInt()

        for (i in 0 until tc){

            cnt = 0

            st = StringTokenizer(br.readLine())

            col = st.nextToken().toInt()
            row = st.nextToken().toInt()
            cab = st.nextToken().toInt()

            map = Array(row){ IntArray(col){0} }
            visit = Array(row){ BooleanArray(col){ false } }

            for (i in 0 until cab){
                st = StringTokenizer(br.readLine())

                val y = st.nextToken().toInt()
                val x = st.nextToken().toInt()

                map[x][y] = 1

            }

            for(i in 0 until row){
                for (j in 0 until col){
                    if(map[i][j] == 1 && !visit[i][j]){
                        dfs(i,j)
                        cnt++;
                    }
                }
            }


            println(cnt)

        }

    }

    private fun dfs(x: Int, y: Int) {

        visit[x][y] = true

        for (i in 0 until 4){

            var newX = x + dx[i]
            var newY = y + dy[i]

            if(newX in 0 until row && newY in 0 until col){
                if(map[newX][newY] == 1 && !visit[newX][newY]) {
                    dfs(newX,newY)
                }
            }

        }

    }

}

fun main() {
    Cabbage.sol()
}