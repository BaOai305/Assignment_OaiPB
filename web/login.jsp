<%-- 
    Document   : login
    Created on : Mar 21, 2022, 10:29:15 PM
    Author     : Phamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>FU - Hòa Lạc Food</title>
    </head>
    <style>
        .divider:after,
        .divider:before {
            content: "";
            flex: 1;
            height: 1px;
            background: #eee;
        }
    </style>
    <body>
        <section class="vh-100">
            <div class="container py-5 h-100">
                <div class="row d-flex align-items-center justify-content-center h-100">
                    <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                        <h3>FU - Hòa Lạc</h3>
                        <h4>Ở đây có mọi thứ đồ ăn cho sinh viên</h4> <br>
                        <form action="login" method="post" class="col-lg-9 float-right">
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="exampleInputPassword1">Email address</label>
                                <input type="email" name="Email" class="form-control form-control-lg"/>
                            </div>
                            <!-- Password input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="exampleInputPassword1">Password</label>
                                <input type="password" name="password" class="form-control form-control-lg" />
                            </div>

                            <div class="d-flex justify-content-around align-items-center mb-4">
                                <!-- Checkbox -->
                                <div class="form-check">
                                    <input
                                        class="form-check-input"
                                        type="checkbox"
                                        value="remember"
                                        name="remember"
                                        />
                                    <label class="form-check-label"> Remember me </label>
                                </div>
                                <a href="./register">Register</a>
                            </div>
                            <!-- Submit button -->
                            <button type="submit" class="btn btn-info float-right form-control">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
