package programmers.simulation

class Weekly5th {

    fun solution(word: String): Int {
        var answer = 0
        var num = 781
        val ch = charArrayOf('A','E','I','O','U')

        for(i in word.indices){
            for(j in 0 until 5){
                if(ch[j] == word[i]){
                    answer += 1 + j * num
                }
            }
            num = (num-1) / 5
        }

        return answer
    }

}