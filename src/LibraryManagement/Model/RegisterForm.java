package LibraryManagement.Model;

import java.util.Date;

public class RegisterForm {
    private int registerId;
    private int readerId;
    private int bookTypeId;
    private int bookTitleId;
    private int bookId;
    private Date loanDate;
    private String loanSituation;
    private Date receiveDate;
    private String receiveSituation;
    private int quantity;

    public RegisterForm() {
    }

    public RegisterForm(int registerId, int readerId, int bookTypeId, int bookTitleId, int bookId,
                        Date loanDate, String loanSituation, Date receiveDate, String receiveSituation, int quantity) {
        this.registerId = registerId;
        this.readerId = readerId;
        this.bookTypeId = bookTypeId;
        this.bookTitleId = bookTitleId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.loanSituation = loanSituation;
        this.receiveDate = receiveDate;
        this.receiveSituation = receiveSituation;
        this.quantity = quantity;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public int getBookTitleId() {
        return bookTitleId;
    }

    public void setBookTitleId(int bookTitleId) {
        this.bookTitleId = bookTitleId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanSituation() {
        return loanSituation;
    }

    public void setLoanSituation(String loanSituation) {
        this.loanSituation = loanSituation;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getReceiveSituation() {
        return receiveSituation;
    }

    public void setReceiveSituation(String receiveSituation) {
        this.receiveSituation = receiveSituation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
