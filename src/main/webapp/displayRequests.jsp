<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Liste des Requêtes</title>
    <link rel="stylesheet" href="css/lists.css">
    <link rel="stylesheet" href="css/alert.css">

</head>
<body>

<c:if test="${not empty sessionScope.Message}">
    ${sessionScope.Message}
</c:if>

<div id="alertPopup" class="toast" style="display: none;">
    <div class="toast-content">
        <svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="#02AFBC"
             class="bi bi-check-circle-fill" viewBox="0 0 16 16">
            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477
            9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75
            0 0 0-.01-1.05z"></path>
        </svg>
        <div class="message">
            <span class="text text-2" id="toast-message">  <c:out value="${sessionScope.Message}"/></span>
        </div>
    </div>
    <button class="close" onclick="closeToast()">
        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
             fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
            <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1
            .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293
            8 4.646 5.354a.5.5 0 0 1 0-.708"></path>
        </svg>
    </button>
    <div class="progress"></div>
</div>

<c:if test="${not empty sessionScope.Message}">
    <c:remove var="Message" scope="session"/>
</c:if>
<div class="container">
    <form method="get" action="displayRequests">
        <div>
            <input type="date" name="date" required value="${sessionScope.date != null ? sessionScope.date : ''}"/>
        </div>
        <div>
            <select name="status" required>
                <c:forEach var="status" items="${statuses}">
                    <option value="${status.status}">${status.status}</option>
                </c:forEach>
            </select>

        </div>
        <div>
            <button type="submit">Filter</button>
        </div>
    </form>
    <div class="panel panel-default">
        <div class="panel-body">
            <table class="table-latitude">

                <br>
                <a href="index.jsp" class="p-4">Retour</a>
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
                                    <button class="ban-btn button3" onclick="showModal(${request.id})">Détails</button>
                                </td>
                                <td>
                                    <button class="ban-btn button3" onclick="showStatusModal(${request.id})">Modifier
                                        Statut
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
<script src="js/alertPopup.js"></script>
</body>
</html>
