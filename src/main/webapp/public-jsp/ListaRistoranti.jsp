<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="org.elis.model.Utente" %>
<%@ page import="org.elis.model.Tipologia" %>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<%Utente u = (Utente)session.getAttribute("UtenteLoggato"); %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<%=request.getContextPath()%>/src/icon.png" type="image/png">
    <title>EnjoEat | Ristoranti</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>	
    /* FOOTER */
	
	
	#logofooter {
	   width: 150px;
	   padding-bottom: 25px;
	}
	
	
	#sezionefooter {
	   background-color: #c1280f;
	   margin-top:100px;
	   padding-top: 40px;
	   padding-bottom: 10px;
	}
	
	
	#instagram-icon,
	#facebook-icon,
	#x-icon,
	#linkedin-icon {
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
	@media (max-width: 768px) {
	   .iconefooter {
	       justify-content: center !important;
	   }
	}
	    
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
	
	
	.hamburgerb {
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
		    
    
    
	body{
	font-family: 'Raleway';
	}
    
   	.img-ristorante {
	  width: 100%;
	}
	
	@media (min-width: 768px) {
	  .img-ristorante {
	    width: 40%;
	    max-width: 300px;
	  }
	}
    .posizione {
        font-size: 25px;
        padding-right: 8px;
    }
    
    .star-on {
    	color: #ff9b19;
	}
	
	@media (max-width: 768px) {
  .sidebar {
    position: static !important;
    top: auto !important;
  }
}
    </style>
</head>
<body>

    <!-- Header -->
    <header id="scroll-header">
    	<%if(u!=null){ %>
        <div class="logo">
            <a href="<%=request.getContextPath()%>/HomePageUtenteServlet">
                <img src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="Logo" />
            </a>
        </div>
        <%} else{%>
        <div class="logo">
            <a href="<%=request.getContextPath()%>/HomePageServlet">
                <img src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="Logo" />
            </a>
        </div>
        <%} %>
        <div class="hamburgerb" id="hamburgerb">
            <i class="fa-solid fa-bars"></i>
        </div>
        <nav class="navmenu" id="navmenu">
            <a href="#" class="mobile-only">Accedi</a>
            <a href="#" class="mobile-only">Diventa Partner</a>
            <a href="#" class="mobile-only">Iscrizione Utente</a>
        </nav>
        <div class="icone">
        	<%if(u!=null){ %>
            <a href="<%=request.getContextPath() %>/ProfiloUtenteServlet" title="Profilo Utente"><i class="fa-solid fa-user" id="user-icon"></i></a>
            <%}else{ %>
             <a href="<%=request.getContextPath() %>/LoginServlet" title="Login"><i class="fa-solid fa-user" id="user-icon"></i></a>
             <%} %>
            <%if(u!=null)
            if(u.getRuolo().name().equalsIgnoreCase("ristoratore")){ %>
            <a href="<%=request.getContextPath() %>/PaginaProfiloRistoratoreServlet" title="Profilo Ristoratore"><i class="fa-solid fa-shop" id="shop-icon"></i></a>
            <%} %>
            <%if(u!=null){ %>
            <a href="<%=request.getContextPath() %>/LogoutServlet" title="Logout"><i class="fa-solid fa-right-from-bracket" id="cart-icon"></i></a>
            <%} %>
        </div>
    </header>


    <div class="container-fluid">
        <div class="row gx-3 gap-4">
			<div class="col"></div>
            <!-- Sidebar -->
            <div class="sidebar col-12 col-md-3 mb-3 border-0 rounded-5 p-0 shadow" style="position: sticky; top: 75px; height: fit-content;">
			  <div>
			    <h5 class="fw-bold mt-3 mb-3 text-center">Filtro per tipologia</h5>
			    <div class="row mt-2 ms-2">
			      <div class="col d-flex flex-column">
			        <div class="form-check">
			          <input class="form-check-input filtroTipologia" type="checkbox" value="Pizzeria" id="Pizzeria">
			          <label class="form-check-label" for="Pizzeria">Pizzeria</label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input filtroTipologia" type="checkbox" value="Italiana" id="Italiana">
			          <label class="form-check-label" for="Italiana">Italiana</label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input filtroTipologia" type="checkbox" value="Kebab" id="Kebab">
			          <label class="form-check-label" for="Kebab">Kebab</label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input filtroTipologia" type="checkbox" value="Dolci" id="Dolci">
			          <label class="form-check-label" for="Dolci">Dolci</label>
			        </div>
			      </div>
			      <div class="col d-flex flex-column">
			        <div class="form-check">
			          <input class="form-check-input filtroTipologia" type="checkbox" value="Orientale" id="Orientale">
			          <label class="form-check-label" for="Orientale">Orientale</label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input filtroTipologia" type="checkbox" value="Vino" id="Vino">
			          <label class="form-check-label" for="Vino">Vino</label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input filtroTipologia" type="checkbox" value="Hamburger" id="Hamburger">
			          <label class="form-check-label" for="Hamburger">Hamburger</label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input filtroTipologia" type="checkbox" value="Healthy" id="Healthy">
			          <label class="form-check-label" for="Healthy">Healthy</label>
			        </div>
			      </div>
			    </div>
			
			    <h5 class="fw-bold mt-4 text-center">Filtro per voto</h5>
			    <div class="row mt-2 ms-2">
			      <div class="col d-flex flex-column">
			        <div class="form-check">
			          <input class="form-check-input filtroVoto" type="checkbox" value="3" id="voto3">
			          <label class="form-check-label" for="voto3">3+ stelle</label>
			        </div>
			        <div class="form-check">
			          <input class="form-check-input filtroVoto" type="checkbox" value="4" id="voto4">
			          <label class="form-check-label" for="voto4">4+ stelle</label>
			        </div>
			        <div class="form-check mb-3">
			          <input class="form-check-input filtroVoto" type="checkbox" value="5" id="voto5">
			          <label class="form-check-label" for="voto5">Solo 5 stelle</label>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>

            <!-- Contenuto principale -->
            <div class="col-12 p-0 col-md-7">
                
                
                <%
				    List<Utente> ristoranti = (List<Utente>) request.getAttribute("ristoranti");
				    if (ristoranti != null) {
				        for (Utente r : ristoranti) {
				%>
				    <div class="card w-100 flex-column flex-md-row p-0 border-0 rounded-5 overflow-hidden mb-3 shadow<%
					    List<Tipologia> tipologiec = r.getTipologie();
					    if (tipologiec != null && !tipologiec.isEmpty()) {
					        for (Tipologia t : tipologiec) {
					            String cleanTipo = t.getNome().trim().replaceAll("\\s+", "-").toLowerCase();
					            out.print(" " + cleanTipo);
					        }
					    }
					%>"
					data-rating="<%= r.getVotoM() != null ? (r.getVotoM()) : 0 %>">
					<%if(r.getFoto()!=null){ %>
				        <img src="data:image/png;base64, <%= r.getBase64ImageString() %>"
				             alt="Foto ristorante"
				             class="img-fluid flex-shrink-0 img-ristorante"
				             style="object-fit: cover; height: 200px;">
				    <%} else{%>
				    	<img src=""
				             alt="Foto ristorante"
				             class="img-fluid flex-shrink-0 img-ristorante"
				             style="object-fit: cover; height: 200px;">
				    <%} %>
				        <div class="card-body d-flex flex-column justify-content-center flex-grow-1">
				            <h3 class="card-title fw-bold"><%= r.getNomeRistorante() %></h3>
				            <%
							    List<Tipologia> tipologie = r.getTipologie();
							    if (tipologie != null && !tipologie.isEmpty()) {
							        for (Tipologia t : tipologie) {
							%>
							    <span class="form control bg-light border rounded-5 me-1 text-center" style="min-width:80px; max-width:120px;"><%= t.getNome() %></span>
							<%
							        }
							    } 
							%>
				            <div class="d-flex align-items-center">
				                <div class="rating mt-2">

				                	
				                    <% int voto = r.getVotoM() != null ? (int) Math.round(r.getVotoM()) : 0;
				                       for (int i = 0; i < 5; i++) { %>
				                        <i class="fa-solid fa-star <%= i < voto ? "star-on" : "text-secondary" %>"></i>
				                    <% } %>
				                    
				                    
				                </div>
				                <span class="ms-2 rating-value mt-2"><%= r.getVotoM() %></span>
				            </div>
				            <div class="row pt-2">
				                <div class="col-8 d-flex align-items-center">
				                    <i class="posizione fa-solid fa-location-dot"></i>
				                    <span><%= r.getIndirizzoRistorante() %></span>
				                </div>
				                <div class="col-4 d-flex justify-content-end">
				                    <a href="<%=request.getContextPath()%>/PaginaRistorante?indirizzo=<%= URLEncoder.encode(r.getIndirizzoRistorante(), "UTF-8") %>" class="btn btn-primary rounded-5 border-0" style="width: 150px; background-color: #c1280f;">Ordina</a>
				                </div>
				            </div>
				        </div>
				    </div>
				<%
				        }
				    }
				%>
            
            
            
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
    

    <script>
    document.addEventListener('DOMContentLoaded', function () {
        const urlParams = new URLSearchParams(window.location.search);
        const tipologiaParam = urlParams.get('filtro');

        const filtriTipologia = [];
        const filtriVoto = [];

        const checkboxTipologia = document.querySelectorAll('.filtroTipologia');
        const checkboxVoto = document.querySelectorAll('.filtroVoto');
        const cards = document.querySelectorAll('.card');

        function aggiornaFiltri() {
            for (let i = 0; i < cards.length; i++) {
                const card = cards[i];
                const classiCard = Array.from(card.classList);
                const rating = parseInt(card.dataset.rating) || 0;

                let mostraPerTipologia = filtriTipologia.length === 0;
                for (let j = 0; j < filtriTipologia.length; j++) {
                    if (classiCard.includes(filtriTipologia[j])) {
                        mostraPerTipologia = true;
                        break;
                    }
                }

                let mostraPerVoto = filtriVoto.length === 0;
                for (let k = 0; k < filtriVoto.length; k++) {
                    if (rating >= filtriVoto[k]) {
                        mostraPerVoto = true;
                        break;
                    }
                }

                card.style.display = (mostraPerTipologia && mostraPerVoto) ? 'flex' : 'none';
            }
        }

        function aggiornaArrayFiltro(array, valore, checked) {
            const index = array.indexOf(valore);
            if (checked && index === -1) {
                array.push(valore);
            } else if (!checked && index !== -1) {
                array.splice(index, 1);
            }
        }

        checkboxTipologia.forEach(cb => {
            cb.addEventListener('change', function () {
                const valore = this.value.trim().toLowerCase().replace(/\s+/g, '-');
                aggiornaArrayFiltro(filtriTipologia, valore, this.checked);
                aggiornaFiltri();
            });
        });

        checkboxVoto.forEach(cb => {
            cb.addEventListener('change', function () {
                const valore = parseInt(this.value, 10);
                if (!isNaN(valore)) {
                    aggiornaArrayFiltro(filtriVoto, valore, this.checked);
                    aggiornaFiltri();
                }
            });
        });

        if (tipologiaParam) {
            const tipologiaUrl = tipologiaParam.trim().toLowerCase();
            checkboxTipologia.forEach(cb => {
                if (cb.value.trim().toLowerCase() === tipologiaUrl) {
                    cb.checked = true;
                    aggiornaArrayFiltro(filtriTipologia, tipologiaUrl, true);
                }
            });

            aggiornaFiltri();
        }

    });
	</script>
</body>
</html>