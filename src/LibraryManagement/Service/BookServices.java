package LibraryManagement.Service;

import LibraryManagement.Model.Book;
import LibraryManagement.Model.LoanedBook;
import LibraryManagement.Model.RegisterForm;
import LibraryManagement.Model.ReturnedBook;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookServices implements I_BookService{
    RegisterService registerService = new RegisterService();
    SQLConnection connection = new SQLConnection();
    final static String SELECT_ALL_BOOKS = "SELECT * FROM bookDetail";
    final static String SELECT_ONE_BOOK = "SELECT * FROM bookDetail WHERE bookId=?";
    final static String UPDATE_BOOK = "UPDATE  bookDetail SET bookName=? ,typeOfBook=?,author=?, quantity=?, " +
            "price=?, language=?, status=?, situation=? WHERE bookId=?";
    final static String VIEW_ISSUED_BOOK_QUANTITY = "SELECT quantity FROM bookDetail";
    final static String VIEW_LOANED_BOOK_QUANTITY = "SELECT quantity FROM bookDetail WHERE status = true";
    final static String VIEW_READER_QUANTITY = "SELECT quantity FROM Book WHERE status = true";
    final static String ADD_NEW_BOOK = "INSERT INTO bookDetail VALUES (?,?,?,?,?,?,?,?,?)";
    final static String DELETE_BOOK = "DELETE FROM bookDetail WHERE bookId= ?";
    private static List<Book> bookList ;
    private Date loanDate = null;
    private Date receiveDate = null;

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

    List<RegisterForm> registerList = registerService.initRegisterList();
    static {
        bookList = new ArrayList<>();
    }
    public BookServices() {
        initBookList();
    }

    public void initBookList(){
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int Id = rs.getInt("bookId");
                String bookName = rs.getString("bookName");
                String typeOfBook = rs.getString("typeOfBook");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String language = rs.getString("language");
                boolean status = rs.getBoolean("status");
                String situation = rs.getString("situation");
                bookList.add(new Book(Id,bookName,typeOfBook,author,quantity,price,language,status,situation));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Book> selectAllBook() {
        ArrayList<Book> bookList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int Id = rs.getInt("bookId");
                String bookName = rs.getString("bookName");
                String typeOfBook = rs.getString("typeOfBook");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String language = rs.getString("language");
                boolean status = rs.getBoolean("status");
                String situation = rs.getString("situation");
                bookList.add(new Book(Id,bookName,typeOfBook,author,quantity,price,language,status,situation));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //kiem tra trang thai book trong danh sach da cho muon khi duoc tra lai
        for(Book book : bookList){
            for(RegisterForm registerForm : registerList){
                if((book.getBookId() == registerForm.getBookId() && (registerForm.getReturnedDate().equalsIgnoreCase("")==false))){
                    book.setSituation(registerForm.getReceiveSituation());
                }
            }
        }
        return bookList;
    }
    @Override
    public boolean saveBook(Book book) {
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_BOOK);
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getTypeOfBook());
            ps.setString(3,book.getAuthor());
            ps.setInt(4,book.getQuantity());
            ps.setInt(5,book.getPrice());
            ps.setString(6,book.getLanguage());
            ps.setBoolean(7,book.getStatus());
            ps.setString(8,book.getSituation());
            ps.setInt(9,book.getBookId());

            int rows = ps.executeUpdate();
            if(rows>0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Book findById(int bookId) {
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ONE_BOOK);
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String bookName = rs.getString("bookName");
                String typeOfBook = rs.getString("typeOfBook");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String language = rs.getString("language");
                boolean status = rs.getBoolean("status");
                String situation = rs.getString("situation");
                Book updatedBook = new Book(bookId,bookName,typeOfBook,author,quantity,price,language,status,situation);
                if (updatedBook!= null)
                    return updatedBook;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addNewBook(Book book) {
        Connection conn = connection.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(ADD_NEW_BOOK);
            ps.setInt(1,book.getBookId());
            ps.setString(2,book.getBookName());
            ps.setString(3,book.getTypeOfBook());
            ps.setString(4,book.getAuthor());
            ps.setInt(5,book.getQuantity());
            ps.setInt(6,book.getPrice());
            ps.setString(7,book.getLanguage());
            ps.setBoolean(8,book.getStatus());
            ps.setString(9,book.getSituation());

            int rows = ps.executeUpdate();
            System.out.println("row" + rows);
            if(rows>0)
                return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeBook(int Id) {
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_BOOK);
            ps.setInt(1,Id);
           int rows = ps.executeUpdate();
           if(rows > 0)
               System.out.println("Delete" + rows);
               return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public int viewIssuedBookQuantity(){
        Connection conn = connection.getConnection();
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(VIEW_ISSUED_BOOK_QUANTITY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                count+=quantity;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
    public int viewLoanedBookQuantity(){
        Connection conn = connection.getConnection();
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(VIEW_LOANED_BOOK_QUANTITY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                count+=quantity;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
    public int viewReaderQuantity(){
        Connection conn = connection.getConnection();
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(VIEW_LOANED_BOOK_QUANTITY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                count+=quantity;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
    public ArrayList<LoanedBook> viewLoanedBookInfo(){
        ArrayList<Book> bookList = selectAllBook();
        ArrayList<LoanedBook> loanedBookList = new ArrayList<>();
        ArrayList<RegisterForm> registerList = registerService.initRegisterList();
        for(RegisterForm register : registerList) {
            if ((register.getReturnedDate()).equals("")) {
                for (Book book : bookList) {
                    if (book.getBookId() == register.getBookId()) {
                        loanedBookList.add(new LoanedBook( register.getBookId(), book.getBookName(), book.getTypeOfBook(),
                                book.getAuthor(), register.getQuantity(),
                                book.getLanguage(), register.getLoanDate(), register.getLoanSituation(), register.getDueDate()));
                        break;
                    }
                }
            }
        }
        return loanedBookList;
    }


    public ArrayList<ReturnedBook> viewReturnedBookInfo(){
        ArrayList<Book> bookList = selectAllBook();
        ArrayList<ReturnedBook> returnedBookList = new ArrayList<>();
        ArrayList<RegisterForm> registerList = registerService.initRegisterList();
        System.out.println("register: "+ registerList.size());

        for(RegisterForm register : registerList) {
            if (!((register.getReturnedDate()).equals(""))) {
                for (Book book : bookList) {
                    if (book.getBookId() == register.getBookId()) {
                        returnedBookList.add(new ReturnedBook( register.getBookId(), book.getBookName(), book.getTypeOfBook(),
                                book.getAuthor(), register.getQuantity(),
                                book.getLanguage(), register.getLoanDate(), register.getReceiveSituation(), register.getReturnedDate()));
                        break;
                    }
                }
            }
        }
        System.out.println("so phan tu: loaned"+returnedBookList.size());
        return returnedBookList;
    }
}
