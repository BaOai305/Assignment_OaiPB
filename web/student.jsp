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
        <jsp:include page="view/student/headerStudent.jsp" />
        <div class="row">
            <div class="col-6">
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
                        <c:forEach items="${requestScope.proList}" var="pro" >
                        <form  action="addToCart" method="POST">
                            <input name="productID" value="${pro.getProductID()}" hidden/>
                            <tr>
                                <th><img src="${pro.getImage()}" width="60%"/></th>
                                <td>
                                    ${pro.getProductName()}<br>
                                    ${pro.getUser_post()}<br>
                                    ${pro.getPrice()}
                                </td>
                                <td>
                                    <input type="number" class="form-control" name="quantity" style="width: 80px"/>
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-sm btn-info">Add To Cart</button>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!--        </div>-->
        <jsp:include page="view/student/cartFooter.jsp" />
    </body>
</html>
