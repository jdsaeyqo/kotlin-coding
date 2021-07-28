package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class HideAndSeek{
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var visit : BooleanArray

    var start = 0
    var target = 0
    var cnt = 0

    fun main(){

        val input = br.readLine().split(" ")
        start = input[0].toInt()
        target = input[1].toInt()

        visit = BooleanArray(100001)

        bfs()

    }

    fun bfs(){

        val q = LinkedList<Int>()

        q.offer(start)
        visit[start] = true

        while(q.isNotEmpty()){

            for(i in 0 until q.size){

                val num = q.poll()!!

                if(num == target){
                    println(cnt)
                    return
                }

                if(num+1 <= 100000 && !visit[num+1] ){
                    visit[num+1] = true
                    q.offer(num+1)
                }

                if(num-1 >= 0 &&!visit[num-1]){
                    visit[num-1] = true
                    q.offer(num-1)
                }

                if(num*2 <= 100000 && !visit[num*2] ){
                    visit[num*2] = true
                    q.offer(num*2)
                }
            }
            cnt++

        }

    }
}

fun main(){
    val s = HideAndSeek()
    s.main()
}