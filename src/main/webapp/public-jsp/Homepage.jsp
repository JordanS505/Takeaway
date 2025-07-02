<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<%=request.getContextPath()%>/src/icon.png" type="image/png">
    <title>EnjoEat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">
    
    <nav class="navbar bg-light mb-4">
        <div class="container-fluid">
            <a href="<%=request.getContextPath()%>/HomePageServlet" class="navbar-brand">
            <img src="<%=request.getContextPath()%>/src/enjoEat-b.png" alt="logo-black" height="40">
            </a>
            
            <div class="d-flex gap-2">
            <a href="<%=request.getContextPath()%>/DiventaPartnerServlet" class="btn btn-outline-secondary btn-sm d-flex align-items-center justify-content-center rounded-4" style="width: 150px; height: 36px;">
                <img src="<%=request.getContextPath()%>/src/shop.png" alt="shop"class="me-2">
                <span class="small text-black fw-bold">Diventa Partner</span>
            </a>

            <a href="<%=request.getContextPath()%>/LoginServlet" class="btn btn-outline-secondary btn-sm d-flex align-items-center justify-content-center rounded-4" style="width: 150px; height: 36px;">
                <img src="<%=request.getContextPath()%>/src/account.png" alt="account" class="me-2">
                <span class="small text-black fw-bold">Accedi</span>
            </a>
        </div>
        </div>
    </nav>

    prova
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>