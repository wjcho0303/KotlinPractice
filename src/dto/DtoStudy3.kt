package dto

import java.time.LocalDateTime

// 도서 대출 기록을 나타내는 데이터 클래스
data class BookBorrowRecord(
    val bookId: Long,               // 도서 고유 ID
    val userId: String,             // 대출자 ID
    val dueDate: LocalDateTime?,    // 도서 반납기한

    val isReturned: Boolean,        // 도서 반환여부
    val isOverdue: Boolean,         // 도서 기한초과여부
    val isReserved: Boolean,        // 도서 예약여부

    val borrowDate: LocalDateTime,  // 도서 대출날짜
    val returnDate: LocalDateTime?, // 도서 반환날짜 (반환되지 않을 경우 null)
) {
    // 부생성자: 대출 기한(dueDate)과 반환 상태(isReturned) 등을 기반으로 다른 상태를 자동으로 설정
    constructor(
        bookId: Long,
        userId: String,
        dueDate: LocalDateTime?,
        isReturned: Boolean,
        isReserved: Boolean,
        borrowDate: LocalDateTime,
        returnDate: LocalDateTime?
    ) : this(
        bookId = bookId,
        userId = userId,
        dueDate = dueDate,
        isReturned = isReturned,
        isOverdue = dueDate?.let { LocalDateTime.now().isAfter(it) } ?: false,
        isReserved = isReserved,
        borrowDate = borrowDate,
        returnDate = returnDate
    )
}

fun main() {
    // 현재 시간
    val now = LocalDateTime.now()

    // 대출 기한 설정 (현재 시간에서 1주일 뒤)
    val dueDate = now.plusWeeks(1)

    // 대출 기록 생성
    val bookBorrowRecord = BookBorrowRecord(
        bookId = 12345L,             // 도서 ID
        userId = "user789",          // 사용자 ID
        dueDate = dueDate,           // 대출 기한
        isReturned = false,          // 반환 여부
        isReserved = true,           // 예약 여부
        borrowDate = now,            // 대출 날짜
        returnDate = null            // 반환 날짜 (아직 반환되지 않음)
    )

    // 생성된 BookBorrowRecord 객체 출력
    println("코틀린")
    println("Book Borrow Record:")
    println("Book ID: ${bookBorrowRecord.bookId}")
    println("User ID: ${bookBorrowRecord.userId}")
    println("Due Date: ${bookBorrowRecord.dueDate}")
    println("Is Returned: ${bookBorrowRecord.isReturned}")
    println("Is Overdue: ${bookBorrowRecord.isOverdue}")
    println("Is Reserved: ${bookBorrowRecord.isReserved}")
    println("Borrow Date: ${bookBorrowRecord.borrowDate}")
    println("Return Date: ${bookBorrowRecord.returnDate}")

    // 과거 대출 기한 예시
    val overdueDueDate = now.minusWeeks(2) // 2주 전 대출 기한
    val overdueBookBorrowRecord = BookBorrowRecord(
        bookId = 67890L,              // 도서 ID
        userId = "user456",           // 사용자 ID
        dueDate = overdueDueDate,     // 대출 기한
        isReturned = false,           // 반환 여부
        isReserved = false,           // 예약 여부
        borrowDate = now.minusMonths(1), // 대출 날짜 (1개월 전)
        returnDate = null             // 반환 날짜 (아직 반환되지 않음)
    )

    // 생성된 BookBorrowRecord 객체 출력
    println("\nOverdue Book Borrow Record:")
    println("Book ID: ${overdueBookBorrowRecord.bookId}")
    println("User ID: ${overdueBookBorrowRecord.userId}")
    println("Due Date: ${overdueBookBorrowRecord.dueDate}")
    println("Is Returned: ${overdueBookBorrowRecord.isReturned}")
    println("Is Overdue: ${overdueBookBorrowRecord.isOverdue}")
    println("Is Reserved: ${overdueBookBorrowRecord.isReserved}")
    println("Borrow Date: ${overdueBookBorrowRecord.borrowDate}")
    println("Return Date: ${overdueBookBorrowRecord.returnDate}")
}