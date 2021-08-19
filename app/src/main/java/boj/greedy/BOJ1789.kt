package boj.greedy

import java.io.BufferedReader
import java.io.InputStreamReader



class BOJ1789 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    fun main(){

        val num = kot.br.readLine().toLong()
        var sum : Long = 0
        var add = 1
        while(true){

            sum+=add

            if(sum > num){
                println(add-1)
                break
            }

            if(sum == num){
                println(add)
                break
            }

            add++
        }

    }
}