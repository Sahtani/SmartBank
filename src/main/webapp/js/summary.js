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
document.getElementById('contactForm').addEventListener('submit', function (event) {


    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;

    const contactDetails = {
        email,
        phone
    };


    localStorage.setItem('contactDetails', JSON.stringify(contactDetails));

});