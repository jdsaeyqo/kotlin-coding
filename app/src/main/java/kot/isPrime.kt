package kot

class isPrime{

    fun checkPrime(num : Int) : Boolean {

        val sqrt = Math.sqrt(num.toDouble()).toInt()

        if (num == 2) {
            return true
        }

        if(num %2 == 0 || num == 1){
            return false
        }

        for(i in 3..sqrt){
            if(num % i == 0){
                return false
            }
        }
        return true
    }

    fun eratos(check : BooleanArray){

        check[0] = true
        check[1] = true

        for(i in 2 until check.size){
            if(!check[i]){
                for (j in 2*i until check.size step i){
                    check[j] = true
                }
            }
        }

        for(i in check.indices){
            if(!check[i]){
                print("$i ")
            }
        }

    }

}

fun main(){
//    val s = isPrime().checkPrime(12)
//    println(s)
//
//    val check = BooleanArray(20)
//    isPrime().eratos(check)

    val list = listOf(1,2,3,4)
    val arr = arrayOf(1,2,3,4)






}