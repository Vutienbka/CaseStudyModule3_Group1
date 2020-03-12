<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Readers</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Reader
                </h2>
            </caption>
            <c:if test="${reader != null}">
                <input type="hidden" name="readerId" value="<c:out value='${reader.readerId}' />"/>
            </c:if>
            <tr>
                <th>readerName:</th>
                <td>
                    <input type="text" name="readerName" size="45"
                           value="<c:out value='${reader.readerName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>identificationId:</th>
                <td>
                    <input type="text" name="identificationId" size="45"
                           value="<c:out value='${reader.identificationId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>dateOfBirth:</th>
                <td>
                    <input type="text" name="dateOfBirth" size="45"
                           value="<c:out value='${reader.dateOfBirth}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${reader.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>occupation:</th>
                <td>
                    <input type="text" name="occupation" size="45"
                           value="<c:out value='${reader.occupation}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${reader.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>