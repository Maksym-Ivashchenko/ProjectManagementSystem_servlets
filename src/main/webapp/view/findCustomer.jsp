<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers">
            <label for="name">Customer ID: </label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <button type="submit">Find</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty customer.id}">
                    <tr>
                        <th>Customer ID:</th>
                        <th>Customer name:</th>
                        <th>Country:</th>
                        <th>E-mail:</th>
                    </tr>
                </c:if>
                <c:if test="${empty company.id}">
                    <p>Customer not found. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${customer.id}"/>
                    </td>
                    <td>
                        <c:out value="${customer.customerName}"/>
                    </td>
                    <td>
                        <c:out value="${customer.country}"/>
                    </td>
                    <td>
                        <c:out value="${customer.email}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>