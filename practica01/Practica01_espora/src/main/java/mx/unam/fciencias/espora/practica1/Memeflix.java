package mx.unam.fciencias.espora.practica1;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase representa el sujeto Memeflix
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Memeflix implements Sujeto {
    
    private LinkedList<Cliente> clientes;
    private List<String> recomendaciones;
    private int mesRecomendacion;

    /**
     * Constructor de la clase Memeflix.
     */
    public Memeflix() {
        this.clientes = new LinkedList<>();
        this.recomendaciones = new LinkedList<>();
        this.mesRecomendacion = 0;
        recomendaciones.add("Tu recomendación del mes es: Sin senos sí hay paraíso");
        recomendaciones.add("Tu recomendación del mes es: La buena mala madre");
        recomendaciones.add("Tu recomendación del mes es: Sing ven y canta");
        recomendaciones.add("Tu recomendación del mes es: Si la vida te da mandarinas");
        recomendaciones.add("Tu recomendación del mes es: Wednesday");
        recomendaciones.add("Tu recomendación del mes es: Black Pink The Movie");
        recomendaciones.add("Tu recomendación del mes es: Parásitos");
        recomendaciones.add("Tu recomendación del mes es: Princesa Mononoke");
        recomendaciones.add("Tu recomendación del mes es: El increíble castillo vagabundo");
        recomendaciones.add("Tu recomendación del mes es: Los increíbles");
        recomendaciones.add("Tu recomendación del mes es: Jefe en pañales");
        recomendaciones.add("Tu recomendación del mes es: Shrek");
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
        return "Memeflix";
    }
}
