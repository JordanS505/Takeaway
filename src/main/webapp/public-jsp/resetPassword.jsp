<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="<%=request.getContextPath()%>/src/icon.png" type="image/png">
    <title>EnjoEat | Reset Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    	@font-face {
    		font-family: 'Rubik';
    		src: url('${pageContext.request.contextPath}/src/Rubik-Black.ttf') format('truetype');
		}
    	
    	h1, #tastoCreaAcc, input[type="submit"] {
    		font-family: 'Rubik', sans-serif;
    	}
    	
	    input[type="submit"] {
	    	transition: filter 0.2s ease;
	    }
	    input[type="submit"]:hover {
	    	filter: brightness(115%);
	     	cursor: pointer;
	    }
    </style>
</head>
<body class="d-flex flex-column min-vh-100">

  <nav class="navbar bg-success mb-4">
        <div class="container-fluid">
            <a href="<%=request.getContextPath()%>/HomePageServlet" class="navbar-brand">
            <img src="<%=request.getContextPath()%>/src/back-w.png" alt="back" width="24">
            <img src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="logo-black" height="40">
            </a>
        </div>
    </nav>

    <div class="container pt-5">
        <div class="row mb-3">
            <div class="col">
                <h1 class="mx-auto" style="max-width: 400px;">Reset Password</h1>
            </div>
        </div>
	</div>
	
	<%-- Primo step: inserimento email --%>
	<% if (request.getParameter("step") == null || "1".equals(request.getParameter("step"))) { %>
	    <form action="<%=request.getContextPath() %>/ResetPasswordServlet" method="POST">
	        <input type="hidden" name="step" value="1" />
	        
	        <div class="row mb-3">
	            <div class="col">
	                <div class="mx-auto" style="max-width: 400px;">
	                    <label for="Email" class="form-label fw-bold small mb-1">Inserisci Email</label>
	                    <input type="email" class="form-control w-100 rounded-4" id="Email" name="Email" placeholder="Email" value="<%= request.getParameter("Email") != null ? request.getParameter("Email") : "" %>">
	                </div>
	            </div>
	        </div>
	        
	        <% if ("campiMancanti".equals(request.getParameter("error"))) { %>
	            <div class="row mb-3 text-center text-danger">
	                Inserisci Email per procedere
	            </div>
	        <% } else if ("notFound".equals(request.getParameter("error"))) { %>
	            <div class="row mb-3 text-center text-danger">
	                Nessun utente trovato con questa email.
	            </div>
	        <% } else if ("serverError".equals(request.getParameter("error"))) { %>
	            <div class="row mb-3 text-center text-danger">
	                Errore del server, riprova più tardi.
	            </div>
	        <% } %>
	        
	        <div class="row mb-3">
	            <div class="col text-center">
	                <input class="form-control mx-auto rounded-4 bg-success text-light" type="submit" value="Controlla Email" style="max-width: 400px;">
	            </div>
	        </div>
	    </form>
	    
	    
	<% } else if ("2".equals(request.getParameter("step"))) { %>
	
	<%-- Secondo step: inserimento nuova password --%>
	    <form action="<%=request.getContextPath() %>/ResetPasswordServlet" method="POST">
	        <input type="hidden" name="step" value="2" />
	
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
	
	        <% if ("vuoti".equals(request.getParameter("error"))) { %>
	            <div class="row mb-3 text-center text-danger">
	                Compila entrambi i campi password.
	            </div>
	        <% } else if ("diverse".equals(request.getParameter("error"))) { %>
	            <div class="row mb-3 text-center text-danger">
	                Le password non corrispondono.
	            </div>
	        <% } else if ("serverError".equals(request.getParameter("error"))) { %>
	            <div class="row mb-3 text-center text-danger">
	                Errore del server, riprova più tardi.
	            </div>
	        <% } else if ("sessionExpired".equals(request.getParameter("error"))) { %>
	            <div class="row mb-3 text-center text-danger">
	                Sessione scaduta. Torna indietro e reinserisci email.
	            </div>
	        <% } %>
	
	        <div class="row mb-3">
	            <div class="col text-center">
	                <input class="form-control mx-auto rounded-4 bg-success text-light" type="submit" value="Aggiorna Password" style="max-width: 400px;">
	            </div>
	        </div>
	    </form>
	<% } %>

<script>
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
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>
