<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/update">
            <label for="name">Skill ID: </label><br>
            <input type="text" id="skillId" name="skillId"><br>
            <label for="name">Branch: </label><br>
            <input type="text" id="branch" name="branch"><br>
            <label for="name">Skill level: </label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Update</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty updatedSkill}">
                    <tr>
                        <th>Skill ID:</th>
                        <th>Branch:</th>
                        <th>Skill level:</th>
                    </tr>
                </c:if>
                <c:if test="${empty updatedSkill}">
                    <p>Skill not updated. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${updatedSkill.id}"/>
                    </td>
                    <td>
                        <c:out value="${updatedSkill.branch}"/>
                    </td>
                    <td>
                        <c:out value="${updatedSkill.skillLevel}"/>
                     </td>
                </tr>
                <c:out value="Skill updated."/>
            </tbody>
        </table>
    </body>
</html>