<%-- 
    Document   : login
    Created on : Mar 15, 2022, 12:10:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>FU Food</title>
    </head>
    <body>

        <div class="container">
            <h1 class="">FU FOOD</h1>
            <h3>Ở Đây có mọi thứ đồ ăn cho sinh viên</h3>
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQoPSHYfoASMsbeyzBDI-qdwqVUMTW9K8T8eYuYxMQrXxtV3JRjquOeizm90gSHYHQiPk&usqp=CAU"/>
            <form action="login" method="post" class="col-lg-8 float-right">

                <h2 class="float">Login</h2>
                <div class="form-group">
                    <label for="exampleInputPassword1" class="text-uppercase">Email</label>
                    <input name="Email" type="Email" class="form-control" placeholder="">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1" class="text-uppercase">Password</label>
                    <input name="password" type="password" class="form-control" placeholder="">
                </div>
                <input type="checkbox" value="remember" name="remember"/> Remember Me! <br/>
                <button type="submit" class="btn btn-info float-right form-control">Login</button>
            </form>
            <h4><a href="register">Register</a></h4>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
