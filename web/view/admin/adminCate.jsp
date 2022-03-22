<%-- 
    Document   : adminCate
    Created on : Mar 22, 2022, 8:11:45 PM
    Author     : Phamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/css/site.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
    <body>
        <jsp:include page="headerAdmin.jsp" ></jsp:include>
            <table style="width: 50%">
                <tr>
                    <th  class="text-right">Category Id</th>
                    <th  class="text-center">Category Name</th>
                    <th >
                        <a class="nav-link" href="./addCate" class="btn btn-sm btn-info">Add new cate</a>
                    </th>
                </tr>
            <c:forEach items="${requestScope.cateList}" var="cate" >
                <tr>
                    <td  class="text-right">${cate.getCategoryID()}</td>
                    <td  class="text-center">${cate.getCategoryName()}</td>
                    <td>
                        <a href="./deleteCate?cateId=${cate.getCategoryID()}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
