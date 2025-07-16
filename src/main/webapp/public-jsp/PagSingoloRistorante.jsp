<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="org.elis.model.*"%>
<%@ page import="java.util.Locale"%>
<!DOCTYPE html>
<html lang="it">
<head>
<%
	Utente c = (Utente) session.getAttribute("UtenteLoggato"); 
	Utente u = (Utente) request.getAttribute("ristoranteScelto");
	%>
<%
	List<Portata> p = (List<Portata>) request.getAttribute("listaPortate");
	%>
<%
	List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");
	%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="<%=request.getContextPath()%>/src/icon.png"
	type="image/png">
<title>EnjoEat | Ordina</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<style>
@font-face {
	font-family: 'Raleway';
	src: url('../res/Raleway-VariableFont_wght.ttf') format('truetype');
}

body {
	margin: 0;
	font-family: 'Raleway', sans-serif;
	font-size: 20px;
}

header {
	display: flex;
	align-items: center;
	justify-content: space-between;
	height: 70px;
	padding: 0 20px;
	background-color: #c1280f;
	position: fixed;
	width: 100%;
	top: 0;
	left: 0;
	z-index: 1000;
}

.logo img {
	height: 32px;
}

.navmenu {
	display: flex;
	gap: 20px;
}

.navmenu a {
	color: white;
	text-decoration: none;
	font-size: 18px;
}

.navmenu a:hover {
	color: #ff9b19;
}

.icone {
	display: flex;
	gap: 15px;
}

.icone i {
	color: white;
	font-size: 25px;
}

.hamburger {
	display: none;
	font-size: 26px;
	color: white;
	cursor: pointer;
}

.container-fluid {
	padding-top: 75px;
}

/* Responsive mobile */
@media screen and (max-width: 768px) {
	.navmenu {
		position: absolute;
		top: 70px;
		left: 0;
		width: 100%;
		height: calc(100vh - 70px);
		background-color: #c1280f;
		/* Fisso anche su mobile */
		flex-direction: column;
		align-items: center;
		justify-content: flex-start;
		padding-top: 20px;
		display: none;
		z-index: 999;
	}
	.navmenu.active {
		display: flex;
	}
	.navmenu a {
		padding: 10px 0;
	}
	.navmenu a:last-child {
		padding-bottom: 20px;
	}
	.icone {
		display: none;
	}
	.hamburger {
		display: block;
	}
	.mobile-only {
		display: block;
	}
}

@media screen and (min-width: 769px) {
	.logo {
		padding-left: 30px;
	}
	.icone {
		padding-right: 30px;
	}
	.mobile-only {
		display: none;
	}
}

/* FOOTER */
#logofooter {
	width: 150px;
	padding-bottom: 25px;
}

#sezionefooter {
	background-color: #c1280f;
	margin-top: 100px;
	padding-top: 40px;
	padding-bottom: 10px;
}

#instagram-icon, #facebook-icon, #x-icon, #linkedin-icon {
	color: white;
	font-size: 25px;
}

#fame {
	color: white;
}

#sezionefooter a {
	color: white !important;
}

#sezionefooter p {
	color: white !important;
}

#sezionefooter h6 {
	color: #ff9b19;
}

#sezionecopyright {
	height: 70px;
	background-color: #7f2d07;
}

#testocopyright {
	color: white;
}

/* Centrare icone footer su dispositivi mobili */
@media ( max-width : 768px) {
	.iconefooter {
		justify-content: center !important;
	}
}

@media ( max-width : 768px) {
	.sidebar {
		position: static !important;
		top: auto !important;
	}
}
.immChiSiamo {
    position: relative;
    /* necessario per posizionare il titolo */
    height: 50vh;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}

.immChiSiamo::before {
    content: '';
    position: absolute;
    /* aggiungi posizione assoluta */
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.3);
    z-index: 1;
}

/* Titolo centrato */
.hero-title {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: white;
    font-size: 3rem;
    font-weight: 700;
    z-index: 2;
    /* sopra overlay */
    text-shadow: 0 2px 6px rgba(0, 0, 0, 0.7);
    margin: 0;
    padding-top:25px;

}
</style>
</head>
<body>
	<!-- Header -->
	<header id="scroll-header">
		<div class="logo">
			<a href="#"> <img
				src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="Logo" />
			</a>
		</div>
		
		<div class="hamburger" id="hamburger">
			<i class="fa-solid fa-bars"></i>
		</div>
		<nav class="navmenu" id="navmenu">
			<a href="#" class="mobile-only">Accedi</a> <a href="#"
				class="mobile-only">Diventa Partner</a> <a href="#"
				class="mobile-only">Iscrizione Utente</a>
		</nav>
		<div class="icone">
			<a href="#" title="Profilo Utente"><i class="fa-solid fa-user"
				id="user-icon"></i></a> <a href="#" title="Profilo Ristoratore"><i
				class="fa-solid fa-shop" id="shop-icon"></i></a> <a href="#"
				title="Carrello"><i class="fa-solid fa-cart-shopping"
				id="cart-icon"></i></a>
		</div>
	</header>

	<%if(u.getFoto()!=null){ %>
		<div class="immChiSiamo" style="background-image: url('data:image/png;base64, <%= u.getBase64ImageString()%>');">
        <h1 class="hero-title"><%=u.getNomeRistorante() %></h1>
    </div>
    	<%} else{%>
    	<div class="immChiSiamo" style="background-image: url('');">
        <h1 class="hero-title"><%=u.getNomeRistorante() %></h1>
    </div>
    <%} %>

	<div class="container-fluid">
		<div class="row gx-3 gap-4">

			<div class="col"></div>

			<div
				class="sidebar col-12 col-md-3 mb-3 border-0 rounded-5 shadow p-3"
				style="height: fit-content; min-height: 150px; position: sticky; top: 90px; height: fit-content;">
				<h2 class="fw-bold">🛒 Il tuo carrello</h2>
				<div id="cart-items" class="mb-2 text-muted">Nessun elemento
					nel carrello</div>
				<hr>
				<div class="d-flex justify-content-between">
					<strong>Totale:</strong> <strong>€<span id="cart-total">0.00</span></strong>
				</div>
				<form id="ordineForm" method="post"
					action="<%=request.getContextPath()%>/CarrelloServlet">
					<input type="hidden" name="ristoranteScelto" value="<%=u.getIndirizzoRistorante()%>">
					<input type="hidden" name="carrello" id="carrelloInput" value="">
					<button type="submit"
						class="btn w-100 border-radius border-0 rounded-pill text-white mt-2"
						style="background-color: #c1280f">Ordina ora!</button>
				</form>
			</div>

			<div class="main col-12 col-md-7 p-0">
				<div class="menu-section">
					<% for (Categoria cat : categorie) { %>
					<h3 class="fw-bold mt-4 mb-3"><%= cat.getNome() %></h3>
					<% for (Portata portata : p) {
			                if (portata.getIdCategoria().equals(cat.getId())) {
			                    String prezzo = String.format("%.2f", portata.getPrezzo());
			            %>
					<div class="card mb-3 p-3 border-0 shadow rounded-5">

						<div class="row d-flex">
							<div class="col-3">
								<% if(portata.getFoto()!=null) { %>
		                                <img src="data:image/png;base64,<%= portata.getBase64ImageString() %>" alt="Foto"
									class="img-fluid flex-shrink-0 img-ristorante"
									style="object-fit: cover; height: 200px;">
		                            <% } else { %>
		                                <img src="" alt="Foto Portata"
									class="img-fluid flex-shrink-0 img-ristorante"
									style="object-fit: cover; height: 200px;">
		                            <% } %>
							</div>
							<div class="col-5">
								<h5 class="mb-1"><%= portata.getNome() %></h5>
								<br> <span class="mb-0 text-muted"><%= prezzo %>€</span>
							</div>
							<div class="col-4 d-flex flex-column align-items-end">
								<div class="d-flex gap-1 align-items-center">
									<span class="fw-bold mt-2">Quantità:</span> <span
										class="quantity mt-2" data-nome="<%= portata.getNome() %>">0</span>
								</div>
								<div class="d-flex me-2 gap-1 align-items-center">
									<button
										class="btn btn-outline-danger border-2 btn-minus fw-bold fs-5"
										style="padding: 0; width: 35px; height: 35px; border-radius: 50%; display: flex; align-items: center; justify-content: center;">−</button>
									<button
										class="btn btn-outline-success border-2 btn-plus fw-bold fs-5"
										style="padding: 0; width: 35px; height: 35px; border-radius: 50%; display: flex; align-items: center; justify-content: center;">+</button>
								</div>
							</div>
						</div>
					</div>
					<% } } %>
					<% } %>
				</div>
			</div>

			<div class="col"></div>

		</div>
	</div>

	<!-- Footer -->
	<footer id="sezionefooter">
		<div class="container text-center text-md-start">
			<div class="row mt-3">
				<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
					<!-- Logo -->
					<img src="../res/logo_giallo.png" alt="" id="logofooter">
					<p id="fame">Entra in Enjoeat: che tu voglia ordinare o
						diventare partner, sei nel posto giusto.</p>
					<div class="iconefooter d-flex gap-3">
						<i class="fa-brands fa-square-instagram" id="instagram-icon"></i>
						<i class="fa-brands fa-square-facebook" id="facebook-icon"></i> <i
							class="fa-brands fa-square-x-twitter" id="x-icon"></i> <i
							class="fa-brands fa-linkedin" id="linkedin-icon"></i>
					</div>
				</div>
				<!-- Colonna Link utili -->
				<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
					<h6 class="text-uppercase fw-bold mb-4">Link utili</h6>
					<p>
						<a href="#!" class="text-reset text-decoration-none">Chi siamo</a>
					</p>
					<p>
						<a href="#!" class="text-reset text-decoration-none">FAQ</a>
					</p>
					<p>
						<a href="#!" class="text-reset text-decoration-none">Contatti</a>
					</p>
				</div>
				<!-- Colonna Profili -->
				<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
					<h6 class="text-uppercase fw-bold mb-4">Profili</h6>
					<p>
						<a href="#!" class="text-reset text-decoration-none">Profilo
							Utente</a>
					</p>
					<p>
						<a href="#!" class="text-reset text-decoration-none">Profilo
							Ristoratore</a>
					</p>
					<p>
						<a href="#!" class="text-reset text-decoration-none">Carrello</a>
					</p>
				</div>
				<!-- Colonna Contatti -->
				<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
					<h6 class="text-uppercase fw-bold mb-4">Contatti</h6>
					<p>Roma, RM 00100, IT</p>
					<p>enjoeat@enjoeatapp.com</p>
					<p>+39 023 85 94 747</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- Copyright -->
	<div class="d-flex align-items-center justify-content-center pt-3"
		id="sezionecopyright">
		<p id="testocopyright">Copyright © 2025 EnjoEat | All rights
			reserved.</p>
	</div>

	<script src='<%=request.getContextPath()%>/js/carrello.js'></script>
	<script >
	
	</script>

</body>
</html>