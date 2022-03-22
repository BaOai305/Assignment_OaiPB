<%-- 
    Document   : adminSeller
    Created on : Mar 22, 2022, 9:16:28 AM
    Author     : Phamb
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
    <body>
        <jsp:include page="headerAdmin.jsp" />

        <table style="width: 100%">
            <tr>
                <th>Nhà bán</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th>Mail</th>
                <th>Sửa</th>
                <th>Xóa</th>
            </tr>
            <c:forEach items="${requestScope.selList}" var="sel">
                <tr>
                    <td>${sel.getFullName()}</td>
                    <td>${sel.getAddress()}</td>
                    <td>${sel.getPhone()}</td>
                    <td>${sel.getMail()}</td>
                    <td>
                        <a href="./editUser?userId=${sel.getUserID()}">Sửa</a>
                    </td>
                    <td>
                        <a href="./deleteUser?userId=${sel.getUserID()}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
