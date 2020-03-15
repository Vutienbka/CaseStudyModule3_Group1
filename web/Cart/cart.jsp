<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body style="background: gray">
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Giỏ Hàng :</h2></caption>
        <tr>
            <th>Ảnh</th>
            <th>Tên Sách</th>
            <th>Thể Loại</th>

        </tr>
        <c:forEach var="cart" items="${listCart}">
            <tr>
                <td> <img class="card-img-top" src="${cart.img}"
                          alt=""></td>
                <td><c:out value="${cart.nameBook}"/></td>
                <td><c:out value="${cart.imageType}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>