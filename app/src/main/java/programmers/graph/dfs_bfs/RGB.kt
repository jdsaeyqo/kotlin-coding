package programmers.graph.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

    lateinit var originalMap: Array<CharArray>
    lateinit var originalVisit : Array<BooleanArray>
    lateinit var rgVisit : Array<BooleanArray>
    lateinit var rgMap: Array<CharArray>
    val dx = arrayOf(1,0,-1,0)
    val dy = arrayOf(0,1,0,-1)
    var answer1 = 0
    var answer2 = 0
    var N = 0
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer

    fun main() {

        st = StringTokenizer(br.readLine())
        N = st.nextToken().toInt()

        if(N == 1){
            println("1 1")
            return
        }

        originalMap = Array(N) { CharArray(N) }
        rgMap = Array(N) { CharArray(N) }
        originalVisit = Array(N){BooleanArray(N)}
        rgVisit = Array(N){BooleanArray(N)}

        initMap()

        for (i in 0 until N){
            println(originalMap[i].contentToString())
        }

        for (i in 0 until N){
            println(rgMap[i].contentToString())
        }


        for(i in 0 until N){
            for(j in 0 until N){
                if(!originalVisit[i][j]){
                    dfs(i,j, originalMap, originalVisit)
                    answer1++
                }

                if(!rgVisit[i][j]){
                    dfs(i,j, rgMap, rgVisit)
                    answer2++
                }
            }
        }

        println("$answer1 $answer2")

    }

    fun dfs(x : Int, y : Int, map : Array<CharArray>, visit : Array<BooleanArray>){

        val ch = map[x][y]
        visit[x][y] = true

        for(i in 0 until 4){
            val nx = x+dx[i]
            val ny = y+dy[i]

            if(nx in 0 until N && ny in 0 until N){
                if(!visit[nx][ny] && map[nx][ny] == ch){
                    dfs(nx,ny,map,visit)
                }
            }
        }

    }


    fun initMap() {

        for (i in 0 until N) {
            val input = br.readLine()
            for (j in 0 until N) {
                val char = input[j]
                originalMap[i][j] = char

                if (char == 'R') {
                    rgMap[i][j] = 'G'
                } else {
                    rgMap[i][j] = char
                }

            }
        }
    }

