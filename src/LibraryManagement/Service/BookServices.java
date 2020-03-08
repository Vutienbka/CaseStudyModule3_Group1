package LibraryManagement.Service;

import LibraryManagement.Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServices implements I_BookService{

    SQLConnection connection = new SQLConnection();
    final static String INSERT_STUDENT_INTO_SQL = "INSERT INTO Book VALUES (?,?,?,?,?,?);";
    final static String SELECT_ALL_BOOKS = "SELECT * FROM Book";
    final static String SELECT_ONE_BOOK = "SELECT * FROM Book WHERE bookId=?";
    final static String UPDATE_BOOK = "UPDATE  Book SET bookName=? ,typeOfBook=?,author=?, quantity=?, " +
            "price=?, language=?, status=?, situation=? WHERE bookId=?";
    final static String VIEW_ISSUED_BOOK_QUANTITY = "SELECT quantity FROM Book";
    final static String VIEW_LOANED_BOOK_QUANTITY = "SELECT quantity FROM Book WHERE status = true";
    final static String VIEW_READER_QUANTITY = "SELECT quantity FROM Book WHERE status = true";
    private static List<Book> bookList ;
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
    public boolean addNewBook(int Id, Book book) {
        return false;
    }

    @Override
    public void removeBook(int Id) {

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
}
