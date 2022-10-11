<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills">
            <label for="id">Skill id: </label><br>
            <input type="text" id="skillId" name="skillId">
            <button type="submit">Find</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty skill.id}">
                    <tr>
                        <th>Skill id:</th>
                        <th>Branch:</th>
                        <th>Skill level:</th>
                    </tr>
                </c:if>
                <c:if test="${empty skill.id}">
                    <p>Skill not found. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${skill.id}"/>
                    </td>
                    <td>
                        <c:out value="${skill.branch}"/>
                    </td>
                    <td>
                        <c:out value="${skill.skillLevel}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>