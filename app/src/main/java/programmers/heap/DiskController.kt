package programmers.heap

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

data class Job(
    val start : Int,
    val duration : Int
)

class Solution {
    @RequiresApi(Build.VERSION_CODES.N)
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var currentTime = 0

        val waiting = PriorityQueue<Job>(compareBy { it.start })
        val size = jobs.size

        jobs.forEach { job->
            waiting.add(Job(job[0],job[1]))
        }

        while (waiting.isNotEmpty()){

            val working = PriorityQueue<Job>(compareBy { it.duration })

            while(waiting.isNotEmpty() && waiting.peek().start <= currentTime){
                working.offer(waiting.poll())
            }

            if(working.isEmpty()){
                currentTime++
                continue
            }
            val job = working.poll()
            currentTime+=job.duration
            answer += currentTime-job.start

            for(i in working.indices){
                waiting.offer(working.poll())
            }

        }
        return answer / size
    }
}


@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val s = Solution()
    val ans = s.solution(arrayOf(intArrayOf(0,3), intArrayOf(1,9), intArrayOf(2,6)))
    println(ans)

}
