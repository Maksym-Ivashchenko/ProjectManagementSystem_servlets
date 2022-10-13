<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/update">
            <label for="id">Company id: </label><br>
            <input type="text" id="companyId" name="companyId">
            <button type="submit">Delete</button>
        </form><br>
        <c:out value="Company deleted."/>
    </body>
</html>