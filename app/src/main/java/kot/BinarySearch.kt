package kot

var N = 7
var arr = intArrayOf(3,6,4,5,1,9,7)

fun main() {

    //이진 탐색 위해서는 먼저 정렬 필요
    arr.sort()

    val k = 6

    var left = 0
    var right: Int = N - 1
    while (left <= right) {
        val mid = (left + right) / 2
        val n: Int = arr[mid]
        if (n == k) {
            println(mid)
            break
        }
        if (n > k) {
            right = mid - 1
        } else {
            left = mid + 1
        }

        if (left > right) {
            println("해당 요소 없음")
            break
        }
    }
}