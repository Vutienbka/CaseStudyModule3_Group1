package LibraryManagement.Controler;

import LibraryManagement.Model.Book;
import LibraryManagement.Model.LoanedBook;
import LibraryManagement.Model.Reader;
import LibraryManagement.Model.ReturnedBook;
import LibraryManagement.Service.BookServices;
import LibraryManagement.Service.ReaderService;
import LibraryManagement.Service.SQLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


@WebServlet(name = "AdminServlet",urlPatterns = {"/"})
public class AdminServlet extends HttpServlet {
    SQLConnection connection = new SQLConnection();
    BookServices bookService = new BookServices();
    ReaderService readerService = new ReaderService();
    ArrayList<Book> bookList = bookService.selectAllBook();
    ArrayList<Reader> readerList = readerService.selectAllReader();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
        {
            action="";
        }
        switch (action) {
            /*----------------BOOK---------------------*/
            case "addForm":
                addBook(request,response);
                break;
            case "view":
                break;
            case "editForm":
                try {
                    editBook(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteForm":
                deleteBook(request,response);
                break;
            /*----------------READER---------------------*/
            default:showHomePage(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
        {
            action="";
        }
        switch (action) {
            /*----------------BOOK---------------------*/
            case "addPage":
                showAddPage(request,response);
                break;
            case "addForm":
                showAddForm(request,response);
                break;
            case "viewLoanedBooks":
                viewLoanedBook(request,response);
                break;
            case "viewReturnedBooks":
                viewReturnedBooks(request,response);
                break;

            case "editPage":
                showEditPage(request,response);
                break;
            case "editForm":
                showEditForm(request,response);
                break;
            case "deletePage":
                showDeletePage(request,response);
                break;
            case "deleteForm":
                showDeleteForm(request,response);
                break;
            /*----------------READER---------------------*/
            case "editReaderPage":
                showEditReaderPage(request,response);
                break;
            default: {
                showHomePage(request, response);
                break;
            }
        }
    }
    public void loginForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/LoginForm.jsp");
        dispatcher.forward(request,response);
    }
    /*-------------------------------------BOOK------------------------------------------------------------------------------*/
    public void showHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int issuedBookQuantity = bookService.viewIssuedBookQuantity();
        int loanedBookQuantity = bookService.viewLoanedBookQuantity();
        int readerQuantity = readerService.viewReaderQuantity();
        int availableBookQuantity = issuedBookQuantity - loanedBookQuantity;
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Admin.jsp");
        request.setAttribute("issuedBookQuantity",issuedBookQuantity);
        request.setAttribute("loanedBookQuantity",loanedBookQuantity);
        request.setAttribute("availableBookQuantity",availableBookQuantity);
        request.setAttribute("readerQuantity",readerQuantity);
        request.setAttribute("bookList",bookList);
        dispatcher.forward(request,response);
    }

    public void showAddPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> bookList = bookService.selectAllBook();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Book/AddBookPage.jsp");
        request.setAttribute("bookList",bookList);
        dispatcher.forward(request,response);
    }
    public void addBook(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String typeOfBook = request.getParameter("typeOfBook");
        String author = request.getParameter("author");
        String quantitys = request.getParameter("quality");
        String prices = request.getParameter("price");
        String language = request.getParameter("language");
        boolean status = Boolean.getBoolean(request.getParameter("status"));
        String situation = request.getParameter("situation");
        RequestDispatcher dispatcher;
        try {
            if ((bookId<0) || (bookName == "")
                    || (typeOfBook == "") || (author == "") || (quantitys=="") || (prices=="")
                    || (request.getParameter("status") == "") || (request.getParameter("situation") == "")) {
                String message = ">> Inputted information still not enough <<";
                dispatcher = request.getRequestDispatcher("Admin/Book/addForm.jsp");
                request.setAttribute("message", message);
                dispatcher.forward(request, response);
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        int quantity = Integer.parseInt(request.getParameter("quality"));
        int price = Integer.parseInt(request.getParameter("price"));
        Book book = new Book(bookId,bookName,typeOfBook,author,quantity,price,language,status,situation);
        if (book == null) {
            System.out.println("sach dang rong");
            dispatcher = request.getRequestDispatcher("Admin/404_Error.jsp");
        } else {
            System.out.println("Sach van khac null");
            boolean check = bookService.addNewBook(book);
            bookList= bookService.selectAllBook();
            if (check) {
                request.setAttribute("message", "New book was Added");
                request.setAttribute("bookList", bookList);
            } else{
                request.setAttribute("message", "New Book not Added");
                request.setAttribute("bookList", bookList);
            }
            try {
                dispatcher = request.getRequestDispatcher("Admin/Book/AddBookPage.jsp");
                dispatcher.forward(request, response);

            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
    public void showAddForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("Admin/Book/addForm.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showEditPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> bookList = bookService.selectAllBook();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Book/EditBookPage.jsp");
        request.setAttribute("bookList",bookList);
        dispatcher.forward(request,response);
    }
    public void editBook(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int bookId = Integer.parseInt(request.getParameter("Id"));
        String bookName = request.getParameter("bookName");
        String typeOfBook = request.getParameter("typeOfBook");
        String author = request.getParameter("author");
        int quantity = Integer.parseInt(request.getParameter("quality"));
        int price = Integer.parseInt(request.getParameter("price"));
        String language = request.getParameter("language");
        boolean status = Boolean.getBoolean(request.getParameter("status"));
        String situation = request.getParameter("situation");
        Book book = new Book(bookId,bookName,typeOfBook,author,quantity,price,language,status,situation);

        RequestDispatcher dispatcher;

        if (book == null) {
            dispatcher = request.getRequestDispatcher("Admin/Book/404_Error.jsp");
        } else {
            boolean check = bookService.saveBook(book);
            bookList=bookService.selectAllBook();
            if (check) {
                request.setAttribute("message", "Book information was updated");
                request.setAttribute("bookList", bookList);
            } else request.setAttribute("message", "Book information not Updated");
            try {
                dispatcher = request.getRequestDispatcher("Admin/Book/EditBookPage.jsp");
                dispatcher.forward(request, response);

            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }

    public void showEditForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("Id"));
        Book book = this.bookService.findById(bookId);
        RequestDispatcher dispatcher;
        if(book == null){
            dispatcher = request.getRequestDispatcher("Admin/404_Error.jsp");
        } else {
            request.setAttribute("book", book);
            dispatcher = request.getRequestDispatcher("Admin/Book/editForm.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showDeletePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> bookList = bookService.selectAllBook();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Book/DeleteBookPage.jsp");
        request.setAttribute("bookList",bookList);
        dispatcher.forward(request,response);
    }
    public void showDeleteForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("Id"));
        Book book = this.bookService.findById(bookId);
        RequestDispatcher dispatcher;
        if(book == null){
            dispatcher = request.getRequestDispatcher("Admin/404_Error.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("Admin/Book/deleteForm.jsp");
            request.setAttribute("book", book);
            dispatcher.forward(request,response);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteBook(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("Id"));
        boolean check = bookService.removeBook(bookId);
        ArrayList<Book> bookList = bookService.selectAllBook();
        if (check) {
            try {
                request.setAttribute("message", "Book was deleted");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Book/DeleteBookPage.jsp");
                request.setAttribute("bookList", bookList);
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            request.setAttribute("message", "Book not deleted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Book/DeleteBookPage.jsp");
            request.setAttribute("bookList", bookList);
            dispatcher.forward(request, response);
        }
    }
    public void viewLoanedBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LoanedBook> loanedBookList = bookService.viewLoanedBookInfo();
        RequestDispatcher dispatcher;
        if(loanedBookList==null){
            String message = "Loaned Books is empty";
            dispatcher = request.getRequestDispatcher("Admin/Book/LoanedBookPage.jsp");
            request.setAttribute("message", message);
            dispatcher.forward(request, response);
        }
        else {
            dispatcher = request.getRequestDispatcher("Admin/Book/LoanedBookPage.jsp");
            request.setAttribute("loanedBookList", loanedBookList);
            dispatcher.forward(request, response);
        }

    }
    public void viewReturnedBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ReturnedBook> returnedBookList = bookService.viewReturnedBookInfo();
        RequestDispatcher dispatcher;
        if(returnedBookList==null){
            String message = "Returned Book List is empty";
            dispatcher = request.getRequestDispatcher("Admin/Book/ReturnedBookPage.jsp");
            request.setAttribute("message", message);
            dispatcher.forward(request, response);
        }
        else {
            dispatcher = request.getRequestDispatcher("Admin/Book/ReturnedBookPage.jsp");
            request.setAttribute("returnedBookList", returnedBookList);
            dispatcher.forward(request, response);
        }

    }
    /*-----------------------------------------------READER--------------------------------------------------------------------*/
    public void showEditReaderPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Reader> readerList = readerService.selectAllReader();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Reader/EditReaderPage.jsp");
        request.setAttribute("readerList",readerList);
        dispatcher.forward(request,response);

    }
}
