package programmers.simulation

class Weekly8th {

    fun solution(sizes: Array<IntArray>): Int {

        var width = 0
        var height = 0

        sizes.forEach{
            it.sortDescending()
            width = width.coerceAtLeast(it[0])
            height = height.coerceAtLeast(it[1])


        }

        return width * height
    }
}