package programmers

class Solution4 {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0

        for(i in left..right){
            answer+=check(i)
        }

        return answer
    }

    private fun check(num : Int) : Int{

        var cnt = 0

        for(i in 1..num){
            if(num % i ==0){
                cnt++
            }
        }


        return if(cnt %2 ==0) num else -num

    }
}

fun main(){
    val s = Solution4()
    println(s.solution(13,17))
}