package mx.unam.fciencias.espora.practica2;

/**
 * Esta clase representa al Robot en su estado Dormido.
 * Implementa la interfaz EstadoRobot.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoDormido implements EstadoRobot {
    
    /**
     * Este atributo hace referencia al robot.
     */
    Robot robot;

    /**
     * Método constructor el cual inicializa el estado Dormido del robot.
     * 
     * @param robot Robot al que se le asigna el estado Dormido.
     */
    public ModoDormido(Robot robot) {
        this.robot = robot;
    }

    /**
     * Este método hace que el robot despierte y modifica su estado a Atendiendo.
     */
    @Override
    public void llamar() {
        System.out.println("--- Modo Dormido ---\n" +
                        "Yendo a atenderte...\n");
        robot.setEstadoActual(robot.getModoAtendiendo());
    }

    /**
     * Este método indica que el robot no puede tomar pedidos ya que está dormido.
     */
    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo tomar tu pedido\n");
    }

    /**
     * Este método indica que el robot no puede confirmar la orden ya que está dormido.
     */
    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo confirmar la orden\n");
    }

    /**
     * Este método indica que el robot no puede cancelar la orden ya que está dormido.
     */
    @Override
    public void cancelarOrden() {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo cancelar la orden\n");
    }

    /**
     * Este método indica que el robot no puede iniciar la preparación ya que está dormido.
     */
    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo iniciar la preparación\n");
    }

    /**
     * Este método indica que el robot no puede entregar el pedido ya que está dormido.
     */
    @Override
    public void solicitarEntrega() {
        System.out.println("--- Modo Dormido ---\n" +
                        "No puedo entregar el pedido\n");
    }
}
