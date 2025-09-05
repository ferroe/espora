package mx.unam.fciencias.espora.practica1;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase representa al sujeto Momazon
 *
 * @author Equipo Espora
 * @version 1.0
 */

public class Momazon implements Sujeto {

    private LinkedList<Cliente> clientes;
    private List<String> recomendaciones;
    private int mesRecomendacion;

    /**
     * Constructor de la clase Momazon.
     */
    public Momazon() {
        this.clientes = new LinkedList<>();
        this.recomendaciones = new LinkedList<>();
        this.mesRecomendacion = 0;
        recomendaciones.add("Tu recomendación del mes es: Yo soy Betty, la fea");
        recomendaciones.add("Tu recomendación del mes es: Fear the Walking Dead");
        recomendaciones.add("Tu recomendación del mes es: El Buen Doctor");
        recomendaciones.add("Tu recomendación del mes es: A él no le gustas tanto");
        recomendaciones.add("Tu recomendación del mes es: Chespirito");
        recomendaciones.add("Tu recomendación del mes es: Terrifier 3");
        recomendaciones.add("Tu recomendación del mes es: Mentiras la serie");
        recomendaciones.add("Tu recomendación del mes es: 2012");
        recomendaciones.add("Tu recomendación del mes es: El que no gana no ama");
        recomendaciones.add("Tu recomendación del mes es: Newtopia");
        recomendaciones.add("Tu recomendación del mes es: Remi");
        recomendaciones.add("Tu recomendación del mes es: El diario de una princesa");
    }

    /**
     * Este método hace el registro de un observador.
     * @param o El observador el cual se desea registrar.
     */
    @Override
    public void registrar(Observador o) {
        clientes.add((Cliente) o);
        System.out.println("El cliente " + o + " ha sido registrado.");
    }
    
    /**
     * Este método hace la desuscripción de un observador.
     * @param o El observador el cual se desea desuscribir.
     */
    @Override
    public void desuscribir(Observador o) {
        clientes.remove((Cliente) o);
        System.out.println("El cliente " + o + " ha sido desuscrito.");
    }

    /**
     * Este método notifica a los observadores registrados.
     */
    @Override
    public void notificar(PrintWriter salida) {
        List<Cliente> copiaClientes = new LinkedList<>(this.clientes);
        for (Cliente cliente : copiaClientes) {
            Suscripcion suscripcion = cliente.getSuscripcion(this);
            if (suscripcion.getIsActiva() && suscripcion != null) {
                TarifaEstrategia tarifa = suscripcion.getTarifa();
                float cobro = tarifa.cobrar(suscripcion);
                String recomendacion = this.getRecomendacion();
                cliente.actualizar(this, cobro, recomendacion, salida);
            }
        }
    }

    /**
     * Este método obtiene la recomendación del mes.
     * @return La recomendación del mes.
     */
    public String getRecomendacion() {
        String recomendacion;
        if (recomendaciones.isEmpty()) {
            recomendacion = "No hay recomendaciones disponibles en este momento.";
        } else {
            recomendacion = recomendaciones.get(mesRecomendacion);
            mesRecomendacion++;
            if (mesRecomendacion >= recomendaciones.size()) {
                mesRecomendacion = 0;
            }
        }
        return recomendacion;
    }

    /**
     * Este método obtiene el nombre del sujeto.
     * @return El nombre del sujeto.
     */
    public String getNombre() {
        return "Momazon";
    }
}
