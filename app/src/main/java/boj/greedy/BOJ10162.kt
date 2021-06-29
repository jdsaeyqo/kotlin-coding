package boj.greedy

import java.lang.StringBuilder

fun main(){

    var time = readLine()!!.toInt()
    val result = IntArray(3)

    while ( time>=10 ){

        if(time >= 300){
            result[0] += time/300
            time%=300

        }else if(time >= 60){
            result[1] += time/60
            time%=60

        }else if(time >= 10){
            result[2] += time/10
            time%=10

        }

    }

    val sb = StringBuilder()
    result.forEach {
        sb.append("$it ")
    }


    if(time != 0) println(-1)
    else println(sb.trim())

}