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
public class PortafolioServidor extends UnicastRemoteObject implements PortafolioRemoto {
    
    private Map<String, Cuenta> cuentaReal;
    private Map<String, Cliente> clientes;

    /**
     * Constructor de la clase PortafolioServidor
     * @param cuentaReal Representa la cuenta real del cliente
     * @param clientes Representa los clientes del banco
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public PortafolioServidor(Map<String, Cuenta> cuentaReal, Map<String, Cliente> clientes) throws RemoteException {
        super();
        this.cuentaReal = cuentaReal;
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
        cuentaReal.get(numeroCuenta).depositar(monto);
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
        return cuentaReal.get(numeroCuenta).getSaldo();
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
        for (Cuenta cuenta: cuentaReal.values()) {
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

        Cuenta origen = cuentaReal.get(cuentaOrigen);
        Cuenta destino = cuentaReal.get(cuentaDestino);

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
    private boolean verificarNIP(String numeroCuenta, String nip) {
        Cuenta cuenta = cuentaReal.get(numeroCuenta);
        if (cuenta == null) {
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
        Cliente cliente = clientes.get(idCliente);
        if (cliente == null) {
            return false;
        }
        String nipCorrecto = cliente.getNIP();
        return nipCorrecto != null && nipCorrecto.equals(nip);
    }
}
