package kot

import java.util.*


class Solution_collection_test {

    val list = mutableListOf<Int>()
    val set = hashSetOf<Int>()
    val map = hashMapOf<String,Int>()
    val treeMap : TreeMap<String,Int> = TreeMap()

    fun string(){

        val str = "ab cd efg"
        val arr = str.split(" ")
        println(arr[0])
        println(arr[1])
        println(arr[2])

        val arr1 = arr.sortedByDescending { it[1] }

        println(arr1)

        val s = "dfa"

    }


    fun list(): Int {

        val letters = ('a'..'z').toMutableList()

       val iter = letters.iterator()

        //리스트 반복문 돌며 제거
       while(iter.hasNext()){
            val next = iter.next()
            if(next == 'c') {
                iter.remove()
            }
        }

        println(letters)

        //리스트 추가 삭제
        list.add(3)
        list.add(2)
        list.add(4)
        list.add(8)
        list.add(1,1) //리스트에 추가
        list[1] = 5 //리스트 값 변경
        println("리스트 : $list")

        println("포함 여부 :${list.contains(3)}")

        println("리스트 오름차순 정렬 : ${list.sorted()}")
        println("리스트 내림차순 정렬 : ${list.sortedDescending()}")
        println("리스트 뒤집기 : ${list.reversed()}")

        list.removeAt(0)
        list.remove(1)
        println("리스트 : $list")

        val arr = list.toTypedArray() // 리스트를 배열로

        var answer = -1
        return answer
    }

    fun set(){
        set.add(5)
        set.add(3)
        set.add(7)
        set.add(7)
        println(" Set : $set") //자동 정렬 됨

        println(set.add(3)) //들어갈 수 없으면 false
        println(set.add(8)) //들어갈 수 있어 true 반환 후 set추가

        set.remove(3)
        println(" Set : $set")

        //Set 값 꺼내기
        val setIterator = set.iterator()

        while (setIterator.hasNext()){
           val next = setIterator.next()
            println(next)
            if(next == 7){
                setIterator.remove()
            }
        }
        println(" Set : $set")

    }

    fun map(){
        map["가"] = 4
        map["나"] = 5
        map["다"] = 3

        for(i in map.keys){
            println("키 : $i") //넣은 순서 반영 x
        }

        for(i in map.values){
            println("값 : $i")
        }

        val map1 = map.toList().sortedBy { it.second }.toMap().toMutableMap()

        println("맵 키 오름차순 정렬 : ${map.toSortedMap()}")
        println("맵 키 내림차순 정렬 : ${map.toSortedMap(reverseOrder())}") // 키 값 자동 내림차순 정렬
        println("맵 value 오름차순 정렬 : ${map.toList().sortedBy { it.second }}")
        println("맵 value 내림차순 정렬 : ${map.toList().sortedByDescending { it.second }}")

        val iter = map.iterator()

        while (iter.hasNext()){
            val next = iter.next()
            if(next.key == "나" || next.value == 3){
                iter.remove()
            }
        }

        println(map)


        treeMap["라"] = 5
        treeMap["나"] = 4
        treeMap["다"] = 3


        for(i in treeMap.keys){
            println("트리맵 키 $i")  // 키 값 자동 오름차순
        }

        for(i in treeMap.values){
            println("트리맵 값 $i")
        }

        val itertree = treeMap.iterator()
        while (itertree.hasNext()){
            val next = itertree.next()
            if(next.value == 4 || next.key == "다"){
                itertree.remove()
            }
        }

        println(treeMap)
    }
}

fun main(){

    val s = Solution_collection_test()
//    println(s.list())
//    println(s.set())
//    println(s.boj.dfs_bfs.getMap())
        println(s.string())
}