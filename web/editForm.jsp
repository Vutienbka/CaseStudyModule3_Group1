<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/8/20
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit form</title>
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
</head>
<body>

<div id = "editForm" class="container-sm" style="border: 1px solid #cccccc; background: #f2f2f2; width: 700px; position: relative;top: 0px">
    <div class="panel-group" style="margin: 0 auto">
        <div class="panel panel-primary"  >
            <div class="panel-heading" >
                <h3 class="panel-title" style="text-align: center;">Edit Form</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label class="control-label"  >BookId:</label>
                        <input type="text" name="bookId" id = "${book.getBookId()}" value="${book.getBookId()}" class="form-control"  placeholder="BookId">
                    </div>
                    <div class="form-group">
                        <label class="control-label">BookName</label>
                        <input type="text" name="bookName" id = "${book.getBookName()}" value="${book.getBookName()}" class="form-control" placeholder="Book Name" >
                    </div>
                    <div class="form-group">
                        <label class="control-label"  >Type Of Book</label>
                        <input type="text" name="typeOfBook" id = "${book.getTypeOfBook()}" value="${book.getTypeOfBook()}" class="form-control"  placeholder="Type Of Book">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Author</label>
                        <input type="text" name = "author" id = "${book.getAuthor()}" value="${book.getAuthor()}" class="form-control" placeholder="Author" >
                    </div>
                    <div class="form-group">
                        <label class="control-label">Quality</label>
                        <input type="text" name="quality" id = "${book.getQuality()}" value="${book.getQuality()}" class="form-control" placeholder="Quality">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Price</label>
                        <input type="text"  name="price" id = "${book.getPrice()}" value="${book.getPrice()}" class="form-control" placeholder="Price" >
                    </div>

                    <div class="form-group">
                        <label class="control-label">Language</label>
                        <input type="text"  name="language" id = "${book.getLanguage()}" value="${book.getLanguage()}" class="form-control" placeholder="Price" >
                    </div>
                    <div class="form-group">
                        <label class="control-label">Status</label>
                        <input type="text"  name="status" id = "${book.getStatus()}" value="${book.getStatus()}" class="form-control" placeholder="Status" >
                    </div>
                    <div class="form-group">
                        <label class="control-label">Situation</label>
                        <input type="text" name="situation" id = "${book.getSituation()}" value="${book.getSituation()}" class="form-control" placeholder="Situation" >
                    </div>
                    <div class="form-group">
                        <button type="submit" id="save" class="btn btn-success" style="width: 120px">Save</button>
                        <button type="submit" id="close" class="btn btn-primary" style="width: 120px">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
