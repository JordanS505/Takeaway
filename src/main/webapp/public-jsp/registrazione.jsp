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
    	
    	h1, #tastoReg {
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

    <nav class="navbar bg-light mb-4">
        <div class="container-fluid">
            <a href="<%=request.getContextPath()%>/HomePageServlet" class="navbar-brand">
            <img src="<%=request.getContextPath()%>/src/back.png" alt="back" width="24">
            <img src="<%=request.getContextPath()%>/src/enjoEat-b.png" alt="logo-black" height="40">
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
                    <input type="password" class="form-control w-100 rounded-4" id="password" name="Password" placeholder="Password">
                </div>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col text-center">
                <input class="form-control border-dark mx-auto border-2 rounded-4 bg-success text-light" type="submit" id="tastoReg" value="Registrati" style="max-width: 400px;">
            </div>
        </div>
        </form>
        
        <% if (request.getParameter("error")!= null && request.getParameter("error").equals("campiMancanti")) { %>
        	<div class="row mb-3">
            	<div class="col text-center">
                	<p style="color:red;">Compila tutti i campi per procedere con la registrazione!</p>
            	</div>
        	</div>
    	<% } %>

    	<% if (request.getAttribute("erroreGenerico") != null) { %>
    		<div class="row mb-3">
            	<div class="col text-center">
                	<p style="color:red;"><%= request.getAttribute("erroreGenerico") %></p>
            	</div>
        	</div>
    	<% } %>
    	
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>