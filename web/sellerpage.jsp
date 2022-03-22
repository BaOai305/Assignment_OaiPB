<%-- 
    Document   : sellerpage
    Created on : Mar 14, 2022, 6:49:05 PM
    Author     : Admin
--%>

<%@page import="model.Product2"%>
<%@page import="dal.ProductDBContext2"%>
<%@page import="dal.ProductDBContext"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/css/site.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Người bán</title>
        <script>
            function deletePro(proId)
            {
                var result = confirm("Bạn có chắn chắn muốn xóa sản phẩm này?");
                if (result)
                {
                    window.location.href = "deletePro?proId=" + proId;
                }
            }
        </script>
    </head>
    <body>
        <h1>Sản Phẩm Đang Bán</h1>
        <div class="container"> 
            <div class="row">
                <c:forEach items="${requestScope.proList}" var="pro" >
                    <div class="col-sm-4 p-2">
                        <img src="${pro.getImage()}" width="60%"/><br>  
                        Tên: ${pro.getProductName()}<br>
                        Giá bán: ${pro.getPrice()}<br>
                        Số lượng còn lại : ${pro.getQuantity()}<br>
                        <a href="editPro?proId=${pro.getProductID()}" >Sửa</a>
                        <a href="#" onclick="deletePro(${pro.getProductID()});" >Xóa</a><br>
                    </div>
                </c:forEach>
            </div>
        </div>
        <a href="addProduct">Thêm sản phẩm mới</a>
    </body>
</html>
