<%-- 
    Document   : home
    Created on : Mar 7, 2022, 1:34:28 PM
    Author     : Phamb
--%>

<%@page import="dal.UserDBContext"%>
<%@page import="dal.ProductDBContext"%>
<%@page import="dal.OrderDetailDBContext"%>
<%@page import="dal.OrderDBContext"%>
<%@page import="dal.CategoryDBContext"%>
<%@page import="model.OrderDetail"%>
<%@page import="model.Order"%>
<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>
            FoodHL</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link href="/css/site.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <%
            ProductDBContext dbPro = new ProductDBContext();
            ArrayList<Product> products = dbPro.getProducts();

//            ArrayList<Product> products = dal.ProductDBContext.getAllProduct();
            CategoryDBContext dbCate = new CategoryDBContext();
            ArrayList<Category> categorys = dbCate.getCategorys();
            String currentUserID = "";
            try {
                currentUserID = session.getAttribute("currentUserID").toString();
            } catch (Exception e) {
            }
            User currentUser = new User();
            if (!currentUserID.isEmpty()) {
                
                UserDBContext dbUser = new UserDBContext();
                currentUser = dbUser.getUserByID(Integer.parseInt(currentUserID));
                
//                currentUser = dal.UserDBContext.getUserByID(Integer.parseInt(currentUserID));
            }

            OrderDBContext dbOrder = new OrderDBContext();
            int cartID = dbOrder.getOrderIDByUserID(currentUser.getUserID());

//            int cartID = dal.OrderDBContext.getOrderIDByUserID(currentUser.getUserID());
            OrderDetailDBContext dbOrderDetail = new OrderDetailDBContext();
            ArrayList<OrderDetail> cartDetail = dbOrderDetail.getOrderDetailByOrderID(cartID);

//            ArrayList<OrderDetail> cartDetail = dal.OrderDetailDBContext.getOrderDetailByOrderID(cartID);
            float totalPrice = 0;
        %>

    </head>
    <body>
        <section class="shoping-cart spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__table">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th class="shoping__product">Products</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th></th>
                                    </tr>
                                </thead>

                                <tbody>

                                    <%
                                        for (OrderDetail detail : cartDetail) {

                                            int productId = detail.getProductID();
                                            Product p = dbPro.getProductByID(productId);

                                    %>
                                <form action="updateCartServlet" method="POST">
                                    <tr>
                                        <td class="shoping__cart__item">
                                            <img src="<%= p.getImage()%>" alt="" style="width: 100px; height: 100px">
                                            <h5><%= p.getProductName()%></h5>
                                        </td>
                                        <td class="shoping__cart__price">
                                            $<%= p.getPrice()%>
                                        </td>
                                        <td class="shoping__cart__quantity">
                                            <div class="quantity">

                                                <div class="pro-qty">

                                                    <input type="text" name="quantity" value="<%= detail.getQuantity()%>">
                                                </div>
                                        </td>
                                        <td class="shoping__cart__total">
                                            $<%= p.getPrice() * detail.getQuantity()%>
                                            <%
                                                totalPrice += p.getPrice() * detail.getQuantity();
                                            %>
                                        </td>
                                        <td class="shoping__cart__item__close">
                                            <a class="btn btn-danger" href="./deleteFromCartServlet?detailID=<%=detail.getDetailID()%>"><span class="icon_close"></span>Delete</a>
                                        </td>
                                        <td class="shoping__cart__item__close">
                                            <input style="display: none" type="text" name="detailID" value="<%= detail.getDetailID()%>">
                                            <button type="submit" class="btn" style="padding-bottom: 13px">update</button>
                                        </td>
                                    </tr>
                                </form>
                                <%

                                    }
                                %>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="shoping__cart__btns">
                            <a style="display: none" href="" class="primary-btn cart-btn">UPDATE QUANTITY</a>
                            <a href="./clearCartServlet?orderID=<%= cartID%>" class="primary-btn cart-btn cart-btn-right">CLEAR CART</a>
                        </div>
                    </div>
                    <div class="col-lg-6">

                    </div>
                    <div class="col-lg-6">
                        <div class="shoping__checkout">
                            <h5>Cart Total</h5>
                            <ul>
                                <li>Subtotal <span>$<%= totalPrice%></span></li>
                                <li>Total <span>$<%= totalPrice%></span></li>
                            </ul>
                            <a href="./checkOutServlet?orderID=<%= cartID%>&totalPrice=<%= totalPrice%>" class="primary-btn">CHECK OUT</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </body>
</html>
