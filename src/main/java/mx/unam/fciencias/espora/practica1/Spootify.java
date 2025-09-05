package mx.unam.fciencias.espora.practica1;

import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase representa al sujeto Spootify
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Spootify implements Sujeto {

    private LinkedList<Cliente> clientes;
    private List<String> recomendaciones;
    private int mesRecomendacion;

    /**
     * Constructor de la clase Spootify.
     */
    public Spootify() {
        this.clientes = new LinkedList<>();
        this.recomendaciones = new LinkedList<>();
        this.mesRecomendacion = 0;
        recomendaciones.add("Tu recomendación del mes es: Álbum: Eyes Wide Open- Twice");
        recomendaciones.add("Tu recomendación del mes es: Artista: Taylor Swift");
        recomendaciones.add("Tu recomendación del mes es: Canción: I love you- Billie Eilish");
        recomendaciones.add("Tu recomendación del mes es: Podcast: Las Alucines");
        recomendaciones.add("Tu recomendación del mes es: Álbum: Map of the Soul: 7- BTS");
        recomendaciones.add("Tu recomendación del mes es: Artista: Bad Bunny");
        recomendaciones.add("Tu recomendación del mes es: Canción: Earthquake- Jisoo");
        recomendaciones.add("Tu recomendación del mes es: Podcast: Entiende tu mente");
        recomendaciones.add("Tu recomendación del mes es: Álbum: 5-Star- Stray Kids");
        recomendaciones.add("Tu recomendación del mes es: Artista: Wonstein");
        recomendaciones.add("Tu recomendación del mes es: Canción: Mago- G-Friend");
        recomendaciones.add("Tu recomendación del mes es: Podcast: Radio Ambulante");
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
    public void notificar() { 
        for (Cliente cliente : clientes) {
            Suscripcion suscripcion = cliente.getSuscripcion();
            if (suscripcion.getIsActiva() && suscripcion != null) {
                Tarifa tarifa = suscripcion.getTarifa();
                float cobro = tarifa.cobrar(suscripcion);
                String recomendacion = this.getRecomendacion();
                cliente.actualizar(this, cobro, recomendacion);
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
            mesRecomendacion = mesRecomendacion ++;
        }
        return recomendacion;
    }

    /**
     * Este método obtiene el nombre del sujeto.
     * @return El nombre del sujeto.
     */
    public String getNombre() {
        return "Spootify";
    }
}
