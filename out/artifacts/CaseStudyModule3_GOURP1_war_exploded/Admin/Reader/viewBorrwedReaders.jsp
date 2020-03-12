<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/12/20
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/12/20
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>View Borrowed Readers</title>
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
    </style>
    <script>
        let hide = document.getElementById("message");
        function hideMessage() {
            hide.style.display="none";
        }
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
                        <label class="control-label col-sm-3"  >ReaderId:</label>
                        <input type="text" id = "bookId" class="form-control"  placeholder="BookId">
                    </div>
                    <div class="form-group">
                        <label class="control-label">ReaderName</label>
                        <input type="text" id="bookName" class="form-control" placeholder="Book Name" >
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3"  >Identification</label>
                        <input type="text" id="typeOfBook" class="form-control"  placeholder="Type Of Book">
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" style="text-align:right;">Date Of Birth</label>
                        <input type="text" id="author" class="form-control" placeholder="Author" >
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3">Gender</label>
                        <input type="text" id ="quality" class="form-control" placeholder="Quality">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Address</label>
                        <input type="text"  id="price" class="form-control" placeholder="Price" >
                    </div>

                    <div class="form-group">
                        <label class="control-label">Occupation</label>
                        <input type="text"  id="language" class="form-control" placeholder="Price" >
                    </div>
                    <div class="form-group">
                        <label class="control-label">Email</label>
                        <input type="text"  id="status" class="form-control" placeholder="Status" >
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
                        <th>ReaderId</th>
                        <th>Reader Name</th>
                        <th>Identification</th>
                        <th>Date Of Birth</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th>Occupation</th>
                        <th>Email</th>
                        <th>BookId</th>
                        <th>BookName</th>
                        <th>Quantity</th>
                        <th>BorrowedDate</th>
                        <th>returnedDate</th>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ReaderId</th>
                        <th>Reader Name</th>
                        <th>Identification</th>
                        <th>Date Of Birth</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th>Occupation</th>
                        <th>Email</th>
                        <th>BookId</th>
                        <th>BookName</th>
                        <th>Quantity</th>
                        <th>BorrowedDate</th>
                        <th>returnedDate</th>
                    </tr>
                    </tfoot>
                    <tbody>

                    <c:forEach items="${borrowedReaderList}" var="reader">
                        <tr>
                            <td><c:out value="${reader.getReaderId()}"></c:out></td>
                            <td><c:out value="${reader.getReaderName()}"></c:out></td>
                            <td><c:out value="${reader.getIdentificationId()}"></c:out></td>
                            <td><c:out value="${reader.getDateOfBirth()}"></c:out></td>
                            <td><c:out value="${reader.getGender()}"></c:out></td>
                            <td><c:out value="${reader.getAddress()}"></c:out></td>
                            <td><c:out value="${reader.getOccupation()}"></c:out></td>
                            <td><c:out value="${reader.getEmail()}"></c:out></td>
                            <td><c:out value="${reader.getBook().getBookId()}"></c:out></td>
                            <td><c:out value="${reader.getBook().getBookName()}"></c:out></td>
                            <td><c:out value="${reader.getBook().getQuantity()}"></c:out></td>
                            <td><c:out value="${reader.getBorrowedDate()}"></c:out></td>
                            <td><c:out value="${reader.getReturnedDate()}"></c:out></td>

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
