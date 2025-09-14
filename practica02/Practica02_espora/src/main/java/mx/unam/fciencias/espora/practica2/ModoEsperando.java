package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ModoEsperando
 * 
 * Esta clase representa al robot cuando entra en modo esperando.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoEsperando implements EstadoRobot {

    Robot robot;

    /**
     * Constructor de la clase ModoEsperando
     * @param robot Es el robot de nuestra pizzeria.
     */

    public ModoEsperando(Robot robot) {
        this.robot = robot;
    }

    /**
     * El método indica que el robot esta en modo esperando y espera una orden.
     */
    @Override
    public void llamar() {
        System.out.println("--- Modo Esperando ---\n" +
                        "Estoy esperando confirmación de una orden\n");
    }

    /**
     * Este método indica que el robot no pueda tomar ordenes pues esta esperando.
     * @param producto Producto es la orden (pizza y helado) que se quiere ordenar.
     */
    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Esperando ---\n" +
                        "No puedo tomar ordenes\n");
    }

    /**
     * Este método indica que el robot esta en espera, y ya se confirmó la orden.
     */
    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Esperando ---\n" +
                        "Ya confirmé tu orden, esperando para preparar...\n");
    }

    /**
     * Esta método indica que el robot no puede cancelar pues ya esta confirmada
     * la orden.
     */
    @Override
    public void cancelarOrden() {
        System.out.println("--- Modo Esperando ---\n" +
                        "No puedes cancelar tu orden, ya la confirmaste\n");
    }

    /**
     * Este método inidica que el robot esta en modo esperando y cambia a 
     * iniciar la preparacion de la orden.
     */
    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Esperando ---\n" +
                        "Iniciando la preparación de tu orden...\n");
        
        Orden orden = robot.getOrdenActual();

        robot.setEstadoActual(robot.getModoCocinando());
        System.out.println("--- Modo Cocinando ---");
        for (Producto producto : orden.getProductos()) {
            System.out.println("Preparando: " + producto.getNombre());
            producto.preparar(); 
            System.out.println("--------------------");
        }

        System.out.println("\nTu orden ya esta lista");
        robot.setEstadoActual(robot.getModoRepartiendo());
    }

    /**
     * Este método indica que el pedido se esta preparando y el robot
     * no puede entregar aun el pedido.
     */
    @Override
    public void solicitarEntrega() { 
        System.out.println("--- Modo Esperando ---\n" +
                        "No puedo entregar el pedido aún, está en preparación\n");
    }
}
