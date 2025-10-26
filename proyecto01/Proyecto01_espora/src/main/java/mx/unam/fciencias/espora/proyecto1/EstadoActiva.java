package mx.unam.fciencias.espora.proyecto1;

public class EstadoActiva implements EstadoCuenta {

    private Cuenta cuenta;

    public EstadoActiva(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void comprar(double monto) {
        if (cuenta.getSaldo() < 0) {
            System.out.println("La compra ha excedido el saldo disponible. Pasando a estado Sobregirada.");
            cuenta.asignarEstado(cuenta.getEstadoSobregirada());
        } else {
            System.out.println("La compra se ha realizado con éxito.");
        }
    }

    @Override
    public void depositar(double monto) {
        System.out.println("El depósito se ha recibido con éxito.");
    }

    @Override
    public void generarIntereses() {
        System.out.println("Generando intereses para la cuenta activa.");
        cuenta.generarIntereses();
    }

    @Override
    public void cargoMensual(double monto) {
        System.out.println("No se aplicará ningún cargo mensual.");

    }

    @Override
    public void bloquearCuenta() {
        System.out.println("Se ha detectado una actividad sospechosa. Pasando a estado Congelada.");
        cuenta.asignarEstado(cuenta.getEstadoCongelada());
    }

    @Override
    public void desbloquearCuenta() {
        System.out.println("La cuenta ya se encuentra en estado Activa. No es necesario desbloquear.");
    }

    @Override
    public void suspenderCuenta() {
        cuenta.suspender();
    }

    @Override
    public void reabrirCuenta() {
        cuenta.reabrir();
    }
}
