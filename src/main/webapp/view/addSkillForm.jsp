<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills" method="post">
            <label for="name">Branch: </label><br>
            <input type="text" id="branch" name="branch"><br>
            <label for="name">Skill level: </label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Save</button>
        </form>
    </body>
</html>