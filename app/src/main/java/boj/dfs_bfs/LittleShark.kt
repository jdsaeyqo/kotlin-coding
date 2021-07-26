package boj.dfs_bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var st : StringTokenizer

lateinit var map : Array<IntArray>
lateinit var visit : Array<BooleanArray>
var feedList = ArrayList<Fish>()
var n = 0

val dx = intArrayOf(1,0,-1,0)
val dy = intArrayOf(0,1,0,-1)

var sharkX = 0
var sharkY = 0
var sharkSize = 2
var eatCnt = 0

var answer = 0

fun main(){

    n = br.readLine().toInt()
    map = Array(n){IntArray(n)}
    visit = Array(n){BooleanArray(n)}

    initMap()

    bfs()

    println(answer)

}

fun bfs(){

    visit[sharkX][sharkY] = true

    val q = LinkedList<Fish>()

    q.offer(Fish(sharkX,sharkY,0))

    while(true){


        while(q.isNotEmpty()){

            val cur = q.poll()!!

            val x = cur.x
            val y = cur.y
            val time = cur.time

            for(i in 0 until 4){
                val nx = x + dx[i]
                val ny = y + dy[i]

                if(nx in 0 until n && ny in 0 until n  && !visit[nx][ny] ){

                    if(map[nx][ny] < sharkSize && map[nx][ny] != 0){
                        q.offer(Fish(nx,ny,time+1))
                        visit[nx][ny] = true
                        feedList.add(Fish(nx,ny,time+1))
                    }

                    if(map[nx][ny] == sharkSize || map[nx][ny] == 0){
                        visit[nx][ny] = true
                        q.offer(Fish(nx,ny,time+1))
                    }
                }
            }
        }

        if(feedList.isNotEmpty()){

            eat()

            q.clear()
            visit = Array(n){BooleanArray(n){false}}

            q.add(Fish(sharkX,sharkY,0))
            visit[sharkX][sharkY] = true

        }else{
            return
        }

    }

}

fun eat(){

    feedList.sortWith(Comparator{o1: Fish, o2: Fish ->
        return@Comparator if (o1.time == o2.time){
            if(o1.x == o2.x){
               if(o1.y > o2.y){
                   1
               }else{
                   -1
               }
            }else{
                if(o1.x > o2.x){
                    1
                }else{
                    -1
                }
            }

        }else if (o1.time > o2.time){
           1
        }else{
            -1
        }
    })

    val now = feedList[0]

    sharkX = now.x
    sharkY = now.y

    eatCnt++
    if(eatCnt == sharkSize){
        sharkSize++
        eatCnt = 0
    }

    answer += now.time

    map[now.x][now.y] = 0

    feedList.clear()

}

fun initMap(){
    for(i in 0 until n){
        st = StringTokenizer(br.readLine())
        for(j in 0 until n){
            map[i][j] = st.nextToken().toInt()
            if(map[i][j] == 9){
                sharkX = i
                sharkY = j
                map[i][j] = 0
            }
        }

    }
}

data class Fish(

    var x : Int,
    var y : Int,
    var time : Int
)


