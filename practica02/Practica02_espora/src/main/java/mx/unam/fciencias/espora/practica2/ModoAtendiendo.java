package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ModoAtendiendo 
 * Esta clase implementa el estado del robot y atiende a los cliente.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoAtendiendo implements EstadoRobot {

    Robot robot;

    /**
     * Constructor de la clase ModoAtendiendo
     * @param robot 
     */
    public ModoAtendiendo(Robot robot){
        this.robot = robot;
    }

    @Override
    public void llamar() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "Ya estoy atendiendo a un cliente, espera un momento\n");
    }

    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "Añadiendo " + producto.getNombre() + " a tu orden\n");
        robot.getOrdenActual().agregarProducto(producto);
    }

    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "Orden confirmada, esperando para preparar...\n");
        robot.setEstadoActual(robot.getModoEsperando());
    }

    @Override
    public void cancelarOrden() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "Orden cancelada, volviendo a dormir...zZz\n");
        robot.setEstadoActual(robot.getModoDormido());

    }

    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "No puedo iniciar la preparación aún, confirma la orden");
    }

    @Override
    public void solicitarEntrega() {
        System.out.println("--- Modo Atendiendo ---\n" +
                        "No puedo entregar el pedido aún, confirma la orden");
    }
}
