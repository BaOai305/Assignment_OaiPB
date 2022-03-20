<%-- 
    Document   : student
    Created on : Mar 20, 2022, 10:24:14 PM
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
    <body>
        <h1>Food Page</h1>
        <div class="container"> 
            <div class="row">
                <c:forEach items="${requestScope.proList}" var="pro" >
                    <div class="col-sm-4 p-2">
                        <form action="addToCart" method="POST">
                            <input name="productID" value="${pro.getProductID()}" hidden/>
                            <img src="${pro.getImage()}" width="60%"/></br>  
                            Tên : ${pro.getProductName()}</br>
                            Nhà bán : ${pro.getUser_post()}</br>
                            Giá : ${pro.getPrice()}</br>
                            Quantity : <input type="number" class="form-control" name="quantity" style="width: 80px"/></br>
                            <button type="submit" class="btn btn-sm btn-info">Add To Cart</button>
                        </form>
                    </div>
                </c:forEach> 
            </div>
        </div>

    </body>
</html>
