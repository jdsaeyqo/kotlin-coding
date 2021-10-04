package boj.datastructure
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ10828 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    fun main(){

        val n = br.readLine().toInt()
        val stk = Stack<Int>()

        repeat(n){

            val str = br.readLine()

            if(str[0] == 'p'){
                if(str[1] == 'u'){
                    stk.push(str.split(" ")[1].toInt())
                }else{
                    if(stk.isNotEmpty()){
                        val pop = stk.pop()
                        println(pop)
                    }else{
                        println(-1)
                    }
                }
            }else if(str[0] == 's'){
                println(stk.size)
            }else if(str[0] == 't'){
                if(stk.isNotEmpty()){
                    println(stk.peek())
                }else{
                    println(-1)
                }

            }else{
                if(stk.isEmpty()){
                    println(1)
                }else{
                    println(0)
                }
            }



        }

    }

}