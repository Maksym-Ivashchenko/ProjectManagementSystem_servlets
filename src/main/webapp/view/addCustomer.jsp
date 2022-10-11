<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/add">
            <label for="name">Customer name: </label><br>
            <input type="text" id="customerName" name="customerName"><br>
            <label for="name">Country: </label><br>
            <input type="text" id="country" name="country"><br>
            <label for="name">E-mail: </label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Save</button>
        </form><br>
        <table>
            <thead>
                <tr>
                    <th>Customer name:</th>
                    <th>Country:</th>
                    <th>E-mail:</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${savedCustomer.customerName}"/>
                    </td>
                    <td>
                        <c:out value="${savedCustomer.country}"/>
                    </td>
                    <td>
                        <c:out value="${savedCustomer.email}"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <c:out value="Customer added."/>
    </body>
</html>