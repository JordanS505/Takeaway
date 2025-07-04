<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<%=request.getContextPath()%>/src/icon.png" type="image/png">
    <title>EnjoEat | Registrati</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	@font-face {
    		font-family: 'Rubik';
    		src: url('${pageContext.request.contextPath}/src/Rubik-Black.ttf') format('truetype');
		}
    	
    	h1, input[type="submit"] {
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

  <nav class="navbar mb-4" style="background-color: #c1280f">
        <div class="container-fluid" style="height:55px">
            <a href="<%=request.getContextPath()%>/HomePageServlet" class="navbar-brand">
            <img src="<%=request.getContextPath()%>/src/back-w.png" alt="back" width="24">
            <img src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="logo-black" height="32">
            </a>
        </div>
    </nav>

    <div class="container pt-5">
        <div class="row mb-3">
            <div class="col">
                <h1 class="mx-auto" style="max-width: 400px;">Registrati</h1>
            </div>
        </div>

        <form action="<%=request.getContextPath() %>/LogicaRegistrazione" method="POST">
        <div class="row mb-3">
            <div class="col mx-auto">
                <div class="d-flex justify-content-between mx-auto gap-3" style="max-width: 400px;">
                    <div class="w-50">
                        <label for="nome" class="form-label fw-bold small mb-1">Nome</label>
                        <input type="text" class="form-control rounded-4" id="nome" name="Nome" placeholder="Nome">
                    </div>
                    <div class="w-50">
                        <label for="cognome" class="form-label fw-bold small mb-1">Cognome</label>
                        <input type="text" class="form-control rounded-4" id="cognome" name="Cognome" placeholder="Cognome">
                    </div>
                </div>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col mx-auto">
                <div class="d-flex justify-content-between mx-auto gap-3" style="max-width: 400px;">
                    <div class="w-50">
                        <label for="username" class="form-label fw-bold small mb-1">Inserisci Username</label>
                        <input type="text" class="form-control rounded-4" id="username" name="Username" placeholder="Username">
                    </div>
                    <div class="w-50">
                        <label for="nascita" class="form-label fw-bold small mb-1">Inserisci Data di Nascita</label>
                        <input type="date" class="form-control rounded-4" name="Nascita" id="nascita">
                    </div>
                </div>
            </div>
        </div>


        <div class="row mb-3">
            <div class="col">
                <div class="mx-auto" style="max-width: 400px;">
                    <label for="email" class="form-label fw-bold small mb-1">Inserisci Email</label>
                    <input type="email" class="form-control w-100 rounded-4" id="email" name="Email" placeholder="Email">
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
        
        <% if (request.getParameter("error") != null && request.getParameter("error").equals("utenteEsistente")) { %>
		    <div class="row mb-3">
		        <div class="col text-center">
		            <p style="color:red;">Username già in uso. Scegli un altro.</p>
		        </div>
		    </div>
		<% } %>
		
		<% if (request.getParameter("error") != null && request.getParameter("error").equals("emailEsistente")) { %>
		    <div class="row mb-3">
		        <div class="col text-center">
		            <p style="color:red;">Email già registrata.</p>
		        </div>
		    </div>
		<% } %>
		
		<% if (request.getParameter("error")!= null && request.getParameter("error").equals("campiMancanti")) { %>
        	<div class="row mb-3">
            	<div class="col text-center">
                	<p style="color:red;">Compila tutti i campi per procedere con la registrazione</p>
            	</div>
        	</div>
    	<% } %>
		
		<% if (request.getParameter("error") != null && request.getParameter("error").equals("minorenne")) { %>
        <div class="row mb-3">
            <div class="col">
                <div class="mx-auto" style="max-width: 400px;">
                    <p style="color:red;">Devi avere più di 18 anni per registrarti</p>
                </div>
            </div>
        </div>
        <% } %>
        
        <% if (request.getParameter("error") != null && request.getParameter("error").equals("passwordDebole")) { %>
        <div class="row mb-3">
            <div class="col">
                <div class="mx-auto" style="max-width: 400px;">
                    <p style="color:red;">La password deve contenere una Maiuscola, una minuscola, un numero ed un carattere speciale</p>
                </div>
            </div>
        </div>
        <% } %>
        
        <% if (request.getParameter("error") != null && request.getParameter("error").equals("pswNC")) { %>
        <div class="row mb-3">
            <div class="col">
                <div class="mx-auto" style="max-width: 400px;">
                    <p style="color:red;">La password non coincide</p>
                </div>
            </div>
        </div>
        <% } %>
        
        <div class="row mb-3">
            <div class="col text-center">
                <input class="form-control mx-auto rounded-4 text-light" type="submit" id="tastoReg" value="Registrati" style="max-width: 400px; background-color:#c1280f">
            </div>
        </div>
        </form>
    	
    	<div class="row">
            <div class="col text-center">
            	<p class="text-muted small">Sei già registrato? <a href="<%=request.getContextPath()%>/LoginServlet" class="small">Accedi</a></p>
            </div>
        </div>
    </div>
    
    <footer class="bg-light text-center py-3 border-top mt-auto">
        <div class="container">
            <img src="<%=request.getContextPath()%>/src/icon.png" alt="icon" height="40">
            <small class="text-muted">&copy; 2025 EnjoEat. Tutti i diritti riservati.</small>
        </div>
    </footer>
    
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