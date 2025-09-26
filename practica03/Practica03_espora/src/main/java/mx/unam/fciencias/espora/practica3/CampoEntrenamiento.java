package mx.unam.fciencias.espora.practica3;

/**
 * Clase para CampoEntrenamiento
 * 
 * Esta clase abstracta representa a los diferentes campos de entrenamiento que pueden existir.
 *  
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class CampoEntrenamiento {

    protected String nombre;
    protected String descripcion;

    /**
     * Método constructor que inicializa la descripción del campo de entrenamiento.
     * 
     * @param descripcion Es la descripción del campo de entrenamiento.
     */
    public CampoEntrenamiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Método getter que devuelve el nombre del campo de entrenamiento.
     *
     * @return El nombre del campo de entrenamiento.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método getter que devuelve la descripción del campo de entrenamiento.
     *
     * @return La descripción para cada campo de entrenamiento.
     */
    public String getDescripcion() {
        return this.descripcion;
    }
}
