package programmers.binarysearch

class CountryPass {
        var start : Long = 0
        var mid : Long = 0
        var end : Long = Long.MAX_VALUE
        var sum : Long = 0
        fun solution(n: Int, times: IntArray): Long {
            var answer: Long = Long.MAX_VALUE

            times.sort()

            while(start <= end){

                mid = (start+end) / 2

                sum = 0
                for(i in times.indices){
                    sum+= mid/times[i]

                    if(sum >= n) break
                }

                if(n > sum){
                    start = mid+1
                }else{
                    end = mid-1
                    answer = Math.min(answer,mid)
                }
            }

            return answer
        }
    }
