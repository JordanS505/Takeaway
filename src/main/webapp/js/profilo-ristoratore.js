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

// Popup recensione dinamico
const modal = document.getElementById('recensioneModal');
const recensioneTesto = document.getElementById('recensioneTesto');
const closeBtn = document.getElementById('closeRecensioneBtn');  // aggiornato: pulsante "Chiudi"
const stelle = document.getElementById('recensioneStars');

// Aggiunge evento a tutti i bottoni "Visualizza recensione"
document.querySelectorAll('.visualizzaRecensioneBtn').forEach(btn => {
  btn.addEventListener('click', () => {
    const recensione = btn.dataset.recensione || 'Recensione non disponibile.';
    const rating = parseInt(btn.dataset.rating) || 0;

    recensioneTesto.textContent = recensione;
    aggiornaStelle(rating);

    modal.style.display = 'block';
  });
});

// Chiudi il popup cliccando sul pulsante "Chiudi"
closeBtn.addEventListener('click', () => {
  modal.style.display = 'none';
});

// Chiudi il popup cliccando fuori dal contenuto
window.addEventListener('click', (e) => {
  if (e.target === modal) {
    modal.style.display = 'none';
  }
});

function aggiornaStelle(rating) {
  stelle.innerHTML = ''; // svuota il contenitore stelle
  for (let i = 1; i <= 5; i++) {
    const star = document.createElement('span');
    star.classList.add('star');
    if (i <= rating) star.classList.add('selected');
    star.textContent = '★';
    stelle.appendChild(star);
  }
}
