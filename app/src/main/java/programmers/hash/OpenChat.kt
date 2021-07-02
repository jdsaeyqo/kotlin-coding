package programmers.hash

class Solution12 {

    val userList = hashMapOf<String,String>()

    fun solution(record: Array<String>): Array<String> {

        record.forEach{
            val arr = it.split(" ")

            if(arr[0] == "Enter"){
                userList[arr[1]] = arr[2]
            }else if(arr[0] == "Change"){
                userList[arr[1]] = arr[2]
            }

        }

        val ansList = mutableListOf<String>()

        record.forEach {

            val arr = it.split(" ")

           if(arr[0] == "Enter"){
               ansList.add("${userList[arr[1]]}님이 들어왔습니다.")
           }else if(arr[0] == "Leave"){
               ansList.add("${userList[arr[1]]}님이 나갔습니다.")
           }
        }

        return ansList.toTypedArray()
    }

}
fun main(){

    val s =Solution12().solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    )

    println(s)
}