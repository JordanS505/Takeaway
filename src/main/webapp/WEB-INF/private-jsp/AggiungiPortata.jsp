<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.elis.model.*"%>
<%@ page import="java.util.Locale"%>
<!DOCTYPE html>
<html lang="it">

<%
Utente u = (Utente) request.getAttribute("ristoranteScelto");
%>
<%
List<Portata> p = (List<Portata>) request.getAttribute("listaPortate");
%>
<%
List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aggiungi portata</title>
    <!-- CSS -->
    <link rel="stylesheet" href="../css/aggiungi-portata.css" />
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

        <div class="row d-flex justify-content-center align-items-center">
            <div class="col-12 text-center">
                <h1 id="primotitolo">Aggiorna il tuo <strong>Menù</strong> in pochi clic!</h1>

            </div>
        </div>
        <!-- Popup Form -->
        <div id="popup">
            <form id="form">
                <h3>Aggiungi portata</h3>
                <input type="text" name="nome" placeholder="Nome" required>
                <textarea name="descrizione" placeholder="Descrizione (ingredienti)" required></textarea>
                <input type="number" name="prezzo" step="0.01" min="0" placeholder="Prezzo (€)" required>
                <input type="file" name="foto" accept="image/*" required>
                <div class="buttons">
                    <button type="button" id="closeBtn">Annulla</button>
                    <button type="submit">Salva</button>
                </div>
            </form>
        </div>




        <div class="row gap-3 mt-5" id="sezione1">
            <div class="col-1 d-none d-md-block"></div>

            <!-- Colonna sinistra -->
            <div class="col-12 col-md-3 rounded-5 shadow" id="colonnasinistra">
                <h2 class="mb-4">Nome Ristorante</h2>
                <!-- Immagine profilo ristorante con icona modifica -->
                <div class="ristorante-img-wrapper d-flex align-items-center gap-2 mb-4">
                    <img src="../res/pizzeria1.jpg" alt="Foto Ristorante" class="img-fluid shadow-sm"
                        style="width: 150px; height: 150px; object-fit: cover; border-radius: 50%;">
                    <a href="#" class="text-decoration-none" title="Modifica Foto">
                    </a>
                </div>
                <p>
                    <i class="fa-solid fa-user me-2"></i><strong>MarioRisto</strong>
                    <a href="#" class="text-decoration-none ms-2" title="Modifica Nome">
                    </a>
                </p>
                <p><i class="fa-solid fa-envelope me-2"></i>mario@example.com</p>
                <p>
                    <i class="fa-solid fa-key me-2"></i>********
                    <a href="#" class="text-decoration-none ms-2" title="Modifica Password">
                    </a>
                </p>
                <p><i class="fa-solid fa-location-dot me-2"></i>Via Roma 123, Milano</p>
                <p><i class="fa-solid fa-clock me-2"></i>10:00 - 22:30</p>
                <p><i class="fa-solid fa-star me-2 text-warning"></i>4.5 / 5</p>
                <button type="button" class="btn btn-success align-self-start mt-3 rounded-3">
                    Torna a Profilo Ristoratore
                </button>

            </div>

            <!-- Colonna destra: PORTATE -->
            <div class="col-12 col-md-7 rounded-5 shadow" id="colonnadestra">
                <h2 class="mb-4">Pizze Classiche</h2>
                <button type="button" class="btn btn-success btn-sm aggiungi-portata-btn mb-3 rounded-3"
                    data-sezione="pizze-classiche">
                    <i class="fa-solid fa-plus me-1"></i> Aggiungi Portata
                </button>


                <!-- PIZZE CLASSICHE -->

                <div class="card order-card flex-shrink-0 rounded-0">
                    <!-- PRIMA CARD -->
                    <div class="card-body vertical-align-fix">
                        <div class="immagine-card">
                            <img src="../res//cardpizza.jpg" alt="Foto Margherita">
                        </div>
                        <div class="order-details">
                            <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i><strong>Margherita</strong></p>
                            <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i>Pomodoro, Mozzarella, Basilico</p>
                            <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>6,0</p>
                        </div>
                        <div class="order-meta">
                            <button type="button" class="btn btn-danger">
                                <i class="fa-solid fa-trash me-2"></i> Rimuovi
                            </button>
                        </div>
                    </div>

                    <hr>
                    <div class="card-body vertical-align-fix">
                        <div class="immagine-card">
                            <img src="../res//cardpizza.jpg" alt="Foto Margherita">
                        </div>
                        <div class="order-details">
                            <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i><strong>Marinara</strong></p>
                            <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i>Pomodoro, Basilico</p>
                            <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>5,5</p>
                        </div>
                        <div class="order-meta">
                            <button type="button" class="btn btn-danger">
                                <i class="fa-solid fa-trash me-2"></i> Rimuovi
                            </button>
                        </div>
                    </div>
                </div>

                <!-- SEZIONE: PIZZE SPECIALI -->
                <h2 class="mb-4 mt-5">Pizze Speciali</h2>
                <button type="button" class="btn btn-success btn-sm aggiungi-portata-btn mb-3 rounded-3"
                    data-sezione="pizze-classiche">
                    <i class="fa-solid fa-plus me-1"></i> Aggiungi Portata
                </button>

                <div class="card order-card flex-shrink-0 rounded-0">
                    <div class="card-body vertical-align-fix">
                        <div class="immagine-card">
                            <img src="../res//cardpizza.jpg" alt="Foto Margherita">
                        </div>
                        <div class="order-details">
                            <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i><strong>Bufalina</strong></p>
                            <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i>Pomodoro, Mozzarella di Bufala,
                                Basilico</p>
                            <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>8,5</p>
                        </div>
                        <div class="order-meta">
                            <button type="button" class="btn btn-danger">
                                <i class="fa-solid fa-trash me-2"></i> Rimuovi
                            </button>
                        </div>
                    </div>
                    <hr>
                    <div class="card-body vertical-align-fix">
                        <div class="immagine-card">
                            <img src="../res//cardpizza.jpg" alt="Foto Margherita">
                        </div>
                        <div class="order-details">
                            <p class="mb-2"><i class="fa-solid fa-utensils me-2"></i><strong>Tartufo</strong></p>
                            <p class="mb-2"><i class="fa-solid fa-receipt me-2"></i>Cremoso al tartufo, funghi porcini
                            </p>
                            <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>9,0</p>
                        </div>
                        <div class="order-meta">
                            <button type="button" class="btn btn-danger">
                                <i class="fa-solid fa-trash me-2"></i> Rimuovi
                            </button>
                        </div>
                    </div>
                </div>

                <!-- SEZIONE: BIBITE -->
                <h2 class="mb-4 mt-5">Bibite</h2>
                <button type="button" class="btn btn-success btn-sm aggiungi-portata-btn mb-3 rounded-3"
                    data-sezione="pizze-classiche">
                    <i class="fa-solid fa-plus me-1"></i> Aggiungi Bibita
                </button>

                <div class="card order-card flex-shrink-0 rounded-0">
                    <div class="card-body vertical-align-fix">
                        <div class="immagine-card">
                            <img src="../res//cardpizza.jpg" alt="Foto Margherita">
                        </div>
                        <div class="order-details">
                            <p class="mb-2"><i class="fa-solid fa-bottle-droplet me-2"></i></i><strong>Acqua</strong>
                            </p>
                            <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>1,5</p>
                        </div>
                        <div class="order-meta">
                            <button type="button" class="btn btn-danger">
                                <i class="fa-solid fa-trash me-2"></i> Rimuovi
                            </button>
                        </div>
                    </div>
                    <hr>
                    <div class="card-body vertical-align-fix">
                        <div class="immagine-card">
                            <img src="../res//cardpizza.jpg" alt="Foto Margherita">
                        </div>
                        <div class="order-details">
                            <p class="mb-2"><i class="fa-solid fa-bottle-droplet me-2"></i></i><strong>Coca
                                    Cola</strong>
                            </p>
                            <p class="mb-2"><i class="fa-solid fa-euro-sign me-2"></i>2,5</p>
                        </div>
                        <div class="order-meta">
                            <button type="button" class="btn btn-danger">
                                <i class="fa-solid fa-trash me-2"></i> Rimuovi
                            </button>
                        </div>
                    </div>
                </div>

                <button type="button" class="btn btn-success mb-3 mt-4 rounded-3">
                    <i class="fa-solid fa-plus me-1"></i> Aggiungi Categoria
                </button>


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


    <!-- Popup Conferma Elimina Portata-->
    <div id="popupElimina">
        <div class="popup-box">
            <p>Sei sicuro di rimuovere la portata selezionata?</p>
            <div class="popup-buttons">
                <button id="cancelDelete" class="btn btn-secondary">Annulla</button>
                <button id="confirmDelete" class="btn btn-danger">Elimina</button>
            </div>
        </div>
    </div>
    <!-- Messaggio conferma eliminazione -->
    <div id="notificaEliminata">La tua portata è stata eliminata!</div>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/aggiungi-portata.js"></script>
</body>

</html>