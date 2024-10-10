<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Requêtes</title>
</head>

<body>
<h1>Liste des Requêtes</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Détails</th>
        <!-- Ajoutez d'autres colonnes selon les attributs de Request -->
    </tr>
    </thead>
    <tbody>
    <c:forEach var="request" items="${requests}">
        <tr>
            <td>${request.id}</td>
            <td>${request.details}</td>
            <!-- Ajoutez d'autres cellules selon les attributs de Request -->
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
