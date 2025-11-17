package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase que representa a una cuenta bancaria en estado Cerrada.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class EstadoCerrada implements EstadoCuenta {

    private CuentaCliente cuenta;

    /**
     * Constructor de la clase EstadoCerrada.
     * @param cuenta Cuenta bancaria asociada al estado.
     */
    public EstadoCerrada(CuentaCliente cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Indica que una cuenta no puede realizar compras ya que se encuentra cerrada.
     * @param monto Monto de la compra.
     * @return false siempre, ya que no se pueden realizar compras.
     */
    @Override
    public boolean comprar(double monto) {
        System.out.println("La cuenta se encuentra en estado Cerrada. No se pueden realizar compras.");
        return false;
    }

    /**
     * Indica que una cuenta no puede realizar depósitos ya que se encuentra cerrada.
     * @param monto Monto del depósito.
     */
    @Override
    public void depositar(double monto) {
        System.out.println("La cuenta se encuentra en estado Cerrada. No se pueden realizar depósitos.");
    }

    /**
     * Indica que no se pueden generar intereses en una cuenta cerrada.
     */
    @Override
    public void generarIntereses() {
        System.out.println("La cuenta se encuentra en estado Cerrada. No hay manera de generar intereses.");
    }

    /**
     * Indica que no se pueden aplicar cargos mensuales en una cuenta cerrada.
     */
    @Override
    public void cargoMensual() {
        System.out.println("La cuenta se encuentra en estado Cerrada. No se puede aplicar un cargo mensual.");
    }

    /**
     * Indica que una cuenta no puede ser bloqueada ya que se encuentra cerrada.
     */
    @Override
    public void bloquearCuenta() {
        System.out.println("La cuenta se encuentra en estado Cerrada. No se puede bloquear la cuenta.");
    }

    /**
     * Indica que una cuenta no puede ser desbloqueada ya que se encuentra cerrada.
     */
    @Override
    public void desbloquearCuenta() {
        System.out.println("La cuenta se encuentra en estado Cerrada. No puede desbloquearse ya que esta cerrada.");
    }

    /**
     * Indica que la cuenta ya ha sido suspendida y por lo tanto se encuentra cerrada.
     */
    @Override
    public void suspenderCuenta() {
        System.out.println("La cuenta ya ha sido suspendida y se encuentra en estado Cerrada.");
    }

    /**
     * Permite reabrir una cuenta cerrada, devolviéndola a su estado activa conservando su antiguedad.
     */
    @Override
    public void reabrirCuenta() {
        String descripcion = "La cuenta puede ser reabierta, conservando su antiguedad. Pasando a estado Activa.";
        cuenta.registrarOperacion(descripcion);
        System.out.println(descripcion);
        cuenta.asignarEstado(cuenta.getEstadoActiva());
    }

    /**
     * Obtiene el nombre del estado actual de la cuenta.
     * @return Nombre del estado actual.
     */
    @Override
    public String getNombreEstado() {
        return "Cerrada";
    }
}
