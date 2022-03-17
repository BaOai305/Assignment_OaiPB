<%-- 
    Document   : index
    Created on : Mar 14, 2022, 6:49:05 PM
    Author     : Admin
--%>

<%@page import="dal.ProductDBContext"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="/css/site.css" rel="stylesheet" type="text/css"/>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sản Phẩm Đang Bán</h1>
        <h2 ><a href="AddnewProduct.jsp">Thêm sản phẩm mới</a></h2>
        <div class="container"> 
                <div class="row">
            <%
                
                int userId = Integer.parseInt(session.getAttribute("currentUserID").toString());
                
                ProductDBContext dbPro = new ProductDBContext();
                ArrayList<Product> arrayList = dbPro.getAllProductPost(userId);
                
              for (Product product : arrayList) {
                      %>
                      <div class="col-sm-4 p-2">
                          <img src="<%=product.getImage()%>" width="60%"/></br>  
                          Tên : <%=product.getProductName()%></br>
                          Nhà Hàng : <%=product.getUser_post()%></br>
                          Giá : <%=product.getPrice()%></br>
                          Quantity : <input type="number" class="form-control" name="quantity" style="width: 80px"/></br>
                          <button type="submit" class="btn btn-sm btn-info">Add To Cart</button>
                      </div>
                        
            <%
                  }
            %>
            
        </div>
        </div>
    
    </body>
</html>
