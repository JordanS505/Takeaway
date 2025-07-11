<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<%=request.getContextPath()%>/src/icon.png" type="image/png">
    <title>EnjoEat Accedi | Entra</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
    <style>
    	
    	body {
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

<body class="d-flex flex-column min-vh-100 bg-light">
    
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
	   	
	   		<div class="col rounded-5 shadow bg-white" style="max-width:500px">
	   		
	   		
		        <div class="row mt-2 mb-2">
		            <div class="col">
		                <h1 class="mx-auto" style="max-width: 400px;">Accedi</h1>
		            </div>
		        </div>
		
		        <form action="<%=request.getContextPath() %>/LogicaLogin" method="POST">
		        <div class="row mb-3">
		            <div class="col">
		                <div class="mx-auto" style="max-width: 400px;">
		                    <label for="email" class="form-label fw-bold small mb-1">Inserisci Email</label>
		                    <input type="email" class="form-control w-100 rounded-5" id="email" name="email" placeholder="Email">
		                </div>
		            </div>
		        </div>
		
		        <div class="row mb-3">
		            <div class="col">
		                <div class="mx-auto" style="max-width: 400px;">
		                    <label for="password" class="form-label fw-bold small mb-1">Inserisci password</label>
		                    <div class="d-flex">
						        <input type="password" class="form-control rounded-5 rounded-end-0" id="password" name="Password" placeholder="Password" style="flex-grow:1;">
						        <button type="button" class="btn btn-outline-secondary  rounded-5 rounded-start-0 border border-light-subtle" id="togglePassword" aria-label="Mostra o nascondi password">
						          <img id="eyeIcon" src="<%=request.getContextPath()%>/src/eye.png" alt="Mostra password" style="width: 24px; height: 24px;">
						        </button>
						    </div>
		                </div>
		            </div>
		        </div>
				
				<% if (request.getParameter("error") != null && request.getParameter("error").equals("autenticazione fallita")) { %>
				<div class="row mb-3">
					<div class="col mx-auto text-center">
						<p style="color:red;">Email o password errate!</p>
					</div>
				</div>
		        	
		    	<% } %>
				
		        <div class="row mb-3">
		            <div class="col text-center">
		                <input class="form-control mx-auto rounded-5 text-light" id="tastoEntra" type="submit" value="Entra" style="max-width: 400px; background-color: #c1280f">
		            </div>
		        </div>
		        </form>
		
		        <div class="row">
		            <div class="col text-center ">
		                <a href="<%=request.getContextPath()%>/ResetPasswordServlet" class=" small">Hai dimenticato la password?</a>
		            </div>
		        </div>
		
		        <div class="row mb-3">
		            <div class="col text-center">
		                <div class="d-flex align-items-center justify-content-center my-3" style="max-width: 400px; margin: 0 auto;">
		                    <div class="flex-grow-1 border-top"></div>
		                        <span class="mx-2 text-muted small">Non hai ancora un account?</span>
		                    <div class="flex-grow-1 border-top"></div>
		                </div>
		                <a href="<%=request.getContextPath()%>/Registrazione" class="btn btn-outline-secondary rounded-5 w-100 mx-auto fw-bold" id="tastoCreaAcc" style="max-width: 400px;">Crea un Account</a>
		            </div>
		        </div>
	        
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