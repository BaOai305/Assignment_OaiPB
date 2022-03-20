<%@page import="dal.CategoryDBContext"%>
<%@page import="model.Category"%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="/css/site.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>HL Food</title>

    </head>
    <body class="sb-nav-fixed">
        <div id="layoutSidenav">
            <main>
                <h1>Add New</h1>
                <div class="container-fluid px-4">
                    <form action="addProduct" method="post">

                        <div class="form-row">
                            <div class="form-group">
                                <label for="inputEmail4">Product Name</label>
                                <input name="name" type="text" class="form-control" id="inputEmail4">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputAddress">Image</label>
                            <input name="img" type="text" class="form-control" id="inputAddress">
                        </div>
                        <div class="form-group">
                            <label for="inputAddress2">Price</label>
                            <input name="price" type="text" class="form-control" id="inpu2">
                        </div>
                        <div class="form-group">
                            <label for="inputAddress2">quantity</label>
                            <input name="quantity" type="number" class="form-control" id="inputAddress2" >
                            <label for="inputAddress2">Category</label>
                            <select class="form-control" name="cate">
                                <c:forEach items="${requestScope.cateList}" var="cate" >
                                    <option value="${cate.getCategoryID()}">${cate.getCategoryName()}</option>
                                </c:forEach>
                            </select>
                            <label for="inputAddress2">usingDate</label>
                            <input name="usingDate" type="number" class="form-control" id="inputAddress2" >
                        </div>
                        <button name="Add" value="add" type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </main>

        </div>
    </div>

</body>
</html>
