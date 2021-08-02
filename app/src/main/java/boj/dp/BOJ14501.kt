package boj.dp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
//7
//3 10
//5 20
//1 10
//1 20
//2 15
//4 40
//2 200
//45

//10
//1 1
//1 2
//1 3
//1 4
//1 5
//1 6
//1 7
//1 8
//1 9
//1 10
//55

//10
//5 10
//5 9
//5 8
//5 7
//5 6
//5 10
//5 9
//5 8
//5 7
//5 6
//20

//10
//5 50
//4 40
//3 30
//2 20
//1 10
//1 10
//2 20
//3 30
//4 40
//5 50
//90
class BOJ14501 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var n = 0

    fun main(){
        n = br.readLine().toInt()
        val timeArr = IntArray(n+1)
        val costArr = IntArray(n+1)
        val dp = IntArray(n+1)


        for(i in 1..n){
            st = StringTokenizer(br.readLine())
            timeArr[i] = st.nextToken().toInt()
            costArr[i] = st.nextToken().toInt()

        }


        for(i in 1..n){
            if(i+timeArr[i] <= n+1){
                dp[i] = costArr[i]
                for(j in 1 until i){
                    if(j + timeArr[j] <= i){
                        dp[i] = Math.max(dp[j]+costArr[i],dp[i])
                    }
                }

            }
        }

        dp.sortDescending()
        println(dp[0])

    }

}

fun main(){
    val s = BOJ14501()
    s.main()
}