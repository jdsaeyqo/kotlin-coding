package programmers

import java.util.*

class DataStructure{

    var stk = Stack<Int>()
    var queue = LinkedList<Int>()
    val priorityQueue = PriorityQueue<Int>()

    fun solution(){

        stk.push(2)
        stk.push(5)
        stk.push(3)

        stk.pop()

        while(stk.isNotEmpty()){
            println(stk.pop())
        }

        queue.offer(4)
        queue.offer(9)
        queue.offer(5)

        queue.offerFirst(1)
        queue.offerLast(10)

        while (queue.isNotEmpty()){
            println(queue.pop())
        }

        priorityQueue.offer(6)
        priorityQueue.offer(2)
        priorityQueue.offer(8)
        priorityQueue.offer(4)

        while (priorityQueue.isNotEmpty()){
            println(priorityQueue.poll())
        }

    }

}

fun main(){

    val s = DataStructure()

    println(s.solution())
}