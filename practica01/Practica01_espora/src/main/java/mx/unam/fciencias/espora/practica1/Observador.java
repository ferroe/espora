package mx.unam.fciencias.espora.practica1;

import java.io.PrintWriter;

/**
 * Esta interfaz que modela el comportamiento de un observador a través del
 * patrón de diseño Observer.
 *
 * @author Equipo Espora
 * @version 1.0
 */

public interface Observador {
    /**
     * Este método es llamado por el sujeto cuando hay un cambio en su estado.
     *
     * @param servicio      El servicio que ha sido cambiado.
     * @param tarifa        La tarifa del servicio después del cambio.
     * @param recomendacion La recomendación asociada al cambio.
     * @param salida        El PrintWriter para la salida del mensaje.
     */
    public void actualizar(Sujeto servicio, float tarifa, String recomendacion, PrintWriter salida);
}
