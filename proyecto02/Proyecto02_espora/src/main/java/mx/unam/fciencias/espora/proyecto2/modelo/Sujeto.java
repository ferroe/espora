package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 * Es la interfaz que define los metodos del sujeto
 * del Observer
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface Sujeto {

    /**
     * Registra un observador
     * @param o el observador a registrar
     */
    public void registrarObservador(Observer o);

    /**
     * Remueve un observador
     * @param o el observador a remover
     */
    public void removerObservador(Observer o);

    /**
     * Notifica a todos los observadores registrados
     */
    public void notificarObservadores();
}
