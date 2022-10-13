<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/developers/update" method="post">
            <label for="name">Developer ID: </label><br>
            <input type="text" id="developerId" name="developerId"><br>
            <label for="name">Developer name: </label><br>
            <input type="text" id="developerName" name="developerName"><br>
            <label for="name">Age: </label><br>
            <input type="text" id="age" name="age"><br>
            <label for="name">Gender: </label><br>
            <input type="text" id="gender" name="gender"><br>
            <label for="name">Different: </label><br>
            <input type="text" id="different" name="different"><br>
            <label for="name">Salary: </label><br>
            <input type="text" id="salary" name="salary"><br>
            <button type="submit">Update</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty updatedDeveloper}">
                    <tr>
                        <th>Developer ID:</th>
                        <th>Developer name:</th>
                        <th>Age:</th>
                        <th>Gender:</th>
                        <th>Different:</th>
                        <th>Salary:</th>
                    </tr>
                </c:if>
                <c:if test="${empty updatedDeveloper}">
                    <p>Developer not updated. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${updatedDeveloper.id}"/>
                    </td>
                    <td>
                        <c:out value="${updatedDeveloper.developerName}"/>
                    </td>
                    <td>
                        <c:out value="${updatedDeveloper.age}"/>
                    </td>
                    <td>
                        <c:out value="${updatedDeveloper.gender}"/>
                    </td>
                    <td>
                        <c:out value="${updatedDeveloper.different}"/>
                    </td>
                    <td>
                        <c:out value="${updatedDeveloper.salary}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>