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

    /**
     * Método principal para ejecutar el cliente de PumaBank
     * 
     * @param args ninguno
     */
    public static void main(String[] args) {
        try {
            System.out.println("Conectando al servidor de PumaBank en " + RMI_URL + "...");
            CuentaRemota banco = (CuentaRemota) Naming.lookup(RMI_URL);
            System.out.println("¡Conexion exitosa!");

            String idClienteAlfredo = "3201";
            String cuentaAhorroAlfredo = "12904";
            String cuentaNominaAlfredo = "20001";
            String cuentaInversionAlfredo = "30951";

            Scanner scanner = new Scanner(System.in);
            System.out.print("Bienvenido, Alfredo (ID: 3201). Por favor, ingresa tu NIP: ");
            String nip = scanner.nextLine();

            System.out.println("\n--- INICIANDO PRUEBAS DE OPERACIONES ---");

            // Prueba de consulta de saldo global
            try {
                double saldoGlobal = banco.getSaldoGlobal(idClienteAlfredo, nip);
                System.out.println("[CLIENTE] Tu saldo global es: $" + String.format("%.2f", saldoGlobal));
            } catch (RemoteException re) {
                System.err.println("[CLIENTE] Error al consultar saldo global: " + re.getMessage());
            }

            // Prueba de deposito
            try {
                double saldoAntes = banco.consultarSaldo(cuentaAhorroAlfredo, nip);
                System.out.println("[CLIENTE] Saldo Ahorro (antes): $" + String.format("%.2f", saldoAntes));

                banco.depositar(cuentaAhorroAlfredo, 500.00, nip);
                System.out.println("[CLIENTE] Deposito de $500.00 exitoso.");

                double saldoDespues = banco.consultarSaldo(cuentaAhorroAlfredo, nip);
                System.out.println("[CLIENTE] Saldo Ahorro (despues): $" + String.format("%.2f", saldoDespues));

            } catch (RemoteException re) {
                System.err.println("[CLIENTE] Error al depositar: " + re.getMessage());
            }

            // Prueba de retiro
            try {
                double saldoAntes = banco.consultarSaldo(cuentaAhorroAlfredo, nip);
                System.out.println("[CLIENTE] Saldo Ahorro (antes): $" + String.format("%.2f", saldoAntes));

                banco.retirar(cuentaAhorroAlfredo, 100.00, nip);
                System.out.println("[CLIENTE] Retiro de $100.00 exitoso");

                double saldoDespues = banco.consultarSaldo(cuentaAhorroAlfredo, nip);
                System.out.println("[CLIENTE] Saldo Ahorro (despues): $" + String.format("%.2f", saldoDespues));

            } catch (RemoteException re) {
                System.err.println("[CLIENTE] Error al retirar: " + re.getMessage());
            }

            // Prueba de transferencia entre cuentas
            try {
                double montoTransferencia = 200.00;
                double saldoNominaAntes = banco.consultarSaldo(cuentaNominaAlfredo, nip);
                double saldoAhorroAntes = banco.consultarSaldo(cuentaAhorroAlfredo, nip);
                System.out.println("[CLIENTE] Saldo Nomina (antes): $" + String.format("%.2f", saldoNominaAntes));
                System.out.println("[CLIENTE] Saldo Ahorro (antes): $" + String.format("%.2f", saldoAhorroAntes));

                banco.transferirEntreCuentas(cuentaNominaAlfredo, cuentaAhorroAlfredo, montoTransferencia, nip);
                System.out.println(
                        "[CLIENTE] Transferencia de $" + String.format("%.2f", montoTransferencia) + " exitosa.");

                double saldoNominaDespues = banco.consultarSaldo(cuentaNominaAlfredo, nip);
                double saldoAhorroDespues = banco.consultarSaldo(cuentaAhorroAlfredo, nip);
                System.out.println("[CLIENTE] Saldo Nomina (despues): $" + String.format("%.2f", saldoNominaDespues));
                System.out.println("[CLIENTE] Saldo Ahorro (despues): $" + String.format("%.2f", saldoAhorroDespues));

            } catch (RemoteException re) {
                System.err.println("[CLIENTE] Error al transferir: " + re.getMessage());
            }

            // Prueba de manejo de NIP incorrecto
            try {
                banco.retirar(cuentaAhorroAlfredo, 50.00, "9999");
                System.out.println("[CLIENTE] El retiro con NIP incorrecto funciono.");
            } catch (RemoteException re) {
                System.err.println("[CLIENTE] El servidor rechazo el NIP: " + re.getMessage());
            }

            // Prueba de seguro antifraude
            try {
                System.out.println("\n--- pequena prueba para seguro antifraude ---");
                System.out.println("[CLIENTE] Simulando retiro grande para activar seguro antifraude...");
                System.out.println("[CLIENTE] Saldo Ahorro (Antes): $"
                        + String.format("%.2f", banco.consultarSaldo(cuentaAhorroAlfredo, nip)));
                System.out.println("[CLIENTE] Retirando $10,000.00 de la cuenta de ahorro...");
                banco.retirar(cuentaAhorroAlfredo, 10000.00, nip);
                
            } catch (RemoteException e) {
                System.err.println("error");
                System.out.println("[CLIENTE] Saldo Ahorro (Despues): $"
                        + String.format("%.2f", banco.consultarSaldo(cuentaAhorroAlfredo, nip)));
            } finally {
                System.out.println("--- fin prueba seguro antifraude ---\n");
            }

            /*
             * Simulación de un año completo para observar intereses y cambios en saldo,
             * ademas de ver el resumen mensual
             */
            try {
                double saldoGlobalAntes = banco.getSaldoGlobal(idClienteAlfredo, nip);
                double saldoAnualAntes = banco.consultarSaldo(cuentaNominaAlfredo, nip);
                double saldoInversionAntes = banco.consultarSaldo(cuentaInversionAlfredo, nip);
                System.out.println("\n--- simulacion de un anio ---");
                System.out.println("[CLIENTE] Saldo Global (Antes): $" + String.format("%.2f", saldoGlobalAntes));
                System.out.println(
                        "[CLIENTE] Saldo Nómina [Plan Anual] (Antes): $" + String.format("%.2f", saldoAnualAntes));
                System.out.println(
                        "[CLIENTE] Saldo Inversión [Activa] (Antes): $" + String.format("%.2f", saldoInversionAntes));

                System.out.println("[CLIENTE] Obteniendo saldo global: $" +
                        String.format("%.2f", banco.getSaldoGlobal(idClienteAlfredo, nip)));

                System.out.println("[CLIENTE] Simulando 12 ciclos mensuales...");
                for (int i = 1; i <= 12; i++) {
                    banco.ejecutarProcesoMensual(idClienteAlfredo, nip);
                }
                System.out.println("[CLIENTE] 12 meses simulados");

                double saldoGlobalDespues = banco.getSaldoGlobal(idClienteAlfredo, nip);
                double saldoAnualDespues = banco.consultarSaldo(cuentaNominaAlfredo, nip);
                double saldoInversionDespues = banco.consultarSaldo(cuentaInversionAlfredo, nip);
                double saldoFinal = banco.getSaldoGlobal(idClienteAlfredo, nip);
                System.out.println("[CLIENTE] Saldo Global (Despues): $" + String.format("%.2f", saldoGlobalDespues));
                System.out.println(
                        "[CLIENTE] Saldo Nomina [Plan Anual] (Despues): $" + String.format("%.2f", saldoAnualDespues));
                System.out.println(
                        "[CLIENTE] Saldo Inversion (Despues): $" + String.format("%.2f", saldoInversionDespues));
                System.out.println("\n[CLIENTE] Despues de 12 meses, tu nuevo saldo global es: $"
                        + String.format("%.2f", saldoFinal));

                double gananciaAnual = saldoAnualDespues - saldoAnualAntes;
                System.out.println("[CLIENTE] RESULTADO Plan Anual (Cuenta Nomina " + cuentaNominaAlfredo + "):");
                System.out.println("          Ganancia total por intereses: $" + String.format("%.2f", gananciaAnual));

                double gananciaInversion = saldoInversionDespues - saldoInversionAntes;
                System.out.println("[CLIENTE] RESULTADO Cuenta Inversion " + cuentaInversionAlfredo + ":");
                System.out.println(
                        "          Ganancia total por intereses: $" + String.format("%.2f", gananciaInversion));
                System.out.println("--- fin simulacion de un anio ---\n");

            } catch (RemoteException re) {
                System.err.println("[CLIENTE] Error durante la simulacion mensual: " + re.getMessage());
            }

            // Prueba de transicion de estados
            try {
                System.out.println("\n--- transicion de estados ---");
                System.out.println("Consultamos el saldo de la cuenta de inversion y su estado:");
                System.out.println("[CLIENTE] Saldo Inversion: $"
                        + String.format("%.2f", banco.consultarSaldo(cuentaInversionAlfredo, nip)));
                System.out.println("[CLIENTE] Estado Inversion: "
                        + banco.getNombreEstado(cuentaInversionAlfredo, nip));
                System.out.println("sobregiramos la cuenta");
                System.out.println("[CLIENTE] Retirando $5,000,000.00 de la cuenta de inversion...");
                banco.retirar(cuentaInversionAlfredo, 5000000.00, nip);
                System.out.println("[CLIENTE] Saldo Inversion: $" + String.format("%.2f",
                                banco.consultarSaldo(cuentaInversionAlfredo, nip)));
                System.out.println("[CLIENTE] Estado Inversion: " + banco.getNombreEstado(cuentaInversionAlfredo, nip));
                System.out.println("El cliente llama al banco ya que no fue el...");
                System.out.println("El banco bloquea la cuenta...");
                banco.bloquearCuenta(cuentaInversionAlfredo, nip);
                System.out.println("[CLIENTE] Estado Inversion: " + banco.getNombreEstado(cuentaInversionAlfredo, nip));
                System.out.println("El cliente no tiene seguro antifraude, el banco solo desbloquea su cuenta...");
                banco.desbloquearCuenta(cuentaInversionAlfredo, nip);
                System.out.println("[CLIENTE] Estado Inversion: " + banco.getNombreEstado(cuentaInversionAlfredo, nip));
                System.out.println("El cliente se molesta con el banco y quiere cerrar su cuenta de inversion...");
                banco.suspenderCuenta(cuentaInversionAlfredo, nip);
                System.out.println("El cliente no pudo cerrar su cuenta por el sobregiro...");
                System.out.println("[CLIENTE] Saldo Inversion: $" + String.format("%.2f",
                                banco.consultarSaldo(cuentaInversionAlfredo, nip)));
                System.out.println("[CLIENTE] Estado Inversion: " + banco.getNombreEstado(cuentaInversionAlfredo, nip));
                System.out.println("El cliente deposita dinero para cubrir el sobregiro...");
                banco.depositar(cuentaInversionAlfredo, 1400000.00, nip);
                System.out.println("El cliente vuelve a intentar cerrar su cuenta de inversion...");
                banco.suspenderCuenta(cuentaInversionAlfredo, nip);
                System.out.println("[CLIENTE] Estado Inversion: " + banco.getNombreEstado(cuentaInversionAlfredo, nip));
                System.out.println("El cliente no pudo por que su cuenta debe estar en ceros...");
                System.out.println("[CLIENTE] Saldo Inversion: $" + String.format("%.2f",
                                banco.consultarSaldo(cuentaInversionAlfredo, nip)));
                System.out.println("El cliente retira el dinero restante para dejar su cuenta en ceros...");
                banco.retirar(cuentaInversionAlfredo, banco.consultarSaldo(cuentaInversionAlfredo, nip), nip);
                System.out.println("El cliente vuelve a intentar cerrar su cuenta de inversion...");
                banco.suspenderCuenta(cuentaInversionAlfredo, nip);
                System.out.println("[CLIENTE] Estado Inversion: " + banco.getNombreEstado(cuentaInversionAlfredo, nip));
                System.out.println("El cliente se arrepiente y vuelve a abrir su cuenta de inversion...");
                banco.reabrirCuenta(cuentaInversionAlfredo, nip);
                System.out.println("[CLIENTE] Estado Inversion: " + banco.getNombreEstado(cuentaInversionAlfredo, nip));
                System.out.println("--- fin transicion de estados ---\n");

            } catch (RemoteException re) {
                System.err.println("[CLIENTE] Error :(");
            }

        } catch (Exception e) {
            System.err.println("\n No se pudo conectar al servidor");
            e.printStackTrace();
        }


    }
}
