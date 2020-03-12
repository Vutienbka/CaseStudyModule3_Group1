<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Au Register Forms by Colorlib</title>

    <!-- Icons font CSS-->
    <link href="<c:url value='registration/vendor/mdi-font/css/material-design-iconic-font.min.css'/>" rel="stylesheet"
          media="all">
    <link href="<c:url value='registration/vendor/font-awesome-4.7/css/font-awesome.min.css'/>" rel="stylesheet"
          media="all">
    <!-- Font special for pages-->
    <link href="<c:url value=' https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i'/>"
          rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="<c:url value='registration/vendor/select2/select2.min.css'/>" rel="stylesheet" media="all">
    <link href="<c:url value='registration/vendor/datepicker/daterangepicker.css'/>" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="<c:url value='registration/css/main.css'/>" rel="stylesheet" media="all">
</head>

<body>
<div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
    <div class="wrapper wrapper--w680">
        <div class="card card-1">
            <div class="card-heading"></div>
            <div class="card-body">
                <h2 class="title">Registration Info</h2>
                <form method="POST">
                    <div class="input-group">
                        <input class="input--style-1" type="text" placeholder="readerName" name="readerName">
                    </div>
                    <div class="input-group">
                        <input class="input--style-1" type="text" placeholder="identificationId" name="identificationId">
                    </div>
                    <div class="input-group">
                        <input class="input--style-1" type="text" placeholder="dateOfBirth" name="dateOfBirth">
                    </div>
                    <div class="input-group">
                        <input class="input--style-1" type="text" placeholder="address" name="address">
                    </div>
                    <div class="row row-space">
                        <div class="col-2">
                            <div class="input-group">
                                <input class="input--style-1" type="text" placeholder="occupation" name="occupation">
                            </div>
                        </div>
                        <div class="col-2">
                            <div class="input-group">
                                <input class="input--style-1" type="text" placeholder="email" name="email">
                            </div>
                        </div>
                    </div>

                    <div class="p-t-20">
                        <button class="btn btn--radius btn--green" type="submit">Submit</button>
                    </div>
                    <a class="text-primary" href="/users?action=listReader">List Reader</a>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Jquery JS-->
<script src="<c:url value='registration/vendor/jquery/jquery.min.js'/>"></script>
<!-- Vendor JS-->
<script src="<c:url value='registration/vendor/select2/select2.min.js'/>"></script>
<script src="<c:url value='registration/vendor/datepicker/moment.min.js'/>"></script>
<script src="<c:url value='registration/vendor/datepicker/daterangepicker.js'/>"></script>

<!-- Main JS-->
<script src="<c:url value='registration/js/global.js'/>"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
