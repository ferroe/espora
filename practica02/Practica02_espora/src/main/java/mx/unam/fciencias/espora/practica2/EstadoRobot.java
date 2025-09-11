package mx.unam.fciencias.espora.practica2;

/**
 * Interfaz para los estados del robot
 * Se definen los comportamientos del robot
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface EstadoRobot {

    /**
     * Metodo para dormir del robot
     */
    public void dormir();

    /**
     * Metodo para atender del robot
     */
    public void atender();

    /**
     * Metodo para cocinar del robot
     */
    public void cocinar();

    /**
     * Metodo para repartir del robot
     */
    public void repartir();
}
