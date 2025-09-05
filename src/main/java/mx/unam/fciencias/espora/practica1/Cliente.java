package mx.unam.fciencias.espora.practica1;
import java.util.LinkedList;

/**
 * Esta clase representa a un cliente de tipo Observador.
 * Un cliente puede suscribirse a múltiples servicios y recibir actualizaciones sobre cambios en esos servicios.
 * Implementa la interfaz Observador para ser notificado de cambios en los servicios a los que está suscrito.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Cliente implements Observador {
    
    private String nombre;
    private float saldo;
    private LinkedList<Suscripcion> servicios;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre El nombre de cada uno de los clientes.
     * @param saldo El saldo con el cual inicio cada uno de los cliente.
     */
    public Cliente(String nombre, float saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.servicios = new LinkedList<>();
    }

    /**
     * Este método es llamado para notificar al cliente sobre un cambio en un servicio al que está suscrito.
     * @param servicio El servicio que ha sufrido un cambio.
     * @param tarifa La tarifa del servicio después del cambio.
     * @param recomendacion Una recomendación de acuerdo al cambio en el servicio.
     */
    @Override
    public void actualizar(Sujeto servicio, float tarifa, String recomendacion) {
        System.out.println("Cliente " + nombre + " ha sido notificado de un cambio en el servicio " + servicio.getNombre() +
                           ". Tarifa: " + tarifa + ". Recomendación: " + recomendacion);
    }

    /**
     * Este método admite que el cliente se suscriba a un servicio.
     * @return La suscripción ya registrada.
     */
    public Suscripcion suscribirServicio() {
        Suscripcion suscripcion = new Suscripcion(this);
        servicios.add(suscripcion);
        return suscripcion;
    }

    /**
     * Este método admite que el cliente cancele su suscripción a un servicio.
     * @param suscripcion La suscripción a la cual decide dejar de ser parte.
     */
    public void cancelarServicio(Suscripcion suscripcion) {
        servicios.remove(suscripcion);
        suscripcion.getServicio().desuscribir(this);
    }
}
