package mx.unam.fciencias.espora.proyecto1;

import java.util.List;

/**
 * Interfaz que define las operaciones que una cuenta
 * bancaria debe implementar
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface Cuenta {
    
    /**
     * Compra con la cuenta
     * @param monto Monto a comprar
     * @return true si la compra fue exitosa, false en caso contrario
     */
    public boolean comprar(double monto);

    /**
     * Deposita en la cuenta
     * @param monto Monto a depositar
     */
    public void depositar(double monto);

    /**
     * Genera intereses para la cuenta
     */
    public void generarIntereses();

    /**
     * Bloquea la cuenta
     */
    public void bloquearCuenta();

    /**
     * Desbloquea la cuenta
     */
    public void desbloquearCuenta();

    /**
     * Suspende la cuenta
     */
    public void suspenderCuenta();

    /**
     * Reabre la cuenta
     */
    public void reabrirCuenta();

    /**
     * Registra un observador
     * @param cliente Observador a registrar
     */
    public void registrar(Observador cliente);

    /**
     * Remove un observador
     * @param cliente Observador a remover
     */
    public void remover(Observador cliente);

    /**
     * Notifica a los observadores
     */
    public void notificarObservadores();

    /**
     * Obtiene el saldo de la cuenta
     * @return Saldo de la cuenta
     */
    public double getSaldo();

    /**
     * Obtiene el número de cuenta
     * @return Número de cuenta
     */
    public String getNumCuenta();

    /**
     * Obtiene el historial de operaciones
     * @return Historial de operaciones
     */
    public List<String> getHistorial();

    /**
     * Realiza el cargo mensual por sobregiro
     */
    public void cargoMensual();

    /**
     * Obtiene el ID del cliente
     * @return ID del cliente
     */
    public String getIdCliente();

    /**
     * Obtiene el número de meses considerados para el promedio
     * @return Número de meses considerados para el promedio
     */
    public int getMesesPromedio();

    /**
     * Obtiene la suma de los saldos mensuales para el cálculo del promedio
     * @return Suma de los saldos mensuales
     */
    public double getSumaSaldosPromedio();

    /**
     * Reinicia los contadores para el cálculo del promedio anual
     */
    public void reiniciarPromedioAnual();

    /**
     * Registra una operación en el historial de la cuenta
     * @param descripcion Descripción de la operación
     */
    public void registrarOperacion(String descripcion);

    /**
     * Avanza al siguiente mes, actualizando los contadores necesarios
     */
    public void avanzarMes();

    /**
     * Obtiene el nombre del estado de la cuenta
     * @return Nombre del estado de la cuenta
     */
    public String getNombreEstado();
}
