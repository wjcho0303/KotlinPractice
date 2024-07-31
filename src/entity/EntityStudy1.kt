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
