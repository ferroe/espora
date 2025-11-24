package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 * Interfaz del sujeto en el patron Observer. Permite registrar,
 * remover y notificar observadores.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public interface Sujeto {

    /**
     * Registra un observador.
     * @param o Observador a registrar.
     */
    public void registrarObservador(Observer o);

    /**
     * Remueve un observador.
     * @param o Observador a remover.
     */
    public void removerObservador(Observer o);

    /**
     * Notifica a todos los observadores registrados.
     */
    public void notificarObservadores();
}
