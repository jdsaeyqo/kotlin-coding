package boj.dp
import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ12101 {

    val br = BufferedReader(InputStreamReader(System.`in`))

    fun main(){

        val input = br.readLine().split(" ")
        val n = input[0].toInt()
        val k = input[1].toInt()

        val arr = Array(n + 3) { ArrayList<String>()}

        arr[1].add("1")
        arr[2].add("1+1")
        arr[2].add("2")
        arr[3].add("1+2")
        arr[3].add("1+1+1")
        arr[3].add("2+1")
        arr[3].add("3")

        for (i in 4..n) {
            for (j in 1..3) {
                arr[i - j].forEach {
                    arr[i].add("$it+$j")
                }
            }
        }
        if (arr[n].size < k) {
            println(-1)

        }else{
            arr[n].sort()
            println(arr[n][k-1])
        }



    }
}