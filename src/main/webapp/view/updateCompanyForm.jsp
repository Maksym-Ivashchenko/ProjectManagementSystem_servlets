<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/update" method="post">
            <label for="name">Company ID: </label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="name">Company name: </label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name">City: </label><br>
            <input type="text" id="city" name="city"><br>
            <label for="name">E-mail: </label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Update</button>
        </form>
    </body>
</html>