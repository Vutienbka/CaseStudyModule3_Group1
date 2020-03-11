package LibraryManagement.Model;

public class BookView extends Book{
    private int loanedQuantity;
    private int availableQuantity;

    public BookView() {
    }

    public BookView(int loanedQuantity, int availableQuantity) {
        this.loanedQuantity = loanedQuantity;
        this.availableQuantity = availableQuantity;
    }

    public BookView(String bookName, String typeOfBook, String author, int price, int quantity, String language, int loanedQuantity, int availableQuantity) {
        super(bookName, typeOfBook, author, price,quantity, language);
        this.loanedQuantity = loanedQuantity;
        this.availableQuantity = availableQuantity;
    }

    public int getLoanedQuantity() {
        return loanedQuantity;
    }

    public void setLoanedQuantity(int loanedQuantity) {
        this.loanedQuantity = loanedQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
