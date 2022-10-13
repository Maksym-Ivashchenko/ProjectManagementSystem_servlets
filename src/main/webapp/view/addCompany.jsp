<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies" method="post">
            <label for="name">Company name: </label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name">City: </label><br>
            <input type="text" id="city" name="city"><br>
            <label for="name">E-mail: </label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Save</button>
        </form><br>
        <table>
            <thead>
                <tr>
                    <th>Company name:</th>
                    <th>City:</th>
                    <th>E-mail:</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${savedCompany.companyName}"/>
                    </td>
                    <td>
                        <c:out value="${savedCompany.city}"/>
                    </td>
                    <td>
                        <c:out value="${savedCompany.email}"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <c:out value="Company added."/>
    </body>
</html>