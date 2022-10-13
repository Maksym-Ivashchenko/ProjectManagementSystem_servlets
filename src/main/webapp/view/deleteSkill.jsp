<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/update">
            <label for="id">Skill id: </label><br>
            <input type="text" id="skillId" name="skillId">
            <button type="submit">Delete</button>
        </form><br>
        <c:out value="Skill deleted."/>
    </body>
</html>