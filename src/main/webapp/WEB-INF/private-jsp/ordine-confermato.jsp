<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.elis.model.*" %>
    <!DOCTYPE html>
<html lang="en">

<head>
	<%Utente u = (Utente)session.getAttribute("UtenteLoggato"); %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Ordine Confermato</title>
    <!-- CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/ordine-inviato.css" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap" rel="stylesheet" />
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>

    <!-- Header -->
    <header id="scroll-header">
        <div class="logo">
            <a href="<%=request.getContextPath()%>/HomePageUtenteServlet">
                <img src="<%=request.getContextPath() %>/src/res/logo-bianco.png" alt="Logo" />
            </a>
        </div>
        <div class="hamburger" id="hamburger">
            <i class="fa-solid fa-bars"></i>
        </div>
        <nav class="navmenu" id="navmenu">
            <a href="#" class="mobile-only">Accedi</a>
            <a href="#" class="mobile-only">Diventa Partner</a>
            <a href="#" class="mobile-only">Iscrizione Utente</a>
        </nav>
        <div class="icone">
            <a href="<%=request.getContextPath() %>/ProfiloUtenteServlet" title="Profilo Utente"><i class="fa-solid fa-user" id="user-icon"></i></a>
            <%if(u!=null){
            	if(u.getRuolo().name().equalsIgnoreCase("ristoratore")){%>
            <a href="<%=request.getContextPath() %>/PaginaProfiloRistoratoreServlet" title="Profilo Ristoratore"><i class="fa-solid fa-shop" id="shop-icon"></i></a>
        </div>
    </header>
	<%}} %>
    <!-- Contenuto principale -->
    <div class="container-fluid thank-you-container" id="contenuto">
        <div class="thank-you-box text-center p-5 rounded-4 shadow-lg">
            <h1 class="mb-3">Grazie per aver ordinato!</h1>
            <p class="mb-4">
                Il tuo ordine è stato ricevuto con successo.
                Ti contatteremo a breve con i dettagli.
            </p>
            <a href="<%=request.getContextPath() %>/HomePageUtenteServlet" class="btn btn-success btn-lg px-4 py-2 fw-semibold rounded-pill">Torna alla Home</a>
        </div>
    </div>

    <!-- Footer -->
    <footer id="sezionefooter">
        <div class="container text-center text-md-start">
            <div class="row mt-3">
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Logo -->
                    <img src="<%=request.getContextPath() %>/src/res/logo_giallo.png" alt="" id="logofooter" />
                    <p id="fame">
                        Entra in Enjoeat: che tu voglia ordinare o diventare partner,
                        sei nel posto giusto.
                    </p>
                    <div class="iconefooter d-flex gap-3">
                        <i class="fa-brands fa-square-instagram" id="instagram-icon"></i>
                        <i class="fa-brands fa-square-facebook" id="facebook-icon"></i>
                        <i class="fa-brands fa-square-x-twitter" id="x-icon"></i>
                        <i class="fa-brands fa-linkedin" id="linkedin-icon"></i>
                    </div>
                </div>
                <!-- Colonna Link utili -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">Link utili</h6>
                    <p><a href="#!" class="text-reset text-decoration-none">Chi siamo</a></p>
                    <p><a href="#!" class="text-reset text-decoration-none">FAQ</a></p>
                    <p><a href="#!" class="text-reset text-decoration-none">Contatti</a></p>
                </div>
                <!-- Colonna Profili -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">Profili</h6>
                    <p><a href="#!" class="text-reset text-decoration-none">Profilo Utente</a></p>
                    <p><a href="#!" class="text-reset text-decoration-none">Profilo Ristoratore</a></p>
                    <p><a href="#!" class="text-reset text-decoration-none">Diventa Partner</a></p>
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
    <div class="d-flex align-items-center justify-content-center pt-3" id="sezionecopyright">
        <p id="testocopyright">Copyright © 2025 EnjoEat | All rights reserved.</p>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/ordine-inviato.js"></script>
</body>

</html>
    