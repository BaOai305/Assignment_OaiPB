<%-- 
    Document   : adminProduct
    Created on : Mar 22, 2022, 11:08:11 AM
    Author     : Phamb
--%>

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
        <jsp:include page="headerAdmin.jsp" />
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
