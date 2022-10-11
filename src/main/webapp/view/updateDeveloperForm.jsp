<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/update">
            <label for="name">Developer ID: </label><br>
            <input type="text" id="developerId" name="developerId"><br>
            <label for="name">Developer name: </label><br>
            <input type="text" id="developerName" name="developerName"><br>
            <label for="name">Age: </label><br>
            <input type="text" id="age" name="age"><br>
            <label for="name">Gender: </label><br>
            <input type="text" id="gender" name="gender"><br>
            <label for="name">Different: </label><br>
            <input type="text" id="different" name="different"><br>
            <label for="name">Salary: </label><br>
            <input type="text" id="salary" name="salary"><br>
            <button type="submit">Update</button>
        </form>
    </body>
</html>