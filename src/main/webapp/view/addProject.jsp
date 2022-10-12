<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/add">
            <label for="name">Project name: </label><br>
            <input type="text" id="projectName" name="projectName"><br>
            <label for="name">Project type: </label><br>
            <input type="text" id="projectType" name="projectType"><br>
            <label for="name">Comments: </label><br>
            <input type="text" id="comments" name="comments"><br>
            <label for="name">Cost: </label><br>
            <input type="text" id="cost" name="cost"><br>
            <label for="name">Date created (by format yyyy-mm-dd): </label><br>
            <input type="text" id="dateCreated" name="dateCreated"><br>
            <button type="submit">Save</button>
        </form><br>
        <table>
            <thead>
                <tr>
                    <th>Project name:</th>
                    <th>Project type:</th>
                    <th>Comments:</th>
                    <th>Cost:</th>
                    <th>Date created:</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${savedProject.projectName}"/>
                    </td>
                    <td>
                        <c:out value="${savedProject.projectType}"/>
                    </td>
                    <td>
                        <c:out value="${savedProject.comments}"/>
                    </td>
                    <td>
                        <c:out value="${savedProject.cost}"/>
                    </td>
                    <td>
                        <c:out value="${savedProject.dateCreated}"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <c:out value="Project added."/>
    </body>
</html>