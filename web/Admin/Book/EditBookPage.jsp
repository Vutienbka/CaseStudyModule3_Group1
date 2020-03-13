<%@ page import="LibraryManagement.Service.SQLConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="LibraryManagement.Service.BookServices" %>
<%@ page import="LibraryManagement.Model.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/7/20
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>EditBook</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <style>
        #editForm{
            display: none;
        }
        #pagination {
            display: flex;
            display: -webkit-flex; /* Safari 8 */
            flex-wrap: nowrap;
            -webkit-flex-wrap: nowrap; /* Safari 8 */
            justify-content: center;
            -webkit-justify-content: center;
        }
    </style>

    <script src="js/jquery.twbsPagination.js"></script>
    <!-- JS tạo nút bấm di chuyển trang start -->
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <!-- JS tạo nút bấm di chuyển trang end -->
    <script type="text/javascript">
        let hide = document.getElementById("message");
        function hideMessage() {
            hide.style.display="none";
        }
        $(function () {
            var pageSize = 9; // Hiển thị 6 sản phẩm trên 1 trang
            showPage = function (page) {
                $(".contentPage").hide();
                $(".contentPage").each(function (n) {
                    if (n >= pageSize * (page - 1) && n < pageSize * page)
                        $(this).show();
                });
            }
            showPage(1);
            ///** Cần truyền giá trị vào đây **///
            var totalRows = 19; // Tổng số sản phẩm hiển thị
            var btnPage = 5; // Số nút bấm hiển thị di chuyển trang
            var iTotalPages = Math.ceil(totalRows / pageSize);
            var obj = $('#pagination').twbsPagination({
                totalPages: iTotalPages,
                visiblePages: btnPage,
                onPageClick: function (event, page) {
                    console.info(page);
                    showPage(page);
                }
            });
            console.info(obj.data());
        });
    </script>
</head>
<body>
<!--Ta Edit Form -->
<div id = "editForm" class="container-sm">
    <div class="panel-group" style="margin: 0 auto">
        <div class="panel panel-primary"  >
            <div class="panel-heading" >
                <h3 class="panel-title" style="text-align: center;">Edit Form</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" >
                    <div class="form-group">
                        <label class="control-label col-sm-3"  >BookId:</label>
                        <input type="text" id = "bookId" class="form-control"  placeholder="BookId">
                    </div>
                    <div class="form-group">
                        <label class="control-label">BookName</label>
                        <input type="text" id="bookName" class="form-control" placeholder="Book Name" >
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"  >Type Of Book</label>
                        <input type="text" id="typeOfBook" class="form-control"  placeholder="Type Of Book">
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" style="text-align:right;">Author</label>
                        <input type="text" id="author" class="form-control" placeholder="Author" >
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3">Quality</label>
                        <input type="text" id ="quality" class="form-control" placeholder="Quality">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Price</label>
                        <input type="text"  id="price" class="form-control" placeholder="Price" >
                    </div>

                    <div class="form-group">
                        <label class="control-label">language</label>
                        <input type="text"  id="language" class="form-control" placeholder="Price" >
                    </div>
                    <div class="form-group">
                        <label class="control-label">Status</label>
                        <input type="text"  id="status" class="form-control" placeholder="Status" >
                    </div>
                    <div class="form-group">
                        <label class="control-label">Situation</label>
                        <input type="text"  id="situation" class="form-control" placeholder="Situation" >
                    </div>
                    <div class="form-group">
                        <button id ="save" type="submit" class="btn btn-success" style="width: 120px"> Save </button>
                        <button id="close" class="btn btn-primary" style="width: 120px">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!--Ta Edit Form -->
<div class="container-fluid">
    <p style="position:relative;top: 10px; font-size: 20px; color: #00aced;text-decoration: #00aced ">
        <a href="book"> Back to Home Page << </a>
        <span style="color: green; font-size: 20px" id="message" onclick="hideMessage()">
            ${message}
        </span>
    </p>
    <div class="card mb-4">
        <div class="card-header" style="font-size: 20px; font-weight: bolder"><i class="fas fa-table mr-1"></i >Books Information</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>BookId</th>
                        <th>Book Name
                                <select value = "bookName"  name = "bookName" style="margin-left: 15px; height: 25px; width: 120px">
                                    <option value="All">All</option>
                                    <%
                                        SQLConnection connection = new SQLConnection();
                                        //BookServices bookService = new BookServices();
                                        // ArrayList<Book> bookList = bookService.selectAllBook();
                                        Connection conn = connection.getConnection();
                                        Statement stat = null;
                                        ResultSet rs = null;
                                        stat = conn.createStatement();
                                        String data;
                                        data = "SELECT bookName FROM BookTitle";
                                        rs = stat.executeQuery(data);
                                        while (rs.next()){
                                    %>
                                    <option value="<%= rs.getString("bookName")%>"> <%= rs.getString("bookName")%></option>
                                    <%
                                        }
                                    %>
                                </select>
                        </th>
                        <th>Type Of Book
                                <select> value = "typeOfBook" name = "typeOfBook" style="margin-left: 15px; height: 25px; width: 120px">
                                    <option value="All">All</option>
                                    <%
                                        data = "SELECT typeOfBook FROM BookType";
                                        rs = stat.executeQuery(data);
                                        while (rs.next()){
                                    %>
                                    <option value="<%= rs.getString("typeOfBook")%>"> <%= rs.getString("typeOfBook")%></option>
                                    <%
                                        }
                                    %>
                                </select>

                        </th>
                        <th>Author Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Language</th>
                        <th>Status</th>
                        <th>Situation</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>BookId</th>
                        <th>Book Name</th>
                        <th>Type Of Book</th>
                        <th>Author Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Language</th>
                        <th>Status</th>
                        <th>Situation</th>
                        <th>Action</th>
                    </tr>
                    </tfoot>
                    <tbody>

                    <%
                        BookServices bookService = new BookServices();
                        ArrayList<Book> bookList = bookService.selectAllBook();
                        stat = conn.createStatement();
                        String dataTable;
                        String searchQuery1 = request.getParameter("bookName");
                        String searchQuery2 = request.getParameter("typeOfBook");
                        String search = "%"+searchQuery2+"%";
                        if(searchQuery2!=null){
                            dataTable = " SELECT * FROM bookDetail WHERE typeOfBook like '%"+searchQuery2+"%' ";
                        }else
                        {
                            dataTable = "SELECT * FROM bookDetail ORDER BY bookId ASC";
                        }
                        rs = stat.executeQuery(dataTable);
                        while (rs.next()){
                    %>
                    <tr class="contentPage">
                        <td><%= rs.getInt("bookId")%></td>
                        <td><%= rs.getString("bookName")%></td>
                        <td><%= rs.getString("typeOfBook")%></td>
                        <td><%= rs.getString("author")%></td>
                        <td><%= rs.getInt("quantity")%></td>
                        <td><%= rs.getInt("price")%></td>
                        <td><%= rs.getString("language")%></td>
                        <td><%= rs.getBoolean("status")%></td>
                        <td><%= rs.getString("situation")%></td>
                        <td>
                            <button class="btn btn-primary"><a style="color: white"
                                                               href="${pageContext.request.contextPath}?action=editForm&Id=<%=rs.getInt("bookId")%>" >Edit Infor</a></button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<ul id="pagination"></ul>
</body>
</html>