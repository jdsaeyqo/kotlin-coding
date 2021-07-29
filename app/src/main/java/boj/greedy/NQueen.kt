package boj.greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

class NQueen {

    val br = BufferedReader(InputStreamReader(System.`in`))

    var N = 0

    var cnt = 0

    fun main(){

        N = br.readLine().toInt()

        for(i in 1..N){
            val arr = IntArray(N+1)
            arr[1] = i
            nQueen(arr,1)
        }

        println(cnt)

    }

    private fun nQueen(arr : IntArray, row : Int){

        if(row == N){
            cnt++
            return
        }

        for(i in 1..N){
            arr[row+1] = i
            if(check(arr,row+1)){
                nQueen(arr,row+1)
            }

        }


    }

    private fun check(arr : IntArray, row : Int) : Boolean {

        for(i in 1 until row){

            if(arr[row] == arr[i] || abs(row - i) == abs(arr[row] - arr[i])){
                return false
            }

        }
        return true
    }

}

fun main(){

    val s = NQueen()

    s.main()
}