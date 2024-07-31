package syntax_study

fun main() {
    // shoppingList 는 Map 으로, 아이템 이름을 key 로 갖고, 가격을 value 로 가지고 있다.
    // 이러한 맵을 만들 때 mapOf 메서드를 사용하며, key 와 value 를 연결할 때는 to 키워드를 사용한다.
    val shoppingList = mapOf(
        "Milk" to 1.50,
        "Bread" to 2.00,
        "Eggs" to 3.00
    )
    println(shoppingList["Milk"])   // 1.5
    println(shoppingList["Bread"])  // 2.0
    println(shoppingList["Eggs"])   // 3.0

    // `let`과 `it`을 활용하여 아이템의 가격을 찾아서 출력
    /**
     let 함수
     let 은 Kotlin 에서 널 안전성(null-safety) 및 함수형 프로그래밍을 지원하기 위해 제공되는 확장 함수이다.
     let 은 객체가 null 이 아닐 때만 실행되는 코드를 정의할 때 유용하다.
     let 은 객체에 대해 호출되어 해당 객체를 람다 함수의 매개변수로 전달한다.
     let 을 사용하여 객체의 속성이나 메서드를 호출하거나, 객체를 처리한 결과를 반환할 수 있습니다.
     특히, 객체가 null 이 아닐 때만 블록 내부의 코드를 실행할 수 있도록 보장
    */

    /**
     it 키워드
     it 은 Kotlin 에서 람다 표현식의 단일 매개변수에 대해 자동으로 지정되는 기본 이름이다.
     만약 람다 식이 하나의 매개변수만 가진다면, it을 사용하여 매개변수에 접근할 수 있다.
     it 은 쉽게 말하자면 해당 메서드를 호출한 인스턴스를 참조한다.
    */

    /**
     run 함수
     run 은 블록을 실행하고 그 블록의 마지막 표현식 값을 반환하는 고차함수이다.
    */

    // 찾고 싶은 아이템의 이름 정의
    val itemToFind = "Bread"

    shoppingList[itemToFind]?.let {
        println("The price of $itemToFind is $$it")
    } ?: run {
        println("Item $itemToFind not found in the shopping list.")
    }

    // let 메서드를 호출한 주체는 shoppingList[itemToFind] 이다. 그래서 it 으로 대신 쓸 수 있다.
    // 가격이 존재하지 않을 경우(null 일 경우), let 블록은 실행되지 않는다.
    // 여기서 run 은 let 과 ?: (엘비스 연산자)와 함께 사용되어, 특정 조건에 따라 다른 블록을 실행하는 데 사용된다.
    // ?: 엘비스 연산자는 앞의 식이 null 일 경우 뒤의 식이 실행되게 한다. ?: run { ... } 은 자주 사용되는 패턴이다.
}

