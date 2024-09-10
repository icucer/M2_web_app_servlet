<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Cálculo del IMC</title>
    <%@ include file="/assets/html/head.jsp" %>
  </head>
<body class="bg-warning p-2 bg-opacity-25 d-flex flex-column min-vh-100">
  <%@ include file="/assets/html/header.jsp" %>
  <section class="container">
    <h2 class="mt-120 fs-2 text-orange">Bienvenido al sistema de cálculo del IMC</h2>
    <form action="calculateIMC" method="post">
      <label class="mt-60 fs-4" for="height">Escribe tu ALTURA actual:</label>
      <input type="text" id="height" name="height" class="mb-3" style="margin-left: 172px;" required>
      <label class="fs-4" for="height">cm.</label><br>

      <label class="mt-3 fs-4" for="weight">Escribe tu PESO actual:</label>
      <input type="text" id="weight" name="weight" style="margin-left: 200px;" required>
      <label class="fs-4" for="weight">kg.</label><br>

      <button type="submit" class="btn btn-warning fs-4 mx-4 mt-60">Calcular IMC</button>
    </form>
  </section>
  <div class="mt-auto">
    <%@ include file="assets/html/footer.jsp" %>
  </div>
</body>
</html>
