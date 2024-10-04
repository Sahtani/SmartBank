<%--
  Created by IntelliJ IDEA.
  User: SOUMIA
  Date: 04/10/2024
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <form>
        <div class="form-group">
            <input type="email" id="email" name="email" required>
            <label for="email">Email*</label>
        </div>
        <div class="form-group">
            <input type="tel" id="telephone" name="telephone" required>
            <label for="telephone">Téléphone mobile*</label>
        </div>
        <div class="recaptcha">
            <div class="g-recaptcha" data-sitekey="your_site_key_here"></div>
        </div>
        <div class="div-button">
            <button class="button">
                <span class="main-text">Continuer</span>
                <span class="sub-text">Sans engagement</span>
            </button>
        </div>


    </form>
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
<script>
    // Récupérer les informations stockées dans localStorage
    const loanDetails = JSON.parse(localStorage.getItem('loanDetails'));

    // Si les informations existent, les afficher dans la page
    if (loanDetails) {
        document.getElementById('projectSummary').innerText = `Mon projet : ${loanDetails.project}`;
        document.getElementById('amountSummary').innerText = `Montant : ${loanDetails.amount} DH`;
        document.getElementById('durationSummary').innerText = `Durée : ${loanDetails.duration} mois`;
    } else {
        document.getElementById('projectSummary').innerText = "Aucun détail de crédit trouvé.";
    }

    // Sauvegarder les coordonnées dans localStorage à la soumission du second formulaire
    document.getElementById('contactForm').addEventListener('submit', function(event) {
        event.preventDefault();

        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;

        const contactDetails = {
            email,
            phone
        };

        // Stocker les coordonnées dans localStorage
        localStorage.setItem('contactDetails', JSON.stringify(contactDetails));

        alert('Coordonnées soumises avec succès !');
    });
</script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</body>
</html>
