<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
   <!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Profilo Utente</title>
    <!-- CSS -->
    <link rel="stylesheet" href="../css/profilo-utente.css" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Raleway&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
        crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>

    <!-- Header -->
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

    <div class="container-fluid">

        <div class="row">
            <div class="col-12">
                <h1 class="text-center" id="primotitolo">Benvenuto nella tua area personale, <b>Alberto Rossi</b>.
                </h1>
            </div>
        </div>

        <div class="row gap-3" id="sezione1">
            <div class="col-1 d-none d-md-block"></div>

            <!-- Colonna sinistra -->
            <div class="col-12 col-md-3 rounded-5 shadow" id="colonnasinistra">
                <h2 class="mb-4">Alberto Rossi</h2>

                <p>
                    <i class="fa-solid fa-user me-2"></i><strong>AlbRoss95</strong>
                    <a href="#" class="text-decoration-none ms-2" title="Modifica Nome">
                        <i class="fa-solid fa-pen-to-square" id="iconamodifica"></i>
                    </a>
                </p>
                <p><i class="fa-solid fa-envelope me-2"></i>albertorossi_95@gmail.com</p>
                <p>
                    <i class="fa-solid fa-key me-2"></i>********
                    <a href="#" class="text-decoration-none ms-2" title="Modifica Password">
                        <i class="fa-solid fa-pen-to-square" id="iconamodifica"></i>
                    </a>
                </p>
            </div>

            <!-- Colonna destra: ORDINI -->
            <div class="col-12 col-md-7 d-flex flex-column gap-4">

                <!-- ORDINI IN TEMPO REALE -->
                <div class="rounded-5 pt-4 pb-5 px-4 shadow" id="colonnatemporeale">
                    <h2 class="mb-4">ORDINI IN TEMPO REALE</h2>
                    <div class="order-carousel-wrapper position-relative">
                        <button class="carousel-arrow left-arrow" id="scrollLeft" aria-label="Scorri a sinistra">
                            <i class="fa-solid fa-chevron-left"></i>
                        </button>
                        <div class="order-carousel d-flex flex-nowrap overflow-auto gap-3" id="carouselOrders">

                            <!-- Card 1 -->
                            <div class="card order-card flex-shrink-0 rounded-5">
                                <div
                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
                                    <div class="order-details">
                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#10234</strong>
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-shop me-2"></i>Mario Rossi</p>
                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>Pizza Margherita, Coca
                                            Cola, Supplì</p>
                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>24,90</p>
                                    </div>
                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
                                        <span class="badge bg-primary mb-2"><i
                                                class="fa-solid fa-hourglass-half me-1"></i>Ordinato</span>
                                        <p><b>Ora </b>12:30</p>
                                    </div>
                                </div>
                            </div>

                            <!-- Card 2 -->
                            <div class="card order-card flex-shrink-0 rounded-5">
                                <div
                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
                                    <div class="order-details">
                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#10235</strong>
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-shop me-2"></i>Laura Bianchi</p>
                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>Insalata Greca, Acqua
                                            Naturale</p>
                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>16,00</p>
                                    </div>
                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
                                        <span class="badge bg-primary mb-2"><i
                                                class="fa-solid fa-hourglass-half me-1"></i>Ordinato</span>
                                        <p><b>Ora </b>13:05</p>
                                    </div>
                                </div>
                            </div>

                            <!-- Card 3 -->
                            <div class="card order-card flex-shrink-0 rounded-5">
                                <div
                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
                                    <div class="order-details">
                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#10236</strong>
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-shop me-2"></i>Giuseppe Verdi</p>
                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>Lasagna, Tiramisu, Vino
                                            Rosso</p>
                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>32,00</p>
                                    </div>
                                    <div class="order-meta text-md-end text-start mt-md-0">
                                        <span class="badge bg-primary mb-2"><i
                                                class="fa-solid fa-hourglass-half me-1"></i>Ordinato</span>
                                        <p><b>Ora </b>20:30</p>
                                    </div>
                                </div>
                            </div>

                            <!-- Card 4 -->
                            <div class="card order-card flex-shrink-0 rounded-5">
                                <div
                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
                                    <div class="order-details">
                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#10237</strong>
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-shop me-2"></i>Sara Neri</p>
                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>Panino Veg, Succo ACE
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>12,50</p>
                                    </div>
                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
                                        <span class="badge bg-primary mb-2"><i
                                                class="fa-solid fa-hourglass-half me-1"></i>Ordinato</span>
                                        <p><b>Ora </b>21:05</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-arrow right-arrow" id="scrollRight" aria-label="Scorri a destra">
                            <i class="fa-solid fa-chevron-right"></i>
                        </button>
                    </div>
                </div>

                <!-- STORICO ORDINI -->
                <div class="rounded-5 pt-4 pb-5 px-4 shadow" id="colonnastorico">
                    <h2 class="mb-4">STORICO ORDINI</h2>
                    <div class="order-carousel-wrapper position-relative">
                        <button class="carousel-arrow left-arrow" id="scrollLeft2" aria-label="Scorri a sinistra">
                            <i class="fa-solid fa-chevron-left"></i>
                        </button>
                        <div class="order-carousel d-flex flex-nowrap overflow-auto gap-3" id="carouselPreparing">

                            <!-- Card 1 -->
                            <div class="card order-card flex-shrink-0 rounded-5">
                                <div
                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
                                    <div class="order-details">
                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#10235</strong>
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-shop me-2"></i>Laura Bianchi</p>
                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>Insalata Greca, Acqua
                                            Naturale</p>
                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>16,00</p>
                                    </div>
                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
                                        <span class="badge bg-success mb-2"><i class="fa-solid fa-check-circle me-1">
                                            </i>Ritirato</span>
                                        <p><b>Ora </b>13:10</p>
                                    </div>
                                </div>
                                <!-- Bottone centrato in basso con stella bianca -->
                                <div class="recensione-footer text-center">
                                    <button class="badge bg-success text-white border-0 mb-3 visualizzaRecensioneBtn"
                                        style="font-size: 0.9rem; cursor: pointer;"
                                        data-recensione="Ottimo servizio e cibo delizioso!" data-rating="4">
                                        <i class="fa-solid fa-star me-1 text-white"></i>Visualizza recensione
                                    </button>
                                </div>
                            </div>

                            <!-- Card 2 -->
                            <div class="card order-card flex-shrink-0 rounded-5">
                                <div
                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
                                    <div class="order-details">
                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#10239</strong>
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-shop me-2"></i>Chiara Gallo</p>
                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>Risotto ai Funghi,
                                            Acqua Frizzante</p>
                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>22,50</p>
                                    </div>
                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
                                        <span class="badge bg-success mb-2"><i class="fa-solid fa-check-circle me-1">
                                            </i>Ritirato</span>
                                        <p><b>Ora </b>12:20</p>
                                    </div>
                                </div>
                                <!-- Bottone centrato in basso con stella bianca -->
                                <div class="recensione-footer text-center">
                                    <button class="badge bg-warning text-white border-0 mb-3 scriviRecensioneBtn"
                                        style="font-size: 0.9rem; cursor: pointer;">
                                        <i class="scriviRecensioneBtn fa-solid fa-star me-1 text-white"></i>Scrivi
                                        recensione
                                    </button>
                                </div>
                            </div>

                            <!-- Card 3 -->
                            <div class="card order-card flex-shrink-0 rounded-5">
                                <div
                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
                                    <div class="order-details">
                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#10240</strong>
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-shop me-2"></i>Federico Neri</p>
                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>Tagliatelle al Ragù,
                                            Vino Bianco</p>
                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>27,00</p>
                                    </div>
                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
                                        <span class="badge bg-success mb-2"><i class="fa-solid fa-check-circle me-1">
                                            </i>Ritirato</span>
                                        <p><b>Ora </b>20:10</p>
                                    </div>
                                </div>
                                <!-- Bottone centrato in basso con stella bianca -->
                                <div class="recensione-footer text-center">
                                    <button class="badge bg-success text-white border-0 mb-3 visualizzaRecensioneBtn"
                                        style="font-size: 0.9rem; cursor: pointer;"
                                        data-recensione="Consegna puntuale e personale cortese." data-rating="5">
                                        <i class="fa-solid fa-star me-1 text-white"></i>Visualizza recensione
                                    </button>
                                </div>
                            </div>

                            <!-- Card 4 -->
                            <div class="card order-card flex-shrink-0 rounded-5">
                                <div
                                    class="card-body d-flex flex-column flex-md-row justify-content-between align-items-start">
                                    <div class="order-details">
                                        <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i><strong>#10241</strong>
                                        </p>
                                        <p class="mb-2"><i class="fa-solid fa-shop me-2"></i>Martina Rizzo</p>
                                        <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i>Pollo al Curry, Riso
                                            Basmati</p>
                                        <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>21,90</p>
                                    </div>
                                    <div class="order-meta text-md-end text-start mt-3 mt-md-0">
                                        <span class="badge bg-success mb-2"><i class="fa-solid fa-check-circle me-1">
                                            </i>Ritirato</span>
                                        <p><b>Ora </b>20:10</p>
                                    </div>
                                </div>
                                <!-- Bottone centrato in basso con stella bianca -->
                                <div class="recensione-footer text-center">
                                    <button class="badge bg-warning text-white border-0 mb-3 scriviRecensioneBtn"
                                        style="font-size: 0.9rem; cursor: pointer;">
                                        <i class="scriviRecensioneBtn fa-solid fa-star me-1 text-white"></i>Scrivi
                                        recensione
                                    </button>
                                </div>
                            </div>

                        </div>
                        <button class="carousel-arrow right-arrow" id="scrollRight2" aria-label="Scorri a destra">
                            <i class="fa-solid fa-chevron-right"></i>
                        </button>
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

    <!-- Popup MOSTRA recensione-->
    <div id="recensionePopup" class="popup-overlay">
        <div class="popup-content">
            <div id="ratingVisualizza"></div>
            <p id="contenutoRecensione"></p>
            <button id="chiudiPopup">Chiudi</button>
        </div>
    </div>


    <!-- Popup SCRIVI recensione-->
    <div id="scriviRecensionePopup" class="popup-overlay">
        <div class="popup-content">
            <button id="chiudiScriviPopup">Chiudi</button>
            <h3>Scrivi la tua recensione</h3>
            <div id="ratingStars" class="rating-stars">
                <i class="star fa-solid fa-star" data-value="1"></i>
                <i class="star fa-solid fa-star" data-value="2"></i>
                <i class="star fa-solid fa-star" data-value="3"></i>
                <i class="star fa-solid fa-star" data-value="4"></i>
                <i class="star fa-solid fa-star" data-value="5"></i>
            </div>
            <textarea id="inputRecensione" rows="4" placeholder="Scrivi qui la tua recensione..."
                class="rounded-3"></textarea>
            <button id="inviaRecensione">Invia recensione</button>
        </div>
    </div>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/profilo-utente.js"></script>
</body>

</html>