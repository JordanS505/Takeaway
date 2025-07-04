<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<%=request.getContextPath()%>/src/icon.png" type="image/png">
    <title>EnjoEat | Ristoranti</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>
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
    <nav class="navbar mb-4" style="background-color: #c1280f;">
        <div>
            <a href="<%=request.getContextPath()%>/HomePageServlet" class="navbar-brand">
                <img src="<%=request.getContextPath()%>/src/back.png" alt="back" width="24">
                <img src="<%=request.getContextPath()%>/src/enjoEat-w.png" alt="logo-black" height="40">
            </a>
        </div>
    </nav>

    <div class="container">
        <div class="row gx-3">

            <!-- Sidebar -->
            <div class="col-12 col-md-3 mb-3 border-0 rounded-5 bg-white shadow">
               
            </div>

            <!-- Contenuto principale -->
            <div class="col-12 col-md-9">
                
                
                <div class="card w-100 d-flex flex-column flex-md-row p-0 border-0 rounded-5 overflow-hidden mb-3" data-rating="3" style="box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);">
                    <img src="<%=request.getContextPath()%>/src/mc.jpg"
					     alt="Immagine Ristorante"
					     class="img-fluid flex-shrink-0 img-ristorante" 
     					 style="object-fit: cover; height: 200px;">
                    <div class="card-body d-flex flex-column justify-content-center flex-grow-1">
                        <h3 class="card-title">McDonald's</h3>
                        <p class="card-text mb-1 border rounded-5 text-center fw-bold text-secondary" style="width: 100px;">fast-food</p>
                        <div class="d-flex align-items-center">
                            <div class="rating">
                                <i class="fa-solid fa-star text-secondary"></i>
                                <i class="fa-solid fa-star text-secondary"></i>
                                <i class="fa-solid fa-star text-secondary"></i>
                                <i class="fa-solid fa-star text-secondary"></i>
                                <i class="fa-solid fa-star text-secondary"></i>
                            </div>
                            <span class="ms-2 rating-value"></span>
                        </div>
                        <div class="row pt-2">
                            <div class="col-8">
                                <div class="d-flex align-items-center">
                                    <i class="posizione fa-solid fa-location-dot"></i>
                                    <span>Via Palmiro Togliatti, 28</span>
                                </div>
                            </div>
                            <div class="col-4 d-flex justify-content-end">
                                <a href="#" class="btn btn-primary rounded-5 border-0" style="width: 150px; background-color: #ff9b19;">Ordina</a>
                            </div>
                        </div>                        
                    </div>
                </div>
            
            
            
            </div>

        </div>
    </div>

    <script>
    document.addEventListener('DOMContentLoaded', () => {
        const cards = document.querySelectorAll('.card[data-rating]');
        
        cards.forEach(card => {
            const ratingValue = parseInt(card.dataset.rating);
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

            if (ratingText) {
                ratingText.textContent = ratingValue + '/5';
            }
        });
    });
    </script>
</body>
</html>