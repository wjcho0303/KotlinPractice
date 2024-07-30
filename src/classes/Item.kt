package classes

import classes.Color.*

class Item(
    // primary constructor (주생성자)
    // 주생성자에 미리 초기화 값을 정의해놓은 프로퍼티는 부생성자에서 프로퍼티를 생략할 수 있다.
    val name: String? = "",
    val price: Int? = -1,
    val color: Color? = null
) {
    /**
     *  secondary constructor (부생성자, 보조생성자)
     *  name 만을 파라미터로 받고, price 는 기본값인 9300 으로 설정
     */
    constructor(name: String) : this(
        name = name,
        price = 9300,
        color = RED
        // code = 50
        // 주생성자에 선언되지 않은 프로퍼티는 부생성자에서 프로퍼티로 사용할 수 없다
    )
    constructor(price: Int) : this(
        name = null,
        price = price,
        color = GREEN
    )
    constructor() : this(
        name = null,
        price = null,
        color = null
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
        // require(price != null && price >= 0) {"Price cannot be negative."}
        println("classes.Item created: name = $name, price = $price, color = $color")
    }
}