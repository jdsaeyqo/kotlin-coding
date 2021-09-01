package programmers.simulation

class Weekly1st {

    fun solution(price: Int, money: Int, count: Int): Long {

        var _price = price
        var cost : Long = 0

        repeat(count){
            cost += _price
            _price += price
        }

        return if(money > cost) 0
        else{
            cost - money
        }

    }
}