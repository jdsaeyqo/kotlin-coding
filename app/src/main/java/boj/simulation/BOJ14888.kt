package kot

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ14888 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer
    var n = 0
    var max = -1000000000
    var min = 1000000000

    lateinit var numArr: IntArray
    lateinit var calcArr: IntArray

    fun main() {

        init()

        calc(1, numArr[0])

        println(max)
        println(min)

    }

    private fun calc(idx: Int, num: Int) {

        if (idx == n) {
            if (num > max) max = num

            if (num < min) min = num

            return
        }

        for (i in 0 until 4) {
            if (calcArr[i] != 0) {

                when (i) {
                    0 -> {
                        calcArr[i]--
                        calc(idx + 1, num + numArr[idx])
                        calcArr[i]++
                    }


                    1 -> {
                        calcArr[i]--
                        calc(idx + 1, num - numArr[idx])
                        calcArr[i]++
                    }


                    2 -> {
                        calcArr[i]--
                        calc(idx + 1, num * numArr[idx])
                        calcArr[i]++
                    }


                    3 -> {
                        calcArr[i]--
                        calc(idx+1,num / numArr[idx])
                        calcArr[i]++
                    }


                }
            }
        }


    }

    private fun init() {
        n = br.readLine().toInt()
        numArr = IntArray(n)

        st = StringTokenizer(br.readLine())
        for (i in 0 until n) {
            numArr[i] = st.nextToken().toInt()
        }

        calcArr = IntArray(4)
        st = StringTokenizer(br.readLine())
        for (i in 0 until 4) {
            calcArr[i] = st.nextToken().toInt()
        }

    }
}

fun main(){
    val s= BOJ14888()
    s.main()
}
