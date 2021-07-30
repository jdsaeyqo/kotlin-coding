package naverwebtoon

class Solution {
    lateinit var map : Array<IntArray>
    lateinit var restArr : IntArray
    lateinit var checkArr : IntArray
    fun solution(bricks: IntArray, n: Int, k: Int): Int {
        var answer: Int = 0

        map = Array(n){IntArray(bricks.size)}

        for(i in 0 until bricks.size){
            if(bricks[i] == 0) continue
            for(j in n-1 downTo n-bricks[i]){

                map[j][i] = 1
            }
        }

        restArr = IntArray(bricks.size-2)
        for(i in 1 until bricks.size-1){
            restArr[i-1] = n-bricks[i]
        }

        var cnt = 0
        var idx = 0
        var sum = 0
        checkArr = IntArray(bricks.size)

        while(cnt != k){

            idx = restArr.indexOf(restArr.min()!!)
            sum+=restArr.min()!!

            cnt = check(idx+1)

        }

        return sum
    }

    fun check(idx : Int) : Int{
        var count = 0
        checkArr[idx] = 1

        for(i in checkArr.indices){
            if(i == checkArr.size-1){
                count++
                break
            }
            if(checkArr[i]==0 && checkArr[i+1] != 0){
                count++
            }
        }
        return count
    }

}

