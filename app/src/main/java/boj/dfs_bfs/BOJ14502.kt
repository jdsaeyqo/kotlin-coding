package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ14502 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var row = 0
    var col = 0
    lateinit var map : Array<IntArray>
    lateinit var copy : Array<IntArray>
    val virus = arrayListOf<IntArray>()
    var max = 0
    var dx = intArrayOf(1,0,-1,0)
    var dy = intArrayOf(0,1,0,-1)

    fun main(){

        init()

        setWall(0,0)

        println(max)

    }

    private fun setWall(start : Int, depth : Int){

        if(depth == 3){
            copyMap()

            for (i in virus.indices){
                dfs(virus[i][0],virus[i][1])
            }

            val num = safe()

            max = Math.max(num,max)
            return
        }

        for(i in start until row*col){
            val x = i / col
            val y = i % col

            if(map[x][y] == 0){
                map[x][y] = 1
                setWall(i+1,depth+1)
                map[x][y] = 0
            }
        }

    }

    private fun safe() : Int{
        var cnt = 0
        for(i in copy.indices){
            for(j in copy[0].indices){
                if(copy[i][j] == 0) cnt++
            }
        }
        return cnt
    }

    private fun dfs(x : Int, y : Int){

        for(i in 0 until 4){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until row && ny in 0 until col){
                if(copy[nx][ny] == 0){
                    copy[nx][ny] = 2
                    dfs(nx,ny)
                }
            }
        }

    }

    private fun copyMap(){

        for(i in 0 until row){
            for(j in 0 until col){
                copy[i][j] = map[i][j]
            }
        }

    }

    private fun init(){

        st = StringTokenizer(br.readLine())
        row = st.nextToken().toInt()
        col = st.nextToken().toInt()

        map = Array(row){ IntArray(col) }
        copy = Array(row){IntArray(col)}

        repeat(row){i ->
            st = StringTokenizer(br.readLine())
            repeat(col){j->
                map[i][j] = st.nextToken().toInt()
                if(map[i][j] == 2){
                    virus.add(intArrayOf(i,j))
                }
            }
        }

    }

}
fun main(){
    val s = BOJ14502()

    s.main()
}