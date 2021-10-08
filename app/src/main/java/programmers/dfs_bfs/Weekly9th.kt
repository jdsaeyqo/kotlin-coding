package programmers.dfs_bfs

class Weekly9th {
    var cnt = 0
    var ans = 100
    fun solution(n: Int, wires: Array<IntArray>): Int {

        val map = Array(n+1){IntArray(n+1)}

        wires.forEach{
            map[it[0]][it[1]] = 1
            map[it[1]][it[0]] = 1

        }

        wires.forEach{

            val copyMap = copyMap(n,map)
            val x = it[0]
            val y = it[1]
            copyMap[x][y] = 0
            copyMap[y][x] = 0
            val visit = BooleanArray(n+1)
            val result = arrayListOf<Int>()

            for(i in 1..n){
                if(!visit[i]){
                    dfs(copyMap,visit,i,n)
                    result.add(cnt)
                    cnt = 0
                }


            }

            ans = Math.min(ans,Math.abs(result[0]-result[1]))

        }

        return ans
    }

    fun dfs(copyMap : Array<IntArray>, visit : BooleanArray, i : Int,n : Int) {
        cnt++
        visit[i] = true
        for(j in 1..n){
            if( i!=j && !visit[j] && copyMap[i][j] == 1){
                dfs(copyMap , visit,j,n)
            }
        }

    }

    fun copyMap(n : Int,map : Array<IntArray>) : Array<IntArray> {
        val copy = Array(n+1){IntArray(n+1)}

        for(i in 1..n){
            for(j in 1..n){
                copy[i][j] = map[i][j]
            }
        }
        return copy
    }
}
