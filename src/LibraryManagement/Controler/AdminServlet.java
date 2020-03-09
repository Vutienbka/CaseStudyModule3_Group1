package LibraryManagement.Controler;

import LibraryManagement.Model.Book;
import LibraryManagement.Service.BookServices;
import LibraryManagement.Service.SQLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet",urlPatterns = {"/"})
public class AdminServlet extends HttpServlet {
    SQLConnection connection = new SQLConnection();
    BookServices bookService = new BookServices();
    ArrayList<Book> bookList = bookService.selectAllBook();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
        {
            action="";
        }
        switch (action) {
            case "addForm":
                addBook(request,response);
                break;
            case "view":
                break;
            case "editForm":
                editBook(request,response);
                break;
            case "deleteForm":
                deleteBook(request,response);
                break;

            default:listBook(request,response);
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
            case "addPage":
                showAddPage(request,response);
                break;
            case "addForm":
                showAddForm(request,response);
                break;
            case "view":
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
            default:listBook(request,response);
                break;
        }
    }
    public void loginForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/LoginForm.jsp");
        dispatcher.forward(request,response);
    }
    public void listBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int issuedBookQuantity = bookService.viewIssuedBookQuantity();
        int loanedBookQuantity = bookService.viewLoanedBookQuantity();
        int availableBookQuantity = issuedBookQuantity - loanedBookQuantity;
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Admin.jsp");
        request.setAttribute("issuedBookQuantity",issuedBookQuantity);
        request.setAttribute("loanedBookQuantity",loanedBookQuantity);
        request.setAttribute("availableBookQuantity",availableBookQuantity);
        request.setAttribute("bookList",bookList);
        dispatcher.forward(request,response);
    }
    public void showAddPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> bookList = bookService.selectAllBook();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/AddBookPage.jsp");
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
                dispatcher = request.getRequestDispatcher("Admin/addForm.jsp");
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
            dispatcher = request.getRequestDispatcher("Admin/MVC_error_404.jsp");
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
                dispatcher = request.getRequestDispatcher("Admin/AddBookPage.jsp");
                dispatcher.forward(request, response);

            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
    public void showAddForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("Admin/addForm.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/EditBookPage.jsp");
        request.setAttribute("bookList",bookList);
        dispatcher.forward(request,response);
    }
    public void editBook(HttpServletRequest request, HttpServletResponse response) {
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
            dispatcher = request.getRequestDispatcher("Admin/404_Error.jsp");
        } else {
            boolean check = bookService.saveBook(book);
            bookList=bookService.selectAllBook();
            if (check) {
                request.setAttribute("message", "Book information was updated");
                request.setAttribute("bookList", bookList);
            } else request.setAttribute("message", "Book information not Updated");
            try {
                dispatcher = request.getRequestDispatcher("Admin/EditBookPage.jsp");
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
            dispatcher = request.getRequestDispatcher("Admin/editForm.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/DeleteBookPage.jsp");
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
            System.out.println("Da tim thay book");
            System.out.println("ten sach"+book.getBookName());
            dispatcher = request.getRequestDispatcher("Admin/deleteForm.jsp");
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
                RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/DeleteBookPage.jsp");
                request.setAttribute("bookList", bookList);
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("message", "Book not deleted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/DeleteBookPage.jsp");
            request.setAttribute("bookList", bookList);
            dispatcher.forward(request, response);
        }

    }
}
