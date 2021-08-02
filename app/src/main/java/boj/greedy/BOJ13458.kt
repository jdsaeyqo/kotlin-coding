package boj.greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//5
//10 9 10 9 10
//7 20
//10
class BOJ13458 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var ans : Long = 0

    fun main(){

        val n = br.readLine().toInt()
        val arr = IntArray(n)

        st = StringTokenizer(br.readLine())
        for(i in 0 until n){
            arr[i] = st.nextToken().toInt()
        }
        st = StringTokenizer(br.readLine())
        val B = st.nextToken().toInt()
        val C = st.nextToken().toInt()

        for(i in 0 until n){
            var stu = arr[i]
            ans++
            if(stu > B){
                stu -=B
                ans+=stu/C
                if(stu%C !=0){
                    ans++
                }
            }

        }

        println(ans)

    }


}

fun main(){
    val s = BOJ13458()
    s.main()
}

