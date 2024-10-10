<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des Requêtes</title>
    <link rel="stylesheet" href="css/lists.css">
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <caption>Liste des Requêtes</caption>
        </div>
        <div class="panel-body">
            <table class="table-latitude">

                <thead>
                <td>Projet</td>
                <td>Statut</td>
                <td>Montant</td>
                <td>Durée</td>
                <td>Paiement Mensuel</td>
                <td>Email</td>
                <td>Prénom</td>
                <td>CIN</td>
                <td>Revenu Mensuel</td>


                </thead>
                <tbody>
                <c:forEach var="request" items="${requests}">
                    <tr>
                        <td>${request.project}</td>
                        <td>${request.status}</td>
                        <td>${request.amount}</td>
                        <td>${request.monthlyPayment}</td>
                        <td>${request.email}</td>
                        <td>${request.firstName}</td>
                        <td>${request.cin}</td>
                        <td>${request.monthlyIncome}</td>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
