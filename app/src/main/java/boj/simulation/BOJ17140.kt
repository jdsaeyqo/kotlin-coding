package boj.simulation
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ17140 {
    val br = BufferedReader(InputStreamReader(System.`in`))
    lateinit var st : StringTokenizer

    var r = 0
    var c = 0
    var k = 0
    lateinit var map : Array<IntArray>
    var n = 3
    var m = 3
    var time = 0
    fun main(){

        init()

        while(true){

            if(r < n && c < m && map[r][c]==k){
                println(time)
                break
            }
            if(time == 101){
                if(r >= n || c >= m || map[r][c] != k){
                    println(-1)
                }else{
                    println(time)
                }
                break
            }

            time++

            if(n >= m){
                doR()


            }else{
                doC()

            }

        }


    }
    private fun doR(){
        val list = arrayListOf<ArrayList<Pair<Int,Int>>>()

        var max = 0
        for(i in 0 until n){
            val tmpList = arrayListOf<Pair<Int,Int>>()
            val visit = IntArray(101)
            for(j in 0 until m){
                visit[map[i][j]]++
            }

            for(k in visit.indices){
                if(visit[k] != 0 && k!=0){
                    tmpList.add(Pair(k,visit[k]))
                }
            }

            tmpList.sortWith(compareBy({it.second},{it.first}))
            max = Math.max(max,tmpList.size)
            list.add(tmpList)


        }
        for(i in list.indices){
            while(list[i].size<max){
                list[i].add(Pair(0,0))
            }
        }

        m = max*2
        map = Array(n){IntArray(m)}

        for(i in 0 until n){
            val tmp = list[i]
            val tmList = arrayListOf<Int>()
            tmp.forEach{
                tmList.add(it.first)
                tmList.add(it.second)
            }
            map[i] = tmList.toIntArray()
        }


    }
    private fun doC(){
        val list = arrayListOf<ArrayList<Pair<Int,Int>>>()

        var max = 0
        for(i in 0 until m){
            val tmpList = arrayListOf<Pair<Int,Int>>()
            val visit = IntArray(101)
            for(j in 0 until n){
                visit[map[j][i]]++
            }

            for(k in visit.indices){
                if(visit[k] != 0 && k!=0){
                    tmpList.add(Pair(k,visit[k]))
                }
            }

            tmpList.sortWith(compareBy({it.second},{it.first}))
            max = Math.max(max,tmpList.size)
            list.add(tmpList)


        }
        for(i in list.indices){
            while(list[i].size<max){
                list[i].add(Pair(0,0))
            }
        }

        n = max*2
        map = Array(n){IntArray(m)}

        for(i in 0 until m){
            val tmp = list[i]
            val tmList = LinkedList<Int>()
            tmp.forEach{
                tmList.add(it.first)
                tmList.add(it.second)
            }
            for(j in 0 until n){
                map[j][i] = tmList.pollFirst()!!
            }
        }


    }

    private fun init(){

        st = StringTokenizer(br.readLine())
        r = st.nextToken().toInt()-1
        c = st.nextToken().toInt()-1
        k = st.nextToken().toInt()
        map = Array(n){IntArray(m)}

        for(i in 0 until n){
            st = StringTokenizer(br.readLine())
            for(j in 0 until m){
                map[i][j] = st.nextToken().toInt()
            }
        }

    }

}