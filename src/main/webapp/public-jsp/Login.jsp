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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
    integrity="sha512-...==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="<%=request.getContextPath()%>/css/Login.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/js/Login.js" rel="stylesheet">

</head>

<body class="d-flex flex-column" style="background-image: url('<%=request.getContextPath() %>/src/res/Frame 12.png')">
<header id="scroll-header">
    <div class="logo">
      <a href="<%= request.getContextPath()%>/HomePageServlet">
        <img src="<%=request.getContextPath() %>/src/res/logo-bianco.png" alt="Logo" />
      </a>
    </div>
    <div class="hamburger" id="hamburger">
      <i class="fa-solid fa-bars"></i>
    </div>
    <nav class="navmenu" id="navmenu">
      <a href="<%=request.getContextPath() %>/LoginServlet" class="mobile-only">Accedi</a>
      <a href="<%=request.getContextPath() %>/DiventaPartnerServlet" class="mobile-only">Diventa Partner</a>
      <a href="<%=request.getContextPath() %>/Registrazione" class="mobile-only">Iscrizione Utente</a>
    </nav>
  </header>

	<div class="container d-flex flex-column" id="contenuto" >
		<div class="row justify-content-center">

			<div class="col rounded-5 shadow bg-white" style="max-width: 500px">


				<div class="row mt-4 mb-2">
					<div class="col">
						<h1 class="mx-auto fw-bold" style="max-width: 400px;">Accedi</h1>
					</div>
				</div>

				<form action="<%=request.getContextPath()%>/LogicaLogin"
					method="POST">
					<div class="row mb-3">
						<div class="col">
							<div class="mx-auto" style="max-width: 400px;">
								<label for="email" class="form-label fw-bold small mb-1">Inserisci
									Email</label> <input type="email" class="form-control w-100 rounded-5"
									id="email" name="email" placeholder="Email">
							</div>
						</div>
					</div>

					<div class="row mb-3">
						<div class="col">
							<div class="mx-auto" style="max-width: 400px;">
								<label for="password" class="form-label fw-bold small mb-1">Inserisci
									password</label>
								<div class="d-flex">
									<input type="password"
										class="form-control rounded-5 rounded-end-0" id="password"
										name="Password" placeholder="Password" style="flex-grow: 1;">
									<button type="button"
										class="btn btn-outline-secondary  rounded-5 rounded-start-0 border border-light-subtle"
										id="togglePassword" aria-label="Mostra o nascondi password">
										<img id="eyeIcon"
											src="<%=request.getContextPath()%>/src/eye.png"
											alt="Mostra password" style="width: 24px; height: 24px;">
									</button>
								</div>
							</div>
						</div>
					</div>

					<%
					if (request.getParameter("error") != null && request.getParameter("error").equals("autenticazione fallita")) {
					%>
					<div class="row mb-3">
						<div class="col mx-auto text-center">
							<p style="color: red;">Email o password errate!</p>
						</div>
					</div>

					<%
					}
					%>

					<div class="row mb-3">
						<div class="col text-center">
							<input class="form-control mx-auto rounded-5 text-light"
								id="tastoEntra" type="submit" value="Entra"
								style="max-width: 400px; background-color: #c1280f">
						</div>
					</div>
				</form>

				<div class="row">
					<div class="col text-center ">
						<a href="<%=request.getContextPath()%>/ResetPasswordServlet"
							class=" small">Hai dimenticato la password?</a>
					</div>
				</div>

				<div class="row mb-3">
					<div class="col text-center">
						<div class="d-flex align-items-center justify-content-center my-3"
							style="max-width: 400px; margin: 0 auto;">
							<div class="flex-grow-1 border-top"></div>
							<span class="mx-2 text-muted small">Non hai ancora un
								account?</span>
							<div class="flex-grow-1 border-top"></div>
						</div>
						<a href="<%=request.getContextPath()%>/Registrazione"
							class="btn btn-outline-secondary rounded-5 w-100 mx-auto fw-bold mb-4"
							id="tastoCreaAcc" style="max-width: 400px;">Crea un Account</a>
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
					<img src="<%=request.getContextPath()%>/src/res/logo_giallo.png" alt="Logo" id="logofooter" />
					<p id="fame">Entra in Enjoeat: che tu voglia ordinare o
						diventare partner, sei nel posto giusto.</p>
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
					<p><a href="<%=request.getContextPath() %>/ChiSiamoServlet" class="text-reset text-decoration-none">Chi siamo</a></p>
			          <p><a href="<%=request.getContextPath() %>/FAQServlet" class="text-reset text-decoration-none">FAQ</a></p>
			          <p><a href="<%=request.getContextPath() %>/ContattiServlet" class="text-reset text-decoration-none">Contatti</a></p>
			        </div>
			        <!-- Colonna Profili -->
			        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
			          <h6 class="text-uppercase fw-bold mb-4">
			            Profili
			          </h6>
			          <p><a href="<%=request.getContextPath() %>/LoginServlet" class="text-reset text-decoration-none">Profilo Utente</a></p>
			          <p><a href="<%=request.getContextPath() %>/LoginServlet" class="text-reset text-decoration-none">Profilo Ristoratore</a></p>
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
	<div class="d-flex align-items-center justify-content-center pt-3"
		id="sezionecopyright">
		<p id="testocopyright">Copyright © 2025 EnjoEat | All rights
			reserved.</p>
	</div>

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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>