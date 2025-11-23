package mx.unam.fciencias.espora.proyecto2.modelo;

public class ModeloParametros {

    private int mesActual;
    private double nivelContaminacion;
    private double nivelEspeciesInvasoras;
    
    private double[] promediosPrecipitacion; 
    private double[] promediosTemperatura;
    private double evaporacionBase;

    public ModeloParametros() {
        this.mesActual = 0;
        this.nivelContaminacion = 0.0;
        this.nivelEspeciesInvasoras = 0.0;
        this.promediosPrecipitacion = new double[12];
        this.promediosTemperatura = new double[12];
    }

    // --- MÉTODOS DE ACCIÓN ---

    public void aplicarLimpieza(double cantidad) {
        double nuevoNivel = this.nivelContaminacion - cantidad;
        // Reemplazo de operador ternario por if-else
        if (nuevoNivel < 0.0) {
            this.nivelContaminacion = 0.0;
        } else {
            this.nivelContaminacion = nuevoNivel;
        }
        System.out.println("Limpieza aplicada. Contaminación local: " + this.nivelContaminacion);
    }

    public void aplicarContaminacion(double cantidad) {
        double nuevoNivel = this.nivelContaminacion + cantidad;
        // Reemplazo de operador ternario (Math.min es aceptable, pero lo hago explícito)
        if (nuevoNivel > 1.0) {
            this.nivelContaminacion = 1.0;
        } else {
            this.nivelContaminacion = nuevoNivel;
        }
    }

    // --- Setters y Getters ---

    public void setMesActual(int mes) {
        // Validación sin Math.max/min para ser explícitos con if-else
        if (mes < 0) {
            this.mesActual = 0;
        } else if (mes > 11) {
            this.mesActual = 11;
        } else {
            this.mesActual = mes;
        }
    }

    public void setPromediosClima(double[] precipitacion, double[] temperatura, double evapBase) {
        this.promediosPrecipitacion = precipitacion;
        this.promediosTemperatura = temperatura;
        this.evaporacionBase = evapBase;
    }

    public void setNivelContaminacion(double v) { this.nivelContaminacion = v; }
    public void setNivelEspeciesInvasoras(double v) { this.nivelEspeciesInvasoras = v; }

    public double getNivelContaminacion() { return nivelContaminacion; }
    public double getNivelEspeciesInvasoras() { return nivelEspeciesInvasoras; }

    public double getNivelAgua() {
        double lluvia = 0.0;
        if (promediosPrecipitacion != null && mesActual < promediosPrecipitacion.length) {
            lluvia = promediosPrecipitacion[mesActual];
        }
        return 50.0 + (lluvia * 0.15) - (evaporacionBase * 10);
    }

    public double getCalidadAgua() {
        double calidad = 100.0 - (nivelContaminacion * 100) - (nivelEspeciesInvasoras * 50);
        if (calidad < 0) {
            return 0.0;
        }
        if (calidad > 100) {
            return 100.0;
        }
        return calidad;
    }
}