<%--
  Created by IntelliJ IDEA.
  User: vutienbka
  Date: 3/9/20
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete book</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/src/css/bootstrap.css">
    <script src="/src/js/jquery.js"></script>
    <script src="/src/js/bootstrap.js"></script>
    <style>
        .decoration{
            margin-top: 20px;
        }
        p{
            color: white;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="container" style="background: #0099ff; width: 1040px; height: 500px; border: 1px solid #cccccc; border-radius: 15px; margin-top: 15px">
    <div class="container-fluid" style="margin: 0 auto">
    <p style="color: #00aced; font-size: 30px">
        ${message}
    </p>
    </div>

    <p style="position:relative;top: 10px;text-decoration: #00aced" >
        <a href="?action=deletePage" style="color: white">Back to delete page<< </a><br>
        <a href="book" style="color: white">Back to home page<< </a>
    </p>
    <p style="margin-left: 450px">Do you want to delete ?</p>
    <div class="decoration">
        <div class="row">
            <div class="card mb-4">
                <div class="card-header" style="font-size: 20px; font-weight: bolder"><i class="fas fa-table mr-1"></i >Books Information</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <form method="post">
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
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>${book.getBookId()}</td>
                                    <td>${book.getBookName()}</td>
                                    <td>${book.getTypeOfBook()}</td>
                                    <td>${book.getAuthor()}</td>
                                    <td>${book.getQuantity()}</td>
                                    <td>${book.getPrice()}</td>
                                    <td>${book.getLanguage()}</td>
                                    <td>${book.getStatus()}</td>
                                    <td>${book.getSituation()}"</td>
                                    <td>
                                        <button class="btn btn-primary" style="width: 120px">
                                            Delete Book
                                        </button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>