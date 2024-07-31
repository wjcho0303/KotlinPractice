package entity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.function.Supplier;

//@Getter
//@Setter
//@Accessors(chain = true)
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
class CustomerReview1 {
    private final Long reviewId;
    private final Long customerId;
    private final Long productId;
    private final String reviewText;
    private final Integer rating;

    // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime reviewDate;

    // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime updatedDate;

    public CustomerReview1(Long reviewId, Long customerId, Long productId, String reviewText, Integer rating, LocalDateTime reviewDate, LocalDateTime updatedDate) {
        this.reviewId = reviewId;
        this.customerId = customerId;
        this.productId = productId;
        this.reviewText = reviewText;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.updatedDate = updatedDate;
    }

    // 코틀린의 companion object { ... } 구현 부분
    // 이런 메서드를 '정적 팩토리 메서드'라고 부른다.
    public static CustomerReview1 of(
            Long reviewId,
            Long customerId,
            Long productId,
            String reviewText,
            Integer rating,
            LocalDateTime reviewDate,
            LocalDateTime updatedDate
    ) {
        return new CustomerReview1(
                reviewId,
                customerId,
                productId,
                reviewText,
                rating,
                reviewDate,
                updatedDate
        );
    }

    // getter 와 setter
    public Long getReviewId() { return reviewId; }
    public Long getCustomerId() { return customerId; }
    public Long getProductId() { return productId; }
    public String getReviewText() { return reviewText; }
    public Integer getRating() { return rating; }
    public LocalDateTime getReviewDate() { return reviewDate; }
    public LocalDateTime getUpdatedDate() { return updatedDate; }

    public enum Columns {
        REVIEW_ID,
        CUSTOMER_ID,
        PRODUCT_ID,
        REVIEW_TEXT,
        RATING,
        REVIEW_DATE,
        UPDATED_DATE
    }

    // 열거형의 값을 지연 초기화
    private static final Supplier<Columns[]> columnsSupplier = Columns::values;

    // Supplier 를 통해 열거형 값을 반환하는 메서드 제공
    public static Columns[] getColumns() {
        return columnsSupplier.get();
    }
    // columnsSupplier.get() 메서드가 호출될 때 열거형 값이 초기화된다.
}

public class EntityStudy1 {
    public static void main(String[] args) {
        // CustomerReview 객체 생성
        CustomerReview1 review = CustomerReview1.of(
                1L,
                100L,
                200L,
                "Great product!",
                5,
                LocalDateTime.of(2024, 7, 31, 10, 0),
                LocalDateTime.of(2024, 7, 31, 12, 0)
        );

        // 객체 내용 출력
        System.out.println("CustomerReview Details:");
        System.out.println("Review ID: " + review.getReviewId());
        System.out.println("Customer ID: " + review.getCustomerId());
        System.out.println("Product ID: " + review.getProductId());
        System.out.println("Review Text: " + review.getReviewText());
        System.out.println("Rating: " + review.getRating());
        System.out.println("Review Date: " + review.getReviewDate());
        System.out.println("Updated Date: " + review.getUpdatedDate());

        // 열거형 클래스 사용 예시
        System.out.println("\nColumn Names:");
        Arrays.stream(CustomerReview1.getColumns()).forEach(System.out::println);
    }
}


