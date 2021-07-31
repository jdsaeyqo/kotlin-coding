package boj.greedy
import java.io.BufferedReader
import java.io.InputStreamReader


class BOJ1158 {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var idx = 0
    var N = 0
    var r = 0
    val list = arrayListOf<Int>()
    val answer = StringBuilder()

    fun main(){

        val input = br.readLine().split(" ")
        N = input[0].toInt()
        r = input[1].toInt() - 1


        for(i in 0 until N){
            list.add(i+1)
        }

        while(list.isNotEmpty()){

            idx+=r
            if(idx >= list.size){
                idx%=list.size
            }

            answer.append("${list[idx]}, ")
            list.removeAt(idx)


        }

        val s = answer.toString().substring(0,answer.length-2)
        val ans = "<${s}>"

        println(ans)

    }

}

fun main(){
    val s = BOJ1158()
    s.main()
}