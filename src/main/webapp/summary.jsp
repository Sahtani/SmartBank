<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire de Simulation de Crédit</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/model.css">
    <link rel="stylesheet" href="css/displayRequests.css">
</head>
<body>

<%
    String message = (String) session.getAttribute("Message");
    if (message != null) {
%>

<div id="alertPopup" class="toast">
    <div class="toast-content">
        <svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="#02AFBC"
             class="bi bi-check-circle-fill" viewBox="0 0 16 16">
            <path
                    d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"></path>
        </svg>

        <div  class="message">
            <span class="text text-1"></span>
            <span class="text text-2">Le montant mensuel enregistré : <%= message %> DH</span>
        </div>
    </div>
    <i class="fa-solid fa-xmark close"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
                                            fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
        <path
                d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708"></path>
    </svg></i>
    <div class="progress"></div>
</div>
<%
        session.removeAttribute("Message");
    }
%>
<div class="grid-container">
    <div class="credit-form ">
        <div class="progress-bar">
            <div class="step completed">
                <span class="number">1</span>
                <span class="text">Simuler mon crédit</span>
            </div>
            <div class="step active step2">
                <span class="number number2">2</span>
                <span class="text">Mes coordonnées</span>
            </div>
            <div class="step step3">
                <span class="number">3</span>
                <span class="text">Mes infos personnelles</span>
            </div>
        </div>

        <form onsubmit="return validateForm()" action="${pageContext.request.contextPath}/secondServlet" method="post"
              id="contactForm">
            <input type="hidden" name="formType" value="form2">
            <div class="form-group">
                <input type="email" id="email" name="email">
                <label for="email">Email*</label>
            </div>
            <div class="form-group">
                <input type="tel" id="phone" name="phone">
                <label for="phone">Téléphone mobile*</label>
            </div>
            <div class="div-button">
                <button class="button" type="submit" name="submit">
                    <span class="main-text">Continuer</span>
                    <span class="sub-text">Sans engagement</span>
                </button>
            </div>
        </form>
    </div>

    <div class="card w-20">
        <p class="titre-center mon color-four">Mon récapitulatif</p>
        <p class="color-four bg1">Mon projet</p>
        <p class="color-first pret"><%= session.getAttribute("projectType") %>
        </p>
        <p class="color-four bg1">Détails de mon crédit</p>
        <div class="data">
            <p class="color-four fs2">Vous êtes:</p>
            <p class="color-first fs2 fw"><%= session.getAttribute("status") %>
            </p>
        </div>
        <div class="data">
            <p class="color-four fs2">Montant:</p>
            <p class="color-first fs2 fw"><%= session.getAttribute("amount") %> DH</p>
        </div>
        <div class="data">
            <p class="color-four fs2">Durée:</p>
            <p class="color-first fs2 fw"><%= session.getAttribute("duration") %> mois</p>
        </div>
        <div class="data">
            <p class="color-four fs2">Mensualité:</p>
            <p class="color-first fs2 fw"><%= session.getAttribute("monthly") %> DH</p>
        </div>
    </div>
</div>
<div id="errorModal" class="modal" style="display: none;">
    <div class="modal-content">
        <div class="border-b flex-center">
            <div class="erreur">
                <ul id="errorList" class="error-list"></ul>
            </div>
        </div>
        <div class="flex-end p-5">
            <button type="button" class="button3 m-t-4" onclick="closeModal()">
                <p class="p-10">Fermer</p>
            </button>
        </div>
    </div>
</div>

<script src="js/summary.js"></script>
<script src="js/alertPopup.js"></script>
</body>
</html>
