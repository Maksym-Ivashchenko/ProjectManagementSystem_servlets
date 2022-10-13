<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/update">
            <label for="id">Developer id: </label><br>
            <input type="text" id="developerId" name="developerId">
            <button type="submit">Delete</button>
        </form>
    </body>
</html>