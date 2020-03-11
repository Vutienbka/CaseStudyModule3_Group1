package LibraryManagement.Model;

import java.util.Date;

public class LoanedBook extends Book{
    private String loanedDate;
    private String loanedSituation;
    private String dueDate;

    public LoanedBook() {
    }
    public LoanedBook(String loanedDate, String loanedSituation, String dueDate) {
        this.loanedDate = loanedDate;
        this.loanedSituation = loanedSituation;
        this.dueDate = dueDate;
    }

    public LoanedBook(int bookId, String bookName, String typeOfBook, String author, int quantity,String language,
                      String loanedDate, String loanedSituation, String dueDate) {
        super(bookId, bookName, typeOfBook, author, quantity, language);
        this.loanedDate = loanedDate;
        this.loanedSituation = loanedSituation;
        this.dueDate = dueDate;
    }

    public String getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(String loanedDate) {
        this.loanedDate = loanedDate;
    }

    public String getLoanedSituation() {
        return loanedSituation;
    }

    public void setLoanedSituation(String loanedSituation) {
        this.loanedSituation = loanedSituation;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
