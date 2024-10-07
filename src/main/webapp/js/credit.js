document.querySelector('.submit-button').addEventListener('click', function (event) {


    const loanDetails = JSON.parse(localStorage.getItem('loanDetails'));
    const contactDetails = JSON.parse(localStorage.getItem('contactDetails'));


    const civilite = document.querySelector('input[name="civilite"]:checked').value;
    const nom = document.querySelector('#nom').value;
    const prenom = document.querySelector('#prenom').value;
    const cin = document.querySelector('#cin').value;
    const dateNaissance = document.querySelector('#date_naissance').value;
    const dateEmbauche = document.querySelector('#date_embauche').value;
    const revenus = document.querySelector('#revenus').value;
    const creditEnCours = document.querySelector('input[name="credit_en_cours"]:checked').value;


    const personalDetails = {
        civilite: civilite,
        nom: nom,
        prenom: prenom,
        cin: cin,
        dateNaissance: dateNaissance,
        dateEmbauche: dateEmbauche,
        revenus: revenus,
        creditEnCours: creditEnCours
    };
console.log(personalDetails);
    const formData = {
        ...loanDetails,
        ...contactDetails,
        ...personalDetails
    };

    console.log('Données combinées : ', formData);


});
