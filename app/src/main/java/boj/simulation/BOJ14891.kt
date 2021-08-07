package boj.simulation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ14891 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    val chain = Array(4){IntArray(8)}
    var n = 0
    lateinit var turnArr : Array<IntArray>
    val visit = BooleanArray(4)
    val score = intArrayOf(1,2,4,8)

    var answer = 0
    fun main(){

        init()

        turnArr.forEach{
            val chainNum = it[0] - 1
            val dir = it[1]

            turn(chainNum,dir)

            visit.fill(false)


        }

        for(i in 0 until 4){
            if(chain[i][0] == 1){
                answer+= score[i]
            }
        }

        println(answer)

    }

    private fun turn(chainNum : Int, dir : Int){

        visit[chainNum] = true

        var left = false
        var right = false

        if(chainNum - 1 >= 0 && !visit[chainNum-1]){
            if(chain[chainNum][6] != chain[chainNum-1][2]){
                left = true

            }
        }

        if(chainNum + 1 <= 3 && !visit[chainNum+1] ){
            if(chain[chainNum][2] != chain[chainNum+1][6]){
                right = true

            }
        }

        if(dir == 1){
            val tmp = chain[chainNum][7]
            for(i in 7 downTo 1){
                chain[chainNum][i] = chain[chainNum][i-1]
            }
            chain[chainNum][0] = tmp
        }else{
            val tmp = chain[chainNum][0]
            for(i in 0..6){
                chain[chainNum][i] = chain[chainNum][i+1]
            }
            chain[chainNum][7] = tmp
        }

        if(left) turn(chainNum-1,-dir)

        if(right) turn(chainNum+1,-dir)

    }

    private fun init(){

        for(i in 0 until 4){
            val input = br.readLine()
            for(j in 0 until 8){
                chain[i][j] = (input[j]-'0')
            }
        }

        n = br.readLine().toInt()
        turnArr = Array(n){IntArray(n)}

        for(i in 0 until n){
            st = StringTokenizer(br.readLine())
            for(j in 0 until 2){
                turnArr[i][j] = st.nextToken().toInt()
            }
        }

    }
}