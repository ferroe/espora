package mx.unam.fciencias.espora.practica1;

import java.util.LinkedList;
import java.util.concurrent.Flow.Subscription;

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
    private LinkedList<Suscripcion> suscripciones;

    /**
     * Constructor de la clase Cliente.
     * 
     * @param nombre El nombre de cada uno de los clientes.
     * @param saldo El saldo con el cual inicio cada uno de los cliente.
     */
    public Cliente(String nombre, float saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.suscripciones = new LinkedList<>();
    }

    /**
     * Este método es llamado para notificar al cliente sobre un cambio en un servicio al que está suscrito.
     * @param servicio El servicio que ha sufrido un cambio.
     * @param tarifa La tarifa del servicio después del cambio.
     * @param recomendacion Una recomendación de acuerdo al cambio en el servicio.
     */
    @Override
    public void actualizar(Sujeto servicio, float tarifa, String recomendacion) {
        Subscripcion suscripcion = getSuscripcion(servicio);

        if (this.saldo >= tarifa) {
            this.saldo = this.saldo - tarifa;
            suscripcion.incrementarMes();
        } else {
            this.cancelarServicio(servicio);
        }
    }

    /**
     * Este método permite que el cliente se suscriba a un servicio.
     * @param servicio El servicio al cual el cliente desea suscribirse.
     * @param tarifa La tarifa del servicio al cual el cliente desea suscribirse.
     */
    public void suscribirServicio(Sujeto servicio, float tarifa) {
        Suscripcion suscripcion = getSuscripcion(servicio);
        if (suscripcion == null) {
            suscripcion = new Suscripcion(this, tarifa, servicio);
            servicios.add(suscripcion);
            servicio.suscribir(this);
        } else if (!suscripcion.isActiva()) {
            suscripcion.setIsActiva(true);
            suscripcion.setTarifa(tarifa);
            servicio.suscribir(this);
        }

    /**
     * Este método permite que el cliente cancele su suscripción a un servicio.
     * @param servicio El servicio al cual el cliente desea cancelar su suscripción.
     */
    public void cancelarServicio(Sujeto servicio) {
        Suscripcion suscripcion = getSuscripcion(servicio);
        if (suscripcion != null && suscripcion.isActiva()) {
            suscripcion.setIsActiva(false);
            servicio.desuscribir(this);
        }
    }

    private Suscripcion getSuscripcion(Sujeto servicio) {
        Suscripcion suscripcionCliente = null;
        for (Suscripcion suscripcion : suscripciones) {
            if (suscripcion.getServicio().equals(servicio)) {
                suscripcionCliente = suscripcion;
                break;
            }
        }
        return suscripcionCliente;
    }
}
