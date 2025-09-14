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
     * Metodo para llamar al robot
     */
    public void llamar();

    /**
     * Metodo para ordenar el pedido al robot
     */
    public void ordenarPedido(Producto producto);

    /**
     * Metodo para confirmar la orden al robot
     */
    public void confirmarOrden();

    /**
     * Metodo para cancelar la orden al robot
     */
    public void cancelarOrden();

    /**
     * Metodo para que el robot inicie la preparacion del pedido
     */
    public void iniciarPreparacion();

    /**
     * Metodo para que se le solicite la entrega al robot
     */
    public void solicitarEntrega();
}
