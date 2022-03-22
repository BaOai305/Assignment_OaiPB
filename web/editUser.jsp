<%-- 
    Document   : editUser
    Created on : Mar 22, 2022, 11:22:47 AM
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
        table.center {
            margin-top: 20%; 
            margin-left: auto; 
            margin-right: auto;
        }
    </style>
    <body>
        <form action="editUser" method="POST" >
            <table class="center">
                <tr>
                    <th>Id:</th>
                    <td>${requestScope.user.userID}
                        <input type="hidden" name="userId" value="${requestScope.user.userID}" />
                        <input type="hidden" name="userRole" value="${requestScope.user.roleID}" />
                    </td>
                </tr>
                <tr>
                    <th>Tên sinh viên:</th>
                    <td>
                        <input type="text" name="userName" value="${requestScope.user.fullName}" />
                    </td>
                </tr>
                <tr>
                    <th>Mật khẩu:</th>
                    <td>
                        <input type="text" name="userPass" value="${requestScope.user.password}" />
                    </td>
                </tr>
                <tr>
                    <th>Địa chỉ:</th>
                    <td>
                        <input type="text" name="userAdres" value="${requestScope.user.address}" />
                    </td>
                </tr>
                <tr>
                    <th>Ngày sinh:</th>
                    <td>
                        <input type="date" name="userBirh" value="${requestScope.user.birthday}" />
                    </td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td>
                        <input type="text" name="userPhone" value="${requestScope.user.phone}" />
                    </td>
                </tr>
                <tr>
                    <th>Mail:</th>
                    <td>
                        <input type="text" name="userMail" value="${requestScope.user.mail}" />
                    </td>
                </tr>
            </table>
            <input style="margin-left: 50%;
                   margin-right: 50%;" type="submit" value="Save" class="center"/>
        </form>    
    </body>
</html>
