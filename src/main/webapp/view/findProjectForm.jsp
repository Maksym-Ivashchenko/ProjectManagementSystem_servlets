<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects">
            <label for="id">Project id:</label><br>
            <input type="text" id="projectId" name="projectId">
            <button type="submit">Find</button>
        </form>
    </body>
</html>