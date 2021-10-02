package programmers.String

import java.util.*

class BuhoMove {
    var buho = ""
    var ans = 0
    fun solution(s: String): Int {

        if (s.length % 2 != 0) {
            return 0
        }

        buho = s

        for (i in 0 until buho.length) {

            if (check()) {
                ans++
            }
            move()

        }

        return ans
    }

    fun check(): Boolean {

        val stk = Stack<Char>()

        for (i in 0 until buho.length) {

            if (buho[i] == '[' || buho[i] == '(' || buho[i] == '{') {
                stk.push(buho[i])
            } else {
                if (stk.isEmpty()) {
                    return false
                } else {
                    if (buho[i] == ']') {
                        if (stk.peek() == '[') {
                            stk.pop()
                        } else {
                            return false
                        }
                    }
                    if (buho[i] == ')') {
                        if (stk.peek() == '(') {
                            stk.pop()
                        } else {
                            return false
                        }
                    }
                    if (buho[i] == '}') {
                        if (stk.peek() == '{') {
                            stk.pop()
                        } else {
                            return false
                        }
                    }
                }


            }

        }

        return true

    }

    fun move() {

        buho = buho.substring(1, buho.length) + buho[0]

    }
}