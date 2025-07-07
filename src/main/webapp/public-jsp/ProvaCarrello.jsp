<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
  <meta charset="UTF-8">
  <title>Ristorante - Carrello Dinamico</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      display: flex;
      background-color: #f9f9f9;
    }

    /* Sidebar carrello */
    .sidebar {
      width: 250px;
      background-color: #fff3e0;
      padding: 20px;
      box-shadow: 2px 0 5px rgba(0,0,0,0.1);
      height: 100vh;
      position: sticky;
      top: 0;
    }

    .sidebar h2 {
      color: #ff6f00;
      margin-top: 0;
    }

    #cart-items {
      font-size: 0.9em;
      margin-bottom: 10px;
    }

    /* Contenuto principale */
    .main {
      flex: 1;
    }

    header {
      position: relative;
      text-align: center;
      color: white;
    }

    header img {
      width: 100%;
      height: 250px;
      object-fit: cover;
      filter: brightness(0.6);
    }

    header h1 {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      font-size: 3em;
      color: #fff;
      text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.8);
    }

    .menu-section {
      padding: 20px;
      max-width: 900px;
      margin: auto;
    }

    .category {
      margin-bottom: 30px;
    }

    .category h2 {
      border-bottom: 2px solid #ff6f00;
      padding-bottom: 5px;
      color: #333;
    }

    .dish {
      margin: 10px 0;
      padding: 10px;
      background-color: #fff;
      border-radius: 6px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }

    .dish-top {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .dish-name {
      font-weight: bold;
    }

    .dish-price {
      color: #ff6f00;
      font-weight: bold;
    }

    .dish button {
      margin-top: 8px;
      background-color: #ff6f00;
      border: none;
      color: white;
      padding: 6px 12px;
      border-radius: 4px;
      cursor: pointer;
    }

    .dish button:hover {
      background-color: #e65c00;
    }
  </style>
</head>
<body>

<!-- 🛒 Carrello -->
<div class="sidebar">
  <h2>🛒 Il tuo carrello</h2>
  <div id="cart-items">Nessun elemento nel carrello</div>
  <hr>
  <strong>Totale: €<span id="cart-total">0.00</span></strong>
</div>

<!-- 🍽️ Menu principale -->
<div class="main">
  <header>
    <img src="https://images.unsplash.com/photo-1600891964599-f61ba0e24092" alt="Ristorante">
    <h1>La Taverna del Gusto</h1>
  </header>

  <div class="menu-section">

    <!-- Sezione dinamica dei piatti -->
    <div class="category">
      <h2>Primi</h2>

      <div class="dish">
        <div class="dish-top">
          <span class="dish-name">Carbonara</span>
          <span class="dish-price">€10.00</span>
        </div>
        <button onclick="addToCart('Carbonara', 10.00)">Aggiungi al carrello</button>
      </div>

      <div class="dish">
        <div class="dish-top">
          <span class="dish-name">Lasagna</span>
          <span class="dish-price">€11.50</span>
        </div>
        <button onclick="addToCart('Lasagna', 11.50)">Aggiungi al carrello</button>
      </div>
    </div>

    <div class="category">
      <h2>Dolci</h2>

      <div class="dish">
        <div class="dish-top">
          <span class="dish-name">Tiramisù</span>
          <span class="dish-price">€4.50</span>
        </div>
        <button onclick="addToCart('Tiramisù', 4.50)">Aggiungi al carrello</button>
      </div>

      <div class="dish">
        <div class="dish-top">
          <span class="dish-name">Panna Cotta</span>
          <span class="dish-price">€4.00</span>
        </div>
        <button onclick="addToCart('Panna Cotta', 4.00)">Aggiungi al carrello</button>
      </div>
    </div>

  </div>
</div>

<!-- 🧠 JavaScript -->
<script>
  const cartItemsContainer = document.getElementById("cart-items");
  const cartTotalElement = document.getElementById("cart-total");
  let cart = [];
  let total = 0;

  function addToCart(nome, prezzo) {
    cart.push({ nome, prezzo });
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
    cart.forEach(item => {
      const div = document.createElement("div");
      div.textContent = `${item.nome} - €${item.prezzo.toFixed(2)}`;
      cartItemsContainer.appendChild(div);
    });

    cartTotalElement.textContent = total.toFixed(2);
  }
</script>

</body>
</html>
