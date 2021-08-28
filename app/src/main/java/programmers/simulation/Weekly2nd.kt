package programmers.simulation

class Weekly2nd {
    fun solution(scores: Array<IntArray>): String {
        val n = scores.size
        var answer: String = ""

        for(i in scores.indices){

            val arr = IntArray(n)

            for(j in scores.indices){
                arr[j] = scores[j][i]
            }

            val avg = checkScore(arr,i)
            answer+=getGrade(avg)
        }

        return answer
    }

    fun checkScore(arr: IntArray, stu: Int): Double {

        val stuScore = arr[stu]
        arr.sort()

        return if (arr[0] == stuScore && arr[1] != stuScore) {
            arr[0] = 0
            getAvg(arr)

        } else if (arr[arr.size - 1] == stuScore && arr[arr.size - 2] != stuScore) {
            arr[arr.size - 1] = 0
            getAvg(arr)

        } else {
            getAvg(arr)
        }

    }
    fun getAvg(avgArr : IntArray) : Double{

        var num = 0.0
        var sum = 0

        for(i in avgArr.indices){
            if(avgArr[i] != 0){
                num++
                sum+=avgArr[i]
            }
        }

        return sum / num

    }

    fun getGrade(avg : Double) : String{

        return when(avg){
            in 90..100 -> "A"
            in 80 until 90 -> "B"
            in 70 until 80 -> "C"
            in 50 until 70 -> "D"
            else -> "F"
        }
    }
}