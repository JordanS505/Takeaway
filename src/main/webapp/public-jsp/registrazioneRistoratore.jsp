<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="org.elis.model.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<%=request.getContextPath()%>/src/icon.png" type="image/png">
    <title>EnjoEat | Registrati</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
    #containerTipologie .row {
        margin-bottom: 10px;
    }
    #containerTipologie .col-6 {
        padding-left: 10px;
        padding-right: 5px;
    }
    
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
    
</style>
<body class="d-flex flex-column min-vh-100">

    <nav class="navbar mb-4" style="background-color: #c1280f">
        <div class="container-fluid" style="height:55px">
            <a href="<%=request.getContextPath()%>/HomePageServlet" class="navbar-brand">
            <img src="<%=request.getContextPath()%>/src/back-w.png" alt="back" width="24">
            <img src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="logo-black" height="32">
            </a>
        </div>
    </nav>

    <div class="container pt-5">
    
    <div class="row justify-content-center">
		<div class="col rounded-5 shadow bg-white" style="max-width: 500px">
	        <div class="row mt-3 mb-3">
	            <div class="col">
	                <h1 class="mx-auto" style="max-width: 400px;">Registrati</h1>
	            </div>
	        </div>
	
	        <form action="<%=request.getContextPath() %>/LogicaDiventaPartner" enctype="multipart/form-data" method="POST">
	            <!-- Nome e Cognome -->
	            <div class="row mb-3">
	                <div class="col mx-auto">
	                    <div class="d-flex justify-content-between mx-auto gap-3" style="max-width: 400px;">
	                        <div class="w-50">
	                            <label for="nome" class="form-label fw-bold small mb-1">Nome</label>
	                            <input type="text" class="form-control rounded-4" id="nome" name="Nome" placeholder="Nome">
	                        </div>
	                        <div class="w-50">
	                            <label for="cognome" class="form-label fw-bold small mb-1">Cognome</label>
	                            <input type="text" class="form-control rounded-4" id="cognome" name="Cognome"
	                                placeholder="Cognome">
	                        </div>
	                    </div>
	                </div>
	            </div>
	
	            <!-- Username e Data Nascita -->
	            <div class="row mb-3">
	                <div class="col mx-auto">
	                    <div class="d-flex justify-content-between mx-auto gap-3" style="max-width: 400px;">
	                        <div class="w-50">
	                            <label for="username" class="form-label fw-bold small mb-1">Inserisci Username</label>
	                            <input type="text" class="form-control rounded-4" id="username" name="Username"
	                                placeholder="Username">
	                        </div>
	                        <div class="w-50">
	                            <label for="nascita" class="form-label fw-bold small mb-1">Inserisci Data di Nascita</label>
	                            <input type="date" class="form-control rounded-4" name="Nascita" id="nascita">
	                        </div>
	                    </div>
	                </div>
	            </div>
	
	            <!-- Nome Ristorante -->
	            <div class="row mb-3">
	                <div class="col">
	                    <div class="mx-auto" style="max-width: 400px;">
	                        <label for="nomeristorante" class="form-label fw-bold small mb-1">Inserisci nome ristorante</label>
	                        <input type="text" class="form-control w-100 rounded-4" id="nomeristorante"
	                            name="Nomeristorante" placeholder="Nome ristorante">
	                    </div>
	                </div>
	            </div>
	
	            <!-- Indirizzo Ristorante -->
	            <div class="row mb-3">
	                <div class="col">
	                    <div class="mx-auto" style="max-width: 400px;">
	                        <label for="indirizzoristorante" class="form-label fw-bold small mb-1">Inserisci indirizzo ristorante</label>
	                        <input type="text" class="form-control w-100 rounded-4" id="indirizzoristorante"
	                            name="Indirizzoristorante" placeholder="Indirizzo ristorante">
	                    </div>
	                </div>
	            </div>
	            
	            <!-- Foto Ristorante  -->
	            <div class="row mb-3">
	            	<div class="col text">
	            		<div class="mx-auto" style="max-width: 400px;">
	            			<input class="form-control w-100 rounded-4" type="file" name="fileFoto"></input>
	            		</div>
	            	</div>
	            </div>
	
	            <!-- ✅ Categorie (checkbox centrate) -->
				<div class="row mb-3">
				    <div class="col">
				        <div class="mx-auto" style="max-width: 400px;">
				            <label class="form-label fw-bold small mb-2">Scegli le categorie:</label>
				
				            <!-- Contenitore principale per le checkbox -->
				            <div id="containerTipologie">
				                <!-- Checkbox per le tipologie esistenti dal database -->
				                <div class="row">
				                    <%
				                        List<Tipologia> tipologieDisponibili = (List<Tipologia>) request.getAttribute("tipologieDisponibili");
				                        if (tipologieDisponibili != null) {
				                            int counter = 0;
				                            for (Tipologia tipologia : tipologieDisponibili) {
				                                if (counter % 2 == 0 && counter > 0) {
				                                    out.print("</div><div class=\"row\">");
				                                }
				                    %>
				                    <div class="col-6">
				                        <div class="form-check">
				                            <input class="form-check-input" type="checkbox" name="Categorie" 
				                                   value="<%= tipologia.getNome() %>" id="<%= tipologia.getNome().toLowerCase() %>">
				                            <label class="form-check-label" for="<%= tipologia.getNome().toLowerCase() %>">
				                                <%= tipologia.getNome() %>
				                            </label>
				                        </div>
				                    </div>
				                    <%
				                                counter++;
				                            }
				                        }
				                    %>
				                </div>
				            </div>
				
				            <!-- Campo per aggiungere una nuova tipologia -->
							<div class="mt-3">
							    <div class="input-group">
							        <input type="text" class="form-control rounded-5 rounded-end-0" id="nuovaTipologia" 
							               placeholder="Aggiungi nuova tipologia">
							        <button class="btn btn-outline-secondary border-1 rounded-end-4" type="button" 
							                onclick="aggiungiTipologia()">Aggiungi</button>
							    </div>
							</div>
				        </div>
				    </div>
				</div>
	
	
	            <!-- Email -->
	            <div class="row mb-3">
	                <div class="col">
	                    <div class="mx-auto" style="max-width: 400px;">
	                        <label for="email" class="form-label fw-bold small mb-1">Inserisci Email</label>
	                        <input type="email" class="form-control w-100 rounded-4" id="email" name="Email"
	                            placeholder="Email">
	                    </div>
	                </div>
	            </div>
	
	            <div class="row mb-3">
		            <div class="col">
		                <div class="mx-auto" style="max-width: 400px;">
		                    <label for="password" class="form-label fw-bold small mb-1">Inserisci password</label>
		                    <div class="d-flex">
						        <input type="password" class="form-control rounded-4 rounded-end-0" id="password" name="Password" placeholder="Password" style="flex-grow:1;">
						        <button type="button" class="btn btn-outline-secondary  rounded-4 rounded-start-0 border border-light-subtle" id="togglePassword" aria-label="Mostra o nascondi password">
						          <img id="eyeIcon" src="<%=request.getContextPath()%>/src/eye.png" alt="Mostra password" style="width: 24px; height: 24px;">
						        </button>
						    </div>
		                    <div class="progress mt-2" style="height: 10px;">
							    <div id="strengthBar" class="progress-bar" role="progressbar" style="width: 0%;"></div>
							</div>
							<small id="strengthText" class="fw-bold"></small>
		                </div>
		            </div>
		        </div>
		
				<div class="row mb-3">
		            <div class="col">
		                <div class="mx-auto" style="max-width: 400px;">
		                    <label for="confirmPassword" class="form-label fw-bold small mb-1">Inserisci password</label>
						    <input type="password" class="form-control rounded-4" id="confirmPassword" name="confirmPassword" placeholder="Password" style="flex-grow:1;">
		                </div>
		            </div>
		        </div>
	            
	
	            <!-- Bottone Registrati -->
	            <div class="row mb-3">
	                <div class="col text-center">
	                	<div class="mx-auto" style="max-width: 400px;">
	                    	<input class="form-control mx-auto rounded-4 text-light" type="submit" value="Registrati" style="max-width: 400px; background-color: #c1280f">
	                    </div>
	                </div>
	            </div>
	            
	            
	            
	        </form>
	
	        <!-- Messaggi di errore -->
	        <% if (request.getAttribute("erroreMinorenne") != null) { %>
	            <div class="row mb-3">
	                <div class="col text-center">
	                    <p style="color:red;">Devi avere almeno 18 anni per registrarti.</p>
	                </div>
	            </div>
	        <% } %>
	
	        <% if (request.getAttribute("erroreGenerico") != null) { %>
	            <div class="row mb-3">
	                <div class="col text-center">
	                    <p style="color:red;">
	                        <%= request.getAttribute("erroreGenerico") %>
	                    </p>
	                </div>
	            </div>
	        <% } %>
	
	        <!-- Link login -->
	        <div class="row">
	            <div class="col text-center">
	                <p class="text-muted small">Sei già registrato? <a href="<%=request.getContextPath()%>/LoginServlet" class="small">Accedi</a></p>
	            </div>
	        </div>
		</div>
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
	function aggiungiTipologia() {
	    const nuovaTipologia = document.getElementById('nuovaTipologia').value.trim();
	    if (nuovaTipologia === '') {
	        alert('Inserisci un nome per la nuova tipologia');
	        return;
	    }
	    
	    // Genera un ID valido
	    const idTipologia = nuovaTipologia.toLowerCase().replace(/\s+/g, '-');
	    
	    // Trova il container delle tipologie
	    const container = document.getElementById('containerTipologie');
	    if (!container) {
	        console.error('Container delle tipologie non trovato');
	        return;
	    }
	    
	    // Trova tutte le righe esistenti
	    const rows = container.getElementsByClassName('row');
	    let lastRow = rows.length > 0 ? rows[rows.length - 1] : null;
	    
	    // Se non ci sono righe o l'ultima riga ha già 2 colonne, crea una nuova riga
	    if (!lastRow || lastRow.getElementsByClassName('col-6').length >= 2) {
	        lastRow = document.createElement('div');
	        lastRow.className = 'row';
	        container.appendChild(lastRow);
	    }
	    
	    // Crea la nuova colonna
	    const newCol = document.createElement('div');
	    newCol.className = 'col-6';
	    
	    // Crea la checkbox e il label
	    const formCheck = document.createElement('div');
	    formCheck.className = 'form-check';
	    
	    const input = document.createElement('input');
	    input.type = 'checkbox';
	    input.className = 'form-check-input';
	    input.name = 'Categorie';
	    input.value = nuovaTipologia;
	    input.id = idTipologia;
	    input.checked = true;
	    
	    const label = document.createElement('label');
	    label.className = 'form-check-label';
	    label.htmlFor = idTipologia;
	    label.textContent = nuovaTipologia;
	    
	    // Assembla gli elementi
	    formCheck.appendChild(input);
	    formCheck.appendChild(label);
	    newCol.appendChild(formCheck);
	    lastRow.appendChild(newCol);
	    
	    // Pulisci il campo di input
	    document.getElementById('nuovaTipologia').value = '';
	    
	    // Invia la nuova tipologia al server
	    fetch('<%=request.getContextPath()%>/AggiungiTipologiaServlet', {
	        method: 'POST',
	        headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	        },
	        body: 'nome=' + encodeURIComponent(nuovaTipologia)
	    }).catch(error => {
	        console.error('Errore durante il salvataggio:', error);
	    });
	}
	

	let input=document.getElementById('password')
	let toggleBtn = document.getElementById("togglePassword");
	let eyeIcon = document.getElementById("eyeIcon");
	let passwordInput = document.getElementById("password");


	toggleBtn.addEventListener("click", function () {
	    if (passwordInput.type === "password") {
	        passwordInput.type = "text";
	        eyeIcon.src = "<%=request.getContextPath()%>/src/eyeoff.png";
	    } else {
	        passwordInput.type = "password";
	        eyeIcon.src = "<%=request.getContextPath()%>/src/eye.png";
	    }
	});
	
	document.getElementById("password").addEventListener("input", function() {
	    const pwd = this.value;
	    const bar = document.getElementById("strengthBar");
	    const text = document.getElementById("strengthText");
	
	    let sicurezza = 0;
	    if (pwd.length >= 8) sicurezza++;
	    if (/[A-Z]/.test(pwd)) sicurezza++;
	    if (/[a-z]/.test(pwd)) sicurezza++;
	    if (/\d/.test(pwd)) sicurezza++;
	    if (/[\W_]/.test(pwd)) sicurezza++;
	
	    const perc = (sicurezza / 5) * 100;
	    bar.style.width = perc + "%";
	
	    bar.classList.remove("bg-danger", "bg-warning", "bg-info", "bg-success");
	
	    if (sicurezza <= 2) {
	        bar.classList.add("bg-danger");
	        text.textContent = "Sicurezza: debole";
	        text.style.color = "#dc3545";
	    } else if (sicurezza === 3) {
	        bar.classList.add("bg-warning");
	        text.textContent = "Sicurezza: debole";
	        text.style.color = "#ffc107";
	    } else if (sicurezza === 4) {
	        bar.classList.add("bg-info");
	        text.textContent = "Sicurezza: buona";
	        text.style.color = "#17a2b8";
	    } else {
	        bar.classList.add("bg-success");
	        text.textContent = "Sicurezza: ottima";
	        text.style.color = "#28a745";
	    }
	});
	
	</script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
 
 </body>
