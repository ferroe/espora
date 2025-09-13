package mx.unam.fciencias.espora.practica2;

public class ModoEsperando implements EstadoRobot {

    Robot robot;

    public ModoEsperando(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void llamar() {
        System.out.println("--- Modo Esperando ---\n" +
                        "Estoy esperando confirmación de una orden\n");
    }

    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Esperando ---\n" +
                        "No puedo tomar ordenes\n");
    }

    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Esperando ---\n" +
                        "Ya confirmé tu orden, esperando para preparar...\n");
    }

    @Override
    public void cancelarOrden() {
        System.out.println("--- Modo Esperando ---\n" +
                        "No puedes cancelar tu orden, ya la confirmaste\n");
    }

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

    @Override
    public void solicitarEntrega() { 
        System.out.println("--- Modo Esperando ---\n" +
                        "No puedo entregar el pedido aún, está en preparación\n");
    }
}
