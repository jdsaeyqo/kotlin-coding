package boj.bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ2422 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer
    var n = 0
    var m = 0
    lateinit var map : Array<BooleanArray>
    lateinit var ar : IntArray
    lateinit var visit : BooleanArray

    var answer = 0
    fun main(){

        init()

        comb(ar,visit,0,n,3)
        println(answer)

    }

    private fun check(list : ArrayList<Int>) : Boolean{

        for(i in 0..1){
            for(j in i+1..2){
                if(map[list[i]][list[j]]) return false
            }
        }

       return true

    }

    private fun comb(ar : IntArray, visit : BooleanArray,start : Int, n : Int, r : Int){

        if(r==0){
            val list = arrayListOf<Int>()
            for(i in visit.indices){
                if(visit[i]){
                    list.add(ar[i])
                }
            }

            if(check(list)) answer++
            return
        }

        for(i in start until n){
            if(!visit[i]){
                visit[i] = true
                comb(ar,visit,i+1,n,r-1)
                visit[i] = false
            }
        }

    }

    private fun init(){

        st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        m = st.nextToken().toInt()
        map = Array(n+1){BooleanArray(n+1)}

        repeat(m){
            st = StringTokenizer(br.readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()
            map[x][y]= true
            map[y][x]= true

        }

        ar = IntArray(n)
        for(i in ar.indices){
            ar[i] = i+1
        }

        visit = BooleanArray(n)

    }
}
fun main(){
    val s = BOJ2422()
    s.main()
}