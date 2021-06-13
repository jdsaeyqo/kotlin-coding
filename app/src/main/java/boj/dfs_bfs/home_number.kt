package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader

object HomeNumber{

    var N = 0
    var ans = 0
    var cnt = 0
    var list = arrayListOf<Int>()
    var map : Array<IntArray> = arrayOf()
    var visit : Array<BooleanArray> = arrayOf()
    var dx = arrayOf(1,0,-1,0)
    var dy = arrayOf(0,1,0,-1)


    fun sol(){
        val br =   BufferedReader(InputStreamReader(System.`in`))

        N = br.readLine().toInt()

        map = Array(N) { IntArray(N) {0} }
        visit = Array(N) { BooleanArray(N) {false}}

        for (i in 0 until N){
            val str  = br.readLine()
            for (j in 0 until  N){
                map[i][j] = str[j] - '0'
            }
        }

        for (i in 0 until N){
            for (j in 0 until N){
                cnt = 0

                if(map[i][j] == 1 && !visit[i][j]){

                    cnt = dfs(i,j)
                    list.add(cnt)

                    ans++

                }
            }
        }

        println(ans)

        list.sort()

        for (i in 0 until ans){
            println(list[i])
        }

    }

    private fun dfs(x: Int, y: Int): Int {

        visit[x][y] = true

        var count = 1

        for (i in 0 until 4){

            val newX = x + dx[i]
            val newY = y + dy[i]

            if(newX in 0 until N && newY in 0 until N ){
                if(map[x][y] == map[newX][newY] && !visit[newX][newY] ){
                    count += dfs(newX,newY)

                }
            }

        }
        return count
    }


}


fun main() {

    HomeNumber.sol()
}