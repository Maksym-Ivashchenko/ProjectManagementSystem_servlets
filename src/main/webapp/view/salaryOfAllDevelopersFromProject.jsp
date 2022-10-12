<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/salary">
            <label for="name">Project name: </label><br>
            <input type="text" id="projectName" name="projectName"><br>
            <button type="submit">Get</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty salary}">
                    <tr>
                        <th>Salary:</th>
                    </tr>
                </c:if>
                <c:if test="${empty salary}">
                    <p>The project don't has developers yet.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${salary}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>