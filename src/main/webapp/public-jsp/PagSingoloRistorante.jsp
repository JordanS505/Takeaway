<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
	<%@ page import="org.elis.model.Utente" %>
<!DOCTYPE html>
<html lang="it">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>La Taverna del Gusto</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      background-color: #f9f9f9;
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
      max-width: 800px;
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
  </style>
</head>
<body>
	<%Utente u = (Utente)request.getAttribute("ristoranteScelto"); %>
<header>
  <img src="https://images.unsplash.com/photo-1600891964599-f61ba0e24092" alt="Ristorante">
  <h1><%=u.getNomeRistorante()%></h1>
</header>

<div class="menu-section">
  <div class="category">
    <h2>Antipasti</h2>
    <div class="dish"><span class="dish-name">Bruschette miste</span><span class="dish-price">€5,00</span></div>
    <div class="dish"><span class="dish-name">Tagliere di salumi</span><span class="dish-price">€8,50</span></div>
  </div>

  <div class="category">
    <h2>Primi</h2>
    <div class="dish"><span class="dish-name">Spaghetti alla carbonara</span><span class="dish-price">€10,00</span></div>
    <div class="dish"><span class="dish-name">Lasagna tradizionale</span><span class="dish-price">€11,50</span></div>
  </div>

  <div class="category">
    <h2>Secondi</h2>
    <div class="dish"><span class="dish-name">Pollo arrosto</span><span class="dish-price">€9,00</span></div>
    <div class="dish"><span class="dish-name">Bistecca alla griglia</span><span class="dish-price">€15,00</span></div>
  </div>

  <div class="category">
    <h2>Dolci</h2>
    <div class="dish"><span class="dish-name">Tiramisù</span><span class="dish-price">€4,50</span></div>
    <div class="dish"><span class="dish-name">Panna cotta</span><span class="dish-price">€4,00</span></div>
  </div>
</div>

</body>
</html>