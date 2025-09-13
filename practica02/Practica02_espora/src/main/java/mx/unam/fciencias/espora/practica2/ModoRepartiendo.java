package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ModoRepartiendo
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoRepartiendo implements EstadoRobot {

    Robot robot;

    public ModoRepartiendo(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void llamar() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "No puedo atender ahorita\n");
    }

    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "Tu pedido se esta repartiendo, no puedes ordenar mas\n");
    }

    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "No puedo confirmar la orden, ya estoy repartiendo\n");
    }

    @Override
    public void cancelarOrden() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "No puedo cancelar la orden, ya estoy repartiendo\n");
    }

    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "No puedo iniciar la preparación, ya estoy repartiendo\n");
    }

    @Override
    public void solicitarEntrega() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "Entregando tu pedido...\n");
        Orden orden = robot.getOrdenActual();
        System.out.println("Su orden ya esta listo, tenga su pedido y su ticket");
        orden.generarTicket();
        robot.setEstadoActual(robot.getModoDormido());
    }
}