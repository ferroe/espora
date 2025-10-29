package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase Cliente que implementa la interfaz Observador
 * Es la clase cliente que se suscribe a las cuentas para recibir notificaciones
 * @author Equipo Espora
 * @version 1.0
 */

public class Cliente implements Observador {

    private String idCliente;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String nip;
    
    /**
     * Constructor de la clase Cliente
     * @param idCliente
     * @param nombre
     * @param apellidoPat
     * @param apellidoMat
     * @param nip
     */
    public Cliente(String idCliente, String nombre, String apellidoPat, String apellidoMat, String nip) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.nip = nip;
    }

    /**
     * Actualiza el observador
     * @param mensaje Es el mensaje a actualizar
     */
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Cliente " + idCliente + " ha recibido el mensaje: " + mensaje);
    }

    /**
     * Suscribe al cliente a una cuenta
     * @param cuenta Es la cuenta a la que se suscribe
     */
    public void suscribir(Sujeto cuenta) {
        cuenta.registrar(this);
    }

    /**
     * Obtiene el id del cliente
     * @return El id del cliente
     */
    public String getIdCliente() {
        return this.idCliente;
    }

    /**
     * Obtiene el NIP del cliente
     * @return El NIP del cliente
     */
    public String getNIP() {
        return this.nip;
    }
}
