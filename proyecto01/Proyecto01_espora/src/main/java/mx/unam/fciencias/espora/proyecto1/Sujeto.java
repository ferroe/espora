package mx.unam.fciencias.espora.proyecto1;

/**
 * Interfaz para sujeto de Observer
 * Interfaz sujeto para nuestro patron de diseño Observer
 * @author Equipo Espora
 * @version 1.0
 */

public interface Sujeto {

    /**
     * Registra un observador
     * @param cliente Es el observador a registrar
     */
    void registrar(Observador cliente);

    /**
     * Remueve un observador
     * @param cliente Es el observador a remover
     */
    void remover(Observador cliente);

    /**
     * Notifica a los observadores registrados
     */
    void notificarObservadores();
}
