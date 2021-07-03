class MathFunction {

    val list = mutableListOf<String>()
    val hm = hashMapOf<String,Int>()
    val hs = hashSetOf<String>()
    val ansList = mutableListOf<String>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()

        orders.sortBy{it.length}

        orders.forEach{ menu ->
            getComb(menu,course)

        }

        hs.forEach{
            for(i in list.indices){
                if(it == list[i]){
                    hm[list[i]]?.let{
                        hm[list[i]] = hm[list[i]]!!+1
                    }?:hm.put(list[i],1)
                }
            }

        }

        val map = hm.toList().sortedByDescending{it.second}.toMap()


        course.forEach{cnt ->
            getMenu(cnt,map)
        }


        return ansList.sorted().toTypedArray()
    }

    fun getMenu(cnt : Int ,map : Map<String,Int>){

        var num = 0

        for(key in map.keys){
            if(key.length == cnt){
                if(map[key]!! >= num && map[key]!! !=1 ){
                    num = map[key]!!
                    ansList.add(key)
                }
            }
        }

    }

    fun getComb(menu : String, course: IntArray){

        for(i in course.indices){
            var arr = menu.toCharArray()
            var visit = BooleanArray(menu.length)
            comb(arr,visit,0,menu.length,course[i])

        }

    }

    fun comb(arr : CharArray, visit : BooleanArray,start : Int,n : Int, r : Int){

        if(r == 0){
            var str = ""
            for(i in visit.indices){
                if(visit[i]){
                    str+=arr[i]
                }
            }
            val sortedStr = sortString(str)
            list.add(sortedStr)
            hs.add(sortedStr)

        }

        for(i in start until n){
            if(!visit[i]){
                visit[i] = true
                comb(arr,visit,i+1,n,r-1)
                visit[i] = false
            }
        }

    }

    fun sortString(str : String) : String{

        val arr =  str.toCharArray().sorted()

        var st = ""

        arr.forEach{
            st+=it
        }
        return st
    }
}