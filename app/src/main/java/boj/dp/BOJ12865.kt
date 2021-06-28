package boj.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

//4 7
//6 13
//4 8
//3 6
//5 12
//
//14


fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n+1) {IntArray(k+1)}

    for(i in 1 until n+1) {

        val (w,v) = br.readLine().split(" ").map { it.toInt() }

        for(j in 1 until k+1) {

            if(j < w) {

                arr[i][j] = arr[i-1][j]

            } else {

                arr[i][j] = max(arr[i-1][j], arr[i-1][j-w] + v)
            }
        }
    }
    println(arr[n][k])


}

