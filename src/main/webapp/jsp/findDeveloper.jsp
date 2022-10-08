<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http//:java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">ProjectManagementSystem</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Home</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Developers <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/developers/form">Find developer</a></li>
                            <li><a href="#">Page 1-2</a></li>
                            <li><a href="#">Page 1-3</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Companies</a></li>
                    <li><a href="#">Customers</a></li>
                    <li><a href="#">Projects</a></li>
                    <li><a href="#">Skills</a></li>
                </ul>
            </div>
        </nav>
        <form action="/developers">
            <label for="id">Developer id: </label><br>
            <input type="number" id="developer" name="developer">
            <button type="submit">Find</button>
        </form>
        <table>
            <thead>
                <tr>
                    <td>Developer name:</td>
                    <td>Age:</td>
                    <td>Gender:</td>
                    <td>Different:</td>
                    <td>Salary:</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${developer.developerName}"/>
                    </td>
                    <td>
                        <c:out value="${developer.age}"/>
                    </td>
                    <td>
                        <c:out value="${developer.gender}"/>
                    </td>
                    <td>
                        <c:out value="${developer.different}"/>
                    </td>
                    <td>
                        <c:out value="${developer.salary}"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>