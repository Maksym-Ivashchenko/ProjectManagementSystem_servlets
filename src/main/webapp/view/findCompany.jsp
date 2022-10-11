<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies">
            <label for="id">Company id:</label><br>
            <input type="text" id="companyId" name="companyId">
            <button type="submit">Find</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty company.id}">
                    <tr>
                        <th>Company id:</th>
                        <th>Company name:</th>
                        <th>City:</th>
                        <th>E-mail:</th>
                    </tr>
                </c:if>
                <c:if test="${empty company.id}">
                    <p>Company not found. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${company.id}"/>
                    </td>
                    <td>
                        <c:out value="${company.companyName}"/>
                    </td>
                    <td>
                        <c:out value="${company.city}"/>
                    </td>
                    <td>
                        <c:out value="${company.email}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>