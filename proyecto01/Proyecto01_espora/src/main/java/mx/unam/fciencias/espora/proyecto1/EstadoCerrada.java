package mx.unam.fciencias.espora.proyecto1;

public class EstadoCerrada implements EstadoCuenta {

    private Cuenta cuenta;

    public EstadoCerrada(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void comprar(double monto) {
        System.out.println("La cuenta se encuentra en estado Cerrada. No se pueden realizar compras.");
    }

    @Override
    public void depositar(double monto) {
        System.out.println("La cuenta se encuentra en estado Cerrada. No se pueden realizar depósitos.");
    }

    @Override
    public void generarIntereses() {
        System.out.println("La cuenta se encuentra en estado Cerrada. No hay manera de generar intereses.");
    }

    @Override
    public void cargoMensual(double monto) {
        System.out.println("La cuenta se encuentra en estado Cerrada. No se puede aplicar un cargo mensual.");
    }

    @Override
    public void bloquearCuenta() {
        System.out.println("La cuenta se encuentra en estado Cerrada. No se puede bloquear la cuenta.");
    }

    @Override
    public void desbloquearCuenta() {
        System.out.println("La cuenta se encuentra en estado Cerrada. No puede desbloquearse ya que está cerrada.");
    }

    @Override
    public void suspenderCuenta() {
        System.out.println("La cuenta se encuentra en estado Cerrada. No puede suspenderse.");
    }

    @Override
    public void reabrirCuenta() {
        System.out.println("La cuenta puede ser reabierta. Pasando a estado Activa.");
        cuenta.asignarEstado(cuenta.getEstadoActiva());
    }
}
