package mx.unam.fciencias.espora.proyecto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase se encarga de leer los datos de los clientes,
 * cuentas y servicios desde los archivos TXT.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class LectorTXT {

    // Nombres de los archivos
    private static final String CLIENTES_TXT = "clientes.txt";
    private static final String CUENTAS_TXT = "cuentas.txt";
    private static final String SERVICIOS_TXT = "cuentas_servicios.txt";

    /**
     * Leer todos los archivos y cargar el banco
     * 
     * @return El PortafolioServidor listo para usarse.
     */
    public PortafolioServidor cargarBanco() throws RemoteException{
        System.out.println("--- Iniciando Carga del Banco PumaBank ---");
        Map<String, Cliente> clientes = cargarClientes();
        Map<String, Cuenta> cuentas = cargarCuentas(clientes);
        cuentas = cargarServicios(cuentas);
        System.out.println("--- Carga del Banco Completada ---");
        return new PortafolioServidor(cuentas, clientes);
    }

    /**
     * Leer cliente.txt y crea a los clientes
     * 
     * @return Un mapa de clientes
     */
    private Map<String, Cliente> cargarClientes() {
        System.out.println("Cargando clientes...");
        Map<String, Cliente> clientesMap = new HashMap<>();
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(CLIENTES_TXT))) {
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("#"))
                    continue;

                String[] datos = linea.split(",");
                if (datos.length < 5)
                    continue;

                String idCliente = datos[0].trim();
                String nombre = datos[1].trim();
                String apPat = datos[2].trim();
                String apMat = datos[3].trim();
                String nip = datos[4].trim();

                Cliente cliente = new Cliente(idCliente, nombre, apPat, apMat, nip);
                clientesMap.put(cliente.getIdCliente(), cliente);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de clientes: " + e.getMessage());
        }

        System.out.println("Clientes cargados: " + clientesMap.size());
        return clientesMap;
    }

    /**
     * Leer cuentas.txt y crea las cuentas básicas
     * 
     * @return Un mapa de cuentas base
     */
    private Map<String, Cuenta> cargarCuentas(Map<String, Cliente> clientes) {
        System.out.println("Cargando cuentas...");
        Map<String, Cuenta> cuentasMap = new HashMap<>();
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(CUENTAS_TXT))) {
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("#"))
                    continue;

                String[] datos = linea.split(",");
                if (datos.length < 8)
                    continue;

                String numCuenta = datos[0].trim();
                String idCliente = datos[1].trim();
                TipoCuenta tipo = TipoCuenta.valueOf(datos[2].toUpperCase());
                String planInteresString = datos[3].toUpperCase();
                double saldo = Double.parseDouble(datos[4]);
                String estado = datos[5].toUpperCase();
                int antiguedad = Integer.parseInt(datos[6]);
                double sumaSaldos = Double.parseDouble(datos[7]);

                InteresEstrategia estrategia;
                switch (planInteresString) {
                    case "PLAN_MENSUAL":
                        estrategia = new PlanMensual();
                        break;
                    case "PLAN_ANUAL":
                        estrategia = new PlanAnual();
                        break;
                    case "PLAN_PREMIUM":
                        estrategia = new PlanPremium();
                        break;
                    default:
                        System.err
                                .println("Plan desconocido " + planInteresString + ", asignando Mensual por defecto");
                        estrategia = new PlanMensual();
                }

                if (clientes.containsKey(idCliente)) {
                    Cliente cliente = clientes.get(idCliente);
                    Cuenta base = new CuentaCliente(numCuenta, idCliente, tipo, saldo,
                            estado, antiguedad, sumaSaldos, estrategia);
                    base.registrar(cliente);
                    cuentasMap.put(base.getNumCuenta(), base);
                } else {
                    System.err.println("Error: La cuenta " + numCuenta + " pertenece a un cliente (" + idCliente
                            + ") que no existe.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de cuentas: " + e.getMessage());
        }

        System.out.println("Cuentas cargadas: " + cuentasMap.size());
        return cuentasMap;
    }

    /**
     * Leer cuentas_servicios.txt y aplica los decoradores
     */
    private Map<String, Cuenta> cargarServicios(Map<String, Cuenta> cuentasBase) {
        System.out.println("Cargando servicios (decoradores)...");
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(SERVICIOS_TXT))) {
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("#"))
                    continue;

                String[] datos = linea.split(",");
                if (datos.length < 2)
                    continue;

                String numCuenta = datos[0].trim();
                String servicio = datos[1].toUpperCase().trim();

                Cuenta cuentaADecorar = cuentasBase.get(numCuenta);
                if (cuentaADecorar == null) {
                    System.err.println(
                            "Advertencia: Se intenta agregar servicio a cuenta " + numCuenta + " que no existe.");
                    continue;
                }

                Cuenta cuentaDecorada = null;
                switch (servicio) {
                    case "SEGURO_ANTIFRAUDE":
                        cuentaDecorada = new SeguroAntifraude(cuentaADecorar);
                        break;
                    case "RECOMPENSAS":
                        cuentaDecorada = new ProgramaRecompensas(cuentaADecorar);
                        break;
                    case "ALERTAS_PREMIUM":
                        cuentaDecorada = new AlertasPremium(cuentaADecorar);
                        break;
                    default:
                        System.err.println("Advertencia: Servicio '" + servicio + "' desconocido.");
                }

                if (cuentaDecorada != null) {
                    cuentasBase.put(numCuenta, cuentaDecorada);
                    System.out.println("Aplicando " + servicio + " a cuenta " + numCuenta);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de servicios: " + e.getMessage());
        }

        System.out.println("Carga de servicios completada.");
        return cuentasBase;
    }
}