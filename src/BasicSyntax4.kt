fun main(args: Array<String>) {
    val item1 = Item("Book", 10000)
    val item2 = Item("Audio")
}

/**
 * Item 클래스 생성
 * property: name, price
 * 부생성자는 constructor, 초기화는 init 사용
 */
class Item(
    // primary constructor (주생성자)
    val name: String,
    val price: Int
) {
    /**
     *  secondary constructor (부생성자, 보조생성자)
     *  name 만을 파라미터로 받고, price 는 기본값인 9300 으로 설정
     */
    constructor(name: String) : this(
        name = name,
        price = 9300
    // , code = 50
        // 주생성자에 선언되지 않은 프로퍼티는 부생성자에서 프로퍼티로 사용할 수 없다
    )

    /**
     * init block (초기화 블록) : 클래스가 인스턴스화 할 때 실행되는 코드 블록
     *     1) require 구문이나 if 조건문 등을 사용하여 입력값 검증 용도
     *     2) 로그를 출력 용도
     *     3) 프로퍼티 초기화 용도
     *     등
     *     다양한 용도로 사용될 수 있음
     */
    init {
        // require 조건 불만족 시 IllegalArgumentException 발생 및 입력한 문자열 출력
        require(price >= 0) {"Price cannot be negative."}
        println("Item created: name = $name, price = $price")
    }
}