package dto

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

// DTO 코드 예제
// data class 를 사용하여 DTO 객체를 정의한다.


// 제품 DTO 정의
// @Serializable : 데이터 클래스를 JSON, ProtoBuf, CBOR 등 다양한 형식으로 직렬화하거나 역직렬화 할 수 있게 해준다.
// 이 어노테이션을 사용하면 Kotlin 클래스의 인스턴스가 자동으로 JSON 으로 변환되거나 JSON 에서 변환될 수 있게 설정할 수 있다.
// JSON 으로 변환할 땐 Json.encodeToString(object) 메서드를 사용한다.

//@Serializable
data class ProductDTO(
    val id: String,

    val name: String,

    val category: String,

    /**@SerialName("unit_sales")*/
    val unitSales: Double,

    val quantity: Int,

    /**@SerialName("subtotal_sales")*/
    val subtotalSales: Double,

    /**@SerialName("media_commission_rate")*/
    val mediaCommissionRate: Double,

    val currency: String
)

// @SerialName("JSON 필드 이름")
// JSON 데이터에서 특정 필드의 이름을 클래스의 프로퍼티명과 다르게 하고 싶을 때, 이 어노테이션으로 JSON 필드명을 바꿔서 보낸다.

// * 참고: 자바에서는 @JsonProperty 또는 @SerializedName 이다. @JsonProperty 를 좀 더 많이 사용한다.


// 주문 DTO 정의
//@Serializable
data class OrderDTO(
    val orderId: String,

    /**@SerialName("order_time")*/
    val orderUnixTime: Long,

    /**@SerialName("merchant_id")*/
    val merchantId: String,

    /**@SerialName("merchant_name")*/
    val merchantName: String,

    /**@SerialName("total_sales")*/
    val totalSales: Double,

    /**@SerialName("total_media_commission")*/
    val totalMediaCommission: Double,

    val products: List<ProductDTO>
) {
    // 유닉스 타임스탬프를 LocalDateTime 으로 변환
    val orderDate: LocalDateTime
        get() = LocalDateTime.ofInstant(
            Instant.ofEpochSecond(orderUnixTime),
            ZoneOffset.ofHours(0)
        )

    /**
    // 객체를 JSON 문자열로 변환
    fun toJson(): String {
        return Json.encodeToString(this)
    }
    */

    /**
    // JSON 문자열을 객체로 변환
    companion object {
        fun fromJson(jsonString: String): OrderDTO {
            return Json.decodeFromString(jsonString)
        }
    }
    */
}

// 예시 사용
fun main() {
    // 제품 데이터 생성
    val product1 = ProductDTO("p001", "상품1", "카테고리A", 100.0, 2, 200.0, 0.1, "USD")
    val product2 = ProductDTO("p002", "상품2", "카테고리B", 150.0, 1, 150.0, 0.15, "USD")

    // 주문 데이터 생성
    val order = OrderDTO(
        orderId = "order123",
        orderUnixTime = Instant.now().minusSeconds(86400).epochSecond, // 현재 시간에서 하루 전
        merchantId = "merchant456",
        merchantName = "상점명",
        totalSales = 350.0,
        totalMediaCommission = 35.0,
        products = listOf(product1, product2)
    )

    /**
    // 객체를 JSON 으로 변환
    val jsonString = order.toJson()
    println("JSON 문자열:")
    println(jsonString)
    */

    /**
    // JSON 문자열을 객체로 변환
    val newOrder = OrderDTO.fromJson(jsonString)
    println("\n주문 날짜:")
    println(newOrder.orderDate)
    */
}