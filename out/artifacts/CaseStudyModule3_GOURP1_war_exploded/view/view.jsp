<%@ page import="java.awt.*" %>
<%@ page import="LibraryManagament.UserService.UserServiceImp" %>
<%@ page import="LibraryManagament.Model.Img" %>
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
                <li class="nav-item">
                    <a class="nav-link text-uppercase text-white" href="/users?action=cart">Giỏ Hàng</a>
                </li>
            </ul>
            <form class="form-inline position-relative ml-lg-4">
                <input class="form-control px-0 w-100" type="search" placeholder="Search" name="find">
                <%--                <button class="search-icon" type="submit" href="/users?action=find"><i class="ti-search text-dark"></i></button>--%>
                <a href="/users?action=find" class="search-icon">ser</a>
            </form>
        </div>
    </div>
</nav>

<!-- Page Content -->

<div class="container">
    <!-- Heading Row -->
    <%
        UserServiceImp userServiceImp = new UserServiceImp();
        Img img = userServiceImp.selectImg(Integer.parseInt(request.getParameter("imageId")));
    %>
    <div class="row align-items-center my-5">
        <div class="col-lg-7">
            <img class="img-fluid rounded mb-4 mb-lg-0" alt="" src="<%=img.getImg()%>">
        </div>
        <!-- /.col-lg-8 -->
        <div class="col-lg-5">
            <h1 class="font-weight-light"><%=img.getNameBook()%></h1>
            <p>Thể Loại : <%=img.getImageType()%></p>
<%--            <a class="btn btn-primary" href="/users?action=oder">Mượn Sách</a>--%>
            <a href="/users?action=oder&imageId=<%=img.getImageId()%>" class="btn btn-primary">Mượn Sách</a>
<%--            <input type="submit" name="action" href="/users?action=oder&imageId=${img.imageId}" value="Add to cart">--%>
        </div>
        <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->

    <!-- Call to Action Well -->
    <div class="card text-white bg-secondary my-5 py-4 text-center">
        <div class="card-body">
            <p class="text-white m-0">This call to action card is a great place to showcase some important information or display a clever tagline!</p>
        </div>
    </div>

    <!-- Content Row -->

    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright © Tùng Lâm</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="<c:url value='view/vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='view/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>




</body></html>
