
    const slider = document.getElementById('mySlider');
    const numberInput = document.getElementById('sliderValue');
    const durationSlider = document.getElementById('durationSlider');
    const durationValue = document.getElementById('durationValue');
    const mensualiteSlider = document.getElementById('mensualiteSlider');
    const mensualiteValue = document.getElementById('mensualiteValue');
    const tauxInteretAnnuel = 0.12;

    function calculerMensualite(capital, dureeEnMois, tauxAnnuel) {
    const tauxMensuel = tauxAnnuel / 12;
    const mensualite = (capital * tauxMensuel) / (1 - Math.pow(1 + tauxMensuel, -dureeEnMois));
    return mensualite.toFixed(2);
}

    function calculerDuree(capital, mensualite, tauxAnnuel) {
    const tauxMensuel = tauxAnnuel / 12;
    const dureeEnMois = -Math.log(1 - (capital * tauxMensuel) / mensualite) / Math.log(1 + tauxMensuel);
    return Math.round(dureeEnMois);
}

    function updateMensualite() {
    const capital = parseFloat(numberInput.value);
    const dureeEnMois = parseInt(durationValue.value);
    let mensualite = calculerMensualite(capital, dureeEnMois, tauxInteretAnnuel);
    mensualiteValue.value = mensualite;
    mensualiteSlider.value = mensualite;
}

    function updateDureeFromMensualite() {
    const capital = parseFloat(numberInput.value);
    const mensualite = parseFloat(mensualiteValue.value);
    const dureeEnMois = calculerDuree(capital, mensualite, tauxInteretAnnuel);
    durationValue.value = dureeEnMois;
    durationSlider.value = dureeEnMois;
}

    slider.addEventListener('input', function () {
    numberInput.value = slider.value;
    updateMensualite();
});

    numberInput.addEventListener('input', function () {
    slider.value = numberInput.value;
    updateMensualite();
});

    durationSlider.addEventListener('input', function () {
    durationValue.value = durationSlider.value;
    updateMensualite();
});

    durationValue.addEventListener('input', function () {
    durationSlider.value = durationValue.value;
    updateMensualite();
});

    mensualiteSlider.addEventListener('input', function () {
    mensualiteValue.value = mensualiteSlider.value;
    updateDureeFromMensualite();
});


    const loanForm = document.getElementById('loanForm');
    loanForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const project = document.getElementById('project').value;
        const status = document.getElementById('status').value;
        const amount = document.getElementById('sliderValue').value;
        const duration = document.getElementById('durationValue').value;
        const monthly = document.getElementById('mensualiteValue').value;
        const fees = (amount * 0.0165);
        const loanDetails = {
            project,
            status,
            amount,
            duration,
            monthly,
            fees
        };
        localStorage.setItem('loanDetails', JSON.stringify(loanDetails));
        console.log('Loan Details Saved to Local Storage:', loanDetails);


        window.location = 'success.jsp';
    });