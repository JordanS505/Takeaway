document.addEventListener('DOMContentLoaded', function () {
    const cartItemsDiv = document.getElementById('cart-items');
    const cartTotalSpan = document.getElementById('cart-total');

    // Mappa per tenere traccia delle quantità per ogni portata
    let cart = new Map();

    // Funzione per aggiornare la visualizzazione del carrello e totale
    function updateCartDisplay() {
        if (cart.size === 0) {
            cartItemsDiv.textContent = 'Nessun elemento nel carrello';
            cartTotalSpan.textContent = '0.00';
            return;
        }
		
        let itemsText = '';
        let total = 0;

        cart.forEach(({ prezzo, quantity }, nome) => {
            itemsText += `${nome} x${quantity} <br>`;
            total += prezzo * quantity;
        });

        cartItemsDiv.innerHTML = itemsText;
        cartTotalSpan.textContent = total.toFixed(2);
    }

	document.querySelectorAll('.btn-plus').forEach(button => {
	    button.addEventListener('click', () => {
	        const container = button.closest('.col-4');
	        const quantitySpan = container.querySelector('.quantity');
	        const nome = quantitySpan.getAttribute('data-nome');

	        // Prendo il prezzo dal card
	        const card = button.closest('.card');
	        const prezzoText = card.querySelector('span.text-muted').textContent;
	        const prezzo = parseFloat(prezzoText.replace('€', ''));

	        let currentQty = parseInt(quantitySpan.textContent);
	        currentQty++;
	        quantitySpan.textContent = currentQty;

	        if (cart.has(nome)) {
	            cart.get(nome).quantity = currentQty;
	        } else {
	            cart.set(nome, { prezzo: prezzo, quantity: currentQty });
	        }

	        updateCartDisplay();
	    });
	});

	document.querySelectorAll('.btn-minus').forEach(button => {
	    button.addEventListener('click', () => {
	        const container = button.closest('.col-4');
	        const quantitySpan = container.querySelector('.quantity');
	        const nome = quantitySpan.getAttribute('data-nome');

	        let currentQty = parseInt(quantitySpan.textContent);
	        if (currentQty > 0) {
	            currentQty--;
	            quantitySpan.textContent = currentQty;

	            if (currentQty === 0) {
	                cart.delete(nome);
	            } else if (cart.has(nome)) {
	                cart.get(nome).quantity = currentQty;
	            }

	            updateCartDisplay();
	        }
	    });
	});
	
	
	document.getElementById('ordineForm').addEventListener('submit', function (e) {
	   

	    const cartArray = [];
	    cart.forEach((value, key) => {
	        cartArray.push({
	            nome: key,
	            prezzo: value.prezzo,
	            quantity: value.quantity
	        });
	    });

	    const json = JSON.stringify(cartArray);
	    console.log("✅ JSON inviato:", json);

	    document.getElementById('carrelloInput').value = json;

	    
	});

	
});


