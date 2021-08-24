package boj.search
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ1920 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer
    var n = 0
    var m = 0
    lateinit var mArr: IntArray

    val hs = hashSetOf<Int>()

    fun main() {

        init()

        mArr.forEach {
            if(hs.contains(it)){
                println(1)
            }else{
                println(0)
            }
        }

    }

    private fun init() {

        n = br.readLine().toInt()

        st = StringTokenizer(br.readLine())
        for (i in 0 until n) {
            hs.add(st.nextToken().toInt())
        }
        m = br.readLine().toInt()
        mArr = IntArray(m)
        st = StringTokenizer(br.readLine())
        for (i in 0 until m) {
            mArr[i] = st.nextToken().toInt()
        }

    }


}

fun main(){
    val s = BOJ1920()
    s.main()
}