// Hamburger menu toggle
const hamburger = document.getElementById('hamburger');
const navmenu = document.getElementById('navmenu');

hamburger.addEventListener('click', () => {
    navmenu.classList.toggle('active');
});

document.querySelectorAll('.navmenu a').forEach(link => {
    link.addEventListener('click', () => {
        navmenu.classList.remove('active');
    });
});

// Popup Aggiungi Portata
const popup = document.getElementById('popup');
const btnChiudi = document.getElementById('closeBtn');
const form = document.getElementById('form');
const inputSezione = document.getElementById('inputSezione');


// Aggiungo evento ai bottoni "Aggiungi Portata"
document.querySelectorAll('.aggiungi-portata-btn').forEach(btn => {
    btn.addEventListener('click', () => {
        popup.style.display = 'flex';
        
        // (Facoltativo) salva la sezione in un dataset
        const sezione = btn.dataset.sezione;
        popup.dataset.sezione = sezione;
		
		if (inputSezione) inputSezione.value = sezione;
    });
});

btnChiudi.addEventListener('click', () => {
    popup.style.display = 'none';
});

popup.addEventListener('click', (e) => {
    if (e.target === popup) {
        popup.style.display = 'none';
		form.reset();
    }
	

});

form.addEventListener('submit', (e) => {
    

    // (Facoltativo) Usa la sezione selezionata
    const sezione = popup.dataset.sezione || '';
    console.log("Nuova portata da aggiungere nella sezione:", sezione);

    // Nasconde popup e resetta il form
    popup.style.display = 'none';
    
});


