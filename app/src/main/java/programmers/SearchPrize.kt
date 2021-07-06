package programmers

import java.util.*

class Solution {

    var infoMap: MutableMap<String, ArrayList<Int>> = mutableMapOf()

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)


        for (i in info.indices) {
            makeKey(info[i])
        }


        val savekey: ArrayList<String> = arrayListOf()
        for ((key, value) in infoMap) {
            if (savekey.contains(key)) {
                continue
            } else {
                savekey.add(key)
                value.sort()
            }
        }


        for (i in query.indices) {
            val temp = query[i].split(" ").toTypedArray()
            val key = temp[0] + temp[2] + temp[4] + temp[6]
            if (!infoMap.containsKey(key)) {
                answer[i] = 0
                continue
            }
            val arr: ArrayList<Int>? = infoMap[key]
            if ("-" == temp[7]) {
                answer[i] = arr!!.size
            } else {
                val score = temp[7].toInt()

                answer[i] = binarySearch(arr, score)
            }
        }

        return answer
    }

    fun makeKey(info: String) {
        val temp = info.split(" ").toTypedArray()
        val language = arrayOf(temp[0], "-")
        val part = arrayOf(temp[1], "-")
        val career = arrayOf(temp[2], "-")
        val food = arrayOf(temp[3], "-")
        val score = temp[4].toInt()

        for (i in language.indices) {
            for (j in part.indices) {
                for (k in career.indices) {
                    for (p in food.indices) {

                        val key = language[i] + part[j] + career[k] + food[p]

                        if (infoMap.containsKey(key)) {
                            val arr = infoMap[key]
                            arr!!.add(score)
                            infoMap[key] = arr

                        } else {
                            val arr: ArrayList<Int> = arrayListOf()
                            arr.add(score)
                            infoMap[key] = arr
                        }
                    }
                }
            }
        }
        return
    }

    fun binarySearch(arr: ArrayList<Int>?, score: Int): Int {

        var mid = 0
        var end = arr!!.size
        var start = 0

        while (end > start) {
            mid = (start + end) / 2
            if (arr[mid] >= score)
                end = mid else start = mid + 1

        }

        return arr.size - start
    }


}