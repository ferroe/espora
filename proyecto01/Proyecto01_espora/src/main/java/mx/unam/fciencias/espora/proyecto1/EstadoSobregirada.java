package mx.unam.fciencias.espora.proyecto1;

public class EstadoSobregirada implements EstadoCuenta {

    private Cuenta cuenta;

    public EstadoSobregirada(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void comprar(double monto) {
        System.out.println("La cuenta se encuentra en estado Sobregirada. No es posible realizar compras.");
    }

    @Override
    public void depositar(double monto) {
        System.out.println("Depósito recibido. Pasando a estado Activa.");
        cuenta.asignarEstado(cuenta.getEstadoActiva());
    }

    @Override
    public void generarIntereses() {
        System.out.println("Generando intereses por sobregiro.");
        cuenta.generarIntereses();
    }

    @Override
    public void cargoMensual(double monto) {
        System.out.println("La cuenta recibe un cargo mensual adicional por sobregiro.");
        cuenta.cargoMensual(monto);
    }

    @Override
    public void bloquearCuenta() {
        System.out.println("La cuenta ha excedido el límite de sobregiro. Pasando a estado Congelada.");
        cuenta.asignarEstado(cuenta.getEstadoCongelada());
    }

    @Override
    public void desbloquearCuenta() {
        System.out.println("La cuenta se encuentra en estado Sobregirada. No puede desbloquearse.");
    }

}
