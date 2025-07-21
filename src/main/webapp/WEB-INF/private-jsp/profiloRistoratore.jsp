<%@page import="org.elis.enumerazioni.Stato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.elis.model.*" %>
<%@page import="java.util.*"%>
   <!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EnjoEat | Ristoratore</title>
    <!-- CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/profilo-ristoratore.css" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<%Utente u = (Utente)session.getAttribute("UtenteLoggato"); %>
<%List<Ordine> ordini = (List<Ordine>) request.getAttribute("Ordini"); %>
<body>

    <!-- Header -->
    <header id="scroll-header">
        <div class="logo">
            <a href="#">
                <img src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="Logo">
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
            <a href="#" title="Profilo Utente"><i class="fa-solid fa-user" id="user-icon"></i></a>
            <a href="#" title="Profilo Ristoratore"><i class="fa-solid fa-shop" id="shop-icon"></i></a>
            <a href="#" title="Carrello"><i class="fa-solid fa-cart-shopping" id="cart-icon"></i></a>
        </div>
    </header>

    <div class="container-fluid">
	
        <div class="row">
            <div class="col-12">
                <h1 class="text-center" id="primotitolo">Benvenuto nella tua area personale, <b><%=u.getNomeRistorante() %></b>.
                </h1>
            </div>
        </div>

        <div class="row gap-3" id="sezione1">
            <div class="col-1 d-none d-md-block"></div>
		
            <!-- Colonna sinistra -->
            <div class="col-12 col-md-3 rounded-5 shadow" id="colonnasinistra">
                <h2 class="mb-4"><%=u.getNomeRistorante() %></h2>
                <!-- Immagine profilo ristorante con icona modifica -->
                <div class="ristorante-img-wrapper d-flex align-items-center gap-2 mb-4">
                    <img src="../res/pizzeria1.jpg" alt="Foto Ristorante" class="img-fluid shadow-sm"
                        style="width: 150px; height: 150px; object-fit: cover; border-radius: 50%;">
                    <a href="#" class="text-decoration-none" title="Modifica Foto">
                        <i class="fa-solid fa-pen-to-square" id="iconamodifica"></i>
                    </a>
                </div>
                <p>
                    <i class="fa-solid fa-user me-2"></i><strong><%=u.getNome()%> <%=u.getCognome() %></strong>
                    <a href="#" class="text-decoration-none ms-2" title="Modifica Nome">
                        <i class="fa-solid fa-pen-to-square" id="iconamodifica"></i>
                    </a>
                </p>
                <p><i class="fa-solid fa-envelope me-2"></i><%=u.getEmail() %></p>
                <p>
                    <i class="fa-solid fa-key me-2"></i>********
                    <a href="#" class="text-decoration-none ms-2" title="Modifica Password">
                        <i class="fa-solid fa-pen-to-square" id="iconamodifica"></i>
                    </a>
                </p>
                <p><i class="fa-solid fa-location-dot me-2"></i><%= u.getIndirizzoRistorante() %></p>
                <p><i class="fa-solid fa-clock me-2"></i>10:00 - 22:30</p>
                <p><i class="fa-solid fa-star me-2 text-warning"></i><%=u.getVotoM() %> / 5</p>
                <a href="<%=request.getContextPath()%>/AggiungiPortataServlet" class="btn btn-success align-self-start mt-3 rounded-3">
                    Modifica Menu
                </a>

            </div>

            <!-- Colonna destra: ORDINI -->
            <div class="col-12 col-md-7 d-flex flex-column gap-4">

                <!-- ORDINI PROCESSATI -->
                <div class="rounded-5 pt-4 pb-5 px-4 shadow" id="colonnaprocessati">
                    <h2 class="mb-4">ORDINI PROCESSATI</h2>
                    <div class="order-carousel-wrapper position-relative">
                        <button class="carousel-arrow left-arrow" id="scrollLeft" aria-label="Scorri a sinistra">
                            <i class="fa-solid fa-chevron-left"></i>
                        </button>
                        <div class="order-carousel d-flex flex-nowrap overflow-auto gap-3" id="carouselOrders">

                            <!-- Card -->
                            <%if(ordini != null){ %>
                            	<%for(Ordine o : ordini) {%>
                            		<%if(o.getStato().name().equalsIgnoreCase("Ritirato")||o.getStato().name().equalsIgnoreCase("Rifiutato")||o.getStato().name().equalsIgnoreCase("Annullato")){ %>
										<div class="card order-card flex-shrink-0 rounded-5">
			                                <div
			                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
			                                    <div class="order-details">
			                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#<%=o.getId() %></strong>
			                                        </p>
			                                        <p class="mb-2"><i class="fa-solid fa-user me-2"></i><%=o.getCliente().getNome()%> <%=o.getCliente().getCognome()%></p>
			                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>
			                                        
			                                        <%for(ElementoOrdine eo : o.getElementi()){%>
			                                        	<%=eo.getNome() %> x<%=eo.getQuantita()%>
			                                        <%}%>
			                                        
			                                        </p>
			                                        <%
			                                        Double totale=0.0;
			                                        for(ElementoOrdine eo : o.getElementi()){
			                                        	totale+=eo.getPrezzo()*eo.getQuantita();
			                                        	}
			                                        %>
			                                        
			                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i><%=totale %></p>
			                                    </div>
			                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
			                                        <span class="badge bg-success mb-2"><i class="fa-solid fa-check-circle me-1">
			                                            </i><%=o.getStato().name() %></span>
			                                        <p><b>Ora </b><%=o.getData() %></p>
			                                    </div>
			                                </div>
			                                <!-- Bottone centrato in basso con stella bianca -->
			                                <% if(o.getStato().name().equalsIgnoreCase("ritirato")){ %>
			                                <div class="recensione-footer text-center">
			                                    <button class="badge bg-success text-white border-0 mb-3 visualizzaRecensioneBtn"
			                                        style="font-size: 0.9rem; cursor: pointer;"
			                                        data-recensione="
			                                        <%if(o.getRecensione()!=null){ 
			                                        	 o.getRecensione().getTesto();
			                                        }else{%>
			                                        	Ancora non recensito
			                                        <%}%>"
			                                        data-rating="
			                                        <%if(o.getRecensione()!=null){ 
			                                        	 o.getRecensione().getVoto();
			                                        }else{%>
			                                         /
			                                        <%}%>">
			                                        <i class="fa-solid fa-star me-1 text-white"></i>Visualizza recensione
			                                    </button>
			                                </div>    
			                                <%}else { %>
			                                <div class="recensione-footer text-center">
			                                	<div class="badge bg-success text-white border-0 mb-3 visualizzaRecensioneBtn"
			                                        style="font-size: 0.9rem; cursor: pointer;"
			                                        data-recensione="Nessuna recensione" data-rating="0">
			                                        <i class="fa-solid fa-star me-1 text-white"></i>Visualizza recensione
			                                    </div>
			                                </div>
			                                <%} %>
			                            </div>
			                        <%} %>
                            	<%} %>
                            <%} %>
                        
                        
                        </div>
                        
                        <button class="carousel-arrow right-arrow" id="scrollRight" aria-label="Scorri a destra">
                            <i class="fa-solid fa-chevron-right"></i>
                        </button>
                    </div>
                </div>

                <!-- ORDINI IN CORSO -->
                <div class="rounded-5 pt-4 pb-5 px-4 shadow" id="colonnaincorso">
                    <h2 class="mb-4">ORDINI IN CORSO</h2>
                    <div class="order-carousel-wrapper position-relative">
                        <button class="carousel-arrow left-arrow" id="scrollLeft2" aria-label="Scorri a sinistra">
                            <i class="fa-solid fa-chevron-left"></i>
                        </button>
                        <div class="order-carousel d-flex flex-nowrap overflow-auto gap-3" id="carouselPreparing">
                           
                            <!-- Card Da ritirare-->
                            <%if(ordini != null){ %>
                            	<%for(Ordine o : ordini) {%>
                            		<%if(o.getStato().name().equalsIgnoreCase("Ricevuto")||o.getStato().name().equalsIgnoreCase("Confermato")){ %>
										<div class="card order-card flex-shrink-0 rounded-5">
			                                <div
			                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
			                                    <div class="order-details">
			                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#<%=o.getId() %></strong>
			                                        </p>
			                                        <p class="mb-2"><i class="fa-solid fa-user me-2"></i><%=o.getCliente().getNome()%> <%=o.getCliente().getCognome()%></p>
			                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>
			                                        
			                                        <%for(ElementoOrdine eo : o.getElementi()){%>
			                                        	<%=eo.getNome() %> x<%=eo.getQuantita()%>
			                                        <%}%>
			                                        
			                                        </p>
			                                        <%
			                                        Double totale=0.0;
			                                        for(ElementoOrdine eo : o.getElementi()){
			                                        	totale+=eo.getPrezzo()*eo.getQuantita();
			                                        	}
			                                        %>
			                                        
			                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i><%=totale %></p>
			                                    </div>
			                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
			                                        <span class="badge bg-success mb-2"><i class="fa-solid fa-check-circle me-1">
			                                            </i><%=o.getStato().name() %></span>
			                                        <p><b>Ora </b><%=o.getData() %></p>
			                                    </div>
			                                </div>
			                                <!-- Tasti per modifica stato -->
			                                <%if(o.getStato().name().equalsIgnoreCase("ricevuto")){ %>
			                            		<form class="align-self-center mb-2" action="AggiornamentoStatoServlet" method="POST">
			                                		<input type="hidden" name="idOrdine" value="<%=o.getId()%>">
			                                		<input class="btn btn-danger align-self-start mt-3 rounded-3" type="submit" name="ModificaStato" value="Rifiutato">
			                                		<input class="btn btn-success align-self-start mt-3 rounded-3" type="submit" name="ModificaStato" value="Confermato">
			                                	</form>     	
			                                <%}else if(o.getStato().name().equalsIgnoreCase("confermato")){ %>  
			                                	<form class="align-self-center mb-2" action="AggiornamentoStatoServlet" method="POST">
			                                		<input type="hidden" name="idOrdine" value="<%= o.getId()%>">
			                                		<input class="btn btn-danger align-self-start mt-3 rounded-3" type="submit" name="ModificaStato" value="Annullato">
			                                		<input class="btn btn-success align-self-start mt-3 rounded-3" type="submit" name="ModificaStato" value="Ritirato">
			                                	</form>
			                                <%} %>
			                            </div>
			                        <%} %>
                            	<%} %>
                            <%} %>
                            
                                                     
                        </div>
                        <button class="carousel-arrow right-arrow" id="scrollRight2" aria-label="Scorri a destra">
                            <i class="fa-solid fa-chevron-right"></i>
                        </button>
                    </div>
                </div>

            </div> <!-- chiude colonna destra -->
        </div> <!-- chiude row sezione1 -->
    </div> <!-- chiude container-fluid -->

    <!-- Footer -->
    <footer id="sezionefooter">
        <div class="container text-center text-md-start">
            <div class="row mt-3">
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Logo -->
                    <img src="../res/logo_giallo.png" alt="" id="logofooter">
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
                    <h6 class="text-uppercase fw-bold mb-4">
                        Link utili</h6>
                    <p><a href="#!" class="text-reset text-decoration-none">Chi siamo</a></p>
                    <p><a href="#!" class="text-reset text-decoration-none">FAQ</a></p>
                    <p><a href="#!" class="text-reset text-decoration-none">Contatti</a></p>
                </div>
                <!-- Colonna Profili -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">
                        Profili
                    </h6>
                    <p><a href="#!" class="text-reset text-decoration-none">Profilo Utente</a></p>
                    <p><a href="#!" class="text-reset text-decoration-none">Profilo Ristoratore</a></p>
                    <p><a href="#!" class="text-reset text-decoration-none">Carrello</a></p>
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

    <!-- POPUP MOSTRA RECENSIONE -->
    <div id="recensioneModal" class="recensione-modal">
        <div class="recensione-content">
          <div id="recensioneStars"></div>
          <p id="recensioneTesto"></p>
          <button id="closeRecensioneBtn" class="chiudi-btn">Chiudi</button>
        </div>
      </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/profilo-ristoratore.js"></script>
</body>

</html>