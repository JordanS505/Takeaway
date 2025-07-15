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
		
		
		.hamburger {
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
</head>

<body class="d-flex flex-column min-vh-100 bg-light">
    
    <header id="scroll-header">
       <div class="logo">
           <a href="#">
               <img src="../res/logo-bianco.png" alt="Logo" />
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

    <div class="container d-flex flex-column min-vh-100 bg-light  mt-5 mb-5">
	   	<div class="row justify-content-center">
	   	
	   		<div class="col rounded-5 shadow bg-white" style="max-width:500px">
	   		
	   		
		        <div class="row mt-2 mb-2">
		            <div class="col">
		                <h1 class="mx-auto fw-bold" style="max-width: 400px;">Accedi</h1>
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
    
    <footer id="sezionefooter">
	    <div class="container text-center text-md-start">
	      <div class="row mt-3">
	        <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
	          <!-- Logo -->
	          <img src="<%=request.getContextPath()%>/src/res/logo_giallo.png" alt="" id="logofooter">
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
	          <p><a href="<%=request.getContextPath() %>/LoginServlet" class="text-reset text-decoration-none">Profilo Utente</a></p>
	          <p><a href="/LoginServlet" class="text-reset text-decoration-none">Profilo Ristoratore</a></p>
	          <p><a href="#" class="text-reset text-decoration-none">Carrello</a></p>
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