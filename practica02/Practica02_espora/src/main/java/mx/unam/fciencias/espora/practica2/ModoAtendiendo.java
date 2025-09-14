package mx.unam.fciencias.espora.practica2;

/**
 * Esta clase representa al Robot en su estado Atendiendo.
 * Implementa la interfaz EstadoRobot.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoAtendiendo implements EstadoRobot {

    /**
     * Este atributo hace referencia al robot.
     */
    Robot robot;

    /**
     * Método constructor el cual inicializa el estado Atendiendo del robot.
     * 
     * @param robot Robot al que se le asigna el estado Atendiendo.
     */
    public ModoAtendiendo(Robot robot){
        this.robot = robot;
    }

    /**
     * Este método indica que el robot ya está atendiendo a un cliente y no puede atender otro en ese momento.
     */
    @Override
    public void llamar() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "Ya estoy atendiendo a un cliente, espera un momento\n");
    }

    /**
     * Este método añade un producto a la orden actual.
     */
    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "Añadiendo " + producto.getNombre() + " a tu orden\n");
        robot.getOrdenActual().agregarProducto(producto);
    }

    /**
     * Este método confirma la orden actual y cambia el estado del robot a Esperando.
     */
    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "Orden confirmada, esperando para preparar...\n");
        robot.setEstadoActual(robot.getModoEsperando());
    }

    /**
     * Este método indica que la orden actual ha sido cancelada, y el robot vuelve a su estado Dormido.
     */
    @Override
    public void cancelarOrden() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "Orden cancelada, volviendo a dormir...zZz\n");
        robot.setEstadoActual(robot.getModoDormido());

    }

    /**
     * Este método indica que el robot no puede iniciar la preparación ya que la orden aún no está confirmada.
     */
    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "No puedo iniciar la preparación aún, confirma la orden");
    }

    /**
     * Este método indica que el robot no puede entregar el pedido ya que la orden aún no está confirmada.
     */
    @Override
    public void solicitarEntrega() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "No puedo entregar el pedido aún, confirma la orden");
    }
}
