package mx.unam.fciencias.espora.practica2;

public class Robot {
    
    private EstadoRobot estadoActual;
    private EstadoRobot modoDormido;
    private EstadoRobot modoAtendiendo;
    private EstadoRobot modoEsperando;
    private EstadoRobot modoCocinando;
    private EstadoRobot modoRepartiendo;
    private Orden ordenActual;

    public Robot() {
        modoDormido = new ModoDormido(this);
        modoAtendiendo = new ModoAtendiendo(this);
        modoEsperando = new ModoEsperando(this);
        modoCocinando = new ModoCocinando(this);
        modoRepartiendo = new ModoRepartiendo(this);
        estadoActual = modoDormido;
    }

    public EstadoRobot getModoDormido() {
        return modoDormido;
    }

    public EstadoRobot getModoAtendiendo() {
        return modoAtendiendo;
    }

    public EstadoRobot getModoEsperando() {
        return modoEsperando;
    }

    public EstadoRobot getModoCocinando() {
        return modoCocinando;
    }

    public EstadoRobot getModoRepartiendo() {
        return modoRepartiendo;
    }

    public void setEstadoActual(EstadoRobot estadoActual) {
        this.estadoActual = estadoActual;
        if (this.estadoActual == this.modoAtendiendo) {
            this.ordenActual = new Orden();
            System.out.println("--- ROBOT ---\nCreando nueva orden...");
        }
        // Si el nuevo estado es 'Dormido', la orden anterior ya se completó.
        if (this.estadoActual == this.modoDormido) {
            this.ordenActual = null;
        }
    }

    public void llamar() {
        estadoActual.llamar();
    }

    public void ordenarPedido(Producto producto) {
        estadoActual.ordenarPedido(producto);
    }

    public void confirmarOrden() {
        estadoActual.confirmarOrden();
    }

    public void cancelarOrden() {
        estadoActual.cancelarOrden();
    }

    public void iniciarPreparacion() {
        estadoActual.iniciarPreparacion();
    }

    public void solicitarEntrega() {
        estadoActual.solicitarEntrega();
    }

    public Orden getOrdenActual() {
        return ordenActual;
    }
}
