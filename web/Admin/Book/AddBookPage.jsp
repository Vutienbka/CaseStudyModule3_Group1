<%@ page import="LibraryManagement.Service.SQLConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="LibraryManagement.Service.BookServices" %>
<%@ page import="LibraryManagement.Model.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/9/20
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Add Book</title>
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

    <script src="js/jquery.twbsPagination.js"></script>
    <!-- JS tạo nút bấm di chuyển trang start -->
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <!-- JS tạo nút bấm di chuyển trang end -->
    <script type="text/javascript">
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
    <style>
        body{
            margin: 0;
            padding: 0;
        }
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
        form{
            display: inline-table;
            border: 1px solid #cccccc;
            margin-right: 40px;
        }
        select {
            margin-left: 0px;
            height: 30px;
            width: 120px;
        }
        table{
            text-align: center;
        }
        td{
            line-height: 37px;
        }
        a{
            display: block;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <p style="position:relative;top: 10px; font-size: 20px; color: #00aced;text-decoration: #00aced ">
        <a href="book"> Back to Home Page << </a>
        <span style="color: green; font-size: 20px" id="message" onclick="hideMessage()">
            ${message}
        </span>
        <a href="${pageContext.request.contextPath}?action=addPage" style="font-size: 20px"> Back to Add Home Page << </a>
    </p>
    <div><button class="btn btn-primary"><a style="color: white"
                href="${pageContext.request.contextPath}?action=addForm&Id=${book.getBookId()}"> Add Book</a>
   </button></div>
    <div class="card mb-4">
        <div class="card-header" style="font-size: 20px; font-weight: bolder"><i class="fas fa-table mr-1"></i >Books Information</div>
        <div class="card-body">
            <div class="table-responsive">
                <span>
                <form action="addPage" method="post">
                    <select value = "bookName"  name = "bookName">
                        <option value="Select">Select</option>
                        <%
                            SQLConnection connection = new SQLConnection();
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
                    <button type="submit" class="btn-secondary">Search by bookName</button>
                </form>
                    </span>
                <span>
                <form action="addPage" method="post">
                    <select value = "typeOfBook" name = "typeOfBook">
                        <option value="Select">Select</option>
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
                    <button type="submit" class="btn-secondary">Search by bookType</button>
                </form>

                <form action="addPage" method="post">
                        <input type="text" style="width: 150px; height: 30px" name="language">
                    <button type="submit" class="btn-secondary">Search by language</button>
                </form>
                </span>
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>BookId</th>
                        <th>Book Name
                        </th>
                        <th>Type Of Book
                        </th>
                        <th>Author Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Language</th>
                        <th>Status</th>
                        <th>Situation</th>
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
                        String searchQuery3 = request.getParameter("language");
                        if(searchQuery2!=null){
                            dataTable = " SELECT * FROM bookDetail WHERE typeOfBook like '%"+searchQuery2+"%' ";
                        }else if(searchQuery1!=null){
                            dataTable = " SELECT * FROM bookDetail WHERE bookName like '%"+searchQuery1+"%' ";
                        }else if(searchQuery3!=null) {
                            dataTable = " SELECT * FROM bookDetail WHERE language like '%"+searchQuery3+"%' ";
                        }else {
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