package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 * Interfaz para objetos que desean recibir notificaciones del modelo.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public interface Observer {

    /**
     * Metodo llamado por el sujeto cuando el estado cambia.
     */
    public void actualizar();
    
}
