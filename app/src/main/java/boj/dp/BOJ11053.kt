package boj.dp
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ11053 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    fun main(){

        val n = br.readLine().toInt()
        val arr = IntArray(n)
        val dp = IntArray(n)

        st = StringTokenizer(br.readLine())
        repeat(n){i->
            arr[i] = st.nextToken().toInt()
        }
        dp[0] = 1

        for(i in 1 until n){
            var flag = false
            for(j in i-1 downTo 0){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1)
                    flag = true
                }
            }
            if(!flag){
                dp[i] = 1
            }
        }
        dp.sortDescending()

        println(dp[0])

    }

}