<%-- 
    Document   : addNewCate
    Created on : Mar 22, 2022, 8:33:52 PM
    Author     : Phamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form action="addCate" method="POST" >
            <table class="center">
                <tr>
                    <th>Tên phân loại:</th>
                    <td>
                        <input type="text" name="cateName"/>
                    </td>
                </tr>
            </table>
            <input style="margin-left: 50%;
                   margin-right: 50%;" type="submit" value="Save" class="center"/>
        </form>
    </body>
</html>
