package mx.unam.fciencias.espora.practica2;

/**
 * Esta clase representa al Robot en su estado Cocinando.
 * Implementa la interfaz EstadoRobot.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoCocinando implements EstadoRobot {

    /**
     * Este atributo hace referencia al robot.
     */
    Robot robot;

    /**
     * Método constructor el cual inicializa el estado Cocinando del robot.
     * 
     * @param robot Robot al que se le asigna el estado Cocinando.
     */
    public ModoCocinando(Robot robot) {
        this.robot = robot;
    }

    /**
     * Este método indica que el robot no puede volver a atender en ese momento ya que está cocinando.
     */
    @Override
    public void llamar() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "No puedo atender ahorita\n");
    }

    /**
     * Este método indica que el robot no puede tomar más pedidos ya que está cocinando el pedido confirmado.
     */
    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Cocinando ---\n" +
                        "Tu pedido se esta cocinando, no puedes ordenar más\n");
    }

    /**
     * Este método indica que no se puede confirmar la orden debido a que el robot ya está cocinando.
     */
    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "Tu pedido ya esta siendo preparado\n");
    }

    /**
     * Este método indica que el robot no puede cancelar el pedido ya que este ya está en preparación.
     */
    @Override
    public boolean cancelarOrden() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "No puedo cancelar tu pedido, ya está en preparación\n");
        return false;
    }

    /**
     * Este método indica que el robot ya ha preparado el pedido.
     */
    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "Tu pedido ya fue preparado\n");
    }

    /**
     * Este método indica que el robot no puede entregar el pedido ya que en este momento está cocinando.
     */
    @Override
    public boolean solicitarEntrega() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "No puedo entregar, ya estoy cocinando\n");
        return false;
    }
}
