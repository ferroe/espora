package mx.unam.fciencias.espora.proyecto1;

/**
 * Interfaz para el observador
 * Interfaz observador para nuestro patron de diseño Observer
 * @author Equipo Espora
 * @version 1.0
 */

public interface Observador {
    
    /**
     * Actualiza el observador
     * @param mensaje Es el mensaje a actualizar
     */
    void actualizar(String mensaje);
}
