package boj.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

//10 13
//BBBBBBBBWBWBW
//BBBBBBBBBWBWB
//BBBBBBBBWBWBW
//BBBBBBBBBWBWB
//BBBBBBBBWBWBW
//BBBBBBBBBWBWB
//BBBBBBBBWBWBW
//BBBBBBBBBWBWB
//WWWWWWWWWWBWB
//WWWWWWWWWWBWB
//12
class BOJ1018 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var min = 65

    lateinit var map : Array<CharArray>
    fun main(){

        val input = br.readLine().split(" ")
        val row = input[0].toInt()
        val col = input[1].toInt()

        map = Array(row){CharArray(col)}

        for(i in 0 until row){
            val info = br.readLine()
            for(j in 0 until col){
                map[i][j] = info[j]
            }
        }

        for(i in 0..row-8){
            for(j in 0..col-8){
                findMin(i,j)
            }
        }
        println(min)

    }

    fun findMin(i : Int, j : Int){

        var next = map[i][j]
        var cnt = 0
        for(a in i until i+8){
            for(b in j until j+8){
                if(map[a][b] != next){
                    cnt++
                }

                if(next == 'B'){
                    next = 'W'
                }else{
                    next = 'B'
                }
            }

            if(next == 'B'){
                next = 'W'
            }else{
                next = 'B'
            }
        }

        cnt = Math.min(cnt,64-cnt)

        min = Math.min(cnt,min)

    }


}