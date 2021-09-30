package boj.dfs_bfs
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ7576 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer
    var n = 0
    var m = 0
    lateinit var map : Array<IntArray>
    val tomatoList = LinkedList<Pair<Int,Int>>()

    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,1,0,-1)

    var day = 0
    fun main(){

        init()

        bfs()

    }

    fun bfs(){


        while(tomatoList.isNotEmpty()){

            for(i in 0 until tomatoList.size){

                val tomato = tomatoList.poll()!!
                val cx = tomato.first
                val cy = tomato.second

                for(j in 0 until 4){
                    val nx = cx+dx[j]
                    val ny = cy+dy[j]

                    if(nx in 0 until n && ny in 0 until m){
                        if(map[nx][ny]==0){
                            map[nx][ny] = 1
                            tomatoList.offer(Pair(nx,ny))
                        }
                    }
                }

            }
            day++

        }

        if(check()){
            println(day-1)
        }else{
            println(-1)
        }
    }

    fun check() : Boolean{

        for(i in 0 until n){
            for(j in 0 until m){
                if(map[i][j] == 0){
                    return false
                }
            }
        }
        return true
    }

    fun init(){
        st = StringTokenizer(br.readLine())
        m = st.nextToken().toInt()
        n = st.nextToken().toInt()

        map = Array(n){IntArray(m)}

        repeat(n){i->
            st = StringTokenizer(br.readLine())
            repeat(m){ j->
                val info = st.nextToken().toInt()
                if(info == 1){
                    tomatoList.add(Pair(i,j))
                }
                map[i][j] = info
            }
        }
    }
}

fun main(){
    BOJ7576().main()
}