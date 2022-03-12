<%-- 
    Document   : student
    Created on : Mar 12, 2022, 9:44:53 PM
    Author     : Phamb
--%>
<%@page import="model.Product"%>
<%@page import="model.Seller"%>
<%@page import="java.util.ArrayList"%>
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
        table, td, th {
            border: 1px solid;
        }

        table {
            width: 50%;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <h2>List of product</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Seller</th>
            <th>Image</th>
            <th>Type</th>
            <th>Price</th>
        </tr>
        <c:set
            var="src_of_image" value="https://i.imgur.com/" >
        </c:set>
        <c:set
            var="end" value=".jpg" >
        </c:set>
        <c:forEach items="${requestScope.products}" var="p">
            <c:set 
                var="image" value="${src_of_image}${p.proImage}${end}" >
            </c:set>
            <tr>
                <td>${p.proName}</td>
                <td>${p.proSeller}</td>
                <td>
                    <img src="${image}"/>
                </td>
                <td>${p.proType}</td>
                <td>${p.proPrice}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
