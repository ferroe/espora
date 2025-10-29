package mx.unam.fciencias.espora.proyecto1;

import java.util.List;

/**
 * Clase que maneja el proceso mensual de fin de mes para las cuentas bancarias
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class GestorMensual {

    /**
     *  Ejecuta el proceso mensual de fin de mes para una cuenta específica
     *
     * @param cuenta La cuenta sobre la que se ejecutará el proceso.
     */
    public void ejecutarProcesoCuenta(Cuenta cuenta) {
        System.out.println("--- Ejecutando proceso mensual para cuenta: " + cuenta.getNumCuenta() + " ---");
        cuenta.cargoMensual();
        cuenta.generarIntereses();
        cuenta.notificarObservadores();
        cuenta.avanzarMes();
        System.out.println("--- Proceso mensual finalizado para: " + cuenta.getNumCuenta() + " ---");
    }
    
    /**
     * Ejecuta el proceso mensual de fin de mes para todas las cuentas proporcionadas
     *
     * @param cuentas Una lista de todas las cuentas a procesar.
     */
    public void ejecutarProcesoGlobal(List<Cuenta> cuentas) {
        System.out.println("--- Proceso mensual global iniciado ---");
        for (Cuenta c : cuentas) {
            ejecutarProcesoCuenta(c);
        }
        System.out.println("--- Proceso mensual global finalizado ---");
    }
}