package mx.unam.fciencias.espora.practica2;

/**
 * Clase para Robot
 * 
 * Esta clase representa al robot de la pizzeria, el cual puede estar en 
 * diferentes estados.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Robot {
    
    private EstadoRobot estadoActual;
    private EstadoRobot modoDormido;
    private EstadoRobot modoAtendiendo;
    private EstadoRobot modoEsperando;
    private EstadoRobot modoCocinando;
    private EstadoRobot modoRepartiendo;
    private Orden ordenActual;

    /**
     * Constructor de la clase Robot con sus metodos y sus modos y estado.
     */
    public Robot() {
        modoDormido = new ModoDormido(this);
        modoAtendiendo = new ModoAtendiendo(this);
        modoEsperando = new ModoEsperando(this);
        modoCocinando = new ModoCocinando(this);
        modoRepartiendo = new ModoRepartiendo(this);
        estadoActual = modoDormido;
    }

    /**
     * Este método tiene al modo dormido el robot.
     * @return Devuelve el modo dormido.
     */
    public EstadoRobot getModoDormido() {
        return modoDormido;
    }

    /**
     * Este método tiene al modo atendiendo del robot.
     * @return Devuelve el modo atendiendo.
     */
    public EstadoRobot getModoAtendiendo() {
        return modoAtendiendo;
    }

    /**
     * Este método tiene al modo esperando del robot.
     * @return Devuelve al modo esperando.
     */
    public EstadoRobot getModoEsperando() {
        return modoEsperando;
    }

    /**
     * Este método tiene al modo cocinando del robot.
     * @return Devuelve el modo cocinando.
     */
    public EstadoRobot getModoCocinando() {
        return modoCocinando;
    }

    /**
     * Este método tiene al modo repartiendo del robot.
     * @return Devuelve el modo repartiendo.
     */
    public EstadoRobot getModoRepartiendo() {
        return modoRepartiendo;
    }

    /**
     * Este metodo cambia el estado actual del robot.
     * @param estadoActual Define el estado actual del robot.
     */
    public void setEstadoActual(EstadoRobot estadoActual) {
        this.estadoActual = estadoActual;
        if (this.estadoActual == this.modoAtendiendo) {
            this.ordenActual = new Orden();
            System.out.println("--- ROBOT ---\n" + 
                                "Estoy listo para tomar tu orden...\n");
        }
        if (this.estadoActual == this.modoDormido) {
            this.ordenActual = null;
        }
    }

    /**
     * Este metodo hace que el cliente llame al robot.
     */
    public void llamar() {
        estadoActual.llamar();
    }
    
    /**
     * Este metodo es para ordenar el pedido.
     * @param producto El producto que ordeno el cliente
     * (pizza o helado)
     */
    public void ordenarPedido(Producto producto) {
        estadoActual.ordenarPedido(producto);
    }

    /**
     * Este método confirma la orden del pedido.
     */
    public void confirmarOrden() {
        estadoActual.confirmarOrden();
    }

    /**
     * Este método cancela la orden del pedido.
     */
    public boolean cancelarOrden() {
        return estadoActual.cancelarOrden();
    }

    /**
     * Este método inicia la preparacion del pedido.
     */
    public void iniciarPreparacion() {
        estadoActual.iniciarPreparacion();
    }

    /**
     * Este método solicita la entrega del pedido.
     */
    public boolean solicitarEntrega() {
        return estadoActual.solicitarEntrega();
    }
    
    /**
     * Este método obtiene la orden actual del robot.
     * @return Devuelve la orden actual.
     */
    public Orden getOrdenActual() {
        return ordenActual;
    }
}
