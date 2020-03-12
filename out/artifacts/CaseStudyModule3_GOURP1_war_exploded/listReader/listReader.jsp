<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body style="background: gray">
<center>
    <h1>List Reader</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>readerId</th>
            <th>readerName</th>
            <th>identificationId</th>
            <th>dateOfBirth</th>
            <th>address</th>
            <th>occupation</th>
            <th>email</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="reader" items="${listReader}">
            <tr>
                <td><c:out value="${reader.readerId}"/></td>
                <td><c:out value="${reader.readerName}"/></td>
                <td><c:out value="${reader.identificationId}"/></td>
                <td><c:out value="${reader.dateOfBirth}"/></td>
                <td><c:out value="${reader.address}"/></td>
                <td><c:out value="${reader.occupation}"/></td>
                <td><c:out value="${reader.email}"/></td>
                <td>
                    <a href="/users?action=edit&readerId=${reader.readerId}">Edit</a>
                    <a href="/users?action=delete&readerId=${reader.readerId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>