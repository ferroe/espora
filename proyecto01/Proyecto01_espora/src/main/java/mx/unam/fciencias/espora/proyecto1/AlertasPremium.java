package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase que representa el servicio de Alertas Premium
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class AlertasPremium extends ServicioDecorador {

    /**
     * Constructor de Alertas Premium
     * @param cuenta La cuenta del cliente a envolver
     */
    public AlertasPremium(Cuenta cuenta) {
        super(cuenta); 
    }

    /**
     * Método comprar decorado para enviar alertas
     *
     * @param monto El monto de la compra
     * @return Devuelve el resultado de la compra (true si fue exitosa)
     */
    @Override
    public boolean comprar(double monto) {
        boolean exito = super.cuentaDecorada.comprar(monto);

        if (exito) {
            enviarAlerta("Compra exitosa de $" + String.format("%.2f", monto) +
                         ". Saldo restante: $" + String.format("%.2f", super.cuentaDecorada.getSaldo()));
        } else {
            enviarAlerta("Compra RECHAZADA por $" + String.format("%.2f", monto) +
                         ". Saldo actual: $" + String.format("%.2f", super.cuentaDecorada.getSaldo()));
        }
        return exito;
    }

    /**
     * Método depositar para enviar alertas
     *
     * @param monto El monto a depositar
     */
    @Override
    public void depositar(double monto) {
        super.cuentaDecorada.depositar(monto);

        enviarAlerta("Depósito recibido por $" + String.format("%.2f", monto) +
                     ". Nuevo saldo: $" + String.format("%.2f", super.cuentaDecorada.getSaldo()));
    }

    /**
     * Método auxiliar para enviar la notificación de alerta
     *
     * @param mensaje El mensaje completo a mostrar
     */
    private void enviarAlerta(String mensaje) {
        System.out.println("[ALERTA PREMIUM]: " + mensaje);
    }
}
