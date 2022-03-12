<%-- 
    Document   : register
    Created on : Mar 12, 2022, 10:03:45 PM
    Author     : Phamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register an account</title>
    </head>
    <body>
        <style>
            table, td, th {
                border: 1px solid;
                border-collapse: collapse;
            }
        </style>
        <form action="register" method="POST" >
            <table>
                <tr>
                    <th>  
                        <label for="typeOfUser">Bạn là:</label>
                    </th>
                    <th>
                        <select name="typeOfUser" id="typeOfUser">
                            <option value="student">Sinh Viên</option>
                            <option value="seller">Nhà bán hàng</option>
                        </select>
                    </th>
                </tr>
                <tr>
                    <th>Họ và Tên:</th>
                    <th>
                        <input type="text" name="name" />
                    </th>
                </tr>
                <tr>
                    <th>Mật khẩu:</th>
                    <th>
                        <input type="password" name="password"/>
                    </th>
                </tr>
                <tr>
                    <th>Nhập lại mật khẩu:</th>
                    <th>
                        <input type="password" name="password_confirm"/>
                    </th>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <th>
                        <input type="number" name="phonenumber"/>
                    </th>
                </tr>
                <tr>
                    <th>Địa chỉ:</th>
                    <th>
                        <input type="text" name="address1"/>
                    </th>
                </tr>
                <tr>
                    <th></th>
                    <th>
                        <input type="submit" value="register"/>
                    </th>
                </tr>
            </table>
        </form>
    </body>
</html>
