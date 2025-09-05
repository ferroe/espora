package mx.unam.fciencias.espora.practica1;

import java.io.PrintWriter;
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
    public void actualizar(Sujeto servicio, float tarifa, String recomendacion, PrintWriter salida) {
        Suscripcion suscripcion = getSuscripcion(servicio);

        if (this.saldo >= tarifa) {
            this.saldo = this.saldo - tarifa;
            suscripcion.incrementarMes();
            salida.println(nombre + " paga: $" + tarifa + " por el servicio " + servicio.getNombre());
            salida.println("\nTe recomendamos: " + recomendacion);
        } else {
            salida.println("\n" + nombre + " no tiene saldo suficiente para pagar el servicio " + servicio.getNombre() + " Lamentamos que su suscripción haya sido cancelada.");
            this.cancelarServicio(servicio, salida);
        }
    }

    /**
     * Este método permite que el cliente se suscriba a un servicio.
     * @param servicio El servicio al cual el cliente desea suscribirse.
     * @param tarifa La tarifa del servicio al cual el cliente desea suscribirse.
     */
    public void suscribirServicio(Sujeto servicio, TarifaEstrategia tarifa, PrintWriter salida) {
        Suscripcion suscripcion = getSuscripcion(servicio);
        if (suscripcion == null) {
            suscripcion = new Suscripcion(tarifa, servicio, this);
            suscripciones.add(suscripcion);
            servicio.registrar(this);
            salida.println(nombre + "Bienvenido a " + servicio.getNombre());
        } else if (!suscripcion.getIsActiva()) {
            suscripcion.setIsActiva(true);
            suscripcion.setTarifa(tarifa);
            servicio.registrar(this);
            salida.println(nombre + "Bienvenido de nuevo a " + servicio.getNombre());
        }
    }

    /**
     * Este método permite que el cliente cancele su suscripción a un servicio.
     * @param servicio El servicio al cual el cliente desea cancelar su suscripción.
     */
    public void cancelarServicio(Sujeto servicio, PrintWriter salida) {
        Suscripcion suscripcion = getSuscripcion(servicio);
        if (suscripcion != null && suscripcion.getIsActiva()) {
            suscripcion.setIsActiva(false);
            servicio.desuscribir(this);
            salida.println(nombre + " ha cancelado su suscripción a " + servicio.getNombre());
        }
    }

    public Suscripcion getSuscripcion(Sujeto servicio) {
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
