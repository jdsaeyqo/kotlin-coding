package programmers

class MatchUp {

    var cnt = 0
    var aNum  = 0
    var bNum  = 0

    fun solution(n: Int, a: Int, b: Int): Int {

        match(Math.min(a,b),Math.max(a,b))

        return cnt
    }

    fun match(a: Int, b : Int){
        cnt++
        if( a==1 && b==2 ){
            return
        }

        if(a == b-1 && a/2 != b/2){
            return
        }

        if(a%2 ==0){
            aNum = a/2
        }else{
            aNum = a/2 +1
        }

        if( b%2 ==0){
            bNum = b/2
        }else{
            bNum = b/2 +1
        }

        match(aNum,bNum)

    }
}