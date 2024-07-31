package syntax_study// sealed 는 타입 계층을 제한적으로 정의하고, 컴파일 타임에 모든 서브타입을 알고 있어야 한다는 점에서 유용하다.
// sealed interface는 인터페이스에 대한 제한된 서브타입 집합을 정의한다.

// sealed 인터페이스 Discount 정의(인터페이스 내에 내부 클래스를 작성하는 방식)
sealed interface Discount {
    /** 할인 금액을 리턴합니다. */
    fun getDiscountAmount(): Double
    /** 할인 유형을 리턴합니다. */
    fun getType(): String
    // sealed interface Discount: Discount 라는 sealed 인터페이스를 정의하여 할인 유형의 공통 인터페이스를 제공
    // 이렇게 해놓으면 이 인터페이스를 구현할 수 있는 클래스를 제한시키며, 구현시켜야 할 메서드를 제시한다.

    /** 퍼센트 기반 할인 유형을 나타내는 데이터 클래스 */
    data class PercentageDiscount(val percentage: Double) : Discount {
        override fun getDiscountAmount(): Double = percentage   // 할인 비율 반환
        override fun getType(): String = "Percentage"           // 할인 유형으로 "Percentage" 문자열 반환
    }

    /** 고정 금액 할인 유형을 나타내는 데이터 클래스 */
    data class FixedAmountDiscount(val amount: Double) : Discount {
        override fun getDiscountAmount(): Double = amount       // 할인하는 금액 반환
        override fun getType(): String = "Fixed Amount"         // 할인 유형으로 "Fixed Amount" 문자열 반환
    }

    /** 구매 하나에 대해 하나를 무료로 제공하는 할인 유형을 나타내는 데이터 클래스 */
    data class BuyOneGetOneFree(val freeItemValue: Double) : Discount {
        override fun getDiscountAmount(): Double = freeItemValue    // 무료 아이템의 가치를 반환
        override fun getType(): String = "BOGO"                 // 할인 유형으로 "BOGO" 문자열 반환
    }
}

// 파타미터로 어떤 타입의 Discount 를 입력하냐에 따라 when 문을 통해 return 을 분기처리 할 수 있다.
fun applyDiscount(discount: Discount, originalPrice: Double): Double {
    return when (discount) {
        is Discount.PercentageDiscount -> originalPrice * (1 - discount.percentage / 100)
        is Discount.FixedAmountDiscount -> originalPrice - discount.amount
        is Discount.BuyOneGetOneFree -> originalPrice - discount.freeItemValue
    }
}

fun main() {
    val percentageDiscount = Discount.PercentageDiscount(10.0)
    val fixedDiscount = Discount.FixedAmountDiscount(5000.0)
    val bogoDiscount = Discount.BuyOneGetOneFree(2500.0)

    val originalPrice = 30000.0

    println("퍼센트 할인 적용 후 가격: ${applyDiscount(percentageDiscount, originalPrice)}")
    println("고정 금액 할인 적용 후 가격: ${applyDiscount(fixedDiscount, originalPrice)}")
    println("구매 하나에 하나 무료 할인 적용 후 가격: ${applyDiscount(bogoDiscount, originalPrice)}")
}