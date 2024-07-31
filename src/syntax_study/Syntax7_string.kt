package syntax_study// 문자열과 문자

fun main() {
    var name = "홍길동"
//    println("저의 이름은 $name입니다.")
    println("저의 이름은 $name" + "입니다.")
    println("저의 이름은 ${name}입니다.")
    name.lowercase()
    name.uppercase()
}