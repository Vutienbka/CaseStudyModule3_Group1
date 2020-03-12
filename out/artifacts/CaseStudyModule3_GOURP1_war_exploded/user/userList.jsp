<%@ page import="LibraryManagement.Service.UserServiceImp" %>
<%@ page import="LibraryManagement.Model.Img" %>
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
    <link href="user/vendor/bootstrap/css/bootstrap.min.css'>" rel="stylesheet" type="text/css" media="all">

    <!-- Custom styles for this template -->
    <link href="user/css/heroic-features.css" rel="stylesheet" type="text/css" media="all">
    <link rel=" stylesheet" href="user/Style.css>" type="text/css" media="all">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Library Online</a>
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
                        <a class="dropdown-item" href="index.html">Tâm lý - Tình Cảm</a>
                        <a class="dropdown-item" href="homepage-2.html">Kinh dị</a>
                        <a class="dropdown-item" href="index.html"> Văn học </a>
                        <a class="dropdown-item" href="homepage-2.html">Khoa học tự nhiên</a>
                        <a class="dropdown-item" href="homepage-2.html">Ngụ Ngôn</a>
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
<!-- Page Features -->

<div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">


        <h5 class="display-5" style="color: #1c7430">Should copy, should not be commercialized</h5></header>


    <div class="row text-center">

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/muon-ca-the-gioi-biet-anh-yeu-em.jpg"
                     alt="">
                <div class="card-body">
                    <h4 class="card-title">Muốn Cả Thế Giới Biết Anh Yêu Em</h4>

                </div>
                <div class="card-footer">
                    <a href="/view/view1.jsp" data-wpel-link="internal">View</a>
<%--                    <a href="view/view1.jsp" class="btn btn-primary">View</a>--%>

                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top"
                     src="https://sachvui.com/cover2/2019/vu-khi-khieu-goi-muon-ca-the-gioi-biet-anh-yeu-em.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Vũ Khí Khiêu Gợi: Muốn Cả Thế Giới Biết Anh Yêu Em</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2018/chao-buoi-sang-ong-xa-cool-ngau-full.jpg"
                     alt="">
                <div class="card-body">
                    <h4 class="card-title">Chào Buổi Sáng: Ông Xã Cool Ngầu </h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/xem-em-thu-phuc-anh-nhu-the-nao.jpg"
                     alt="">
                <div class="card-body">
                    <h4 class="card-title">Xem Em Thu Phục Anh Như Thế Nào</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view&Id" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

<%--    </div>--%>
<%--    <div class="row text-center">--%>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2018/xin-chao-nguoi-thua-ke.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Xin Chào, Người Thừa Kế</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2018/nang-dau-cuc-pham.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Nàng Dâu Cực Phẩm</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top"
                     src="https://sachvui.com/cover2/2019/choc-vao-hao-mon-cha-dung-dung-vao-me-con.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Chọc Vào Hào Môn: Cha Đừng Đụng Vào Mẹ Con</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/chi-muon-cung-em-chinh-la-tot-nhat.jpg"
                     alt="">
                <div class="card-body">
                    <h4 class="card-title">Chỉ Muốn Cùng Em, Chính Là Tốt Nhất</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

    </div>

    <div class="row text-center">

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/muon-em-the-nao-cung-khong-du.jpg"
                     alt="">
                <div class="card-body">
                    <h4 class="card-title">Muốn Em Thế Nào Cũng Không Đủ</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/mua-vo.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Mua Vợ</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2018/boss-hung-du-ong-xa-ket-hon-di.jpg"
                     alt="">
                <div class="card-body">
                    <h4 class="card-title">Boss Hung Dữ - Ông Xã Kết Hôn Đi</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/ep-kho-nam-phu.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Ép Khô Nam Phụ</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

    </div>

    <div class="row text-center">

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/boss-tro-thanh-chong.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Boss Trở Thành Chồng</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/ga-cho-cha-cua-nam-chinh.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Gả Cho Cha Của Nam Chính</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2019/sung-yeu-bi-mat-cua-ba-xa.jpg" alt="">
                <div class="card-body">
                    <h4 class="card-title">Sủng Yêu: Bí Mật Của Bà Xã</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="https://sachvui.com/cover2/2018/choc-tuc-vo-yeu-mua-mot-tang-mot.jpg"
                     alt="">
                <div class="card-body">
                    <h4 class="card-title">Chọc Tức Vợ Yêu - Mua Một Tặng Một</h4>

                </div>
                <div class="card-footer">
                    <a href="/users?action=view" class="btn btn-primary">View</a>
                </div>
            </div>
        </div>

    </div>
    <!-- /.row -->

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
