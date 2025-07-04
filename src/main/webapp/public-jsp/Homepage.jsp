<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>EnjoEat</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Homepage.css" />
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
    integrity="sha512-...==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>

  <!-- Header -->
  <header id="scroll-header">
    <div class="logo">
      <a href="#">
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
    <div class="icone">
      <a href="<%=request.getContextPath() %>/LoginServlet" title="Profilo Utente"><i class="fa-solid fa-user" id="user-icon"></i></a>
      <a href="<%=request.getContextPath() %>/DiventaPartnerServlet" title="Profilo Ristoratore"><i class="fa-solid fa-shop" id="shop-icon"></i></a>
      <a href="#" title="Carrello"><i class="fa-solid fa-cart-shopping" id="cart-icon"></i></a>
    </div>
  </header>

  <!-- Sezione 1 - Video -->
  <div class="sezionevideo d-flex align-items-center justify-content-center text-center">
      <video autoplay muted loop playsinline>
      <source src="<%=request.getContextPath() %>/src/res/video2.mp4" type="video/mp4">
    </video>
      <div class="video-overlay"></div>
      <div class="video-content container">
          <h1 id="titolovideo">Il gusto è pronto. Tu quando arrivi?</h1>
          <p class="lead">Ordina online e passa a ritirare senza attese. EnjoEat è il
        tuo punto di riferimento per l’asporto veloce e delizioso.</p>
          <a href="#altro" id="primobtn" class="btn mt-2 btn-lg rounded-5 p-3">ORDINA SUBITO!</a>
          <a href="<%=request.getContextPath() %>/DiventaPartnerServlet" id="secondobtn" class="btn mt-2 btn-lg rounded-5 p-3">DIVENTA PARTNER</a>
        </div>
  </div>

  <div class="container-fluid">

    <!-- Sezione 2 - Card -->
    <div class="container-fluid">
      <div class="col-lg-12 text-center" id="haifame">
        <span id="sottotitolofame">IL PIACERE DI SCEGLIERE</span>
        <h2 class="mt-0 mb-3" id="h2cta">Cosa preferiresti mangiare?</h2>
      </div>
      <!-- Contenitore con padding laterale su desktop -->
      <div class="container-xl px-lg-5">
        <div class="row">
          <div id="sezionecard1" class="d-flex justify-content-center flex-wrap gap-3">
            <div class="card text-center rounded-5">
              <img class="card-img-top" src="<%=request.getContextPath() %>/src/res/pizzaa.jpg" alt="Pizza">
              <div class="card-body">
                <p class="card-text">Hai voglia di pizza? Scopri le migliori pizzerie vicino a te, ordina online e
                  rilassati: al resto pensiamo noi!</p>
                <a href="#" class="btn w-100 rounded-5">PIZZA</a>
              </div>
            </div>
            <div class="card text-center rounded-5">
              <img class="card-img-top" src="<%=request.getContextPath() %>/src/res/cardristorante.jpg" alt="Italiano">
              <div class="card-body">
                <p class="card-text">Hai voglia di cucina italiana? Dalle lasagne alla parmigiana, scegli il tuo piatto
                  e ritiralo subito!</p>
                <a href="#" class="btn w-100 rounded-5">ITALIANO</a>
              </div>
            </div>
            <div class="card text-center rounded-5">
              <img class="card-img-top" src="<%=request.getContextPath() %>/src/res/cardhamburger.jpg" alt="Hamburger">
              <div class="card-body">
                <p class="card-text">Hai voglia di hamburger? Panini succosi, patatine croccanti e salse irresistibili
                  a un clic da te.</p>
                <a href="#" class="btn w-100 rounded-5">HAMBURGER</a>
              </div>
            </div>
            <div class="card text-center rounded-5">
              <img class="card-img-top" src="<%=request.getContextPath() %>/src/res/cardsushi.jpg" alt="Orientale">
              <div class="card-body">
                <p class="card-text">Hai voglia di cucina orientale? Sushi, ramen e specialità asiatiche arrivano
                  fresche e pronte a sorprenderti.</p>
                <a href="#" class="btn w-100 rounded-5">ORIENTALE</a>
              </div>
            </div>
          </div>
        </div>
        <div class="row mt-3">
          <div id="sezionecard2" class="d-flex justify-content-center flex-wrap gap-3">
            <div class="card text-center rounded-5">
              <img class="card-img-top" src="<%=request.getContextPath() %>/src/res/cardkebab.jpg" alt="Kebab">
              <div class="card-body">
                <p class="card-text">Hai voglia di kebab? Scopri i migliori locali della zona e lasciati conquistare dai
                  loro sapori speziati.</p>
                <a href="#" class="btn w-100 rounded-5">KEBAB</a>
              </div>
            </div>
            <div class="card text-center rounded-5">
              <img class="card-img-top" src="<%=request.getContextPath() %>/src/res/cardolci.jpg" alt="Dolci">
              <div class="card-body">
                <p class="card-text">Hai voglia di dolci? Torte, gelati e tante golosità per addolcire ogni
                  momento della giornata.</p>
                <a href="#" class="btn w-100 rounded-5">DOLCI</a>
              </div>
            </div>
            <div class="card text-center rounded-5">
              <img class="card-img-top" src="<%=request.getContextPath() %>/src/res/cardhealthy.jpg" alt="Healthy">
              <div class="card-body">
                <p class="card-text">Hai voglia di mangiare sano? Bowl e piatti bilanciati per restare
                  leggero senza rinunciare al gusto.</p>
                <a href="#" class="btn w-100 rounded-5">HEALTHY</a>
              </div>
            </div>
            <div class="card text-center rounded-5">
              <img class="card-img-top" src="<%=request.getContextPath() %>/src/res/cardvino.jpg" alt="Vino">
              <div class="card-body">
                <p class="card-text">Hai voglia di qualcosa di buono? Scopri le nostre etichette selezionate e ritirale
                  quando vuoi.</p>
                <a href="#" class="btn w-100 rounded-5">VINO</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Sezione 3 - Vantaggi del nostro servizio -->
    <div class="row" id="sezionevantaggi">
      <div class="d-flex justify-content-center">
        <h2 id="h2vantaggi">I vantaggi del nostro servizio</h2>
      </div>
      <div class="col-12">
        <div class="row text-center">
          <div class="col-lg-4 col-md-6 col-12 mt-5">
            <i class="fas fa-bolt fa-4x"></i>
            <h5 class="mt-3 fs-3">Ritiro Veloce</h5>
            <p class="fs-5">Ordina online e ritira senza attese</p>
          </div>
          <div class="col-lg-4 col-md-6 col-12 mt-5">
            <i class="fas fa-lock fa-4x"></i>
            <h5 class="mt-3 fs-3">Pagamento Sicuro</h5>
            <p class="fs-5">Paga in app o al ritiro, in sicurezza</p>
          </div>
          <div class="col-lg-4 col-md-6 col-12 mt-5">
            <i class="fas fa-utensils fa-4x"></i>
            <h5 class="mt-3 fs-3">Ordini Personalizzati</h5>
            <p class="fs-5">Scegli ingredienti e preferenze</p>
          </div>
        </div>
      </div>
      <div class="col-12 d-flex justify-content-center mt-4">
        <a href="#" class="btn mt-2 btn-lg rounded-5 p-3" id="ctabtn">ORDINA SUBITO!</a>
      </div>
    </div>

    <!-- Sezione 4 - Recensioni -->
    <div class="row" id="rigarec">
      <h2 id="cosadicono">Cosa dicono di noi</h2>
      <div id="recensioniCarousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="4000"
        data-bs-pause="hover">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="recensione-card">
              <div class="recensione-left">
                <img src="<%=request.getContextPath() %>/src/res/ragazza1.jpg" alt="Profilo Anna Bianchi" class="recensione-img" />
                <h5 class="recensione-nome">Anna Bianchi</h5>
              </div>
              <div class="recensione-right">
                <div class="star-rating" aria-label="Valutazione: 5 su 5 stelle">
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                </div>
                <h5 class="recensione-titolo">Ottimo servizio!</h5>
                <p class="recensione-testo">
                  Sono rimasto molto soddisfatto dalla rapidità con cui è stato evaso il mio ordine e dalla
                  qualità eccellente del cibo ricevuto. Tutto è stato curato nei minimi dettagli, dalla
                  preparazione alla consegna. Consiglio vivamente questo servizio a chi cerca efficienza e
                  gusto senza compromessi!
                </p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="recensione-card">
              <div class="recensione-left">
                <img src="<%=request.getContextPath() %>/src/res/ragazzo2.jpg" alt="Profilo Marco Rossi" class="recensione-img" />
                <h5 class="recensione-nome">Marco Rossi</h5>
              </div>
              <div class="recensione-right">
                <div class="star-rating" aria-label="Valutazione: 4.5 su 5 stelle">
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star half">&#9733;</span>
                </div>
                <h5 class="recensione-titolo">Fantastico!</h5>
                <p class="recensione-testo">
                  Servizio impeccabile, dall’ordine alla consegna. Ho trovato l’interfaccia facile da usare e il cibo è
                  arrivato puntuale e ancora caldo. La qualità ha superato le mie aspettative, davvero un’esperienza da
                  ripetere. Complimenti per l’ottima organizzazione!
                </p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="recensione-card">
              <div class="recensione-left">
                <img src="<%=request.getContextPath() %>/src/res/ragazza2.jpg" alt="Profilo Laura Verdi" class="recensione-img" />
                <h5 class="recensione-nome">Laura Verdi</h5>
              </div>
              <div class="recensione-right">
                <div class="star-rating" aria-label="Valutazione: 5 su 5 stelle">
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star full">&#9733;</span>
                  <span class="star half">&#9733;</span>
                </div>
                <h5 class="recensione-titolo">Esperienza top</h5>
                <p class="recensione-testo">
                  EnjoEat è diventato il mio punto di riferimento per il cibo da asporto. Ordini semplici, tempi di
                  attesa
                  brevi
                  e piatti sempre gustosi. Apprezzo molto anche la possibilità di personalizzare ogni ordine. Ottima
                  soluzione per
                  chi ha poco tempo ma non vuole rinunciare alla qualità.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div> <!-- Chiusura Container-Fluid -->

  <!-- Footer -->

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
  <!-- Copyright -->
  <div class="d-flex align-items-center justify-content-center pt-3" id="sezionecopyright">
    <p id="testocopyright">Copyright © 2025 EnjoEat | All rights reserved.</p>
  </div>



  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="<%=request.getContextPath() %>/js/script_homepage.js"></script>
</body>

</html>