package programmers.simulation

import kot.Boxer

// 테스트케이스 5번 해결 안됨
class Weekly6th {
    fun solution(weights: IntArray, head2head: Array<String>): IntArray {

        val boxerList = arrayListOf<Boxer>()
        val n = weights.size

        for (i in 0 until n) {
            val boxer = Boxer(num = i + 1, weight = weights[i])
            for (j in 0 until n) {
                if(i!=j){

                    if(head2head[i][j] !='N'){
                        boxer.match++
                    }
                    if (head2head[i][j] == 'W') {
                        boxer.win++
                        if (weights[i] < weights[j]) {
                            boxer.winToBig++
                        }
                    }
                }

            }

            boxer.rate = boxer.win / boxer.match.toDouble() * 100
            boxerList.add(boxer)

        }

        boxerList.sortWith(
            compareByDescending(Boxer::rate)
                .thenByDescending(Boxer::winToBig)
                .thenByDescending(Boxer::weight)
                .thenBy(Boxer::num)
        )

        val answer = IntArray(n)
        for (i in 0 until n) {
            answer[i] = boxerList[i].num
        }

        return answer
    }
}

data class Boxer(
    var num: Int = 0,
    var weight: Int = 0,
    var match: Int = 0,
    var win: Int = 0,
    var winToBig: Int = 0,
    var rate: Double = 0.0

)