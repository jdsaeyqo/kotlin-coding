package boj.dfs_bfs
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ14500 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer
    var n = 0
    var m = 0
    var max = 0

    lateinit var map : Array<IntArray>
    lateinit var visit : Array<BooleanArray>

    val dx = intArrayOf(0,1,0,-1)
    val dy = intArrayOf(1,0,-1,0)

    val ex = arrayOf(intArrayOf(0,0,0,1),intArrayOf(0,1,2,1),intArrayOf(0,0,0,-1),intArrayOf(0,-1,0,1))
    val ey = arrayOf(intArrayOf(0,1,2,1),intArrayOf(0,0,0,1),intArrayOf(0,1,2,1),intArrayOf(0,1,1,1))

    fun main(){

        init()

        for(i in 0 until n){
            for(j in 0 until m){

                dfs(i,j,map[i][j],1)

                //ㅗ 모양
                dfsEx(i,j)
            }
        }

        println(max)
    }

    fun dfsEx(x : Int, y : Int){

        for(i in 0 until 4){
            var sum = 0
            var check = true
            for(j in 0 until 4){
                val nx = x + ex[i][j]
                val ny = y + ey[i][j]

                if(nx in 0 until n && ny in 0 until m){
                    sum+=map[nx][ny]
                }else{
                    check = false
                    break
                }
            }
            if(check){
                max = Math.max(sum,max)
            }
        }

    }
    fun dfs(x : Int, y : Int, sum : Int,cnt : Int){

        if(cnt ==4){
            max = Math.max(max,sum)
            return
        }

        visit[x][y] = true

        for(i in 0 until 4){
            val nx = x + dx[i]
            val ny = y + dy[i]

            if(nx in 0 until n && ny in 0 until m){
                if(!visit[nx][ny]){
                    dfs(nx,ny,sum+map[nx][ny],cnt+1)
                }
            }
        }
        visit[x][y] = false

    }

    fun init(){
        st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        m = st.nextToken().toInt()

        map = Array(n){IntArray(m)}
        visit = Array(n){BooleanArray(m)}

        for(i in 0 until n){
            st = StringTokenizer(br.readLine())
            for(j in 0 until m){
                map[i][j] = st.nextToken().toInt()
            }
        }
    }
}