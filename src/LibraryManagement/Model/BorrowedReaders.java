package LibraryManagement.Model;


public class BorrowedReaders extends Reader {
    private String borrowedDate;
    private String returnedDate;
    Book book;

    public BorrowedReaders(int readerId, String readerName, String identificationId, String dateOfBirth, String gender, String address, String occupation,
   String email, String borrowedDate, String returnedDate, Book book) {
        super(readerId, readerName, identificationId, dateOfBirth, gender, address, occupation, email);
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.book = book;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
