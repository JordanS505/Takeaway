
// Hamburger menu toggle
const hamburger = document.getElementById('hamburger');
const navmenu = document.getElementById('navmenu');

hamburger.addEventListener('click', () => {
    navmenu.classList.toggle('active');
});

document.querySelectorAll('.navmenu a').forEach(link => {
    link.addEventListener('click', () => {
        navmenu.classList.remove('active');
    });
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
