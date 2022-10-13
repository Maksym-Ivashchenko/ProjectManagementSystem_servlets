<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/update" method="post">
            <label for="name">ID: </label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="name">Company name: </label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name">City: </label><br>
            <input type="text" id="city" name="city"><br>
            <label for="name">E-mail: </label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Update</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty updatedCompany}">
                    <p>Company updated</p>
                    <tr>
                        <th>ID:</th>
                        <th>Company name:</th>
                        <th>City:</th>
                        <th>E-mail:</th>
                    </tr>
                </c:if>
                <c:if test="${empty updatedCompany}">
                    <p>Company not updated. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${updatedCompany.id}"/>
                    </td>
                    <td>
                        <c:out value="${updatedCompany.companyName}"/>
                    </td>
                    <td>
                        <c:out value="${updatedCompany.city}"/>
                    </td>
                    <td>
                        <c:out value="${updatedCompany.email}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>