package mx.unam.fciencias.espora.proyecto1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz CuentaRemota para nuestro PumaBank
 * Esta interfaz define los métodos remotos 
 * de los clientes para realizar operaciones bancarias.
 * @author Equipo Espora
 * @version 1.0
 */
public interface CuentaRemota extends Remote {

    /**
     * Metodo para depositar dinero en una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param monto Representa la cantidad a depositar
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    void depositar(String numeroCuenta, double monto, String nip) throws RemoteException;

    /**
     * Metodo para retirar dinero de una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param monto Representa la cantidad a retirar
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    void retirar(String numeroCuenta, double monto, String nip) throws RemoteException;

    /**
     * Metodo para transferir dinero entre cuentas propias
     * @param cuentaOrigen Representa la cuenta de origen
     * @param cuentaDestino Representa la cuenta de destino
     * @param monto Representa la cantidad a transferir
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    boolean transferirEntreCuentas(String cuentaOrigen, String cuentaDestino, double monto, String nip) throws RemoteException;

    /**
     * Metodo para consultar el saldo de una sola cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @return El saldo de la cuenta
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public double consultarSaldo(String numeroCuenta, String nip) throws RemoteException;

    /**
     * Metodo para obtener el saldo global de todas las cuentas de un cliente
     * @param idCliente Representa el ID del cliente
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    double getSaldoGlobal(String idCliente, String nip) throws RemoteException;

    /**
     * Metodo para ejecutar el proceso mensual
     * @param idCliente Representa el ID del cliente
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    void ejecutarProcesoMensual(String idCliente, String nip) throws RemoteException;

    /**
     * Metodo para obtener el nombre del estado de una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @return El nombre del estado de la cuenta
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    String getNombreEstado(String numeroCuenta, String nip) throws RemoteException;

    /**
     * Metodo para bloquear una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    void bloquearCuenta(String numeroCuenta, String nip) throws RemoteException;

    /**
     * Metodo para desbloquear una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    void desbloquearCuenta(String numeroCuenta, String nip) throws RemoteException;

    /**
     * Metodo para suspender una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    void suspenderCuenta(String numeroCuenta, String nip) throws RemoteException;

    /**
     * Metodo para reabrir una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    void reabrirCuenta(String numeroCuenta, String nip) throws RemoteException;
}