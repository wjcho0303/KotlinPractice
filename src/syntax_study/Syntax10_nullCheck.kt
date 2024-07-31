package syntax_study

fun main() {
    var name: String? = null
    name = "hello"
    name = null

    var name2: String = ""
    if (name != null) {
        name2 = name
    }

    var name3: String = ""
//    name3 = name!!  // 이 코드가 NullPointerException 발생시킴

    var name4: String = ""
    name?.let {
        name4 = name
    }

    println("name = $name") // null
    println("name2 = $name2") // ""
    println("name3 = $name3") // ""
    println("name4 = $name4") // ""
}