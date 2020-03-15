package LibraryManagement.Model;


public class RegisterForm {
    private int registerId;
    private int readerId;
    private int bookTypeId;
    private int bookTitleId;
    private int bookId;
    private String loanDate;
    private String loanSituation;
    private String dueDate;
    private String returnedDate;
    private String receiveSituation;
    private int quantity;


    public RegisterForm() {
    }

    public RegisterForm(int registerId, int readerId, int bookTypeId, int bookTitleId, int bookId, String loanDate, String loanSituation,
                        String dueDate, String returnedDate, String receiveSituation, int quantity) {
        this.registerId = registerId;
        this.readerId = readerId;
        this.bookTypeId = bookTypeId;
        this.bookTitleId = bookTitleId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.loanSituation = loanSituation;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
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

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanSituation() {
        return loanSituation;
    }

    public void setLoanSituation(String loanSituation) {
        this.loanSituation = loanSituation;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
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
