package mx.unam.fciencias.espora.proyecto1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Clase principal para el cliente de PumaBank
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class ClienteMain {

    private static final String RMI_URL = "rmi://localhost:1099/PumaBank";

    public static void main(String[] args) {
        try {
            System.out.println("Conectando al servidor de PumaBank en " + RMI_URL + "...");
            CuentaRemota banco = (CuentaRemota) Naming.lookup(RMI_URL);

            System.out.println("¡Conexión exitosa!");
            String idClienteAlfredo = "C-001";
            String cuentaAhorroAlfredo = "11111";
            String cuentaNominaAlfredo = "22222";

            Scanner scanner = new Scanner(System.in);
            System.out.print("Bienvenido, Alfredo. Por favor, ingresa tu NIP: ");
            String nip = scanner.nextLine();

            try {
                double saldoGlobal = banco.getSaldoGlobal(idClienteAlfredo, nip);
                System.out.println("Tu saldo global es: $" + String.format("%.2f", saldoGlobal));

                banco.depositar(cuentaAhorroAlfredo, 500.00, nip);
                System.out.println("Depósito de $500.00 en cuenta " + cuentaAhorroAlfredo + " exitoso.");

                banco.retirar(cuentaAhorroAlfredo, 100.00, nip);
                System.out.println("Retiro de $100.00 de cuenta " + cuentaAhorroAlfredo + " exitoso.");

                System.out.println("Transfiriendo $200.00 de Nómina a Ahorro...");
                banco.transferirEntreCuentas(cuentaNominaAlfredo, cuentaAhorroAlfredo, 200.00, nip);
                System.out.println("Transferencia exitosa.");

                double nuevoSaldo = banco.consultarSaldo(cuentaAhorroAlfredo, nip);
                System.out.println("Tu nuevo saldo en Ahorro es: $" + String.format("%.2f", nuevoSaldo));

                System.out.println("Intentando retirar con NIP incorrecto '9999'...");
                banco.retirar(cuentaAhorroAlfredo, 50.00, "9999"); // Esto debe fallar

            } catch (RemoteException re) {
                System.err.println("¡Operación fallida! Error desde el servidor: " + re.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error: No se pudo conectar al servidor de PumaBank.");
            System.err.println("Asegúrate de que la clase PumaBank (servidor) esté ejecutándose.");
            e.printStackTrace();
        }
    }
}