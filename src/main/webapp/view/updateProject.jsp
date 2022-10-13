<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/projects/update" method="post">
            <label for="name">Project ID: </label><br>
            <input type="text" id="projectId" name="projectId"><br>
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
            <button type="submit">Update</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty updatedProject}">
                    <tr>
                        <th>Project ID:</th>
                        <th>Project name:</th>
                        <th>Project type:</th>
                        <th>Comments:</th>
                        <th>Cost:</th>
                        <th>Date created:</th>
                    </tr>
                </c:if>
                <c:if test="${empty updatedProject}">
                    <p>Project not updated. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${updatedProject.id}"/>
                    </td>
                    <td>
                        <c:out value="${updatedProject.projectName}"/>
                    </td>
                    <td>
                        <c:out value="${updatedProject.projectType}"/>
                    </td>
                    <td>
                        <c:out value="${updatedProject.comments}"/>
                    </td>
                    <td>
                        <c:out value="${updatedProject.cost}"/>
                    </td>
                    <td>
                        <c:out value="${updatedProject.dateCreated}"/>
                    </td>
                </tr>
                <c:out value="Project updated."/>
            </tbody>
        </table>
    </body>
</html>