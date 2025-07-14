<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="ordineForm" method="post" action="<%=request.getContextPath()%>/ProvaServlet">
  <input type="hidden" name="carrello" id="carrelloInput" value="">
  <button type="submit">Ordina ora!</button>
</form>

<script>
  document.getElementById('ordineForm').addEventListener('submit', function () {
    document.getElementById('carrelloInput').value = '{"prova":1}';
    console.log('Valore carrelloInput settato a:', document.getElementById('carrelloInput').value);
  });
</script>

</body>
</html>