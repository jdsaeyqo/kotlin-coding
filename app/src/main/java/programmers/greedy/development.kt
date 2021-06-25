package programmers.greedy

import java.util.*

class Solution5 {

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {

        val completeDay : Queue<Int> = LinkedList()

        val ans = mutableListOf<Int>()

        for(i in progresses.indices){

            completeDay.offer(getDay(progresses[i],speeds[i]))

        }

        var num = completeDay.poll()
        var cnt = 1

        while(completeDay.isNotEmpty()){

                val next = completeDay.poll()

                if(num >= next){

                    cnt++

                }else{
                    ans.add(cnt)
                    num = next
                    cnt = 1

                }
        }

        ans.add(cnt)


        return ans.toIntArray()
    }

    private fun getDay(progress : Int, speed : Int) : Int{

        val remainProgress = 100 - progress

        return if (remainProgress % speed == 0) remainProgress / speed
        else remainProgress / speed +1

    }

}

fun main(){
    val s = Solution5()
   val answ =  s.solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))

    println(answ.contentToString())
}