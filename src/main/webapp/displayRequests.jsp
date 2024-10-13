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
        <div class="panel-heading">Liste des Requêtes</div>
        <div class="panel-body">
            <table class="table-latitude">
                <caption>Liste des Requêtes</caption>
                <thead>
                <tr>
                    <th>Projet</th>
                    <th>Statut</th>
                    <th>Montant</th>
                    <th>Durée</th>
                    <th>Paiement Mensuel</th>
                    <th>Email</th>
                    <th>Prénom</th>
                    <th>CIN</th>
                    <th>Revenu Mensuel</th>
                    <th>Détails</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty requests}">
                        <c:forEach var="request" items="${requests}">
                            <tr>
                                <td>${request.project}</td>
                                <td>${request.status}</td>
                                <td>${request.amount}</td>
                                <td>${request.duration}</td>
                                <td>${request.monthlyPayment}</td>
                                <td>${request.email}</td>
                                <td>${request.firstName}</td>
                                <td>${request.cin}</td>
                                <td>${request.monthlyIncome}</td>
                                <td>
                                    <button class="ban-btn" onclick="showModal(${request.id})">Détails</button>
                                </td>
                                <td>
                                    <button class="ban-btn" onclick="showStatusModal(${request.id})">Modifier Statut
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="11">Aucun crédit trouvé.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>

<c:forEach var="request" items="${requests}">
    <div id="modal-${request.id}" class="modal">
        <div class="modal-content">
            <span class="close-btn" onclick="closeModal(${request.id})">&times;</span>
            <h2>Historique du Crédit</h2>
            <div class="table-container h-table">
                <table class="custom-table">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Explication</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty request.requestStatuses}">
                        <c:forEach var="status" items="${request.requestStatuses}">
                            <tr>
                                <td>${status.date}</td>
                                <td>${status.status.status}</td>
                                <td>${status.description}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty request.requestStatuses}">
                        <tr>
                            <td colspan="3">Aucun statut trouvé.</td>
                        </tr>
                    </c:if>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div id="status-modal-${request.id}" class="modal">
        <div class="modal-content model-height">
            <span class="close-btn" onclick="closeStatusModal(${request.id})">&times;</span>
            <h2>Modifier Statut</h2>
            <form action="${pageContext.request.contextPath}/updateStatusServlet" method="post">
                <input type="hidden" name="requestId" value="${request.id}"/>
                <label for="status-${request.id}">Nouveau Statut:</label>
                <select name="status" id="status-${request.id}">
                    <c:forEach var="status" items="${statuses}">
                        <option value="${status.id}">${status.status}</option>
                    </c:forEach>
                </select>


                <div class="m-t-9 input-container">
                        <textarea name="description" id="explication-${credit.id}" placeholder="" rows="6" cols="50"
                                  class="custom-input"></textarea>
                    <label for="explication-${request.id}" class="custom-label">Explication*</label>
                </div>
                <div class="flex-end p-5">
                    <button type="submit" class="button3">Soumettre</button>
                </div>
            </form>
        </div>
    </div>

</c:forEach>

<script>
    function showModal(creditId) {
        document.getElementById('modal-' + creditId).style.display = "block";
    }

    function closeModal(creditId) {
        document.getElementById('modal-' + creditId).style.display = "none";
    }

    function showStatusModal(id) {
        document.getElementById('status-modal-' + id).style.display = "block";
    }

    function closeStatusModal(id) {
        document.getElementById('status-modal-' + id).style.display = "none";
    }

    window.onclick = function (event) {
        const modals = document.querySelectorAll('.modal');
        modals.forEach(modal => {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        });
    };
</script>
</body>
</html>
