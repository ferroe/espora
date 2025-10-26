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
     */
    public void comprar(double monto);

    /**
     * Permite a la cuenta realizar un depósito.
     */
    public void depositar(double monto);

    /**
     * Permite a la cuenta generar intereses.
     */
    public void generarIntereses();

    /**
     * Muestra cuando se ha sobrepasado el límite de la cuenta.
     */
    public void sobrelimitar(double monto);

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
}
