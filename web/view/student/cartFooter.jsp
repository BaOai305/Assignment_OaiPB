<%@page import="model.Product"%>
<%@page import="model.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dal.OrderDetailDBContext"%>
<%@page import="dal.OrderDBContext"%>
<%@page import="dal.UserDBContext"%>
<%@page import="model.User"%>
<%@page import="dal.ProductDBContext"%>
<%-- 
Document   : cartFooter
Created on : Mar 22, 2022, 4:31:11 PM
Author     : Phamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/css/site.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>JSP Page</title>
<%
    ProductDBContext dbPro = new ProductDBContext();
    String currentUserID = "";
    currentUserID = session.getAttribute("currentUserID").toString();
    User currentUser = new User();
    if (!currentUserID.isEmpty()) {
        UserDBContext dbUser = new UserDBContext();
        currentUser = dbUser.getUserByID(Integer.parseInt(currentUserID));
    }
    OrderDBContext dbOrder = new OrderDBContext();
    int cartID = dbOrder.getOrderIDByUserID(currentUser.getUserID());
    OrderDetailDBContext dbOrderDetail = new OrderDetailDBContext();
    ArrayList<OrderDetail> cartDetail = dbOrderDetail.getOrderDetailByOrderID(cartID);
    float totalPrice = 0;
%>
<!--<div class="row">-->
    <div class="col-4">
        <table class="table table-borderless">
            <thead>
                <tr>
                    <th scope="col">Products</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (OrderDetail detail : cartDetail) {
                        int productId = detail.getProductID();
                        Product p = dbPro.getProductByID(productId);
                %>                       
            <form  action="updateCart" method="POST">
                <tr>
                    <th><img src="<%= p.getImage()%>" style="width: 100px; height: 100px"/></th>
                    <td class="text-center">
                        <%= p.getProductName()%><br>
                        <%= p.getPrice()%>đ<br>
                    </td>
                    <td >
                        <input type="number" name="quantity" value="<%= detail.getQuantity()%>">
                    </td>
                    <td>
                        <%= p.getPrice() * detail.getQuantity()%>
                        <%
                            totalPrice += p.getPrice() * detail.getQuantity();
                        %>đ
                    </td>
                    <td>
                        <button type="submit" class="btn" style="padding-bottom: 13px">update</button> <br>
                        <a class="btn btn-danger" href="./deleteCart?detailID=<%=detail.getDetailID()%>"><span class="icon_close"></span>Xóa</a>
                    </td>
                </tr>
            </form>
            <%}%>
            <tr>
                <td colspan="4"> </td>
                <td>
                    <a href="./clearCart?orderID=<%= cartID%>" class="primary-btn cart-btn cart-btn-right">Xóa đơn hàng</a>
                </td>
            </tr>
            <tr>
                <td colspan="2"></td>
                <td class="text-right">
                    Tổng tiền:
                </td>
                <td>
                    <%= totalPrice%>đ
                </td>
                <td>
                    <a href="./checkOut?orderID=<%= cartID%>&totalPrice=<%= totalPrice%>" class="btn btn-sm btn-info">Thanh toán</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>    

