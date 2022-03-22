<%-- 
    Document   : adminStudent
    Created on : Mar 22, 2022, 11:15:39 AM
    Author     : Phamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <th>Sinh viên</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th>Mail</th>
                <th>Sửa</th>
                <th>Xóa</th>
            </tr>
            <c:forEach items="${requestScope.stuList}" var="stu">
                <tr>
                    <td>${stu.getFullName()}</td>
                    <td>${stu.getAddress()}</td>
                    <td>${stu.getPhone()}</td>
                    <td>${stu.getMail()}</td>
                    <td>
                        <a href="./editUser?userId=${stu.getUserID()}">Sửa</a>
                    </td>
                    <td>
                        <a href="./deleteUser?userId=${stu.getUserID()}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
