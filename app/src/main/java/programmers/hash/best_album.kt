package programmers.hash

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {

        val ansList = mutableListOf<Int>()

        if (genres.size == 1) {
            return intArrayOf(0)
        }

        val hm = hashMapOf<String, Int>()

        for (i in genres.indices) {

            hm[genres[i]]?.let { genre ->

                hm[genres[i]] = plays[i] + genre

            } ?: hm.put(genres[i], plays[i])

        }

        val hmSorted = hm.toList().sortedByDescending { it.second }

        hmSorted.forEach {

            val genre = it.first
            val map = hashMapOf<Int, Int>()

            for (i in genres.indices) {
                if (genres[i] == genre) {
                    map[i] = plays[i]
                }
            }

            val map1 = map.toList().sortedByDescending { pair -> pair.second }

            ansList.add(map1[0].first)

            if (map1.size > 1) {
                ansList.add(map1[1].first)
            }

        }

        return ansList.toIntArray()

    }
}

fun main() {

    val s = Solution()
    val c = s.solution(arrayOf("a", "b", "c"), intArrayOf(5, 6, 7))
    println(c)

}