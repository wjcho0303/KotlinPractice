// import 문 두 개 다 켜면 ambiguous 에러 터진다. max() 가 똑같이 때문이다.
//import java.lang.Math.*
import kotlin.math.*
import kotlin.random.Random


fun main() {
    var a = 10
    var b = 20
    println(max(a, b))
    println(max(a,b))

    val randomValue1 = Random.nextInt()
    println("randomValue1 is $randomValue1")

    val randomValue2 = Random.nextInt(1, 2) // 2 포함 X
    println("randomValue2 is $randomValue2")

    val randomValue3 = Random.nextDouble(0.0, 100.0) // 100.0 포함 X
    println("randomValue3 is $randomValue3")

    val randomValue4 = Random.nextDouble()
    println("randomValue4 is $randomValue4")

    val randomValue5 = Random.nextBoolean()
    println("randomValue5 is $randomValue5")
}