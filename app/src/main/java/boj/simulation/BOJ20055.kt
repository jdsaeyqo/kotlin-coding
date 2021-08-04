package boj.simulation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ20055 {


    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer

    var n = 0
    var k = 0
    var cnt = 0
    var phase = 1

    lateinit var belt: IntArray
    lateinit var robot : BooleanArray


    fun main() {

        init()

        while (true) {

            //1 과정 수행
            //컨테이너 회전
            val tmp = belt[belt.size - 1]
            for (i in belt.size - 1 downTo 1) {
                belt[i] = belt[i-1]
            }
            belt[0] = tmp

            //로봇 회전

            for(i in robot.size-1 downTo 1){
                robot[i] = robot[i-1]
            }
            robot[0] = false
            robot[n-1] = false

            //2 로봇 이동

           for(i in robot.size-1 downTo 1){
               if(robot[i-1] && !robot[i] && belt[i] > 0){
                   robot[i] = true
                   robot[i-1] = false
                   belt[i]--
                   if(belt[i] == 0) cnt++
               }

           }

            //3 로봇 올리기
            if (belt[0] != 0) {
                belt[0]--
                robot[0] = true
                if (belt[0] == 0) cnt++

            }

            //4 0이 K개 이상인지 체크
            if (cnt >= k) {
                break
            }

            phase++

        }

        println(phase)

    }

    fun init() {
        st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        k = st.nextToken().toInt()
        belt = IntArray(n * 2)
        robot = BooleanArray(n)
        st = StringTokenizer(br.readLine())
        for (i in 0 until n * 2) {
            belt[i] = st.nextToken().toInt()
        }
    }
}

fun main(){
    val s = BOJ20055()
    s.main()
}