<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.elis.model.*"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.Base64"%>

<!DOCTYPE html>
<html lang="it">

<%
Utente u = (Utente) session.getAttribute("UtenteLoggato");

List<Portata> portate = (List<Portata>) request.getAttribute("listaPortate");

List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EnjoEat | Modifica Menù</title>
    <!-- CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/aggiungi-portata.css" />
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

<body>

    <!-- Header -->
    <header id="scroll-header">
        <div class="logo">
            <a href="#">
                <img src="<%=request.getContextPath()%>/res/logo-bianco.png" alt="Logo" />
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
        </div>
    </header>


    <div class="container-fluid">

        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-12 text-center">
                <h1 id="primotitolo">Aggiorna il tuo <strong>Menù</strong> in pochi clic!</h1>

            </div>
        </div>
        <!-- Popup Form -->
        <div id="popup">
            <form id="form" action="<%=request.getContextPath() %>/LogicaAggiungiPortata" enctype="multipart/form-data" method="POST">
                <h3>Aggiungi portata</h3>
                <input type="text" name="nome" placeholder="Nome" required>
                <textarea name="descrizione" placeholder="Descrizione (ingredienti)" required></textarea>
                <input type="number" name="prezzo" step="0.01" min="0" placeholder="Prezzo (€)" required>
                <input type="file" name="foto">
                <input type="hidden" name="sezione" id="inputSezione">
		        <div class="form-check mb-2">
		            <input class="form-check-input" type="checkbox" name="senzaGlutine" id="senzaGlutine">
		            <label class="form-check-label" for="senzaGlutine">Senza glutine</label>
		        </div>
		        <div class="form-check mb-3">
		            <input class="form-check-input" type="checkbox" name="senzaLattosio" id="senzaLattosio">
		            <label class="form-check-label" for="senzaLattosio">Senza lattosio</label>
		        </div>
                <div class="buttons">
                    <button type="button" id="closeBtn">Annulla</button>
                    <input type="submit" value="Invia">
                </div>
            </form>
        </div>

		<div id="popupCategoria">
			<form id="formCategoria" action="<%=request.getContextPath() %>/LogicaAggiungiCategoria" method="POST">
				<h3>Aggiungi Categoria</h3>
				<input type="text" name="nomeCat" placeholder="Nome Categoria" required>
				<input type="hidden" name="idRist" value="<%=u.getIdUtente()%>">
				<div class="buttons">
        			<button type="button" id="btnChiudiCategoria">Annulla</button>
        			<input type="submit" value="Invia">
        		</div>
			</form>
		</div>


        <div class="row gap-3 mt-5" id="sezione1">
            <div class="col-1 d-none d-md-block"></div>

            <!-- Colonna sinistra -->
            <div class="col-12 col-md-3 rounded-5 shadow" id="colonnasinistra">
                <h2 class="mb-4"><%=u.getNomeRistorante()%></h2>
                <!-- Immagine profilo ristorante con icona modifica -->
                <div class="ristorante-img-wrapper d-flex align-items-center gap-2 mb-4">
                    <img src="<%=u.getFoto() %>" alt="Foto Ristorante" class="img-fluid shadow-sm"
                        style="width: 150px; height: 150px; object-fit: cover; border-radius: 50%;">
                    <a href="#" class="text-decoration-none" title="Modifica Foto">
                    </a>
                </div>
                <p>
                    <i class="fa-solid fa-user me-2"></i><strong><%=u.getNome() %> <%=u.getCognome() %></strong>
                    <a href="#" class="text-decoration-none ms-2" title="Modifica Nome">
                    </a>
                </p>
                <p><i class="fa-solid fa-envelope me-2"></i><%=u.getEmail() %></p>
                <p>
                    <i class="fa-solid fa-key me-2"></i>********
                    <a href="#" class="text-decoration-none ms-2" title="Modifica Password">
                    </a>
                </p>
                <p><i class="fa-solid fa-location-dot me-2"></i><%=u.getIndirizzoRistorante() %></p>
                <p><i class="fa-solid fa-clock me-2"></i>10:00 - 22:30</p>
                <p><i class="fa-solid fa-star me-2 text-warning"></i><%=u.getVotoM() %> / 5</p>
                <a href="<%=request.getContextPath() %>/PaginaProfiloRistoratoreServlet" class="btn btn-success align-self-start mt-3 rounded-3">
                    Torna a Profilo Ristoratore
                </a>

            </div>
			
			<!-- Colonna destra -->
            <div class="col-12 col-md-7 rounded-5 shadow" id="colonnadestra">
                <%if (categorie!=null && !categorie.isEmpty()) { %>
                    <% for(Categoria c : categorie) { %>
                        <div class="mb-5 categoria-section">
                            <div class="categoria-header">
                                <h2><%=c.getNome() %></h2>
                                <div class="categoria-actions">
                                    <form action="<%=request.getContextPath() %>/RimuoviCategoria" method="post" 
                                          onsubmit="return confirm('Sei sicuro di voler eliminare la categoria <%=c.getNome()%> e tutte le sue portate?')">
                                        <input type="hidden" name="idCategoria" value="<%=c.getId()%>">
                                        <button type="submit" class="btn btn-danger btn-sm rounded-3">
                                            <i class="fa-solid fa-trash me-1"></i> Rimuovi
                                        </button>
                                    </form>
                                    <button type="button" class="btn btn-success btn-sm aggiungi-portata-btn rounded-3"
                                        data-sezione="<%=c.getId()%>">
                                        <i class="fa-solid fa-plus me-1"></i> Aggiungi
                                    </button>
                                </div>
                            </div>
                            
                            <% if(portate != null && !portate.isEmpty()) { 
                                boolean hasPortate = false;
                                for(Portata p : portate) { 
                                    if(p.getCategoria().getId() == c.getId()) { 
                                        hasPortate = true; %>
                                        <div class="card order-card flex-shrink-0 rounded-5 mb-3">
                                            <div class="card-body vertical-align-fix d-flex">
                                                <div class="immagine-card rounded-start-5 me-3">
                                                    <% if(p.getFoto()!=null) { %>
                                                        <img src="data:image/png;base64, <%= p.getBase64ImageString() %>" alt="Foto portata" class="rounded-start-5">
                                                    <% } else { %>
                                                        <img src="" alt="Foto portata" class="rounded-start-5">
                                                    <% } %>
                                                </div>
                                                <div class="order-details">
                                                    <p class="mb-2"><strong><%=p.getNome() %></strong></p>
                                                    <p class="mb-2"><%=p.getDescrizione() %></p>
                                                    <p class="mb-2">€ <%=String.format(Locale.ITALY, "%.2f", p.getPrezzo()) %></p>
                                                    <div class="portata-actions">
                                                        <form action="<%=request.getContextPath() %>/RimuoviPortata" method="post"
                                                              onsubmit="return confirm('Rimuovere questa portata dal menù?')">
                                                            <input type="hidden" name="idPortata" value="<%=p.getId() %>">
                                                            <button type="submit" class="btn btn-outline-danger btn-sm">
                                                                <i class="fa-solid fa-trash"></i> Rimuovi
                                                            </button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    <% } 
                                } 
                                if(!hasPortate) { %>
                                    <div class="alert alert-info">Nessuna portata in questa categoria</div>
                                <% }
                            } else { %>
                                <div class="alert alert-info">Nessuna portata in questa categoria</div>
                            <% } %>
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="alert alert-warning">Nessuna categoria disponibile</div>
                <% } %>
                
                <button type="button" id="btnApriCategoria" class="btn btn-primary mt-3">
                    <i class="fa-solid fa-plus me-1"></i> Aggiungi Nuova Categoria
                </button>
            </div>
        </div>
    </div>





    <!-- Footer -->
    <footer id="sezionefooter">
        <div class="container text-center text-md-start">
            <div class="row mt-3">
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Logo -->
                    <img src="<%=request.getContextPath()%>/res/logo_giallo.png" alt="" id="logofooter">
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


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/aggiungiPortata.js"></script>
    
</body>

</html>