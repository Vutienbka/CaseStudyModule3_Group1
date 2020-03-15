<%@ page import="LibraryManagament.UserService.UserServiceImp" %>
<%@ page import="LibraryManagament.Model.Img" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 08/03/2020
  Time: 01:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Heroic Features - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='user/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" media="all">

    <!-- Custom styles for this template -->
    <link href="<c:url value='user/css/heroic-features.css'/>" rel="stylesheet" type="text/css" media="all">
    <link rel=" stylesheet" href=" <c:url value='user/Style.css'/>" type="text/css" media="all">

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
<!-- Page Features -->

<div class="container">
    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">

        <h5 class="display-5" style="color: #1c7430">Should copy, should not be commercialized</h5></header>

    <div class="row text-center">
        <c:forEach var="image" items="${listImageHistory}">
            <div class="col-lg-3 col-md-6 mb-4">

                <div class="card h-100">
                    <img class="card-img-top" src="${image.img}"
                         alt="">
                    <div class="card-body">
                        <h5 class="card-title">${image.nameBook}</h5>
                    </div>
                    <div class="card-footer">
                        <p class="card-title">Thể Loại : ${image.imageType}</p>
                    </div>

                    <div class="card-footer">
                        <a href="/users?action=view&imageId=${image.imageId}" class="btn btn-primary">View</a>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright © Tùng Lâm </p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="<c:url value=' user/vendor/jquery/jquery.min.js'/>" type="text/javascript"></script>
<script src="<c:url value=' user/vendor/bootstrap/js/bootstrap.bundle.min.js'/>" type="text/javascript"></script>


</body>
</html>
