<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/delete">
            <label for="id"><font color="#ffffff">Skill id:</font></label><br>
            <input type="text" id="skillId" name="skillId">
            <button type="submit">Delete</button>
        </form>
    </body>
</html>