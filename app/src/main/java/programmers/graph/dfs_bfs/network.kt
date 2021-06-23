package programmers.graph.dfs_bfs

class network {

    var visit : BooleanArray = booleanArrayOf()
        fun solution(n: Int, computers: Array<IntArray>): Int {

            visit = BooleanArray(n)

            var cnt = 0

            for(i in computers.indices){
               if(!visit[i]){
                   dfs(i, computers)
                   cnt++
               }
            }

            return cnt
        }

        private fun dfs(i : Int, computers : Array<IntArray>) : BooleanArray{

            visit[i] = true

            for (j in computers[i].indices){
                if(i != j && computers[i][j] == 1 && !visit[j]){
                    dfs(j,computers)
                }
            }

            return visit

        }

}

fun main(){
    val s = network()
    val ans = s.solution(3, arrayOf(intArrayOf(1,1,0), intArrayOf(1,1,1), intArrayOf(0,1,1)))

    println(ans)

}