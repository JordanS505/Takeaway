const cartItemsContainer = document.getElementById("cart-items");
  const cartTotalElement = document.getElementById("cart-total");
  let cart = [];
  let total = 0;

  function addToCart(nome, prezzo) {
	console.log("Aggiunto:", nome, prezzo); 
    cart.push({ nome: nome,prezzo: prezzo });
    total += prezzo;
    renderCart();
  }

  function renderCart() {
    if (cart.length === 0) {
      cartItemsContainer.innerHTML = "Nessun elemento nel carrello";
      cartTotalElement.textContent = "0.00";
      return;
    }

    cartItemsContainer.innerHTML = "";
    for(let item of cart){
    	const div = document.createElement("div");
      div.textContent = `${item.nome} - €${item.prezzo.toFixed(2)}`;
      cartItemsContainer.appendChild(div);
    }
   

    cartTotalElement.textContent = total.toFixed(2);
  }