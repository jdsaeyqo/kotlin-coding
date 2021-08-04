package boj.dfs_bfs
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


class BOJ1926 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var n = 0
    var m = 0

    val dx = intArrayOf(0,1,0,-1)
    val dy = intArrayOf(1,0,-1,0)
    lateinit var visit : Array<BooleanArray>
    lateinit var map : Array<IntArray>

    var cnt = 0
    var max = 0

    fun main(){

        init()

        for(i in 0 until n){
            for(j in 0 until m){

                if(map[i][j] == 1 && !visit[i][j]){
                    visit[i][j] = true
                    bfs(i,j)
                    cnt++
                }

            }
        }
        println(cnt)
        println(max)


    }

    fun bfs(x : Int, y : Int){

        var size = 0
        val q = LinkedList<Pair<Int,Int>>()

        q.offer(Pair(x,y))

        while(q.isNotEmpty()){

            size++

            val position = q.poll()


            for(i in 0 until 4){
                val nx = position.first + dx[i]
                val ny = position.second + dy[i]

                if(nx in 0 until n && ny in 0 until m){
                    if(!visit[nx][ny] && map[nx][ny]==1){
                        visit[nx][ny] = true
                        q.offer(Pair(nx,ny))
                    }
                }
            }

        }
        max = Math.max(size,max)

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
fun main(){
    val s = BOJ1926()
    s.main()
}