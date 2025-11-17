package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.Map;

/**
 * Esta es la estrategia para la rana moctezuma, que implementa la
 * clase EfectoEstrategia
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class EstrategiaRanaMoctezuma implements EfectoEstrategia {

    /**
     * Metodo que calcula el efecto de la estrategia de la poblacion
     * en el que la rana moctezuma reacciona con la contaminacion y especies invasoras
     * 
     * @param poblacion La poblacion a la que se le aplica el efecto
     * @param parametros los parametros ambientales que afectan a la poblacion
     */
    @Override
    public void calcularEfecto(PoblacionEspecie poblacion, Map<String, Double> parametros) {
        System.out.println("La Rana Moctezuma: " + poblacion.getNombre());

        double contaminacion = parametros.getOrDefault("contaminacion", 0.0);
        double invasoras = parametros.getOrDefault("especiesInvasoras", 0.0);
        if (contaminacion > 0.4 && invasoras > 0.4) {
            System.out.println("Hay un amenaza combinada (Contaminación: " + contaminacion + ", Invasoras: " + invasoras + ")");
            double saludActual = poblacion.getSalud();
            poblacion.setSaludPromedio(saludActual * 0.90);
            System.out.println("Su nueva salud es: " + poblacion.getSalud());

        } else {
            System.out.println("Estas en condiciones aceptables, la rana resiste.");
        }
    }
}
