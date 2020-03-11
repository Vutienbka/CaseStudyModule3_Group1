package LibraryManagement.Model;

public class ReturnedBook extends Book{
    private String loanedDate;
    private String returnedSituation;
    private String returnedDate;

    public ReturnedBook() {
    }
    public ReturnedBook(String loanedDate, String returnedSituation, String returnedDate) {
        this.loanedDate = loanedDate;
        this.returnedSituation = returnedSituation;
        this.returnedDate = returnedDate;
    }

    public ReturnedBook(int bookId, String bookName, String typeOfBook, String author, int quantity,String language,
                      String loanedDate, String returnedSituation, String returnedDate) {
        super(bookId, bookName, typeOfBook, author, quantity, language);
        this.loanedDate = loanedDate;
        this.returnedSituation = returnedSituation;
        this.returnedDate = returnedDate;
    }
    public void setLoanedDate(String loanedDate) {
        this.loanedDate = loanedDate;
    }

    public String getLoanedDate() {
        return loanedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setDueDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }
    public void setReturnedSituation(String returnedSituation) {
        this.returnedSituation = returnedSituation;
    }

    public String getReturnedSituation() {
        return returnedSituation;
    }


}
