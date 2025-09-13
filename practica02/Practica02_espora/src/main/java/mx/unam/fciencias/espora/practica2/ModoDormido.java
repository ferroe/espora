package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ModoDormido
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoDormido implements EstadoRobot {
    
    Robot robot;

    public ModoDormido(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void llamar() {
        System.out.println("--- Modo Dormido ---\n" +
                        "Yendo a atenderte...\n");
        robot.setEstadoActual(robot.getModoAtendiendo());
    }

    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo tomar tu pedido\n");
    }

    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo confirmar la orden\n");
    }

    @Override
    public void cancelarOrden() {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo cancelar la orden\n");
    }

    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo iniciar la preparación\n");
    }

    @Override
    public void solicitarEntrega() {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo entregar el pedido\n");
    }
}
