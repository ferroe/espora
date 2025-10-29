package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase que representa a una cuenta bancaria en estado Activa.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class EstadoActiva implements EstadoCuenta {

    private CuentaCliente cuenta;

    /**
     * Constructor de la clase EstadoActiva.
     * @param cuenta Cuenta bancaria asociada al estado.
     */
    public EstadoActiva(CuentaCliente cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Permite realizar una compra cuando hay saldo suficiente.
     * En caso de que no, la cuenta pasa a estado sobregirada.
     * @param monto Monto de la compra.
     * @return true si la compra fue exitosa, false en caso contrario.
     */
    @Override
    public boolean comprar(double monto) {
        double saldoActual = cuenta.getSaldo();
        String descripcion;
        if (monto > saldoActual) {
            System.out.println("La compra ha excedido el saldo disponible. Pasando a estado Sobregirada.");
            cuenta.setSaldo(saldoActual - monto);
            descripcion = "La compra ha sido realizada (Sobregiro): -$" + monto + ". Su nuevo saldo es: " + cuenta.getSaldo();
            cuenta.registrarOperacion(descripcion);
            cuenta.asignarEstado(cuenta.getEstadoSobregirada());
            return true;
        } else {
            cuenta.setSaldo(saldoActual - monto);
            descripcion = "La compra ha sido exitosa: -$" + monto + ". Su nuevo saldo es: " + cuenta.getSaldo();
            cuenta.registrarOperacion(descripcion);
            System.out.println(descripcion);
            return true;
        }
    }

    /**
     * Permite realizar un depósito en la cuenta activa.
     * @param monto Monto del depósito.
     */
    @Override
    public void depositar(double monto) {
        double nuevoSaldo = cuenta.getSaldo() + monto;
        cuenta.setSaldo(nuevoSaldo);
        String descripcion = "El deposito ha sido realizado: +$" + monto + ". Su nuevo saldo es: " + cuenta.getSaldo();
        cuenta.registrarOperacion(descripcion);
        System.out.println(descripcion);
    }

    /**
     * Permite que la cuenta activa genere intereses.
     */
    @Override
    public void generarIntereses() {
        System.out.println("Calculando intereses para la cuenta activa.");
        InteresEstrategia estrategia = cuenta.getEstrategia();
        double interesGenerado = estrategia.calcularInteres(cuenta);
        if (interesGenerado > 0) {
            System.out.println("Se genero la cantidad generada de: $" + interesGenerado + " en intereses.");
            this.depositar(interesGenerado);
        } else {
            System.out.println("No se generaron intereses para la cuenta.");
        }
    }

    /**
     * Especifica que no se aplicará ningún cargo mensual en la cuenta activa.
     */
    @Override
    public void cargoMensual() {
        System.out.println("No se aplicara ningun cargo mensual.");
    }

    /**
     * Permite bloquear la cuenta activa, cuando se detecta actividad sospechosa.
     * Cambiando su estado a congelada.
     */
    @Override
    public void bloquearCuenta() {
        System.out.println("Se ha detectado una actividad sospechosa. Pasando a estado Congelada.");
        cuenta.asignarEstado(cuenta.getEstadoCongelada());
    }

    /**
     * Especifica que una cuenta no puede ser desbloqueada ya que está activa.
     */
    @Override
    public void desbloquearCuenta() {
        System.out.println("La cuenta ya se encuentra en estado Activa. No es necesario que sea desbloqueada.");
    }

    /**
     * Permite suspender la cuenta activa únicamente cuando su saldo es cero.
     */
    @Override
    public void suspenderCuenta() {
        if (cuenta.getSaldo() > 0) {
            System.out.println("La cuenta tiene saldo no cero. Retire su dinero para poder suspenderla.");
            System.out.println("Su saldo actual es: $" + cuenta.getSaldo());
            return;
        } else {
            System.out.println("Usted ha decidido suspender la cuenta. Pasando a estado Cerrada.");
            cuenta.asignarEstado(cuenta.getEstadoCerrada());
        }
    }

    /**
     * Especifica que una cuenta no puede ser reabierta ya que la misma ya se encuentra activa.
     */
    @Override
    public void reabrirCuenta() {
        System.out.println("La cuenta ya se encuentra en estado Activa. No es necesario que sea reabierta.");
    }
}
