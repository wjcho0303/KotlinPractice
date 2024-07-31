package syntax_study// 콜백함수: 특정 이벤트가 발생할 때 호출시키는 용도로 정의하는 함수. 주로 비동기 작업이나 이벤트 핸들링, 함수형 프로그래밍 등에서 사용된다.
// 콜백함수는 다른 함수에 인자로 전달되어, 특정 작업이 완료된 후에 호출된다.

// 콜백함수를 인자로 받는 함수 정의
fun performOperation(number: Int, callback: (Int) -> Unit) {
    val result = number * 2
    callback(result)    // 콜백함수 호출
}

fun main() {
    // 콜백함수 정의: 함수임에도 불구하고 fun 으로 시작하지 않고 val 로 시작하는 모습을 볼 수 있다.
    val callback: (Int) -> Unit = { result ->
        println("Result: $result")
    }

    val number1 = performOperation(10, callback)
    val number2 = performOperation(20, callback)
    val number3 = performOperation(30, callback)
}