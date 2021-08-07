package boj.simulation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ14890 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer

    var n = 0
    var L = 0
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0 - 1, 0)

    lateinit var map: Array<IntArray>

    var ans = 0

    fun main() {

        init()

       for(i in 0 until n){
           if(makeRoad(i,0,'H')){
               ans++
           }
           if(makeRoad(0,i,'V')){
               ans++
           }
       }

        println(ans)

    }

    private fun makeRoad(x : Int, y : Int, dir : Char) : Boolean{

        val visit = BooleanArray(n)
        val height = IntArray(n)

        for(i in 0 until n){
            if(dir == 'H'){
                height[i] = map[x][y+i]
            }else{
                height[i] = map[x+i][y]
            }
        }

        for(i in 0 until n-1){
            if(height[i] == height[i+1]){
                continue
            }

            if(Math.abs(height[i] - height[i+1]) > 1){
                return false
            }

            if(height[i] - 1 == height[i+1]){
                for(j in i+1..i+L){
                    if(j >=n || visit[j] || height[j] != height[i+1]){
                        return false
                    }
                    visit[j] = true
                }

            }else if(height[i] + 1 == height[i+1]){
                for(j in i downTo i-L+1){
                    if(j < 0 || visit[j] || height[j] != height[i]){
                        return false
                    }
                    visit[j] = true
                }
            }
        }
        return true

    }


    private fun init() {

        st = StringTokenizer(br.readLine())

        n = st.nextToken().toInt()
        L = st.nextToken().toInt()

        map = Array(n) { IntArray(n) }


        repeat(n) { i ->
            st = StringTokenizer(br.readLine())
            repeat(n) { j ->
                map[i][j] = st.nextToken().toInt()
            }
        }


    }
}

fun main() {
    val s = BOJ14890()
    s.main()
}