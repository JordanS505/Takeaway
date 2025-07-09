//Hamburger menu toggle
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
