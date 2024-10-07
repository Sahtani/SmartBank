
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire de Simulation de Crédit</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="credit-form">
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
            <span class="number ">3</span>
            <span class="text">Mes infos personnelles</span>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/secondServlet" method="post" id="contactForm">
        <input type="hidden" name="formType" value="form2">
        <div class="form-group">
            <input type="email" id="email" name="email" required>
            <label for="email">Email*</label>
        </div>
        <div class="form-group">
            <input type="tel" id="phone" name="phone" required>
            <label for="phone">Téléphone mobile*</label>
        </div>
        <div class="recaptcha">
            <div class="g-recaptcha" data-sitekey="your_site_key_here"></div>
        </div>
        <div class="div-button">
            <button class="button" type="submit" name="submit">
                <span class="main-text">Continuer</span>
                <span class="sub-text">Sans engagement</span>
            </button>
        </div>
    </form>

</div>
<h1>Résumé des Données</h1>

<div class=" card w-20">
    <p class="titre-center mon color-four">Mon récapitulatif</p>
    <p class="color-four bg1 ">Mon projet</p>
    <p class="color-first pret"><%= session.getAttribute("projectType") %></p>
    <p class="color-four bg1 ">Détails de mon crédit</p>
    <div class="data">
        <p class="color-four fs2">Vous êtes:</p>
        <p class=" color-first fs2 fw"><%= session.getAttribute("status") %></p>
    </div>
    <div class="data">
        <p class="color-four fs2">Montant:</p>
        <p class=" color-first fs2 fw"><%= session.getAttribute("amount") %> DH</p>
    </div>
    <div class="data">
        <p class="color-four fs2">Durée:</p>
        <p class=" color-first fs2 fw"><%= session.getAttribute("duration") %> mois</p>
    </div>
    <div class="data">
        <p class="color-four fs2">Mensualité:</p>
        <p class=" color-first fs2 fw"><%= session.getAttribute("monthly")%> DH</p>
    </div>
</div>
</div>
</div>

<div class="summary" id="summary" >
    <h2>Détails de mon crédit</h2>
    <p id="projectSummary"></p>
    <p id="statusSummary"></p>
    <p id="amountSummary"></p>
    <p id="durationSummary"></p>
    <p id="monthlySummary"></p>
    <p id="feesSummary"></p>
</div>
<script src="js/summary.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</body>
</html>
