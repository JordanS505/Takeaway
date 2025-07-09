// Hamburger menu toggle
const hamburger = document.getElementById('hamburger');
const navmenu = document.getElementById('navmenu');

hamburger.addEventListener('click', () => {
    navmenu.classList.toggle('active');
});

// Chiudi menu al click su link (opzionale)
document.querySelectorAll('.navmenu a').forEach(link => {
    link.addEventListener('click', () => {
        navmenu.classList.remove('active');
    });
});

// SLIDER CAROSELLO ORDINI
const carousel = document.getElementById('carouselOrders');
const scrollAmount = 520;

document.getElementById('scrollLeft').addEventListener('click', () => {
    carousel.scrollBy({ left: -scrollAmount, behavior: 'smooth' });
});

document.getElementById('scrollRight').addEventListener('click', () => {
    carousel.scrollBy({ left: scrollAmount, behavior: 'smooth' });
});

// SLIDER CAROSELLO ORDINI IN PREPARAZIONE
const carouselPreparing = document.getElementById('carouselPreparing');
const scrollAmount2 = 520;

document.getElementById('scrollLeft2').addEventListener('click', () => {
    carouselPreparing.scrollBy({ left: -scrollAmount2, behavior: 'smooth' });
});

document.getElementById('scrollRight2').addEventListener('click', () => {
    carouselPreparing.scrollBy({ left: scrollAmount2, behavior: 'smooth' });
});


document.addEventListener('DOMContentLoaded', () => {

    // POPUP VISUALIZZA RECENSIONE
    const popupOverlay = document.getElementById('recensionePopup');
    const closeBtn = document.getElementById('chiudiPopup');
    const recensioneText = document.getElementById('contenutoRecensione');
    const visualizzaBtns = document.querySelectorAll('.visualizzaRecensioneBtn');

    visualizzaBtns.forEach(button => {
        button.addEventListener('click', () => {
            const testoRecensione = button.dataset.recensione || 'Nessuna recensione disponibile.';
            recensioneText.textContent = testoRecensione;
            popupOverlay.style.display = 'flex';
            document.body.style.overflow = 'hidden';
        });
    });

    closeBtn.addEventListener('click', () => {
        popupOverlay.style.display = 'none';
        document.body.style.overflow = '';
    });

    popupOverlay.addEventListener('click', (e) => {
        if (!document.querySelector('#recensionePopup .popup-content').contains(e.target)) {
            popupOverlay.style.display = 'none';
            document.body.style.overflow = '';
        }
    });

    // POPUP SCRIVI RECENSIONE
    const scriviPopup = document.getElementById('scriviRecensionePopup');
    const chiudiScriviBtn = document.getElementById('chiudiScriviPopup');
    const inviaBtn = document.getElementById('inviaRecensione');
    const inputRecensione = document.getElementById('inputRecensione');
    const scriviBtns = document.querySelectorAll('.scriviRecensioneBtn');

    scriviBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            scriviPopup.style.display = 'flex';
            document.body.style.overflow = 'hidden';
            inputRecensione.value = '';
        });
    });

    chiudiScriviBtn.addEventListener('click', () => {
        scriviPopup.style.display = 'none';
        document.body.style.overflow = '';
    });

    scriviPopup.addEventListener('click', (e) => {
        const popupContent = scriviPopup.querySelector('.popup-content');
        if (!popupContent.contains(e.target)) {
            scriviPopup.style.display = 'none';
            document.body.style.overflow = '';
        }
    });

    inviaBtn.addEventListener('click', () => {
        const recensione = inputRecensione.value.trim();
        if (currentRating === 0) {
            alert('Per favore seleziona un rating da 1 a 5 stelle.');
            return;
        }
        if (recensione.length === 0) {
            alert('Per favore scrivi una recensione prima di inviare.');
            return;
        }
        alert(`Recensione inviata:\nRating: ${currentRating} stelle\nTesto: ${recensione}`);
        scriviPopup.style.display = 'none';
        document.body.style.overflow = '';
        // resettare rating e testo per prossima recensione
        currentRating = 0;
        updateStars(0);
        inputRecensione.value = '';
    });
    


    const ratingStars = document.querySelectorAll('#ratingStars .star');
    let currentRating = 0;

    ratingStars.forEach(star => {
        star.addEventListener('click', () => {
            currentRating = parseInt(star.dataset.value);
            updateStars(currentRating);
        });

        star.addEventListener('mouseover', () => {
            updateStars(parseInt(star.dataset.value));
        });

        star.addEventListener('mouseout', () => {
            updateStars(currentRating);
        });
    });

    function updateStars(rating) {
        ratingStars.forEach(star => {
            if (parseInt(star.dataset.value) <= rating) {
                star.classList.add('selected');
            } else {
                star.classList.remove('selected');
            }
        });
    }




});
