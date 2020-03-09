<%--
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
    <style>
    </style>
    <script>
        let hide = document.getElementById("message");
        function hideMessage() {
            hide.style.display="none";
        }
    </script>
</head>
<body>
<div class="container-fluid">
    <p style="position:relative;top: 10px; font-size: 20px; color: #00aced;text-decoration: #00aced ">
        <a href="book"> Back to Home Page << </a>
        <span style="color: green; font-size: 20px" id="message" onclick="hideMessage()">
            ${message}
        </span>
    </p>
    <div><button class="btn btn-primary"><a style="color: white"
                href="${pageContext.request.contextPath}?action=addForm&Id=${book.getBookId()}"> Add Book</a>
   </button></div>
    <div class="card mb-4">
        <div class="card-header" style="font-size: 20px; font-weight: bolder"><i class="fas fa-table mr-1"></i >Books Information</div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
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

                    <c:forEach items="${bookList}" var="book">
                        <tr>
                            <td><c:out value="${book.getBookId()}"></c:out></td>
                            <td><c:out value="${book.getBookName()}"></c:out></td>
                            <td><c:out value="${book.getTypeOfBook()}"></c:out></td>
                            <td><c:out value="${book.getAuthor()}"></c:out></td>
                            <td><c:out value="${book.getQuantity()}"></c:out></td>
                            <td><c:out value="${book.getPrice()}"></c:out></td>
                            <td><c:out value="${book.getLanguage()}"></c:out></td>
                            <td><c:out value="${book.getStatus()}"></c:out></td>
                            <td><c:out value="${book.getSituation()}"></c:out></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>