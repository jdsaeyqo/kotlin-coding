package programmers.graph.dfs_bfs


class ChangeWord {

    var answer = 51
    lateinit var visit : BooleanArray

    fun solution(begin: String, target: String, words: Array<String>): Int {

        visit = BooleanArray(words.size)

        dfs(begin,target,words,0)

        return if(answer ==51) 0
        else answer

    }

    fun check(begin : String , word : String) : Boolean{

        var cnt = 0
        for(i in begin.indices){
            if(begin[i] != word[i]){
                cnt++
            }
        }

        return cnt == 1

    }

    fun dfs(word: String,target: String, words: Array<String>,count :Int){

        if(word == target){
            if(answer > count) answer = count
            return
        }

        for(i in words.indices){
            if(!visit[i] && check(word,words[i])){
                visit[i] = true
                dfs(words[i],target,words,count+1)
                visit[i] = false
            }
        }


    }
}