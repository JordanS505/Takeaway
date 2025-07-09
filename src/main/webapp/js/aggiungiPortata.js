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
const sliderContainers = document.querySelectorAll('.categoria-slider');
const scrollAmount = 520;

sliderContainers.forEach(container => {
  const carousel = container.querySelector('.carouselOrders');
  const btnLeft = container.querySelector('.left-arrow');
  const btnRight = container.querySelector('.right-arrow');

  btnLeft.addEventListener('click', () => {
    carousel.scrollBy({ left: -scrollAmount, behavior: 'smooth' });
  });

  btnRight.addEventListener('click', () => {
    carousel.scrollBy({ left: scrollAmount, behavior: 'smooth' });
  });
});