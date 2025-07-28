// Hamburger menu toggle
const navmenu = document.getElementById('navmenu');

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

    // Variabile rating globale per popup scrivi recensione
    let currentRating = 0;

    // POPUP VISUALIZZA RECENSIONE
    const popupOverlay = document.getElementById('recensionePopup');
    const closeBtn = document.getElementById('chiudiPopup');
    const recensioneText = document.getElementById('contenutoRecensione');
    const ratingVisualizza = document.getElementById('ratingVisualizza'); // div per stelle visualizza
    const visualizzaBtns = document.querySelectorAll('.visualizzaRecensioneBtn');
	const form = document.getElementById('form');
	const inputSezione = document.getElementById('inputSezione');
    visualizzaBtns.forEach(button => {
        button.addEventListener('click', () => {
			const testoRecensione = button.dataset.recensione || 'Nessuna recensione disponibile.';
	        const rating = parseInt(button.dataset.rating) || 0;

	        recensioneText.textContent = testoRecensione;

	        // Aggiorna stelle nel popup
	        ratingVisualizza.innerHTML = ''; // reset stelle

	        for (let i = 1; i <= 5; i++) {
	            const star = document.createElement('i');
	            star.classList.add('star', 'fa-solid', 'fa-star');
	            if (i <= rating) {
	                star.classList.add('selected');
	            } else {
	                star.style.color = '#ccc'; // stelle grigie per non selezionate
	            }
	            ratingVisualizza.appendChild(star);
	        }

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
	
	
    scriviBtns = document.querySelectorAll('.scriviRecensioneBtn');

    scriviBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            scriviPopup.style.display = 'flex';
            document.body.style.overflow = 'hidden';
            inputRecensione.value = '';
            currentRating = 0;
            updateStars(0);
					const sezione = btn.dataset.sezione;
			        
					
					if (inputSezione) inputSezione.value = sezione;
        });
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
        
    });

    // STELLE RATING POPUP SCRIVI RECENSIONE
    const ratingStars = document.querySelectorAll('#ratingStars .star');

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
	
	form.addEventListener('submit', (e) => {
	    

	    // (Facoltativo) Usa la sezione selezionata
	    const sezione = popup.dataset.sezione || '';
	    console.log("Nuova portata da aggiungere nella sezione:", sezione);
	    
	    
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
