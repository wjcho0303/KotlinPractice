package syntax_study// 제네릭

// 제네릭 클래스
// 클래스는 인스턴스의 설계도이다. 일반적인 클래스는 특정 데이터 타입을 가진 필드를 포함하고, 특정 메서드를 정의해놓는다.
// 일반적인 클래스는 자기 자신의 타입이 클래스를 정의할 때부터 자기 자신 타입으로 고정된다.
// 하지만 제네릭 클래스는 타입 파라미터를 사용하는 클래스로, 타입 파라미터는 클래스 선언 시 지정하고, 객체를 생성할 때 실제 타입을 지정한다.
// T는 타입 파라미터로, Box 클래스가 다양한 타입을 처리할 수 있게 해준다. 객체를 생성할 때는 실제 타입을 지정할 수 있다.

class Box<T>(@JvmField val value: T) {
    fun getValue(): T = value
}

data class Box2<T>(val value: T)

// @JvmField 을 사용하면 Kotlin 프로퍼티의 getter 와 setter 가 자동으로 생성되지 않는다.
// 예를 들어 위 코드에서 value 가 val 로 선언되어 있으므로, Kotlin 은 자동으로 getValue() 메서드를 생성한다.
// 실제로 이 메서드는 JVM 바이트코드에서는 getValue()라는 이름으로 존재하게 되며, Kotlin 과 JVM 간의 상호작용에서 문제가 발생할 수 있다.

// data class 를 사용하는 경우 자동으로 생성되는 componentN() 메서드와 copy() 메서드가 있어 직접 @JvmField 를 사용하지 않아도 된다.
// data class 는 프로퍼티에 대한 getValue() 메서드를 자동으로 생성하며, @JvmField 없이도 JVM 호환성 문제를 피할 수 있다.

fun main() {
    val box1 = Box(10)
    val box2 = Box("hello")
    println(Box::class)         // class Box
    println(box1)               // Box@28d93b30
    println(box1.getValue())    // 10
    println(box2)               // Box@1b6d3586
    println(box2.getValue())    // hello

    val box3 = Box2(10)
    val box4 = Box2("hello")
    println(Box2::class)        // class Box2
    println(box3)               // Box2(value=10)
    println(box3.value)         // 10
    println(box4)               // Box2(value=hello)
    println(box4.value)         // hello

    val box5 = Box(Box2(10))
    println(box5)
    println(box5.getValue())    // Box2(value=10)

    val box6 = Box2(Box(10))
    println(box6)               // Box2(value=Box@5d099f62)
    println(box6.value)         // Box@5d099f62
}



// * 참고: 위 제네릭 클래스와 아래의 일반적인 클래스를 비교해볼 것

// 일반적인 클래스 정의
data class IntBox(val value: Int)
// IntBox 클래스의 인스턴스는 오직 Int 타입의 값을 저장할 수 있다. 다른 타입의 값을 저장하려고 하면 컴파일 에러가 발생한다.
// 이와 같이 일반적인 클래스는 타입이 명확히 정의된 경우에 적합하며, 다른 타입의 데이터를 처리하려면 새로운 클래스를 정의해야 한다.

// 하지만 제네릭 클래스는 동일한 클래스 구조를 여러 타입의 데이터를 저장하고 처리할 수 있다.
// 그러므로 제네릭 클래스를 사용하면 코드의 재사용성과 타입 안정성을 높일 수 있다.