package kot

data class Node(var x : Int = 0, var y : Int = 0, var z : Int  = 0 )

fun main(){

    val list = arrayListOf<Node>()

    list.add(Node(3,2,4))
    list.add(Node(4,1,2))
    list.add(Node(5,4,5))
    list.add(Node(3,6,2))

    list.sortWith(
        compareBy(Node::z)
            .thenBy(Node::x)
            .thenBy(Node::y)
    )


    println(list)

}