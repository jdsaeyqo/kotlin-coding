package boj.grpah

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ1922 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer
    var n = 0
    var m = 0
    lateinit var map : Array<IntArray>

    fun main(){

        init()

        for(k in 1..n){
            for(i in 1..n){
                for(j in 1..n){
                    if(map[i][j] < map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j]
                    }
                }
            }
        }

    }

    private fun init(){

        n = br.readLine().toInt()
        m = br.readLine().toInt()
        map = Array(n+1){IntArray(4)}
        for(i in 1..n){
            st = StringTokenizer(br.readLine())
            for(j in 1..3){
                map[i][j] = st.nextToken().toInt()
            }

        }

    }

}