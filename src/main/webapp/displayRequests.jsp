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

        </div>
        <div class="panel-body">
            <table class="table-latitude">
                <caption>Liste des Requêtes</caption>
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
                <th >Details</th>
                <th >Action</th>


                </thead>
                <tbody>

                <c:if test="${not empty requests}">
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
                            <td class="th-d">
                                <button class="ban-btn"
                                        onclick="showModal(1)">Détails
                                </button>
                            </td>
                            <td>
                                <button class="ban-btn"
                                        onclick="showStatusModal(1)">Modifier Status
                                </button>
                            </td>


                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty requests}">
                    <tr>
                        <td colspan="15">Aucun crédit trouvé.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div id="modal-1" class="modal">
    <div class="modal-content"><span class="close-btn" onclick="closeModal(1)">&times;</span>
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
                <tr>
                    <td>2024-03-24</td>
                    <td>Approuvé</td>
                    <td>Crédit approuvé après révision des documents</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="flex-end p-5">
        </div>
    </div>
</div>

<div id="status-modal-1" class="modal">
    <div class="modal-content model-heigth"><span class="close-btn" onclick="closeStatusModal(1)">&times;</span>
        <h2>Modifier Status</h2>
        <form>
            <label for="status">Nouveau Status:</label> <select id="status" name="status">
            <option value="Actif">Actif</option>
            <option value="Inactif">Inactif</option>
            <option value="Suspendu">Suspendu</option>
        </select>
            <div class="flex-end p-5">
                <button type="button" class="button3" onclick="submitStatus(1)">
                    <p class="p-10">Soumettre</p>

                </button>
            </div>
        </form>
    </div>
</div>

<script>
    function showModal(creditId) {
        var modal = document.getElementById('modal-' + creditId);
        modal.style.display = "block";
    }

    function closeModal(creditId) {
        var modal = document.getElementById('modal-' + creditId);
        modal.style.display = "none";
    }

    function showStatusModal(id) {
        var modal = document.getElementById('status-modal-' + id);
        modal.style.display = "block";
    }

    function closeStatusModal(id) {
        var modal = document.getElementById('status-modal-' + id);
        modal.style.display = "none";
    }

    function submitStatus(id) {
        var status = document.getElementById('status').value;
        alert("Le status a été mis à jour à: " + status);
        closeStatusModal(id);
    }

    window.onclick = function (event) {
        var modals = document.querySelectorAll('.modal');
        modals.forEach(modal => {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        });
    }
</script>

</body>

</html>
