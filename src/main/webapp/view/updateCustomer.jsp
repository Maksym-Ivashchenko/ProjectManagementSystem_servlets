<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/update">
            <label for="name">Customer ID: </label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <label for="name">Customer name: </label><br>
            <input type="text" id="customerName" name="customerName"><br>
            <label for="name">Country: </label><br>
            <input type="text" id="country" name="country"><br>
            <label for="name">E-mail: </label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Update</button>
        </form><br>
        <table>
            <thead>
                <c:if test="${not empty updatedCustomer}">
                    <tr>
                        <th>Customer ID:</th>
                        <th>Customer name:</th>
                        <th>Country:</th>
                        <th>E-mail:</th>
                    </tr>
                </c:if>
                <c:if test="${empty updatedCustomer}">
                    <p>Customer not updated. Try again.</p>
                </c:if>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${updatedCustomer.id}"/>
                    </td>
                    <td>
                        <c:out value="${updatedCustomer.customerName}"/>
                    </td>
                    <td>
                        <c:out value="${updatedCustomer.country}"/>
                    </td>
                    <td>
                        <c:out value="${updatedCustomer.email}"/>
                    </td>
                </tr>
                <c:out value="Customer updated."/>
            </tbody>
        </table>
    </body>
</html>