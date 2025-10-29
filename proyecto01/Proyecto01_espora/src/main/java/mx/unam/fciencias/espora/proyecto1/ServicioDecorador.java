package mx.unam.fciencias.espora.proyecto1;

import java.util.List;

/**
 * Clase abstracta para los decoradores de servicios adicionales
 *
 * @author Equipo Espora
 * @version 1.0
 */
public abstract class ServicioDecorador implements Cuenta {

    protected Cuenta cuentaDecorada;

    /**
     * Constructor que recibe la cuenta a envolver
     * @param cuentaDecorada la cuenta a decorar
     */
    public ServicioDecorador(Cuenta cuentaDecorada) {
        this.cuentaDecorada = cuentaDecorada;
    }

    /**
     * compra en la cuenta decorada
     * @param monto el monto a comprar
     * @return true si la compra fue exitosa, false en caso contrario
     */
    @Override
    public boolean comprar(double monto) {
        return cuentaDecorada.comprar(monto);
    }

    /**
     * Deposita en la cuenta decorada
     * @param monto el monto a depositar
     */
    @Override
    public void depositar(double monto) {
        cuentaDecorada.depositar(monto);
    }

    /**
     * Genera intereses en la cuenta decorada
     */
    @Override
    public void generarIntereses() {
        cuentaDecorada.generarIntereses();
    }

    /**
     * Bloquea la cuenta decorada
     */
    @Override
    public void bloquearCuenta() {
        cuentaDecorada.bloquearCuenta();
    }

    /**
     * Desbloquea la cuenta decorada
     */
    @Override
    public void desbloquearCuenta() {
        cuentaDecorada.desbloquearCuenta();
    }

    /**
     * Suspende la cuenta decorada
     */
    @Override
    public void suspenderCuenta() {
        cuentaDecorada.suspenderCuenta();
    }

    /**
     * Reabre la cuenta decorada
     */
    @Override
    public void reabrirCuenta() {
        cuentaDecorada.reabrirCuenta();
    }

    /**
     * Obtiene el saldo de la cuenta decorada
     * @return el saldo de la cuenta decorada
     */
    @Override
    public double getSaldo() {
        return cuentaDecorada.getSaldo();
    }

    /**
     * Obtiene el número de cuenta de la cuenta decorada
     * @return el número de cuenta de la cuenta decorada
     */
    @Override
    public String getNumCuenta() {
        return cuentaDecorada.getNumCuenta();
    }

    /**
     * Obtiene el historial de la cuenta decorada
     * @return el historial de la cuenta decorada
     */
    @Override
    public List<String> getHistorial() {
        return cuentaDecorada.getHistorial();
    }

    /**
     * Carga el cargo mensual en la cuenta decorada
     */
    @Override
    public void cargoMensual() {
        cuentaDecorada.cargoMensual();
    }

    /**
     * Obtiene el ID del cliente de la cuenta decorada
     * @return el ID del cliente de la cuenta decorada
     */
    @Override
    public String getIdCliente() {
        return cuentaDecorada.getIdCliente();
    }

    /**
     * Registra un observador en la cuenta decorada
     * @param cliente el observador a registrar
     */
    @Override
    public void registrar(Observador cliente) {
        cuentaDecorada.registrar(cliente);
    }

    /**
     * Remueve un observador de la cuenta decorada
     * @param cliente el observador a remover
     */
    @Override
    public void remover(Observador cliente) {
        cuentaDecorada.remover(cliente);
    }

    /**
     * Notifica a los observadores de la cuenta decorada
     */
    @Override
    public void notificarObservadores() {
        cuentaDecorada.notificarObservadores();
    }

    /**
     * Obtiene el número de meses promedio de la cuenta decorada
     * @return el número de meses promedio de la cuenta decorada
     */
    @Override
    public int getMesesPromedio() {
        return cuentaDecorada.getMesesPromedio();
    }

    /**
     * Obtiene la suma de los saldos promedio de la cuenta decorada
     * @return la suma de los saldos promedio de la cuenta decorada
     */
    @Override
    public double getSumaSaldosPromedio() {
        return cuentaDecorada.getSumaSaldosPromedio();
    }

    /**
     * Reinicia el promedio anual de la cuenta decorada
     */
    @Override
    public void reiniciarPromedioAnual() {
        cuentaDecorada.reiniciarPromedioAnual();
    }

    /**
     * Registra una operación en la cuenta decorada
     * @param operacion la operación a registrar
     */
    @Override
    public void registrarOperacion(String operacion) {
        cuentaDecorada.registrarOperacion(operacion);
    }

    /**
     * Avanza un mes en la cuenta decorada
     */
    @Override
    public void avanzarMes() {
        cuentaDecorada.avanzarMes();
    }
}
