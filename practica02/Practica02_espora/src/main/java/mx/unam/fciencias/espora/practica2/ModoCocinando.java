package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ModoCocinando
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ModoCocinando implements EstadoRobot {

    Robot robot;

    public ModoCocinando(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void llamar() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "No puedo atender ahorita\n");
    }

    @Override
    public void ordenarPedido(Producto producto) {
        System.out.println("--- Modo Cocinando ---\n" +
                        "Tu pedido se esta cocinando, no puedes ordenar mas\n");
    }

    @Override
    public void confirmarOrden() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "Tu pedido ya esta siendo preparado\n");
    }

    @Override
    public void cancelarOrden() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "No puedo cancelar tu pedido, ya esta en preparación\n");
    }

    @Override
    public void iniciarPreparacion() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "Tu pedido ya fue preparado\n");
    }

    @Override
    public void solicitarEntrega() {
        System.out.println("--- Modo Cocinando ---\n" +
                        "No puedo entregar, ya estoy cocinando\n");
    }
}
