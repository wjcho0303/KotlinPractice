package syntax_study

// 탑 레벨 상수
val num1 = 20   // 재대입 불가
var num2 = 20
const val num3 = 30 // main 보다 먼저 컴파일되어 이 값을 사용하면 성능상 우위를 가져옴

fun main() {
    var i: Int = 10
    var name: String = "Kotlin"
    var point: Double = 3.14

    i = 20
    // num1 = 30
    num2 = 40   // 수정 가능
    println("num2 = $num2")

    val num4 = num3 + 50
    println("num4 = ${num4}")
}