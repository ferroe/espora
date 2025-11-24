package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 *
 * Contenedor de parametros ambientales y metodos para modificarlos.
 *
 */
public class ModeloParametros {

    private int mesActual;
    private double nivelContaminacion;
    private double nivelEspeciesInvasoras;
    
    private double[] promediosPrecipitacion; 
    private double[] promediosTemperatura;
    private double evaporacionBase;

    /**
     * Construye parametros con valores por defecto.
     */
    public ModeloParametros() {
        this.mesActual = 0;
        this.nivelContaminacion = 0.0;
        this.nivelEspeciesInvasoras = 0.0;
        this.promediosPrecipitacion = new double[12];
        this.promediosTemperatura = new double[12];
    }

    /**
     * Aplica una limpieza reduciendo el nivel de contaminacion local.
     * @param cantidad Fraccion a restar del nivel de contaminacion.
     */
    public void aplicarLimpieza(double cantidad) {
        double nuevoNivel = this.nivelContaminacion - cantidad;
        if (nuevoNivel < 0.0) {
            this.nivelContaminacion = 0.0;
        } else {
            this.nivelContaminacion = nuevoNivel;
        }
        System.out.println("Limpieza aplicada. Contaminacion local: " + this.nivelContaminacion);
    }

    /**
     * Aumenta el nivel de contaminacion local.
     * @param cantidad Fraccion a sumar al nivel de contaminacion.
     */
    public void aplicarContaminacion(double cantidad) {
        double nuevoNivel = this.nivelContaminacion + cantidad;
        if (nuevoNivel > 1.0) {
            this.nivelContaminacion = 1.0;
        } else {
            this.nivelContaminacion = nuevoNivel;
        }
    }

    /**
     * Establece el mes actual (0-11).
     * @param mes Mes a establecer.
     */
    public void setMesActual(int mes) {
        if (mes < 0) {
            this.mesActual = 0;
        } else if (mes > 11) {
            this.mesActual = 11;
        } else {
            this.mesActual = mes;
        }
    }

    /**
     * Establece los promedios climatologicos para la zona.
     */
    public void setPromediosClima(double[] precipitacion, double[] temperatura, double evapBase) {
        this.promediosPrecipitacion = precipitacion;
        this.promediosTemperatura = temperatura;
        this.evaporacionBase = evapBase;
    }

    public void setNivelContaminacion(double v) { this.nivelContaminacion = v; }
    public void setNivelEspeciesInvasoras(double v) { this.nivelEspeciesInvasoras = v; }

    public double getNivelContaminacion() { return nivelContaminacion; }
    public double getNivelEspeciesInvasoras() { return nivelEspeciesInvasoras; }

    /**
     * Calcula un valor aproximado del nivel de agua segun precipitacion y evaporacion.
     * @return Nivel de agua estimado.
     */
    public double getNivelAgua() {
        double lluvia = 0.0;
        if (promediosPrecipitacion != null && mesActual < promediosPrecipitacion.length) {
            lluvia = promediosPrecipitacion[mesActual];
        }
        return 50.0 + (lluvia * 0.15) - (evaporacionBase * 10);
    }

    /**
     * Calcula una medida de calidad del agua entre 0 y 100.
     * @return Calidad de agua.
     */
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