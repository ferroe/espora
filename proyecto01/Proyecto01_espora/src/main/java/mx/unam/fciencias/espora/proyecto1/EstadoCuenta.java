package mx.unam.fciencias.espora.proyecto1;

/**
 * Interfaz que define los métodos a implementar por las clases que
 * representan los distintos estados de una cuenta bancaria.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface EstadoCuenta {

    /**
     * Permite a la cuenta realizar una compra.
     * @param monto Monto de la compra.
     * @return true si la compra fue exitosa, false en caso contrario.
     */
    public boolean comprar(double monto);

    /**
     * Permite a la cuenta realizar un depósito.
     * @param monto Monto del depósito.
     */
    public void depositar(double monto);

    /**
     * Permite a la cuenta generar intereses.
     */
    public void generarIntereses();

    /**
     * Aplica el cargo mensual correspondiente.
     */
    public void cargoMensual();

    /**
     * Permite que la cuenta sea bloqueada.
     */
    public void bloquearCuenta();

    /**
     * Permite que la cuenta sea desbloqueada.
     */
    public void desbloquearCuenta();

    /**
     * Permite que la cuenta sea suspendida.
     */
    public void suspenderCuenta();

    /**
     * Permite que la cuenta pueda ser reabierta.
     */
    public void reabrirCuenta();

    /**
     * Obtiene el nombre del estado actual de la cuenta.
     * @return Nombre del estado actual.
     */
    public String getNombreEstado();
}
