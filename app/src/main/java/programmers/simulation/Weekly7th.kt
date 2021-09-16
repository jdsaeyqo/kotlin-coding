package programmers.simulation

class Weekly7th {

    //7주차 해결중
    fun solution(enter: IntArray, leave: IntArray): IntArray {

        val answer = IntArray(enter.size)

        val enterList = enter.toMutableList()

        leave.forEach { num ->
            val index = enterList.indexOf(num)

            if(index > 0){
                for(i in 0 until index){
                    answer[num]++
                    answer[enterList[0]]++


                }

        } }


        return answer
    }
}