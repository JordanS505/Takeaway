// Scroll Header Behavior
window.addEventListener('scroll', function () {
  const header = document.getElementById('scroll-header');
  const navmenu = document.getElementById('navmenu');

  if (window.scrollY > 300) {
    header.classList.add('scrolled');

    // Aggiunge sfondo rosso al nav solo se è attivo (visibile)
    if (navmenu.classList.contains('active')) {
      navmenu.classList.add('scrolled');
    }
  } else {
    header.classList.remove('scrolled');
    navmenu.classList.remove('scrolled');
  }
});

// Hamburger Menu Toggle
const hamburger = document.getElementById('hamburger');
const navmenu = document.getElementById('navmenu');

hamburger.addEventListener('click', () => {
  navmenu.classList.toggle('active');

  // Controlla scroll al momento dell'apertura
  if (window.scrollY > 300 && navmenu.classList.contains('active')) {
    navmenu.classList.add('scrolled');
  } else {
    navmenu.classList.remove('scrolled');
  }
});
