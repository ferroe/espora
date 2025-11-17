package mx.unam.fciencias.espora.proyecto1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

/**
 * Clase PortafolioServidor que implementa la interfaz PortafolioRemoto
 * Esta clase maneja las operaciones bancarias remotas para los clientes.
 * @author Equipo Espora
 * @version 1.0
 */
public class PortafolioServidor extends UnicastRemoteObject implements CuentaRemota {

    private Map<String, Cuenta> cuentasMap;
    private Map<String, Cliente> clientes;
    private static final long serialVersionUID = 1L;
    public static final int RMI_OBJECT_PORT = 1100;

    /**
     * Constructor de la clase PortafolioServidor
     * @param cuentasMap Representa el mapa de cuentas del cliente
     * @param clientes Representa los clientes del banco
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public PortafolioServidor(Map<String, Cuenta> cuentasMap, Map<String, Cliente> clientes) throws RemoteException {
        super(RMI_OBJECT_PORT);
        this.cuentasMap = cuentasMap;
        this.clientes = clientes;
    }

    /**
     * Metodo para depositar dinero en una cuenta
     * @param numeroCuenta Representa el número de cuenta a depositar
     * @param monto Representa el monto a depositar
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    @Override
    public void depositar(String numeroCuenta, double monto, String nip) throws RemoteException {
        if (!verificarNIP(numeroCuenta, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo.");
        }
        cuentasMap.get(numeroCuenta).depositar(monto);
    }

    /**
     * Metodo para consultar el saldo de una sola cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @return El saldo de la cuenta
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    @Override
    public double consultarSaldo(String numeroCuenta, String nip) throws RemoteException {
        if (!verificarNIP(numeroCuenta, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo.");
        }
        return cuentasMap.get(numeroCuenta).getSaldo();
    }

    /**
     * Metodo para obtener el saldo global de todas las cuentas de un cliente
     * @param idCliente Representa el ID del cliente
     * @param nip Representa el NIP del cliente
     * @return El saldo global de todas las cuentas del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    @Override
    public double getSaldoGlobal(String idCliente, String nip) throws RemoteException {
        if (!verificarNIPCliente(idCliente, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo.");
        }

        double saldoGlobal = 0.0;
        for (Cuenta cuenta: cuentasMap.values()) {
            if (cuenta.getIdCliente().equals(idCliente)) {
                saldoGlobal += cuenta.getSaldo();
            }
        }
        return saldoGlobal;
    }

    /**
     * Metodo para transferir dinero entre cuentas propias
     * @param cuentaOrigen Representa la cuenta de origen
     * @param cuentaDestino Representa la cuenta de destino a la que se manda el dinero
     * @param monto Representa el monto a transferir
     * @param nip Representa el NIP del cliente
     * @return true si la transferencia fue exitosa, false en caso contrario
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    @Override
    public boolean transferirEntreCuentas(String cuentaOrigen, String cuentaDestino, double monto, String nip) throws RemoteException {
        if (!verificarNIP(cuentaOrigen, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo.");
        }

        Cuenta origen = cuentasMap.get(cuentaOrigen);
        Cuenta destino = cuentasMap.get(cuentaDestino);

        if (origen == null || destino == null) {
            throw new RemoteException("Verifica tus datos, no se pudo completar la solicitud.");
        }

        boolean exito = origen.comprar(monto);
        if (exito) {
            destino.depositar(monto);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para verificar el NIP de una cuenta
     * @param numeroCuenta Numero de cuenta del cliente
     * @param nip Representa el NIP del cliente
     * @return true si el NIP es correcto, false en caso contrario
     */
    private boolean verificarNIP(String numeroCuenta, String nip) throws RemoteException {
        System.out.println("verificarNIP para cuenta " + numeroCuenta);
        Cuenta cuenta = cuentasMap.get(numeroCuenta);
        if (cuenta == null) {
            System.out.println("verificarNIP falló - Cuenta no encontrada");
            return false;
        }

        String idDueno = cuenta.getIdCliente();
        return verificarNIPCliente(idDueno, nip);
    }

    /**
     * Metodo auxiliar para verificar el NIP de un cliente
     * @param idCliente ID del cliente
     * @param nip Representa el NIP del cliente
     * @return true si el NIP es correcto, false en caso contrario
     */
    private boolean verificarNIPCliente(String idCliente, String nip) {
        System.out.println("Verificando NIP para cliente: " + idCliente);
        Cliente cliente = clientes.get(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado: " + idCliente);
            return false;
        }
        String nipCorrecto = cliente.getNIP();
        boolean resultado = nipCorrecto != null && nipCorrecto.equals(nip);
        System.out.println("Comparando NIPs [" + nip + "] con [" + nipCorrecto + "]" + " - Resultado: " + resultado);
        return resultado;
    }

    /**
     * Retira dinero de una cuenta
     *
     * @param numeroCuenta numero de la cuenta
     * @param monto Monto a retirar
     * @param nip NIP del cliente
     * @throws RemoteException Si el NIP es incorrecto o la operación falla
     */
    @Override
    public void retirar(String numeroCuenta, double monto, String nip) throws RemoteException {
        if (!verificarNIP(numeroCuenta, nip)) {
            throw new RemoteException("El NIP es incorrecto, verifícalo de nuevo.");
        }

        Cuenta cuenta = cuentasMap.get(numeroCuenta);
        if (cuenta == null) {
            throw new RemoteException("La cuenta " + numeroCuenta + " no existe.");
        }

        boolean exito = cuenta.comprar(monto);

        if (!exito) {
            throw new RemoteException("Retiro fallido. Fondos insuficientes o la cuenta está bloqueada/cerrada.");
        }
    }

    /**
     * Ejecuta el proceso mensual para un cliente
     *
     * @param idCliente ID del cliente
     * @param nip NIP del cliente
     * @throws RemoteException Si el NIP es incorrecto
     */
    @Override
    public void ejecutarProcesoMensual(String idCliente, String nip) throws RemoteException {
        if (!verificarNIPCliente(idCliente, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo.");
        }
        GestorMensual gestor = new GestorMensual();
        for (Cuenta cuenta : cuentasMap.values()) {
            if (cuenta.getIdCliente().equals(idCliente)) {
                gestor.ejecutarProcesoCuenta(cuenta);
            }
        }
        System.out.println("Servidor: Proceso mensual completado para cliente " + idCliente);
    }

    /**
     * Metodo para obtener el nombre del estado de una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @return El nombre del estado de la cuenta
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    @Override
    public String getNombreEstado(String numeroCuenta, String nip) throws RemoteException {
        if (!verificarNIP(numeroCuenta, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo");
        }
        Cuenta cuenta = cuentasMap.get(numeroCuenta);
        if (cuenta == null) {
            throw new RemoteException("La cuenta " + numeroCuenta + " no existe");
        }
        return cuenta.getNombreEstado();
    }

    /**
     * Metodo para bloquear una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public void bloquearCuenta(String numeroCuenta, String nip) throws RemoteException {
        if (!verificarNIP(numeroCuenta, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo");
        }
        Cuenta cuenta = cuentasMap.get(numeroCuenta);
        if (cuenta == null) {
            throw new RemoteException("La cuenta " + numeroCuenta + " no existe");
        }
        cuenta.bloquearCuenta();
    }

    /**
     * Metodo para desbloquear una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public void desbloquearCuenta(String numeroCuenta, String nip) throws RemoteException {
        if (!verificarNIP(numeroCuenta, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo");
        }
        Cuenta cuenta = cuentasMap.get(numeroCuenta);
        if (cuenta == null) {
            throw new RemoteException("La cuenta " + numeroCuenta + " no existe");
        }
        cuenta.desbloquearCuenta();
    }

    /**
     * Metodo para suspender una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public void suspenderCuenta(String numeroCuenta, String nip) throws RemoteException {
        if (!verificarNIP(numeroCuenta, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo");
        }
        Cuenta cuenta = cuentasMap.get(numeroCuenta);
        if (cuenta == null) {
            throw new RemoteException("La cuenta " + numeroCuenta + " no existe");
        }
        cuenta.suspenderCuenta();
    }

    /**
     * Metodo para reabrir una cuenta
     * @param numeroCuenta Representa el número de cuenta
     * @param nip Representa el NIP del cliente
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public void reabrirCuenta(String numeroCuenta, String nip) throws RemoteException {
        if (!verificarNIP(numeroCuenta, nip)) {
            throw new RemoteException("El NIP es incorrecto, verificalo de nuevo");
        }
        Cuenta cuenta = cuentasMap.get(numeroCuenta);
        if (cuenta == null) {
            throw new RemoteException("La cuenta " + numeroCuenta + " no existe");
        }
        cuenta.reabrirCuenta();
    }
}
