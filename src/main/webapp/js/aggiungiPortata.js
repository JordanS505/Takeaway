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

// Aggiungo evento ai bottoni "Aggiungi Portata"
document.querySelectorAll('.aggiungi-portata-btn').forEach(btn => {
    btn.addEventListener('click', () => {
        popup.style.display = 'flex';
        
        // (Facoltativo) salva la sezione in un dataset
        const sezione = btn.dataset.sezione;
        popup.dataset.sezione = sezione;
    });
});

btnChiudi.addEventListener('click', () => {
    popup.style.display = 'none';
});

popup.addEventListener('click', (e) => {
    if (e.target === popup) {
        popup.style.display = 'none';
    }
});

form.addEventListener('submit', (e) => {
    e.preventDefault();

    // (Facoltativo) Usa la sezione selezionata
    const sezione = popup.dataset.sezione || '';
    console.log("Nuova portata da aggiungere nella sezione:", sezione);

    // Nasconde popup e resetta il form
    popup.style.display = 'none';
    form.reset();
});

// Gestione popup di eliminazione portata
const popupElimina = document.getElementById('popupElimina');
const cancelDelete = document.getElementById('cancelDelete');
const confirmDelete = document.getElementById('confirmDelete');
const notifica = document.getElementById('notificaEliminata');
let targetToDelete = null;

document.querySelectorAll('.btn-danger').forEach(button => {
    button.addEventListener('click', () => {
        targetToDelete = button.closest('.card-body');
        popupElimina.style.display = 'flex';
    });
});

cancelDelete.onclick = () => {
    popupElimina.style.display = 'none';
};

confirmDelete.onclick = () => {
    if (targetToDelete) targetToDelete.remove();
    popupElimina.style.display = 'none';
    
    notifica.style.display = 'block';
    setTimeout(() => {
        notifica.style.display = 'none';
    }, 2000);
};
