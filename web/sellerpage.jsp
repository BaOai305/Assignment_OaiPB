<%-- 
    Document   : sellerpage
    Created on : Mar 14, 2022, 6:49:05 PM
    Author     : Admin
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
        <jsp:include page="view/seller/headerSeller.jsp" ></jsp:include>
        <div class="row">
            <div class="col-12">
                <table class="table table-borderless">
                    <thead>
                        <tr>
                            <th scope="col">Ảnh</th>
                            <th scope="col">Chi tiết</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Thêm vào giỏ hàng</th>
                        </tr>
                    </thead>
                    <tbody>
                    <tbody>
                    <c:forEach items="${requestScope.proList}" var="pro" >
                        <tr>
                            <th><img src="${pro.getImage()}" width="60%"/></th>
                            <td>
                                ${pro.getProductName()}<br>
                                Giá: ${pro.getPrice()}đ<br>
                                Số lượng còn lại: ${pro.getQuantity()}
                            </td>
                            <td>
                                <a href="editPro?proId=${pro.getProductID()}&key=2" >Sửa</a>                                </td>
                            <td>
                                <a href="#" onclick="deletePro(${pro.getProductID()});" >Xóa</a><br>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
