<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/skills/add">
            <label for="name">Branch: </label><br>
            <input type="text" id="branch" name="branch"><br>
            <label for="name">Skill level: </label><br>
            <input type="text" id="skillLevel" name="skillLevel"><br>
            <button type="submit">Save</button>
        </form><br>
        <table>
            <thead>
                <tr>
                    <th>Branch:</th>
                    <th>Skill level:</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${savedSkill.branch}"/>
                    </td>
                    <td>
                        <c:out value="${savedSkill.skillLevel}"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <c:out value="Skill added."/>
    </body>
</html>