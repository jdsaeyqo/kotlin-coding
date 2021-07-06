package programmers.greedy

import java.util.*

class MatrixTurn {

    lateinit var arr : Array<IntArray>

    lateinit var result : IntArray

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {

        arr = Array(rows+1){IntArray(columns+1)}
        result = IntArray(queries.size)

        initArr(rows,columns)

        for(i in queries.indices){
            var x1 = queries[i][0]
            var y1 = queries[i][1]
            var x2 = queries[i][2]
            var y2 = queries[i][3]

            turnMatrix(x1,y1,x2,y2,i)

        }

        return result
    }

    fun turnMatrix(x1 : Int,y1 : Int,x2 : Int,y2 : Int,idx : Int){

        val queue = LinkedList<Int>()

        queue.offer(arr[x1][y1])
        var min = arr[x1][y1]

        //위
        for(i in y1+1..y2){
            val next = arr[x1][i]
            queue.offer(next)
            if(min > next) min = next
            arr[x1][i] = queue.poll()
        }

        //오른쪽

        for(i in x1+1..x2){
            val next = arr[i][y2]
            queue.offer(next)
            if(min > next) min = next
            arr[i][y2] = queue.poll()
        }

        //아래
        for(i in y2-1 downTo y1){
            val next = arr[x2][i]
            queue.offer(next)
            if(min > next) min = next
            arr[x2][i] = queue.poll()
        }

        //왼쪽
        for(i in x2-1 downTo x1){
            val next = arr[i][y1]
            queue.offer(next)
            if(min > next) min = next
            arr[i][y1] = queue.poll()
        }


        result[idx] = min

    }

    fun initArr(rows : Int, columns : Int){

        for(i in 1..rows){
            for(j in 1..columns){
                arr[i][j] = columns*(i-1)+j

            }
        }
    }
}