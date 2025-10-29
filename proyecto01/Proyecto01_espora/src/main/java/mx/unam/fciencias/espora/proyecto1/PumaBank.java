package mx.unam.fciencias.espora.proyecto1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Clase principal para iniciar el servidor de PumaBank
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class PumaBank {
    private static final int RMI_PORT = 1099;
    private static final String SERVICE_NAME = "PumaBank";

    /**
     * Método principal para iniciar el servidor RMI de PumaBank
     * @param args
     */
    public static void main(String[] args) {
        
        System.out.println("Iniciando servidor de PumaBank...");

        try {
            System.out.println("Cargando base de datos desde archivos .txt...");
            LectorTXT cargador = new LectorTXT();
            PortafolioServidor portafolioServidor = cargador.cargarBanco();
            System.out.println("Datos cargados: PumaBank funcionando");
            Registry registry = LocateRegistry.createRegistry(RMI_PORT);
            String rmiUrl = "//localhost:" + RMI_PORT + "/" + SERVICE_NAME;
            Naming.rebind(rmiUrl, portafolioServidor);

            System.out.println("-----------------------------------------");
            System.out.println("Servidor PumaBank iniciado y listo");
            System.out.println(" Servicio publicado como: " + rmiUrl);
            System.out.println(" Esperando conexiones de clientes...");
            System.out.println("-----------------------------------------");

        } catch (RemoteException e) {
            System.err.println("Errorde RMI al iniciar el servidor:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error al iniciar el servidor:");
            e.printStackTrace();
        }
    }
}
