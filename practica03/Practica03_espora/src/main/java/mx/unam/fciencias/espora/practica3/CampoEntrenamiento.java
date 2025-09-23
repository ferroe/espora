package mx.unam.fciencias.espora.practica3;

/**
 * Clase para CampoEntrenamiento
 * Clase abstracta que representa la estructura de los campos de 
 * entrenamiento
 *  
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class CampoEntrenamiento {

    protected String descripcion;

    /**
     * Método constructor para CampoEntrenamiento
     * @param descripcion Es la descripción del campo de entrenamiento.
     */
    public CampoEntrenamiento(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método Getter para descripción que devuelve el valor 
     * del atributo "descripcion"
     * @return La descripción para cada campo de entrenamiento
     */
    public String getDescripcion() {
        return this.descripcion;
    }
}
