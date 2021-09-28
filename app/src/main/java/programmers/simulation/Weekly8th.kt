package programmers.simulation

class Weekly8th {

    fun solution(sizes: Array<IntArray>): Int {

        var width = 0
        var height = 0

        sizes.forEach{
            it.sortDescending()
            
            //Math.max(width,it[0]) = width.coerceAtLeast(it[0])
            //Math.min(width,it[1]) = width.coerceAtMost(it[1])
            width = width.coerceAtLeast(it[0])
            height = height.coerceAtLeast(it[1])



        }

        return width * height
    }
}