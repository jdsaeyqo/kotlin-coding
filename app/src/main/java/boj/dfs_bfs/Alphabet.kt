package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


class Alphabet {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var row = 0
    var col = 0
    var max = 0

    lateinit var map : Array<CharArray>
    var visit = BooleanArray(26)

    var dx = intArrayOf(1,0,-1,0)
    var dy = intArrayOf(0,1,0,-1)

    fun main(){
        st = StringTokenizer(br.readLine())

        row = st.nextToken().toInt()
        col = st.nextToken().toInt()

        map = Array(row){CharArray(col)}

        initMap()

        dfs(0,0,1)

        println(max)

    }

    fun dfs(x : Int, y : Int, cnt : Int){

        visit[map[x][y]-'A'] = true

        for(i in 0 until 4){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until row && ny in 0 until col){
                if(!visit[map[nx][ny]-'A']){
                    dfs(nx,ny,cnt+1)
                }
            }
        }

        visit[map[x][y]-'A'] = false
        max = Math.max(max,cnt)


    }

    fun initMap(){
        for(i in 0 until row){
            val line = br.readLine()
            for(j in 0 until col){
                map[i][j] = line[j]
            }
        }
    }
}
