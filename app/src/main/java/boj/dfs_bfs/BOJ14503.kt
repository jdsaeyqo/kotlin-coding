package boj.dfs_bfs
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ14503 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var n = 0
    var m = 0
    var robotX = 0
    var robotY = 0
    var dir = 0

    var dx = intArrayOf(-1,0,1,0)
    var dy = intArrayOf(0,1,0,-1)
    var answer = 0
    lateinit var map : Array<IntArray>

    fun main(){

        init()

        dfs(robotX,robotY)
        println(answer)

    }
    private fun dfs(x : Int, y : Int){

        if(map[x][y] != -1){
            map[x][y] = -1
            answer++
        }

        var check = false
        for(i in 0 until 4){
            dir--
            if(dir < 0) dir = 3

            val nx = x+dx[dir]
            val ny = y+dy[dir]

            if(nx in 0 until n && ny in 0 until m){
                if(map[nx][ny]==0){
                    dfs(nx,ny)
                    check = true
                    break
                }
            }

        }
        if(!check){
            var back = dir-2
            if(back < 0) back+=4
            val bx = x+dx[back]
            val by = y+dy[back]
            if(bx in 0 until n && by in 0 until m){
                if(map[bx][by] != 1){
                    dfs(bx,by)
                }
            }


        }

    }

    private fun init(){

        st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        m = st.nextToken().toInt()

        map = Array(n){ IntArray(m) }
        st = StringTokenizer(br.readLine())
        robotX = st.nextToken().toInt()
        robotY = st.nextToken().toInt()
        dir = st.nextToken().toInt()

        repeat(n){ i ->
            st = StringTokenizer(br.readLine())
            repeat(m){ j ->
                map[i][j] = st.nextToken().toInt()
            }
        }

    }

}
fun main(){
    val s = BOJ14503()
    s.main()
}