
    window.onload = function () {
    const popup = document.getElementById('alertPopup');
    if (popup.innerText.trim() !== "") {
    popup.style.display = 'block';
    setTimeout(() => {
    popup.style.opacity = '0';
    setTimeout(() => {
    popup.style.display = 'none';
}, 500);
}, 5000);
}
};
