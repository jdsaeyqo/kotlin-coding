package boj.greedy

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
fun main(){

    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val maxHeap = PriorityQueue<Int>{o1, o2 -> o2 - o1 }
    val minHeap = PriorityQueue<Int>()

    val sb = StringBuilder()

    for(i in 0 until N){
        val num = br.readLine().toInt()

        if(minHeap.size == maxHeap.size){
            maxHeap.offer(num)
        }else minHeap.offer(num)

        if(minHeap.isNotEmpty() && maxHeap.isNotEmpty()){
            if(minHeap.peek()!! < maxHeap.peek()!!){
                val tmp = minHeap.poll()
                minHeap.offer(maxHeap.poll())
                maxHeap.offer(tmp)
            }
        }
        sb.append("${maxHeap.peek()}\n")

    }

    println(sb)
}