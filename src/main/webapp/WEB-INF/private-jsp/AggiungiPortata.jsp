<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.elis.model.*"%>
<%@ page import="java.util.Locale"%>
<!DOCTYPE html>
<html lang="it">

<%
Utente u = (Utente) request.getAttribute("ristoranteScelto");
%>
<%
List<Portata> p = (List<Portata>) request.getAttribute("listaPortate");
%>
<%
List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");
%>

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Aggiungi Portata</title>
<!-- CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/profilo-ristoratore.css" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Raleway&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>

	<!-- Header -->
	<header id="scroll-header">
		<div class="logo">
			<a href="#"> <img src="../res/logo-bianco.png" alt="Logo" />
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

	<div class="container-fluid">

		<div class="row">
			<div class="col-12">
				<h1 class="text-center" id="primotitolo">
					Benvenuto nella tua area personale, <b><%=u.getNome()%></b>.
				</h1>
			</div>
		</div>

		<div class="row gap-3" id="sezione1">
			<div class="col-1 d-none d-md-block"></div>

			<!-- Colonna sinistra -->
			<div class="col-12 col-md-3 rounded-5 shadow" id="colonnasinistra">
				<h2 class="mb-4"><%=u.getNomeRistorante()%></h2>
				<!-- Immagine profilo ristorante con icona modifica -->
				<div
					class="ristorante-img-wrapper d-flex align-items-center gap-2 mb-4">
					<img src="../res/pizzeria1.jpg" alt="Foto Ristorante"
						class="img-fluid shadow-sm"
						style="width: 150px; height: 150px; object-fit: cover; border-radius: 50%;">
					<a href="#" class="text-decoration-none" title="Modifica Foto">
						<i class="fa-solid fa-pen-to-square" id="iconamodifica"></i>
					</a>
				</div>
				<p>
					<i class="fa-solid fa-user me-2"></i><strong><%=u.getUsername()%></strong>
					<a href="#" class="text-decoration-none ms-2" title="Modifica Nome">
						<i class="fa-solid fa-pen-to-square" id="iconamodifica"></i>
					</a>
				</p>
				<p>
					<i class="fa-solid fa-envelope me-2"></i>mario@example.com
				</p>
				<p>
					<i class="fa-solid fa-key me-2"></i>******** <a href="#"
						class="text-decoration-none ms-2" title="Modifica Password"> <i
						class="fa-solid fa-pen-to-square" id="iconamodifica"></i>
					</a>
				</p>
				<p>
					<i class="fa-solid fa-location-dot me-2"></i>Via Roma 123, Milano
				</p>
				<p>
					<i class="fa-solid fa-clock me-2"></i>10:00 - 22:30
				</p>
				<p>
					<i class="fa-solid fa-star me-2 text-warning"></i>4.5 / 5
				</p>
				<button type="button"
					class="btn btn-success align-self-start mt-3 rounded-3">
					Modifica Menu</button>

			</div>

			<!-- Colonna destra: ORDINI -->
			<div class="col-12 col-md-7 d-flex flex-column gap-4">

				<!-- ORDINI PROCESSATI -->
				<%
				for (Categoria c : categorie) {
				%>
				<div class= categoria-slider>
				<div class="rounded-5 pt-4 pb-5 px-4 shadow" id="colonnaprocessati">
					<h2 class="mb-4"><%=c.getNome()%>
					</h2>
						
							<!-- Card 1 -->
							<%
							for (Portata portata : p) {
								if (portata.getIdCategoria() == c.getId()) {
							%>
							<div class="card order-card flex-shrink-0 rounded-5">
								<div
									class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
									<div class="order-details">
										<p class="mb-2">
											<i class="fa-solid fa-utensils me-2"></i><%=portata.getNome()%></p>
										<p class="mb-2">
											<i class="fa-solid fa-receipt me-2"></i><%=portata.getDescrizione()%></p>
										<p class="mb-2">
											<i class="fa-solid fa-euro-sign me-2"></i><%=portata.getPrezzo()%></p>
									</div>

								</div>

							</div>
							<%
								}
								%>
							<%
								}
								%>
							<div class="card order-card flex-shrink-0 rounded-5">
								<div
									class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
									<div class="order-details">
										<button style="display : flex ; background-color: #c1280f ; justify-content: center ;" class="p-2 rounded-circle">
											<i style="color: white" class="fa-solid fa-plus"></i></button>
									</div>

								</div>

							</div>
						

						
				</div>
				</div>
				<%
							}
							%>
				

			</div>
			<!-- chiude colonna destra -->
		</div>
		<!-- chiude row sezione1 -->
	</div>
	<!-- chiude container-fluid -->

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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/aggiungiPortata.js"></script>
</body>

</html>