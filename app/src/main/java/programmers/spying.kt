package programmers

class SolutionSpy {
    fun solution(clothes: Array<Array<String>>): Int {

        val map = hashMapOf<String,Int>()

        clothes.forEach { cloth ->

           if(map.containsKey(cloth[1])){

               map[cloth[1]] = map[cloth[1]]!!+1

           }else{
               map[cloth[1]] = 1
           }

        }

        var count = 1

        map.values.forEach {
            count *=it+1
        }


        return count-1
    }

}

fun main(){
    val s = SolutionSpy()

    val arr = arrayOf(arrayOf("yellowhat", "headgear"),arrayOf("bluesunglasses", "eyewear"),arrayOf("green_turban", "headgear"))

   val ans =  s.solution(arr)
    println(ans)
}