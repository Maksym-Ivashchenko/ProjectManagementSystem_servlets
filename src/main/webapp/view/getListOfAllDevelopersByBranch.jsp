<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/branch">
            <label for="id">Branch: </label><br>
            <input type="text" id="developerBranch" name="developerBranch">
            <button type="submit">Get</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty developers}">
                    <tr>
                        <th>ID:</th>
                        <th>Developer name:</th>
                        <th>Age:</th>
                        <th>Gender:</th>
                        <th>Different:</th>
                        <th>Salary:</th>
                    </tr>
                </c:if>
                <c:if test="${empty developers}">
                    <p>Developer not found. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <c:forEach var="developer" items="${developers}">
                    <tr>
                        <td>
                            <c:out value="${developer.id}"/>
                        </td>
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
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>