package programmers.graph.floyd

class Solution {

    fun solution(n: Int, results: Array<IntArray>): Int {

        var answer = 0

        val map = Array(n+1){IntArray(n+1)}

        for(result in results){
            map[result[0]][result[1]] = 1
            map[result[1]][result[0]] = -1
        }

        floyd(map,n)

        map.forEach{
            println(it.contentToString())
        }


        for(i in 1..n){
            var cnt = 0
            for(j in 1..n){
                if(map[i][j] != 0){
                    cnt++
                }
            }
            if(cnt == n-1) answer++
        }


        return answer
    }

    fun floyd(map : Array<IntArray>,n : Int){

        for(k in 1..n){
            for(i in 1..n){
                for(j in 1..n){
                    if(map[i][k] == map[k][j] && map[i][k]!=0){
                        map[i][j] = map[i][k]
                    }
                }
            }
        }

    }
}