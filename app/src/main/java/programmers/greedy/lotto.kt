package programmers.greedy

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val answer = IntArray(2)

        lottos.forEach { i ->

            if (i in win_nums) {
                answer[0]++
                answer[1]++

            } else if (i == 0) {
                answer[0]++
            }

        }

        return setScore(answer)
    }

    private fun setScore(answer : IntArray) : IntArray{

       for(i in answer.indices){
           if(answer[i] >=2){
               answer[i] = 7-answer[i]
           }else{
               answer[i] = 6
           }
       }

        return answer

    }
}

fun main(){

    val s = Solution()
    val ans = s.solution(intArrayOf(44, 1, 0, 0, 31, 25), intArrayOf(31, 10, 45, 1, 6, 19))

    println(ans.contentToString())

}