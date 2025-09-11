package mx.unam.fciencias.espora.practica2;

/**
 * Clase abstracta para los helados.
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class Helado {
    
    protected String descripcion = "Helado desconocido";

    /**
     * Este método regresa la descripción del helado.
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Este método regresa el costo del helado.
     */
    public abstract double costo();
}
