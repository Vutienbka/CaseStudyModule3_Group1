<%@ page import="LibraryManagament.UserService.UserServiceImp" %>
<%@ page import="LibraryManagament.Model.Img" %>
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
        <caption><h2>Bạn đã mượn :</h2></caption>
        <tr>
            <th>readerId</th>
            <th>readerName</th>
            <th>identificationId</th>

        </tr>
        <%
            UserServiceImp userServiceImp = new UserServiceImp();
            Img img = userServiceImp.selectImg(Integer.parseInt(request.getParameter("imageId")));
            userServiceImp.insertOrder(img);
        %>
            <tr>
                <td><img class="card-img-top" src="<%=img.getImg()%>"
                         alt="">/></td>
                <td><c:out value="<%=img.getNameBook()%>"/></td>
                <td><c:out value="<%=img.getImageType()%>"/></td>

            </tr>
        <tr>
            <h1><a class="navbar-brand" href="/users?action=customer"> Tiếp tục mượn </a></h1>
        </tr>
    </table>
</div>
</body>
</html>