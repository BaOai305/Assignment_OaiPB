<%-- 
    Document   : login
    Created on : Mar 7, 2022, 4:03:46 PM
    Author     : Phamb
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký tài khoản</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

    </head>
    <body>
        <section class="vh-150" style="background-color: #508bfc;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card shadow-2-strong" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">

                                <form action="registerServlet" method="POST">
                                    <h1 class="mb-5">FU Food</h1>
                                    <h3 class="mb-5">Đăng ký tài khoản</h3>

                                    <div class="form-outline mb-4">
                                        <input required="" name="fullName" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Full name"/>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input required="" name="password" type="password" id="typePasswordX-2" class="form-control form-control-lg" placeholder="Password"/>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input required="" name="address" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Address"/>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input required="" type="date" name="birthDay" id="typeEmailX-2" class="form-control form-control-lg" placeholder="BirthDay"/>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input required="" name="phone" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Phone"/>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input required="" type="email" name="mail" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Mail"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <select class="form-control" name="role">
                                            <c:forEach items="${requestScope.roleList}" var="role" >
                                                <option value="${role.getRoleID()}">${role.getRoleName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
