package programmers.graph.floyd

class Delivery {

    lateinit var map : Array<IntArray>
    var n =0

    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {

        n = N
        map = Array(N+1){IntArray(N+1)}

        for(i in 1..n){
            for(j in 1..n){
                if(i==j) map[i][j] = 0
                else map[i][j] = 500001
            }
        }

        fetchRoad(road)
        floyd()

        var answer = 0

        for(i in 1..n){
            if(map[1][i] <= k){
                answer++
            }
        }

        return answer
    }

    private fun floyd(){

        for(k in 1..n){
            for(i in 1..n){
                for(j in 1..n){
                    if(i == j) continue

                    if(map[i][j] > map[i][k]+map[k][j]){
                        map[i][j] = map[i][k]+map[k][j]
                    }
                }
            }
        }

    }
    private fun fetchRoad(road: Array<IntArray>){

        for(i in road.indices){

            if(map[road[i][0]][road[i][1]] < road[i][2]) continue

            map[road[i][0]][road[i][1]] = road[i][2]
            map[road[i][1]][road[i][0]] = road[i][2]
        }

    }
}