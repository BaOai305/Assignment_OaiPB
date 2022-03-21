<%-- 
    Document   : AdminPage
    Created on : Mar 17, 2022, 10:53:22 AM
    Author     : Phamb
--%>

<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
        <h1>Hello ${requestScope.admin.adminEmail}</h1>
        <h2><a href="./logout">Đăng xuất</a></h2>
        <table style="width: 100%">
            <tr>
                <th>Ảnh sản phẩm </th>
                <th>Tên sản phẩm</th>
                <th>Nhà bán</th>
                <th>Giá</th>
                <th>Số lượng</th>
                <th>Sửa</th>
                <th>Xóa</th>
            </tr>
            <c:forEach items="${requestScope.proList}" var="pro" >
                <tr>
                    <td><img src="${pro.getImage()}"/></td>
                    <td>${pro.getProductName()}</td>
                    <td>${pro.getUser_post()}</td>
                    <td>${pro.getPrice()}</td>
                    <td>${pro.getQuantity()}</td>
                    <td>
                        <a href="./editPro?proId=${pro.getProductID()}">Sửa</a>
                    </td>
                    <td>
                        <a href="./deletePro?proId=${pro.getProductID()}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
