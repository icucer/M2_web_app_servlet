package cl.ipp.calculo_imc.servlet;

import cl.ipp.calculo_imc.entidad.CalculadoraIMC;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ServletIMC", urlPatterns = "/calculateIMC")
public class ServletIMC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redireccionar al formulario de entrada (formulario_imc.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("formulario_imc.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String weightStr = request.getParameter("weight");
        String heightStr = request.getParameter("height");

        // Validar que los parámetros no sean nulos o vacíos
        if (weightStr != null && !weightStr.isEmpty() && heightStr != null && !heightStr.isEmpty()) {
            try {
                // Convertir los parámetros a tipo double
                double weight = Double.parseDouble(weightStr);
                double height = Double.parseDouble(heightStr);

                // Crear una instancia de IMCCalculator
                CalculadoraIMC calculator = new CalculadoraIMC(weight, height);

                // Calcular el IMC y la clasificación
                double imc = calculator.calculateIMC();
                String classification = calculator.classifyIMC();

                // Pasar los resultados a la JSP
                HttpSession session = request.getSession();
                session.setAttribute("imc", imc);
                session.setAttribute("classification", classification);

                // Redireccionar a la página de resultados (result.jsp)
                response.sendRedirect("result.jsp");

            } catch (NumberFormatException e) {
                // En caso de error de formato en los números, redirigir al formulario con un mensaje de error
                request.setAttribute("error", "Por favor, ingrese valores numéricos válidos.");
                doGet(request, response);
            }
        } else {
            // En caso de campos vacíos, redirigir al formulario con un mensaje de error
            request.setAttribute("error", "Todos los campos son obligatorios.");
            doGet(request, response);
        }
    }
}
