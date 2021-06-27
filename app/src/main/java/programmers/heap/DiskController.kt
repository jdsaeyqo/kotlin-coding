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
        val size = waiting.size

        jobs.forEach { job->
            waiting.add(Job(job[0],job[1]))
        }

        while (waiting.isNotEmpty()){

            val working = PriorityQueue<Job>(compareBy { it.duration })

            if(waiting.isNotEmpty() && waiting.peek().start <= currentTime){
                working.offer(waiting.poll())
            }

            if(working.isEmpty()){
                currentTime++
                continue
            }
            val job = working.poll()
            currentTime+=job.duration
            answer += currentTime-job.start

        }
        return answer / size
    }
}


@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val s = Solution()




}
