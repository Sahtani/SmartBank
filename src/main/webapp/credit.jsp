<%--
  Created by IntelliJ IDEA.
  User: SOUMIA
  Date: 04/10/2024
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire de Demande de Crédit</title>
    <link rel="stylesheet" href="css/credit.css">
</head>

<body>
<div class="container-div">
    <div class="container">
        <div class="credit-form-bar">
            <div class="progress-bar">
                <div class="step completed">
                    <span class="number">1</span>
                    <span class="text">Simuler mon crédit</span>
                </div>
                <div class="step completed">
                    <span class="number">2</span>
                    <span class="text">Mes coordonnées</span>
                </div>
                <div class="step active step3">
                    <span class="number">3</span>
                    <span class="text">Mes infos personnelles</span>
                </div>
            </div>

            <div class="credit-form">
                <form action="${pageContext.request.contextPath}/thirdServlet" method="post">
                    <div class="form-group radio-group">
                        <label class="label">Civilité</label><br>
                        <div class="options">
                            <div class="input-radio">
                                <input type="radio" id="madame" name="civilite" value="Madame">
                                <label for="madame">Madame</label>
                            </div>
                            <div class="input-radio">
                                <input type="radio" id="mademoiselle" name="civilite" value="Mademoiselle">
                                <label for="mademoiselle">Mademoiselle</label>
                            </div>
                            <div class="input-radio">
                                <input type="radio" id="monsieur" name="civilite" value="Monsieur">
                                <label for="monsieur">Monsieur</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="text" id="nom" name="nom" required>
                        <label for="nom">Nom*</label>
                    </div>
                    <div class="form-group">
                        <input type="text" id="prenom" name="prenom" required>
                        <label for="prenom">Prénom*</label>
                    </div>
                    <div class="form-group">
                        <input type="text" id="cin" name="cin" required>
                        <label for="cin">Numéro CIN / Carte de séjour*</label>
                    </div>
                    <div class="form-group">
                        <input type="text" id="date_naissance" name="date_naissance" required>
                        <label for="date_naissance">Date de naissance* (JJ/MM/YYYY)</label>
                    </div>
                    <div class="form-group">
                        <input type="text" id="date_embauche" name="date_embauche" required>
                        <label for="date_embauche">Date d'embauche/début de l'activité* (JJ/MM/YYYY)</label>
                    </div>
                    <div class="form-group">
                        <input type="number" id="revenus" name="revenus" required>
                        <label for="revenus">Total revenus mensuels (net en DH)*</label>
                    </div>
                    <div class="form-group radio-group">
                        <label>Avez-vous des crédits en cours ?</label><br>
                        <div class="radio-options">
                            <div class="options">
                                <div class="input-radio">
                                    <input type="radio" id="credit_oui" name="credit_en_cours" value="Oui">
                                    <label for="credit_oui">Oui</label>
                                </div>
                                <div class="input-radio">
                                    <input type="radio" id="credit_non" name="credit_en_cours" value="Non" checked>
                                    <label for="credit_non">Non</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group checkbox-group">
                        <input type="checkbox" id="conditions" name="conditions" required>
                        <label for="conditions">J'ai lu et j'accepte les <a href="#">conditions générales d'utilisation</a> figurant sur les informations légales, notamment la mention relative à la protection des données personnelles</label>
                    </div>
                    <div class="button-group">
                        <button type="submit" class="submit-button" name="submit">Demander ce crédit</button>
                        <button type="button" class="secondary-button">Voir mon récapitulatif</button>
                    </div>
                </form>


            </div>
        </div>
        <div class="credit-summary">
            <h2>Mon récapitulatif</h2>

            <section>
                <h3>Mon projet</h3>
                <p class="highlight">Prêt Personnel</p>
            </section>

            <section>
                <h3>Coordonnées et infos personnelles</h3>
                <div class="info-group">
                    <span>Email:</span>
                    <span class="highlight">soumia.sahtani@gmail.com</span>
                </div>
                <div class="info-group">
                    <span>Téléphone:</span>
                    <span class="highlight">0774567955</span>
                </div>
            </section>

            <section>
                <h3>Détails de mon crédit</h3>
                <div class="info-group">
                    <span>Vous êtes:</span>
                    <span class="highlight">Fonctionnaire</span>
                </div>
                <div class="info-group">
                    <span>Montant:</span>
                    <span class="highlight">10 000 DH</span>
                </div>
                <div class="info-group">
                    <span>Durée:</span>
                    <span class="highlight">24 mois</span>
                </div>
                <div class="info-group">
                    <span>Mensualité:</span>
                    <span class="highlight">469,40 DH</span>
                </div>
                <div class="info-group">
                    <span>Frais de dossier:</span>
                    <span class="highlight">271,50 DH</span>
                </div>
            </section>
        </div>

    </div>
    <p class="color-four bg1 ">votre email</p>
    <p class="color-first pret"><%= session.getAttribute("email") %></p>

    <div class="data">
        <p class="color-four fs2">votre telephone:</p>
        <p class=" color-first fs2 fw"><%= session.getAttribute("phone") %></p>
    </div>
</div>

</body>
<script src="js/credit.js"></script>

</html>
