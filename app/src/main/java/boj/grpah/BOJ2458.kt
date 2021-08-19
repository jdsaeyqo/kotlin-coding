package boj.grpah
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ2458 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var N = 0
    var M = 0
    lateinit var map : Array<IntArray>
    val max = 1000000000
    fun main(){

        init()

        for(k in 0 until N){
            for(i in 0 until N){
                for(j in 0 until N){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j]
                    }
                }
            }
        }

        var ans = 0
        for(i in 0 until N){
            var cnt = 0
            for(j in 0 until N){
                if(map[i][j] < max || map[j][i] < max){
                    cnt++
                }
            }
            if(cnt == N-1) ans++
        }
        println(ans)
    }

    private fun init(){

        st = StringTokenizer(br.readLine())
        N = st.nextToken().toInt()
        M = st.nextToken().toInt()
        map = Array(N){IntArray(N){max}}
        for(i in 0 until M){
            st = StringTokenizer(br.readLine())
            map[st.nextToken().toInt()-1][st.nextToken().toInt()-1] = 1
        }

    }
}