package boj.grpah

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ1922 {

    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st: StringTokenizer

    var n = 0
    var m = 0
    val edgeList = arrayListOf<Edge>()
    lateinit var parent : IntArray

    fun main() {

        init()
        parent = IntArray(n+1)
        for(i in 1..n){
            parent[i] = i
        }

        edgeList.sort()

        var ans = 0
        for(i in edgeList.indices){
            val edge = edgeList[i]

            if(find(edge.start) != find(edge.end)){
                ans += edge.weight
                union(edge.start,edge.end)
            }
        }

        println(ans)

    }
    private fun union(x : Int, y : Int){
        val nx = find(x)
        val ny = find(y)

        if(nx != ny){
            parent[ny] = nx
        }

    }

    private fun find(x : Int) : Int {
        if(x == parent[x]){
            return x
        }
        parent[x] = find(parent[x])
        return parent[x]
    }

    private fun init() {

        n = br.readLine().toInt()
        m = br.readLine().toInt()


        for (i in 0 until m) {
            st = StringTokenizer(br.readLine())
            val start = st.nextToken().toInt()
            val end =  st.nextToken().toInt()
            val weight = st.nextToken().toInt()

            edgeList.add(Edge(start,end, weight))

        }

    }

    data class Edge(var start: Int = 0, var end: Int = 0, var weight: Int = 0) : Comparable<Edge> {

        override fun compareTo(other: Edge): Int {
            return weight - other.weight
        }

    }


}

fun main(){
    val s = BOJ1922()
    s.main()
}