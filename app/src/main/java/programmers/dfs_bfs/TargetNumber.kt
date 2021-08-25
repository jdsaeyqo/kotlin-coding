package programmers.dfs_bfs

class TargetNumber {
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {

        calc(numbers[0],1,numbers,target)
        calc(-numbers[0],1,numbers,target)

        return answer
    }

    fun calc(sum : Int, idx : Int, numbers : IntArray, target : Int){

        if(idx == numbers.size){
            if(sum==target){
                answer++

            }
            return
        }

        calc(sum+numbers[idx],idx+1,numbers,target)
        calc(sum-numbers[idx],idx+1,numbers,target)

    }
}