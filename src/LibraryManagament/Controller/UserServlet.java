package LibraryManagament.Controller;

import LibraryManagament.Model.Img;
import LibraryManagament.Model.Reader;
import LibraryManagament.UserService.UserServiceImp;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/users"})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserServiceImp userServiceImp;

    public void init() {
        userServiceImp = new UserServiceImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "listReader":
                try {
                    listUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "customer":
                listImage(request,response);
                break;
            case "registration":
                try {
                    insertRegistration(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "view":
                viewBook(request, response);
                break;
            case "edit":
                    updateReader(request,response);
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                loginForm(request, response);
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "listReader":
                try {
                    listUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "customer":
                listImage(request, response);
                break;
            case "registration":
                registrationForm(request, response);
                break;
            case "view":
                viewBook(request, response);
                break;
            case "edit":
                    updateForm(request,response);
                break;
            case "deletePage":
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                loginForm(request, response);
                break;
        }
    }

    public void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login/login.jsp");
        dispatcher.forward(request, response);
    }

//    public void showListBook(HttpServletRequest request, HttpServletResponse response) {
////        List<Img> imgList = userServiceImp.selectAllImgs();
////        request.setAttribute("listReader", imgList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/userList.jsp");
////        request.setAttribute("imgList",imgList);
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void registrationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration/registration.jsp");
        dispatcher.forward(request, response);
    }

    public void insertRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String readerName = request.getParameter("readerName");
        String identificationId = request.getParameter("identificationId");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");
        String occupation = request.getParameter("occupation");
        String email = request.getParameter("email");
        Reader newReader = new Reader(readerName, identificationId, dateOfBirth, address, occupation, email);
        userServiceImp.insertUser(newReader);
        RequestDispatcher dispatcher = request.getRequestDispatcher("registration/registration.jsp");
        dispatcher.forward(request, response);
    }

    public void viewBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Reader> listReader = userServiceImp.selectAllUsers();
        request.setAttribute("listReader", listReader);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listReader/listReader.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int readerId = Integer.parseInt(request.getParameter("readerId"));
        userServiceImp.deleteUser(readerId);

        List<Reader> listReader = userServiceImp.selectAllUsers();
        request.setAttribute("listReader", listReader);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listReader/listReader.jsp");
        dispatcher.forward(request, response);
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) {
        int readerId = Integer.parseInt(request.getParameter("readerId"));
        Reader existingReader = userServiceImp.selectUser(readerId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit/edit.jsp");
        request.setAttribute("reader", existingReader);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateReader(HttpServletRequest request, HttpServletResponse response) {
        int readerId = Integer.parseInt(request.getParameter("readerId"));
        String readerName = request.getParameter("readerName");
        String identificationId = request.getParameter("identificationId");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");
        String occupation = request.getParameter("occupation");
        String email = request.getParameter("email");
        Reader reader = new Reader(readerId, readerName, identificationId, dateOfBirth, address, occupation, email);
        try {
            userServiceImp.updateUser(reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listImage(HttpServletRequest request, HttpServletResponse response)
    {
        List<Img> listImage = null;
        try {
            listImage = userServiceImp.selectAllImgs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listImage", listImage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/userList.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
        int imageId = Integer.parseInt(request.getParameter("imageId"));
        Img existingReader = userServiceImp.selectImg(imageId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        request.setAttribute("img", existingReader);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
