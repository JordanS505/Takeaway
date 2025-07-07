<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="org.elis.model.Utente" %>
<%@ page import="org.elis.model.Tipologia" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<%=request.getContextPath()%>/src/icon.png" type="image/png">
    <title>EnjoEat | Ristoranti</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>	
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
    </style>
</head>
<body class="bg-light">

    <nav class="navbar mb-4" style="background-color: #c1280f">
        <div class="container-fluid" style="height:55px">
            <a href="<%=request.getContextPath()%>/HomePageServlet" class="navbar-brand">
            <img src="<%=request.getContextPath()%>/src/back-w.png" alt="back" width="24">
            <img src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="logo-black" height="32">
            </a>
        </div>
    </nav>


    <div class="container">
        <div class="row gx-3">

            <!-- Sidebar -->
            <div class="col-12 col-md-3 mb-3 border-0 rounded-5 bg-white shadow" style="height: 50vh;">
            	<div>
            		<h5 class="fw-bold">Filtro per tipologia</h5>
            		
            		<input class="form-check-input filtro-checkbox" type="checkbox" value="Pizzeria" id="Pizzeria">
					<label class="form-check-label" for="Pizzeria">Pizzeria</label>
					
					<input class="form-check-input filtro-checkbox" type="checkbox" value="Italiana" id="Italiana">
					<label class="form-check-label" for="Italiana">Italiana</label>
					
					<input class="form-check-input filtro-checkbox" type="checkbox" value="Kebab" id="Kebab">
					<label class="form-check-label" for="Kebab">Kebab</label>
					
					<input class="form-check-input filtro-checkbox" type="checkbox" value="Dolci" id="Dolci">
					<label class="form-check-label" for="Dolci">Dolci</label>
					
					<input class="form-check-input filtro-checkbox" type="checkbox" value="Orientale" id="Orientale">
					<label class="form-check-label" for="Orientale">Orientale</label>
					
					<input class="form-check-input filtro-checkbox" type="checkbox" value="Vino" id="Vino">
					<label class="form-check-label" for="Vino">Vino</label>
					
					<input class="form-check-input filtro-checkbox" type="checkbox" value="Hamburger" id="Hamburger">
					<label class="form-check-label" for="Hamburger">Hamburger</label>
					
					<input class="form-check-input filtro-checkbox" type="checkbox" value="Healthy" id="Healthy">
					<label class="form-check-label" for="Healthy">Healthy</label>
            	</div>
            </div>

            <!-- Contenuto principale -->
            <div class="col-12 col-md-9">
                
                
                <%
				    List<Utente> ristoranti = (List<Utente>) request.getAttribute("ristoranti");
				    if (ristoranti != null) {
				        for (Utente r : ristoranti) {
				%>
				    <div class="card w-100 d-flex flex-column flex-md-row p-0 border-0 rounded-5 overflow-hidden mb-3" 
				data-tipologie="<%
				    if (r.getTipologie() != null && !r.getTipologie().isEmpty()) {
				        for (int i = 0; i < r.getTipologie().size(); i++) {
				            out.print(r.getTipologie().get(i).getNome());
				            if (i < r.getTipologie().size() - 1) out.print(",");
				        }
				    }
				%>"
				    
				    style="box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);">
				        <img src="<%= r.getFoto() %>"
				             alt="Foto ristorante"
				             class="img-fluid flex-shrink-0 img-ristorante"
				             style="object-fit: cover; height: 200px;">
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
							    } else {
							%>
							    <span class="text-muted fst-italic">Nessuna tipologia</span>
							<%
							    }
							%>
				            <div class="d-flex align-items-center">
				                <div class="rating">

				                	
				                    <% int voto = r.getVotoM() != null ? (int) Math.round(r.getVotoM()) : 0;
				                       for (int i = 0; i < 5; i++) { %>
				                        <i class="fa-solid fa-star <%= i < voto ? "star-on" : "text-secondary" %>"></i>
				                    <% } %>
				                    
				                    
				                </div>
				                <span class="ms-2 rating-value"><%= voto %>/5</span>
				            </div>
				            <div class="row pt-2">
				                <div class="col-8 d-flex align-items-center">
				                    <i class="posizione fa-solid fa-location-dot"></i>
				                    <span><%= r.getIndirizzoRistorante() %></span>
				                </div>
				                <div class="col-4 d-flex justify-content-end">
				                    <a href="#" class="btn btn-primary rounded-5 border-0" style="width: 150px; background-color: #c1280f;">Ordina</a>
				                </div>
				            </div>
				        </div>
				    </div>
				<%
				        }
				    }
				%>
            
            
            
            </div>

        </div>
    </div>

    <script>
    document.addEventListener('DOMContentLoaded', () => {
        const checkboxes = document.querySelectorAll('.filtro-checkbox');
        const cards = document.querySelectorAll('.card[data-tipologie]');
        
        // Filtro per tipologie
        checkboxes.forEach(cb => {
            cb.addEventListener('change', () => {
                const selezionati = Array.from(checkboxes)
                    .filter(cb => cb.checked)
                    .map(cb => cb.value.toLowerCase());

                cards.forEach(card => {
                    const tipi = card.dataset.tipologie.toLowerCase().split(",");
                    const mostra = selezionati.length === 0 || selezionati.some(sel => tipi.includes(sel));
                    card.style.display = mostra ? 'flex' : 'none';
                });
            });
        });

        // Gestione stelle rating (se vuoi usare data-rating)
        cards.forEach(card => {
            const ratingValue = parseInt(card.dataset.rating);
            if (!isNaN(ratingValue)) {
                const stars = card.querySelectorAll('.rating i');
                const ratingText = card.querySelector('.rating-value');
                stars.forEach((star, index) => {
                    if (index < ratingValue) {
                        star.classList.add('star-on');
                        star.classList.remove('text-secondary');
                    } else {
                        star.classList.remove('star-on');
                        star.classList.add('text-secondary');
                    }
                });
                if (ratingText) ratingText.textContent = ratingValue + '/5';
            }
        });
    });
    </script>
</body>
</html>