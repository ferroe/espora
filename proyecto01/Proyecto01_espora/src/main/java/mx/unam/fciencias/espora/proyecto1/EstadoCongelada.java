package mx.unam.fciencias.espora.proyecto1;

public class EstadoCongelada implements EstadoCuenta {

    private Cuenta cuenta;

    public EstadoCongelada(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void comprar(double monto) {
        System.out.println("La cuenta se encuentra en estado Congelada. No se pueden realizar compras.");
    }

    @Override
    public void depositar(double monto) {
        System.out.println("La cuenta se encuentra en estado Congelada. No se pueden realizar depósitos.");
    }

    @Override
    public void generarIntereses() {
        System.out.println("La cuenta se encuentra en estado Congelada. No hay manera de generar intereses.");
    }

    @Override
    public void cargoMensual(double monto) {
        System.out.println("La cuenta se encuentra en estado Congelada. No se puede aplicar un cargo mensual.");
    }

    @Override
    public void bloquearCuenta() {
        System.out.println("La cuenta se encuentra en estado Congelada. No se puede bloquear la cuenta.");
    }

    @Override
    public void desbloquearCuenta() {
        System.out.println("La cuenta se ha revisado y puede ser desbloqueada. Pasando a estado Activa.");
        cuenta.asignarEstado(cuenta.getEstadoActiva());
    }

    @Override
    public void suspenderCuenta() {
        System.out.println("La cuenta se encuentra en estado Congelada. No puede suspenderse.");
    }

    @Override
    public void reabrirCuenta() {
        System.out.println("La cuenta se encuentra en estado Congelada. No puede reabrirse.");
    }
}
