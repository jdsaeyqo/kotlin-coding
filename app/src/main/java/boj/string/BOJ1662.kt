package boj.string

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ1662 {
    fun main(){

        val br = BufferedReader(InputStreamReader(System.`in`))

        val s = br.readLine()

        val leng = Stack<Int>()
        val multi = Stack<Int>()

        var cnt = 0

        for(i in s.indices){
            if(s[i] == '('){
                cnt -=1
                val num = s[i-1] - '0'
                leng.push(cnt)
                multi.push(num)
                cnt = 0
            }else if(s[i] == ')'){
                var value = multi.pop()
                value*=cnt

                val originLen = leng.pop()
                cnt = originLen+value
            }else cnt++
        }

        println(cnt)


    }
}