package syntax_study// sealed 는 타입 계층을 제한적으로 정의하고, 컴파일 타임에 모든 서브타입을 알고 있어야 한다는 점에서 유용하다.
// sealed class는 클래스의 상속을 제한하여 특정 서브클래스만 정의할 수 있도록 한다.

/**
 * CalculationResult는 Success와 Error라는 두 개의 서브타입을 가진 sealed 클래스이다.
 */
sealed class CalculationResult {
    data class Success(val result: Double) : CalculationResult()    // 생성자
    data class Error(val message: String) : CalculationResult()     // 생성자
}

// 계산을 수행하고 결과를 반환하는 함수
fun performCalculation(a: Double, b: Double, operation: String): CalculationResult {
    return try {
        val result = when (operation) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> {
                if (b == 0.0) throw ArithmeticException("Cannot divide by zero")
                a / b
            }
            else -> throw IllegalArgumentException("Invalid operation")
        }
        CalculationResult.Success(result)
    } catch (e: Exception) {
        CalculationResult.Error(e.message ?: "Unknown error")
    }
}

fun main() {
    val result1 = performCalculation(10.0, 5.0, "+")
    val result2 = performCalculation(10.0, 0.0, "/")

    when (result1) {
        is CalculationResult.Success -> println("Result: ${result1.result}")
        is CalculationResult.Error -> println("Error: ${result1.message}")
    }

    when (result2) {
        is CalculationResult.Success -> println("Result: ${result2.result}")
        is CalculationResult.Error -> println("Error: ${result2.message}")
    }

}