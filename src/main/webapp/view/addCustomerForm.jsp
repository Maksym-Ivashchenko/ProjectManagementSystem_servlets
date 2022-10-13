<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
         <form action="/customers" method="post">
            <label for="name">Customer name: </label><br>
            <input type="text" id="customerName" name="customerName"><br>
            <label for="name">Country: </label><br>
            <input type="text" id="country" name="country"><br>
            <label for="name">E-mail: </label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>