<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Resultado del IMC</title>
    <%@ include file="/assets/html/head.jsp" %>
</head>
<body class="bg-warning p-2 bg-opacity-25 d-flex flex-column min-vh-100">
<%@ include file="/assets/html/header.jsp" %>
<section class="container">
    <h2 class="mt-120 fs-2">Resultados del IMC</h2>
    <p class="mt-60 fs-4">Índice de masa corporal (IMC): <strong style="margin-left: 120px;"><%= session.getAttribute("imc") %></strong></p>
    <p class="mt-4 fs-4">Clasificación: <strong style="margin-left: 310px;"><%= session.getAttribute("classification") %></strong></p>

    <a href="formulario_imc.jsp" class="btn btn-warning fs-4 mt-60">Calcular de nuevo</a>
</section>
<div class="mt-auto">
    <%@ include file="/assets/html/footer.jsp" %>
</div>
</body>
</html>
