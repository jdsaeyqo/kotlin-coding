package boj.perm_comb

//4 6
//a t c i s w

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
lateinit var st : StringTokenizer

fun main(){

    st = StringTokenizer(br.readLine())

    val r = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val arr = Array(n){""}
    st = StringTokenizer(br.readLine())

    for(i in arr.indices){
        arr[i] = st.nextToken()
    }

    arr.sort()

    val visit = BooleanArray(n)
    comb(arr,visit,0,n,r)

}

fun check(str : String) : Boolean{

    var cntMo = 0
    var cntJa = 0
    str.forEach{ ch ->

        if(ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'e'){
            cntMo++
        }else{
            cntJa++
        }

    }

    if(cntMo < 1 || cntJa < 2 ){
        return false
    }
    return true

}

fun comb(arr : Array<String>, visit : BooleanArray, start : Int, n : Int, r : Int){

    if(r == 0){
        var str = ""
        for(i in visit.indices){
            if(visit[i]){
                str += arr[i]
            }
        }

        if(check(str)){
            println(str)
        }

    }

    for(i in start until n){
        if(!visit[i]){
            visit[i] = true
            comb(arr,visit,i+1,n,r-1)
            visit[i] = false
        }
    }


}