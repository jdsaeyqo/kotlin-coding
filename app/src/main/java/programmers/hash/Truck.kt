package programmers.hash

import java.util.*

class Solution1 {
    val waitingQueue = LinkedList<Truck>()
    val movingQueue = LinkedList<Truck>()
    val finishQueue = LinkedList<Truck>()
    var maxWeight = 0
    var maxLength = 0
    var answerTime = 0

    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        maxLength = bridge_length
        maxWeight = weight

        truck_weights.forEach{weight ->
            waitingQueue.offer(Truck(0,weight))
        }

        while(finishQueue.size!=truck_weights.size){

            if(movingQueue.isNotEmpty()){
                val finishTruck = movingQueue.peek()
                if(finishTruck.time == maxLength){
                    finishQueue.offer(finishTruck)
                    movingQueue.poll()

                }
            }

            if(waitingQueue.isNotEmpty()){
                val startTruck = waitingQueue.peek()
                movingQueue.offer(startTruck)
            }

            if(movingQueue.size <= maxLength && sumWeight(movingQueue) <= maxWeight){
                waitingQueue.poll()
            }else{
                movingQueue.pollLast()
            }

            move(movingQueue)

            answerTime++

        }

        return answerTime
    }

    fun move(q : LinkedList<Truck>){
        val iter = q.iterator()

        while(iter.hasNext()){
            val next = iter.next()
            next.time++
        }

    }

    fun sumWeight(q : LinkedList<Truck>) : Int{
        var sum = 0

        if(q.isNotEmpty()){
            val iter = q.iterator()

            while(iter.hasNext()){
                val next = iter.next()
                sum+=next.weight

            }
        }

        return sum
    }
}

data class Truck(var time : Int,var weight : Int)

