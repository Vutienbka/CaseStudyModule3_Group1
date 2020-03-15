<%@ page import="java.awt.*" %>
<%@ page import="LibraryManagament.UserService.UserServiceImp" %>
<%@ page import="LibraryManagament.Model.Img" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en"><head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Small Business - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='view/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='view/css/small-business.css'/>" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/users?action=customer">Library Online</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-center" id="navogation">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link text-uppercase text-white dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Thể Loại
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/users?action=affection">Tình Cảm</a>
                        <a class="dropdown-item" href="/users?action=econome">Kinh Tế</a>
                        <a class="dropdown-item" href="/users?action=history"> Lịch Sử </a>
                    </div>
                </li>
                <!--        <li class="nav-item">-->
                <!--          <a class="nav-link text-uppercase text-white" href="about.html">About</a>-->
                <!--        </li>-->
                <!--        <li class="nav-item">-->
                <!--          <a class="nav-link text-uppercase text-white" href="blog.html">Blog</a>-->
                <!--        </li>-->
                <li class="nav-item">
                    <a class="nav-link text-uppercase text-white" href="/users?action=registration">Đăng kí thành viên</a>
                </li>
            </ul>
            <form class="form-inline position-relative ml-lg-4">
                <input class="form-control px-0 w-100" type="search" placeholder="Search">
                <button class="search-icon" type="submit"><i class="ti-search text-dark"></i></button>
            </form>
        </div>
    </div>
</nav>

<!-- Page Content -->


<div style="margin-top: 20px">
<center>
    <h1>List Reader</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Ảnh</th>
            <th>Tên Sách</th>
            <th>Thể Loại</th>

        </tr>
        <%
            UserServiceImp userServiceImp = new UserServiceImp();
            Img img = userServiceImp.selectImg(Integer.parseInt(request.getParameter("imageId")));
        %>
            <tr>
                <td><c:out value="<%=img.getImg()%>"/></td>
                <td><c:out value="<%=img.getNameBook()%>"/></td>
                <td><c:out value="<%=img.getImageType()%>"/></td>
            </tr>

    </table>
</div>
</div>



<!-- Bootstrap core JavaScript -->
<script src="<c:url value='view/vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='view/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>




</body></html>
