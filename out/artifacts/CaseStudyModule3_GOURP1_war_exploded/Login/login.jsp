<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login V16</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
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
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/animsition.css">
    <link rel="stylesheet" href="css/select2.css">
    <link rel="stylesheet" href="css/daterangepicker.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/util.css">
    <link rel="stylesheet" href="css/Style.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Library Login
				</span>
            <div class="text-center text-primary font-weight-bold font-italic text-uppercase">
                <h2>
                    <a href="${pageContext.request.contextPath}/users?action=customer">Custormer</a>
                </h2>
            </div>
            <form class="login100-form validate-form p-b-33 p-t-5">

                <div class="wrap-input100 validate-input" data-validate="Enter username">
                    <input class="input100" type="text" name="username" placeholder="User name">
                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <input class="input100" type="password" name="pass" placeholder="Password">
                    <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                </div>

                <div class="container-login100-form-btn m-t-32">
                    <button class="login100-form-btn">
                        Login
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<script src="Login/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="Login/vendor/animsition/js/animsition.js"></script>
<script src="Login/vendor/bootstrap/js/bootstrap.js"></script>
<script src="Login/vendor/bootstrap/js/popper.js"></script>
<script src="Login/vendor/select2/select2.js"></script>
<script src="Login/vendor/daterangepicker/daterangepicker.js"></script>
<script src="Login/vendor/daterangepicker/moment.js"></script>
<script src="Login/vendor/countdowntime/countdowntime.js"></script>
<script src="Login/js/main.js"></script>

</body>
</html>
