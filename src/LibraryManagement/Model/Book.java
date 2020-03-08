package LibraryManagement.Model;

public class Book {
    private int bookId;
    private String bookName;
    private String typeOfBook;
    private String Author;
    private int quantity;
    private int price;
    private String language;
    private boolean status;
    private String situation;

    public Book() {
    }

    public Book(int bookId, String bookName, String typeOfBook, String author, int quantity, int price, String language, boolean status, String situation) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.typeOfBook = typeOfBook;
        this.Author = author;
        this.quantity = quantity;
        this.price = price;
        this.language = language;
        this.status = status;
        this.situation = situation;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(String typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
