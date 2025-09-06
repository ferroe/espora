package mx.unam.fciencias.espora.practica1;

import java.io.PrintWriter;

/**
 * Esta interfaz maneja los métodos que un sujeto debe implementar.
 * Permite registrar, desuscribir y notificar a los observadores.
 * Asimismo es parte del patrón de diseño Observer.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface Sujeto {

    /**
     * Este método hace el registro de un observador.
     * @param o El observador el cual se desea registrar.
     */
    public void registrar(Observador o);

    /**
     * Este método hace la desuscripción de un observador.
     * @param o El observador el cual se desea desuscribir.
     */
    public void desuscribir(Observador o);

    /**
     * Este método notifica a todos los observadores que están registrados.
     */
    public void notificar(PrintWriter salida);

    /**
     * Este método regresa el nombre del servicio.
     * @return El nombre del servicio.
     */
    public String getNombre();
}
