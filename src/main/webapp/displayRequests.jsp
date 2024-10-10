<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des Requêtes</title>
    <link rel="stylesheet" href="css/lists.css">
</head>
<body>
<h1>Liste des Requêtes</h1>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h1>HTML Tables</h1>
        </div>
        <div class="panel-body">
            <table class="table-latitude">
                <caption>Employee Information</caption>
                <thead>
                <th>Name</th>
                <th>Designation</th>
                <th>E-mail</th>
                <th>E-mail</th>
                </thead>
                <tbody>
                <c:forEach var="request" items="${requests}">
                    <tr>
                        <td>${request.id}</td>
                        <td>${request.amount}</td>
                        <td>${request.amount}</td>
                        <td>${request.amount}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
