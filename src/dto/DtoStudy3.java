package dto;

import java.time.LocalDateTime;

/**@Getter*/
/**@ToString*/
/**@AllArgsConstructor*/
/**@NoArgsConstructor*/
class BookBorrowRecord1 {
    private Long bookId;
    private String userId;
    private LocalDateTime dueDate;

    private boolean isReturned;
    private boolean isOverdue;
    private boolean isReserved;

    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public Long getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public BookBorrowRecord1(
            Long bookId,
            String userId,
            LocalDateTime dueDate,
            boolean isReturned,
            boolean isReserved,
            LocalDateTime borrowDate,
            LocalDateTime returnDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.dueDate = dueDate;
        this.isReturned = isReturned;
        this.isOverdue = (dueDate != null) ? LocalDateTime.now().isAfter(dueDate) : false;
        this.isReserved = isReserved;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}


public class DtoStudy3 {
    public static void main(String[] args) {
        // 현재 시간
        LocalDateTime now = LocalDateTime.now();

        // 대출 기한 설정 (현재 시간에서 1주일 뒤)
        LocalDateTime dueDate = now.plusWeeks(1);

        // 대출 기록 생성
        BookBorrowRecord1 bookBorrowRecord = new BookBorrowRecord1(
                12345L,
                "user789",
                dueDate,
                false,
                true,
                now,
                null);

        // 생성된 BookBorrowRecord 객체 출력
        System.out.println("자바");
        System.out.println("Book Borrow Record:");
        System.out.println("Book ID: " + bookBorrowRecord.getBookId());
        System.out.println("User ID: " + bookBorrowRecord.getUserId());
        System.out.println("Due Date: " + bookBorrowRecord.getDueDate());
        System.out.println("Is Returned: " + bookBorrowRecord.isReturned());
        System.out.println("Is Overdue: " + bookBorrowRecord.isOverdue());
        System.out.println("Is Reserved: " + bookBorrowRecord.isReserved());
        System.out.println("Borrow Date: " + bookBorrowRecord.getBorrowDate());
        System.out.println("Return Date: " + bookBorrowRecord.getReturnDate());

        // 과거 대출 기한 예시
        LocalDateTime overdueDueDate = now.minusWeeks(2);
        BookBorrowRecord1 overdueBookBorrowRecord = new BookBorrowRecord1(
                67890L,
                "user456",
                overdueDueDate,
                false,
                false,
                now.minusMonths(1),
                null);

        // 생성된 BookBorrowRecord 객체 출력
        System.out.println("\nOverdue Book Borrow Record:");
        System.out.println("Book ID: " + overdueBookBorrowRecord.getBookId());
        System.out.println("User ID: " + overdueBookBorrowRecord.getUserId());
        System.out.println("Due Date: " + overdueBookBorrowRecord.getDueDate());
        System.out.println("Is Returned: " + overdueBookBorrowRecord.isReturned());
        System.out.println("Is Overdue: " + overdueBookBorrowRecord.isOverdue());
        System.out.println("Is Reserved: " + overdueBookBorrowRecord.isReserved());
        System.out.println("Borrow Date: " + overdueBookBorrowRecord.getBorrowDate());
        System.out.println("Return Date: " + overdueBookBorrowRecord.getReturnDate());
    }
}



