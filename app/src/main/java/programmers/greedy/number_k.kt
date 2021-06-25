package programmers.greedy

class Solution3 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)

        for(i in commands.indices){
            answer[i] = check(array,commands[i])
        }

        return answer
    }

    private fun check(array: IntArray, commands: IntArray) : Int{

        val arr = array.copyOfRange(commands[0]-1,commands[1])

        arr.sort()

        return arr[commands[2]-1]

    }
}

fun main(){
    val s = Solution3()
    val ans = s.solution(intArrayOf(1,5,2,6,3,7,4), arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3)))

    println(ans.contentToString())
}