<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/update">
            <label for="id">Customer id: </label><br>
            <input type="text" id="customerId" name="customerId">
            <button type="submit">Delete</button>
        </form><br>
    </body>
</html>