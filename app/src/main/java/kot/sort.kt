package kot

data class Node(var x : Int = 0, var y : Int = 0, var z : Int  = 0 )

fun main(){

    val list = arrayListOf<Node>()

    list.add(Node(3,2,4))
    list.add(Node(4,1,2))
    list.add(Node(5,4,5))
    list.add(Node(3,6,2))

    list.sortWith(
        //z순으로 먼저 정렬 후
        compareBy(Node::z)
            //z같으면 x 정렬
            .thenBy(Node::x)
            //x까지 같으면 y정렬
            .thenBy(Node::y)
    )

    list.sortWith(
        //z순으로 역순 정렬 후
        compareByDescending(Node::z)
            //z같으면 x 역순 정렬
            .thenByDescending(Node::x)
            //x같으면 y 순 정렬
            .thenBy(Node::y)
    )

    println(list)

    val list1 = arrayListOf<Pair<Int,Int>>()

    list1.add(Pair(1,2))
    list1.add(Pair(0,3))

    list1.sortBy{it.first}
    println(list1)




}