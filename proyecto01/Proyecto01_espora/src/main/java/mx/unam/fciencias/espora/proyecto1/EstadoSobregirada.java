package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase que representa a una cuenta bancaria en estado Sobregirada.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class EstadoSobregirada implements EstadoCuenta {

    private CuentaCliente cuenta;
    /**
     * Cargo mensual aplicado a cuentas sobregiradas.
     */
    private static final double CARGO_MENSUAL_SOBREGIRO = 150.0;

    /**
     * Constructor de la clase EstadoSobregirada.
     * @param cuenta Cuenta bancaria asociada al estado.
     */
    public EstadoSobregirada(CuentaCliente cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Indica que una cuenta no puede realizar compras en estado sobregirada.
     * @param monto Monto de la compra.
     * @return false siempre, ya que no se permiten compras.
     */
    @Override
    public boolean comprar(double monto) {
        System.out.println("La cuenta se encuentra en estado Sobregirada. No es posible realizar compras.");
        System.out.println("Por favor, haga el deposito correspondiente para que su cuenta pueda volver a operar.");
        return false;
    }

    /**
     * Permite realizar depósitos en la cuenta para cubrir el sobregiro.
     * Cuando el sobregiro es cubierto, la cuenta vuelve a estado activa.
     * @param monto Monto del depósito.
     */
    @Override
    public void depositar(double monto) {
        double nuevoSaldo = cuenta.getSaldo() + monto;
        cuenta.setSaldo(nuevoSaldo);
        String descripcion = "Cubriendo deposito de sobregiro: +$" + monto + ". Su nuevo saldo es: " + cuenta.getSaldo();
        cuenta.registrarOperacion(descripcion);
        System.out.println(descripcion);
        if (nuevoSaldo >= 0) {
            System.out.println("Usted ha cubierto el sobregiro. Pasando a estado Activa.");
            cuenta.asignarEstado(cuenta.getEstadoActiva());
        }
    }

    /**
     * Indica que no se pueden generar intereses en una cuenta sobregirada.
     */
    @Override
    public void generarIntereses() {
        System.out.println("No se pueden generar intereses en una cuenta sobregirada.");
    }

    /**
     * Aplica el cargo mensual correspondiente a una cuenta en estado sobregirada.
     */
    @Override
    public void cargoMensual() {
        double nuevoSaldo = cuenta.getSaldo() - CARGO_MENSUAL_SOBREGIRO;
        cuenta.setSaldo(nuevoSaldo);
        String descripcion = "Cargo mensual por sobregiro aplicado: -$" + 
        CARGO_MENSUAL_SOBREGIRO + ". Su nuevo saldo es: " + nuevoSaldo;
        cuenta.registrarOperacion(descripcion);
        System.out.println(descripcion);
    }

    /**
     * Permite que una cuenta sea bloqueada debido a actividad sospechosa.
     * Cambiando su estado a congelada.
     */
    @Override
    public void bloquearCuenta() {
        System.out.println("Se ha detectado actividad sospechosa. Pasando a estado Congelada.");
        cuenta.asignarEstado(cuenta.getEstadoCongelada());
    }

    /**
     * Indica que una cuenta sobregirada no puede ser desbloqueada.
     */
    @Override
    public void desbloquearCuenta() {
        System.out.println("La cuenta se encuentra en estado Sobregirada. No puede desbloquearse.");
        System.out.println("Por favor, haga el deposito correspondiente para cubrir el sobregiro.");
    }

    /**
     * Indica que una cuenta sobregirada no puede ser suspendida, ya que primero se debe cubrir el sobregiro.
     */
    @Override
    public void suspenderCuenta() {
        System.out.println("La cuenta se encuentra en estado Sobregirada. No puede ser suspendida.");
        System.out.println("Haga el deposito correspondiente para cubrir el sobregiro y poder suspender la cuenta.");
    }

    /**
     * Indica que una cuenta sobregirada no puede ser reabierta.
     */
    @Override
    public void reabrirCuenta() {
        System.out.println("La cuenta se encuentra en estado Sobregirada. No puede reabrirse.");
    }

    /**
     * Obtiene el nombre del estado actual de la cuenta.
     * @return Nombre del estado actual.
     */
    @Override
    public String getNombreEstado() {
        return "Sobregirada";
    }
}
