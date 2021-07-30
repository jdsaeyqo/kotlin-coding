package kot

class CombPerm{

    fun perm(arr : IntArray, output : IntArray, visit : BooleanArray, depth : Int, n : Int, r : Int){

        if(depth == r){
            for (i in 0 until r){
                print("${output[i]} ")
            }
            println()
            return
        }

        for(i in 0 until n){
            if(!visit[i]){
                visit[i] = true
                output[depth] = arr[i]
                perm(arr,output,visit, depth+1, n, r)
                visit[i] = false
            }
        }

    }

    fun comb(arr : CharArray, visit : BooleanArray, start : Int, n : Int, r : Int){
        if(r==0){
            for (i in visit.indices){
                if(visit[i]){
                    print("${arr[i]} ")
                }
            }
            println()
            return
        }

        for(i in start until n){
            if(!visit[i]){
                visit[i] = true
                comb(arr,visit, i+1, n, r-1)
                visit[i] = false
            }
        }
    }


}

fun main(){

    val arr = intArrayOf(1,2,3,4,5)
    val N = arr.size
    val output = IntArray(arr.size)
    val visit = BooleanArray(arr.size)

    val s = "abcde"
    val array = s.toCharArray()
    val output1 = CharArray(arr.size)


//    val perm = CombPerm().perm(arr,output,visit,0,N,2)
//    println(perm)

    val comb = CombPerm().comb(array,visit,0,N,2)
    println(comb)


}