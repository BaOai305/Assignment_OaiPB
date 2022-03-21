<%-- 
    Document   : editProduct
    Created on : Mar 21, 2022, 1:05:06 PM
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
        /*        table, th, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                }*/
        table.center {
            margin-top: 20%; 
            margin-left: auto; 
            margin-right: auto;
        }
    </style>
    <body>
        <form action="editPro" method="POST" >
            <table class="center">
                <tr>
                    <th>Id:</th>
                    <td>${requestScope.product.productID}
                        <input type="hidden" name="proId" value="${requestScope.product.productID}" />
                    </td>
                </tr>
                <tr>
                    <th>Tên sản phẩm:</th>
                    <td>
                        <input type="text" name="proName" value="${requestScope.product.productName}" />
                    </td>
                </tr>
                <tr>
                    <th>Link ảnh:</th>
                    <td>
                        <input type="text" name="proImg" value="${requestScope.product.image}" />
                    </td>
                </tr>
                <tr>
                    <th>Giá:</th>
                    <td>
                        <input type="text" name="proPrice" value="${requestScope.product.price}" />
                    </td>
                </tr>
                <tr>
                    <th>Số lượng:</th>
                    <td>
                        <input type="number" name="proQuantity" value="${requestScope.product.quantity}" />
                    </td>
                </tr>
                <tr>
                    <th>Loại sp:</th>
                    <td>
                        <select name="proCate" >
                            <c:forEach items="${requestScope.cateList}" var="cate" >
                                <option value="${cate.getCategoryID()}">${cate.getCategoryName()}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Ngày sử dụng:</th>
                    <td>
                        <input type="text" name="proUsing" value="${requestScope.product.getUsingDate()}" />
                    </td>
                </tr>
            </table>
            <input style="margin-left: 50%;
                   margin-right: 50%;" type="submit" value="Save" class="center"/>
        </form>
    </body>
</html>
