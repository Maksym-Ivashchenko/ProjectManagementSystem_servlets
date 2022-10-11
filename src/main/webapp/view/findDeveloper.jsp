<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers">
            <label for="id">Developer id: </label><br>
            <input type="text" id="developerId" name="developerId">
            <button type="submit">Find</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty developer.id}">
                    <tr>
                        <th>Developer name:</th>
                        <th>Age:</th>
                        <th>Gender:</th>
                        <th>Different:</th>
                        <th>Salary:</th>
                    </tr>
                </c:if>
                <c:if test="${empty developer.id}">
                    <p>Developer not found. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${developer.developerName}"/>
                    </td>
                    <td>
                        <c:out value="${developer.age}"/>
                    </td>
                    <td>
                        <c:out value="${developer.gender}"/>
                    </td>
                    <td>
                        <c:out value="${developer.different}"/>
                    </td>
                    <td>
                        <c:out value="${developer.salary}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>