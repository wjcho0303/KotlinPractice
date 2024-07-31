package entity

import java.time.LocalDateTime

// 고객 리뷰를 나타내는 데이터 클래스
data class CustomerReview(
    val reviewId: Long,
    val customerId: Long,
    val productId: Long,
    val reviewText: String,
    val rating: Int,
    val reviewDate: LocalDateTime,
    val updatedDate: LocalDateTime
) {
    companion object {
        fun of(
            reviewId: Long,
            customerId: Long,
            productId: Long,
            reviewText: String,
            rating: Int,
            reviewDate: LocalDateTime = LocalDateTime.now(),
            updatedDate: LocalDateTime = LocalDateTime.now()
        ): CustomerReview {
            return CustomerReview(
                reviewId = reviewId,
                customerId = customerId,
                productId = productId,
                reviewText = reviewText,
                rating = rating,
                reviewDate = reviewDate,
                updatedDate = updatedDate
            )
        }

        // Columns 열거형의 값을 by lazy 로 지연 초기화
        // columns 속성은 처음 참조될 때만 초기화된다.
        val columns by lazy {
            Columns.entries.toTypedArray()
        }

        // 일반적으로 초기화 로직이 복잡한 경우에는 by lazy 가 유용하지만, 예제의 경우 단순하기 때문에 실용성은 없는 학습용 코드임.
        // 참고로, return@lazy null 이 식에서 @lazy 는 lazy 블록을 종료시킨다는 의미이다.
        /**
            val receipt: SoiReceipt? by lazy {
                json.decodeFromString(receiptStr ?: return@lazy null)
            }

            이 코드는 receipt 이라는 변수를 lazy 초기화로 정의하고 있다.
            lazy 초기화는 receipt 변수의 값이 처음 접근될 때만 계산된다.
            lazy 블록에서 receiptStr 의 값이 null 인지 확인한다:
            만약 receiptStr 이 null 이면 return@lazy null 이 실행되어 lazy 블록은 null 을 반환하고, receipt 은 null 로 설정된다.
            만약 receiptStr 이 null 이 아니면, receiptStr 을 json.decodeFromString()에 전달하여 SoiReceipt 객체를 생성하고 반환한다.
        */
    }

    enum class Columns {
        REVIEW_ID,
        CUSTOMER_ID,
        PRODUCT_ID,
        REVIEW_TEXT,
        RATING,
        REVIEW_DATE,
        UPDATED_DATE
    }
}

fun main() {
    // CustomerReview 객체 생성
    val review = CustomerReview.of(
        reviewId = 1L,
        customerId = 100L,
        productId = 200L,
        reviewText = "Great product!",
        rating = 5,
        reviewDate = LocalDateTime.of(2024, 7, 31, 10, 0),
        updatedDate = LocalDateTime.of(2024, 7, 31, 12, 0)
    )

    // 객체 내용 출력
    println("CustomerReview Details:")
    println("Review ID: ${review.reviewId}")
    println("Customer ID: ${review.customerId}")
    println("Product ID: ${review.productId}")
    println("Review Text: ${review.reviewText}")
    println("Rating: ${review.rating}")
    println("Review Date: ${review.reviewDate}")
    println("Updated Date: ${review.updatedDate}")

    // 열거형 클래스 사용 예시
    println("\nColumn Names:")
    CustomerReview.columns.forEach { column ->
        println(column)
    }
}
