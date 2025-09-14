package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ModoRepartiendo
 * En esta clase tenemos representado al robot cuando esta en modo repartiendo.
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoRepartiendo implements EstadoRobot {

    Robot robot;

    /**
     * Constructor de la clase ModoRepartiendo.
     * @param robot Es el robot de nuestra pizzeria.
     */
    public ModoRepartiendo(Robot robot) {
        this.robot = robot;
    }

    /**
     * Este metodo inidica que el robot no puede antender pues esta 
     * repartiendo el pedido.
     */
    @Override
    public void llamar() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "No puedo atender ahorita\n");
    }

    /**
     * Este método indica que el robot no puede tomar más ordenes.
     * @param producto Producto es la orden (pizza y helado) que se quiere ordenar.
     */
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

    /**
     * Este método indica que el robot no puede cancelar la orden pues ya 
     * esta en reparto.
     */
    @Override
    public boolean cancelarOrden() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "No puedo cancelar la orden, ya estoy repartiendo\n");
        return false;
    }

    /**
     * Este método indica que el robot no puede iniciar la preparación pues ya 
     * esta repartiendo. 
     */
    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "No puedo iniciar la preparación, ya estoy repartiendo\n");
    }

    /**
     * Este método indica que el robot ya tiene listo el pedido junto con el ticket.
     */
    @Override
    public boolean solicitarEntrega() {
        System.out.println("--- Modo Repartiendo ---\n" +
                        "Entregando tu pedido...\n");
        Orden orden = robot.getOrdenActual();
        System.out.println("Su orden ya esta listo, tenga su pedido y su ticket");
        orden.generarTicket();
        robot.setEstadoActual(robot.getModoDormido());
        return true;
    }
}