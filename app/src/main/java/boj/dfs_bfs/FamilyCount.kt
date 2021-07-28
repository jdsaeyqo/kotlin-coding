package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var st : StringTokenizer

var N = 0
var M = 0
var cnt = 0
lateinit var map : Array<IntArray>
lateinit var visit : BooleanArray

fun main(){

    N = br.readLine().toInt()
    map = Array(N+1){IntArray(N+1)}
    visit = BooleanArray(N+1)

    st = StringTokenizer(br.readLine())
    val person1 = st.nextToken().toInt()
    val person2 = st.nextToken().toInt()

    M = br.readLine().toInt()
    for( i in 0 until M){
        st = StringTokenizer(br.readLine())

        val p1 = st.nextToken().toInt()
        val p2 = st.nextToken().toInt()
        map[p1][p2] = 1
        map[p2][p1] = 1
    }

    bfs(person1,person2)

    println(cnt)
}

fun bfs(p1 : Int, p2 : Int){

    val q = LinkedList<Int>()

    q.offer(p1)
    visit[p1] = true

    while(q.isNotEmpty()){
        for(i in 0 until q.size){

            var p = q.poll()
            if(p == p2){
                return

            }

            for(j in 1..N){
                if(!visit[j] && map[p][j] == 1){
                    q.offer(j)
                    visit[j] = true
                }
            }

        }
        cnt++

    }

    cnt = -1

}