<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers">
            <label for="name">Customer ID: </label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <button type="submit">Find</button>
        </form>
    </body>
</html>