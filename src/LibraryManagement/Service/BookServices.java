package LibraryManagement.Service;

import LibraryManagement.Model.*;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServices implements I_BookService{
    RegisterService registerService = new RegisterService();
    SQLConnection connection = new SQLConnection();
    final static String SELECT_ALL_BOOKS = "SELECT * FROM bookDetail";
    final static String SELECT_ALL_BOOK_FOR_VIEWING = "SELECT * FROM BookOverview";
    final static String VIEW_READER_QUANTITY = "SELECT quantity FROM Book WHERE status = true";
    final static String SELECT_ONE_BOOK = "SELECT * FROM bookDetail WHERE bookId=?";

    /*-------------------------------------EDIT----------------------------------------------*/
    final static String EDIT_BOOK_DETAIL = "UPDATE  bookDetail SET bookName=? ,typeOfBook=?,author=?, quantity=?, " +
            "price=?, language=?, status=?, situation=?, image= ? WHERE bookId=?";
    final static String EDIT_BOOK_TITLE_TABLE ="UPDATE BookTitle SET bookName=? ,author=?," +
            "price=?, language=? WHERE bookTitleId=?";
    final static String EDIT_BOOK_TYPE_TABLE ="UPDATE BookType SET typeOfBook=? WHERE bookTypeId=?";
    final static String EDIT_BOOK_TABLE ="UPDATE Book SET situation=? WHERE bookId=?";
    final static String EDIT_BOOK_OVERVIEW_TABLE = "UPDATE  BookOverview SET bookName=? ,typeOfBook=?,author=?, " +
            "price=?, language=?, situation=? WHERE bookTitleId=? AND bookTypeId=?";
    /*-------------------------------------UPDATE----------------------------------------------*/

    final static String UPDATE_BOOK_DETAIL = "UPDATE  bookDetail SET bookName=? ,typeOfBook=?,author=?, quantity=?, " +
            "price=?, language=?, status=?, situation=?, image= ? WHERE bookId=?";

    /*-------------------------------------UPDATE----------------------------------------------*/
    final static String VIEW_ISSUED_BOOK_QUANTITY = "SELECT quantity FROM bookDetail";
    final static String ADD_NEW_BOOK = "INSERT INTO bookDetail VALUES (?,?,?,?,?,?,?,?,?)";
    final static String DELETE_BOOK = "DELETE FROM bookDetail WHERE bookId= ?";

    /*-------------------------------------------------------------------------------------------*/
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
                String image = rs.getString("image");
                bookList.add(new Book(Id,bookName,typeOfBook,author,quantity,price,language,status,situation, image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BookView> viewAllBook() {
        ArrayList<BookView> bookList = new ArrayList<>();
        ArrayList<LoanedBook> loanedBookList = viewLoanedBookInfo();
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_BOOK_FOR_VIEWING);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String bookName = rs.getString("bookName");
                String typeOfBook = rs.getString("typeOfBook");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String language = rs.getString("language");
                int loanedQuantity = 0;
                int availableQuantity;

                for(LoanedBook book : loanedBookList){
                    if(book.getBookName().equalsIgnoreCase(bookName)){
                        loanedQuantity+= book.getQuantity();
                    }
                }
                availableQuantity = quantity - loanedQuantity;
                bookList.add(new BookView(bookName,typeOfBook,author,quantity,price,language,loanedQuantity,availableQuantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
    public void updateBookDetail(ArrayList<Book> bookList, ArrayList<RegisterForm> registerList,Connection conn) {
        //kiem tra trang thai book trong danh sach da cho muon khi duoc tra lai
        for (Book book : bookList) {
            try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_BOOK_DETAIL);
            for (RegisterForm registerForm : registerList) {
                if (book.getBookId()==registerForm.getBookId()) {
                        if (!(registerForm.getReturnedDate().equalsIgnoreCase(""))){
                            book.setSituation(registerForm.getReceiveSituation());
                            try {
                                ps.setString(1,book.getBookName());
                                ps.setString(2,book.getTypeOfBook());
                                ps.setString(3,book.getAuthor());
                                ps.setInt(4,book.getQuantity());
                                ps.setInt(5,book.getPrice());
                                ps.setString(6,book.getLanguage());
                                ps.setBoolean(7,book.getStatus());
                                ps.setString(8,registerForm.getReceiveSituation());
                                ps.setString(9,book.getImage());
                                ps.setInt(10,book.getBookId());
                                int rows = ps.executeUpdate();
                                if((rows>0))
                                    System.out.println("Update book detail thanh cong");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        else if (registerForm.getReturnedDate().equalsIgnoreCase("")) {
                            try {
                                ps.setString(1,book.getBookName());
                                ps.setString(2,book.getTypeOfBook());
                                ps.setString(3,book.getAuthor());
                                ps.setInt(4,book.getQuantity());
                                ps.setInt(5,book.getPrice());
                                ps.setString(6,book.getLanguage());
                                ps.setBoolean(7,true);
                                ps.setString(8,book.getSituation());
                                ps.setString(9,book.getImage());
                                ps.setInt(10,book.getBookId());
                                int rows = ps.executeUpdate();
                                if((rows>0))
                                    System.out.println("Update book detail thanh cong");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }


                }
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public ArrayList<Book> selectAllBook() {
        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<RegisterForm> registerList = registerService.initRegisterList();
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("bookId");
                String bookName = rs.getString("bookName");
                String typeOfBook = rs.getString("typeOfBook");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String language = rs.getString("language");
                boolean status = rs.getBoolean("status");
                String situation = rs.getString("situation");
                String image = rs.getString("image");
                bookList.add(new Book(Id, bookName, typeOfBook, author, quantity, price, language, status, situation, image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateBookDetail(bookList,registerList,conn);
        return bookList;
    }
    public void updateBookTitleTable(Book book, Connection conn) {
        String getBookTitleId = "SELECT bookTitleId FROM Book WHERE bookId=?";
        int bookTitleId=0;
        try {
            PreparedStatement ps= conn.prepareStatement(getBookTitleId);
            ps.setInt(1,book.getBookId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                bookTitleId =rs.getInt("bookTitleId");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("bookTitle: "+ bookTitleId);
        try {
            PreparedStatement ps = conn.prepareStatement(EDIT_BOOK_TITLE_TABLE);
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getPrice());
            ps.setString(4,book.getLanguage());
            ps.setInt(5,bookTitleId);
            int rows = ps.executeUpdate();
            if((rows>0))
                System.out.println("Update bookTitle Table thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBookTypeTable(Book book, Connection conn) {
        String getBookTypeId = "SELECT bookTypeId FROM Book WHERE bookId=?";
        int bookTypeId=0;
        try {
            PreparedStatement ps= conn.prepareStatement(getBookTypeId);
            ps.setInt(1,book.getBookId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                bookTypeId =rs.getInt("bookTypeId");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(EDIT_BOOK_TYPE_TABLE);
            ps.setString(1,book.getTypeOfBook());
            ps.setInt(2,bookTypeId);
            int rows = ps.executeUpdate();
            if((rows>0))
                System.out.println("Update bookType Table thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBookTable(Book book, Connection conn) {
        String getBookId = "SELECT bookId FROM Book WHERE bookId=?";
        int bookId=0;
        try {
            PreparedStatement ps= conn.prepareStatement(getBookId);
            ps.setInt(1,book.getBookId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                bookId =rs.getInt("bookId");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(EDIT_BOOK_TABLE);
            ps.setString(1,book.getSituation());
            ps.setInt(2,bookId);
            int rows = ps.executeUpdate();
            if((rows>0))
                System.out.println("Update book Table thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBookOverviewTable(Book book, Connection conn) {
        String getBookId = "SELECT bookTitleId, bookTypeId FROM Book WHERE bookId=?";
        System.out.println("bookId: " + book.getBookId());
        int bookTitleId=0;
        int bookTypeId=0;
        try {
            PreparedStatement ps= conn.prepareStatement(getBookId);
            ps.setInt(1,book.getBookId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                bookTitleId =rs.getInt("bookTitleId");
                bookTypeId =rs.getInt("bookTypeId");
                System.out.println("bookTitleId: "+ bookTitleId);
                System.out.println("bookTypeId: "+ bookTypeId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(EDIT_BOOK_OVERVIEW_TABLE);
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getTypeOfBook());
            ps.setString(3,book.getAuthor());
            ps.setInt(4,book.getPrice());
            ps.setString(5,book.getLanguage());
            ps.setString(6,book.getSituation());
            ps.setInt(7,bookTitleId);
            ps.setInt(8,bookTypeId);
            int rows = ps.executeUpdate();
            if((rows>0))
                System.out.println("Update BookOverView Table thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean saveBook(Book book) {
        Connection conn = connection.getConnection();
        updateBookTitleTable(book,conn);
        updateBookTypeTable(book,conn);
        updateBookTable(book,conn);
        updateBookOverviewTable(book,conn);
        try {
            PreparedStatement ps = conn.prepareStatement(EDIT_BOOK_DETAIL);
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getTypeOfBook());
            ps.setString(3,book.getAuthor());
            ps.setInt(4,book.getQuantity());
            ps.setInt(5,book.getPrice());
            ps.setString(6,book.getLanguage());
            ps.setBoolean(7,book.getStatus());
            ps.setString(8,book.getSituation());
            ps.setString(9,book.getImage());
            ps.setInt(10,book.getBookId());
            int rows = ps.executeUpdate();
            if((rows>0))
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
                String image = rs.getString("image");
                Book updatedBook = new Book(bookId,bookName,typeOfBook,author,quantity,price,language,status,situation, image);
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
        ArrayList<LoanedBook> bookList = viewLoanedBookInfo();
        return bookList.size();
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
        return returnedBookList;
    }
}
