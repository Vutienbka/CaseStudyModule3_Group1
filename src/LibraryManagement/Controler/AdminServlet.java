package LibraryManagement.Controler;

import LibraryManagement.Model.Book;
import LibraryManagement.Service.BookServices;
import LibraryManagement.Service.SQLConnection;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
            case "create":
                break;
            case "view":
                break;
            case "editForm":
                editForm(request,response);
                break;
            case "deletePage":
                break;

            case "deleteForm":
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
            case "create":
                break;
            case "view":
                break;
            case "editPage":
                showEditPage(request,response);
                break;
            case "editForm":
                showEditForm(request,response);
                System.out.println("Hello da vao nha");
                break;
            case "deletePage":
                break;

            case "deleteForm":
                break;

            default:listBook(request,response);
                break;
        }
    }
    public void loginForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("LoginForm.jsp");
        dispatcher.forward(request,response);
    }
    public void listBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int issuedBookQuantity = bookService.viewIssuedBookQuantity();
        int loanedBookQuantity = bookService.viewLoanedBookQuantity();
        int availableBookQuantity = issuedBookQuantity - loanedBookQuantity;
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin.jsp");
        request.setAttribute("issuedBookQuantity",issuedBookQuantity);
        request.setAttribute("loanedBookQuantity",loanedBookQuantity);
        request.setAttribute("availableBookQuantity",availableBookQuantity);
        request.setAttribute("bookList",bookList);
        dispatcher.forward(request,response);
    }
    public void showEditPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> bookList = bookService.selectAllBook();
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditBookPage.jsp");
        request.setAttribute("bookList",bookList);
        dispatcher.forward(request,response);
    }
    public void editForm(HttpServletRequest request, HttpServletResponse response) {
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
            dispatcher = request.getRequestDispatcher("MVC_error_404.jsp");
        } else {
            boolean check = bookService.saveBook(book);
            bookList=bookService.selectAllBook();
            if (check) {
                request.setAttribute("message", "Book information was updated");
                request.setAttribute("bookList", bookList);
            } else request.setAttribute("message", "Book information not Updated");
            try {
                dispatcher = request.getRequestDispatcher("EditBookPage.jsp");
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
            dispatcher = request.getRequestDispatcher("MVC_error_404.jsp");
        } else {
            request.setAttribute("book", book);
            dispatcher = request.getRequestDispatcher("editForm.jsp");
            System.out.println("hello anh em nha");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
