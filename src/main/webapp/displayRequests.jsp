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
  </tr>
  </thead>
  <tbody>
  <c:forEach var="request" items="${requests}">
    <tr>
      <td>${request.id}</td>
         </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
