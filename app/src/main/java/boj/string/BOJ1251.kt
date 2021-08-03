package boj.string

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ1251 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var input = ""
    val list = arrayListOf<String>()

    fun main(){

        input = br.readLine()

        for(i in 1..input.length-2){
            for(j in i+1 until input.length){

                val first = input.substring(0,i)
                val second = input.substring(i,j)
                val third = input.substring(j,input.length)

                list.add(change(first,second,third))

            }
        }

        println(list.sorted()[0])

    }
    private fun change(first : String, second : String, third : String) : String{

        val firstReverse = first.reversed()
        val secondReverse = second.reversed()
        val thirdReverse = third.reversed()

        return firstReverse+secondReverse+thirdReverse


    }

}