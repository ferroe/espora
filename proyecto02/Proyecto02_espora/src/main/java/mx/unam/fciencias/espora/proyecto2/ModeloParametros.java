package mx.unam.fciencias.espora.proyecto2;

/**
 * La clase ModeloParametros que maneja los parametros 
 * ambientales dentro del ecosistema
 * @author Equipo Espora
 * @version 1.0
 */

public class ModeloParametros {

    private double calidadAgua;
    private double nivelAgua;
    private double nivelContaminacion;
    private double nivelEspeciesInvasoras;

    /**
     * Constructor de ModeloParametros
     */
    public ModeloParametros() {
        this.calidadAgua = 1.0;
        this.nivelAgua = 0.8;
        this.nivelContaminacion = 0.1;
        this.nivelEspeciesInvasoras = 0.1;
    }

    /**
     * Obtiene la calidad del agua
     * @return La calidad del agua
     */
    public double getCalidadAgua() {
        return this.calidadAgua;
    }

    /**
     * Obtiene el nivel de agua
     * @return El nivel de agua
     */
    public double getNivelAgua() {
        return this.nivelAgua;
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
     * La calidad del agua
     * @param calidadAgua La calidad del agua
     */
    public void setCalidadAgua(double calidadAgua) {
        this.calidadAgua = calidadAgua;
    }

    /**
     * El nivel de agua
     * @param nivelAgua El nivel de agua
     */
    public void setNivelAgua(double nivelAgua) {
        this.nivelAgua = nivelAgua;
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
