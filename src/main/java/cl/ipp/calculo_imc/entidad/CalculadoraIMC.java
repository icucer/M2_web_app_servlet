package cl.ipp.calculo_imc.entidad;

public class CalculadoraIMC {
    // Atributos
    private double weight;
    private double height;
    private double height_meters;

    // Constructor
    public CalculadoraIMC(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    // Método para calcular el IMC
    public double calculateIMC() {
        // Fórmula del IMC: peso (kg) / (altura (m) ^ 2)
        height_meters = height / 100;
        double imc = weight / (height_meters * height_meters);

        // Redondear a 2 decimales
        return Math.round(imc * 100.0) / 100.0;
    }

    // Método para determinar la clasificación del IMC
    public String classifyIMC() {
        double imc = calculateIMC();
        if (imc < 16.00) {
            return "Infrapeso: Delgadez severa";
        } else if (imc >= 16.00 && imc < 17.00) {
            return "Infrapeso: Delgadez moderada";
        } else if (imc >= 17.00 && imc < 18.50) {
            return "Infrapeso: Delgadez aceptable";
        } else if (imc >= 18.50 && imc < 25.00) {
            return "Peso normal";
        } else if (imc >= 25.00 && imc < 30.00) {
            return "Sobrepeso";
        } else if (imc >= 30.00 && imc < 35.00) {
            return "Obeso: Tipo I";
        } else if (imc >= 35.00 && imc <= 40.00) {
            return "Obeso: Tipo II";
        } else {
            return "Obeso: Tipo III";
        }
    }

    // Getters y Setters
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight_meters() {
        return height_meters;
    }

    public void setHeight_meters(double height_meters) {
        this.height_meters = height_meters;
    }
}
