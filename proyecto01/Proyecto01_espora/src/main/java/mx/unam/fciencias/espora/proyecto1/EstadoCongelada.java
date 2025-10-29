package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase que representa a una cuenta bancaria en estado Congelada.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class EstadoCongelada implements EstadoCuenta {

    private CuentaCliente cuenta;

    /**
     * Constructor de la clase EstadoCongelada.
     * @param cuenta Cuenta bancaria asociada al estado.
     */
    public EstadoCongelada(CuentaCliente cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Indica que una cuenta no puede realizar compras ya que se encuentra congelada.
     * @param monto Monto de la compra.
     * @return false siempre, ya que no se permiten compras.
     */
    @Override
    public boolean comprar(double monto) {
        System.out.println("La cuenta se encuentra en estado Congelada. No se pueden realizar compras.");
        return false;
    }

    /**
     * Indica que una cuenta no puede realizar depósitos ya que se encuentra congelada.
     * @param monto Monto del depósito.
     */
    @Override
    public void depositar(double monto) {
        System.out.println("La cuenta se encuentra en estado Congelada. No se pueden realizar depositos.");
    }

    /**
     * Indica que no se pueden generar intereses en una cuenta congelada.
     */
    @Override
    public void generarIntereses() {
        System.out.println("La cuenta se encuentra en estado Congelada. No hay manera de generar intereses.");
    }

    /**
     * Indica que no se pueden aplicar cargos mensuales en una cuenta congelada.
     */
    @Override
    public void cargoMensual() {
        System.out.println("La cuenta se encuentra en estado Congelada. No se puede aplicar un cargo mensual.");
    }

    /**
     * Indica que la cuenta ya ha sido bloqueada.
     */
    @Override
    public void bloquearCuenta() {
        System.out.println("La cuenta ya ha sido bloqueada por lo que se encuentra en estado Congelada.");
    }

    /**
     * Permite desbloquear la cuenta congelada.
     * Determina si el saldo de la cuenta es negativo, pasa a estado sobregirada; si no, a estado activa.
     */
    @Override
    public void desbloquearCuenta() {
        String descripcion;
        if (cuenta.getSaldo() < 0) {
            descripcion = "La cuenta se ha desbloqueado, pero usted tiene un saldo negativo. Pasando a estado Sobregirada.";
            cuenta.registrarOperacion(descripcion);
            System.out.println(descripcion);
            System.out.println("Se le recomienda contratar un seguro antifraude.");
            cuenta.asignarEstado(cuenta.getEstadoSobregirada());
            return;
        } else {
            descripcion = "La cuenta ha sido desbloqueada. Pasando a estado Activa.";
            cuenta.registrarOperacion(descripcion);
            System.out.println(descripcion);
            cuenta.asignarEstado(cuenta.getEstadoActiva());
        }
    }

    /**
     * Indica que una cuenta congelada no puede ser suspendida.
     */
    @Override 
    public void suspenderCuenta() {
        System.out.println("La cuenta se encuentra en estado Congelada. No puede suspenderse.");
    }

    /**
     * Indica que una cuenta congelada no puede ser reabierta.
     */
    @Override
    public void reabrirCuenta() {
        System.out.println("La cuenta se encuentra en estado Congelada. No puede reabrirse.");
    }
}
