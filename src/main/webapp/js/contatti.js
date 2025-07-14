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


// Popup richiesta inviata
document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form');
  
    form.addEventListener('submit', function (e) {
      e.preventDefault(); // blocca il submit normale
  
      // Crea il popup
      const popup = document.createElement('div');
      popup.textContent = "Grazie! La tua richiesta è stata inviata.";
      popup.classList.add('position-fixed', 'bg-success', 'text-white', 'p-3', 'rounded', 'shadow');
      
      // Stile per centrare il popup
      Object.assign(popup.style, {
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        zIndex: '1050',
        fontSize: '1.25rem',
        minWidth: '300px',
        textAlign: 'center',
      });
  
      document.body.appendChild(popup);
  
      // Rimuovi il popup dopo 3 secondi
      setTimeout(() => {
        popup.remove();
        form.reset(); // opzionale: resetta il form dopo invio
      }, 3000);
    });
  });
  