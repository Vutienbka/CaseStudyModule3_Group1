package LibraryManagement.Model;

import java.util.Date;

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
    private Date loanDate;
    private Date receiveDate;
    private String place;
    private String image;
    public Book() {
    }

    public Book(int bookId, String bookName, String typeOfBook, String author, int quantity, String language) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.typeOfBook = typeOfBook;
        Author = author;
        this.quantity = quantity;
        this.language = language;
    }

    public Book(int bookId, String bookName, String typeOfBook, String author, int quantity, int price, String language, boolean status, String situation , String image) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.typeOfBook = typeOfBook;
        this.Author = author;
        this.quantity = quantity;
        this.price = price;
        this.language = language;
        this.status = status;
        this.situation = situation;
        this.image = image;
    }

    public Book(int bookId, String bookName, String typeOfBook, String author, int quantity, int price, String language, boolean status, String situation) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.typeOfBook = typeOfBook;
        Author = author;
        this.quantity = quantity;
        this.price = price;
        this.language = language;
        this.status = status;
        this.situation = situation;
    }

    public Book(int bookId, String bookName, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public Book(String bookName, String typeOfBook, String author, int quantity, int price, String language) {
        this.bookName = bookName;
        this.typeOfBook = typeOfBook;
        Author = author;
        this.quantity = quantity;
        this.price = price;
        this.language = language;
    }

    public Book(int bookId, String bookName, String typeOfBook, String author, int quantity, int price, String language, boolean status, String situation, Date loanDate, Date receiveDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.typeOfBook = typeOfBook;
        Author = author;
        this.quantity = quantity;
        this.price = price;
        this.language = language;
        this.status = status;
        this.situation = situation;
        this.loanDate = loanDate;
        this.receiveDate = receiveDate;
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

    public boolean isStatus() {
        return status;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
