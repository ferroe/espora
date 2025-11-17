package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 * La clase ModeloParametros que maneja los parametros 
 * ambientales dentro del ecosistema
 * @author Equipo Espora
 * @version 1.0
 */

public class ModeloParametros {

    private double nivelContaminacion;
    private double nivelEspeciesInvasoras;

    /**
     * Constructor de ModeloParametros
     */
    public ModeloParametros() {
        this.nivelContaminacion = 0.1;
        this.nivelEspeciesInvasoras = 0.1;
    }

    /**
     * Obtiene la calidad del agua
     * @return La calidad del agua
     */
    public double getCalidadAgua() {
        double calidadAgua = 100.0 - (this.nivelContaminacion * 1.5);
        return calidadAgua;
    }

    /**
     * Obtiene el nivel de agua
     * @return El nivel de agua
     */
    public double getNivelAgua() {
        double nivelAgua = 100.0 - (this.nivelContaminacion * 1.5);
        return nivelAgua;
    }

    /**
     * Obtiene el nivel de contaminación
     * @return El nivel de contaminación
     */
    public double getNivelContaminacion() {
        return this.nivelContaminacion;
    }

    /**
     * Obtiene el nivel de especies invasoras
     * @return El nivel de especies invasoras
     */
    public double getNivelEspeciesInvasoras() {
        return this.nivelEspeciesInvasoras;
    }

    /**
     * El nivel de contaminacion
     * @param nivelContaminacion El nivel de contaminacion
     */
    public void setNivelContaminacion(double nivelContaminacion) {
        this.nivelContaminacion = nivelContaminacion;
    }

    /**
     * El nivel de especies invasoras
     * @param nivelEspeciesInvasoras El nivel de especies invasoras
     */
    public void setNivelEspeciesInvasoras(double nivelEspeciesInvasoras) {
        this.nivelEspeciesInvasoras = nivelEspeciesInvasoras;
    }    
}
