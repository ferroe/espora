package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.Map;

/**
 *
 * Estrategia biologica para la Rana Moctezuma. Evalua contaminacion
 * y presencia de invasoras para ajustar la salud de la poblacion.
 *
 */
public class EstrategiaRanaMoctezuma implements EfectoEstrategia {

    /**
     * Calcula el efecto combinado de contaminacion e invasoras.
     * @param poblacion Poblacion objetivo.
     * @param parametros Parametros ambientales (contaminacion, especiesInvasoras, ...).
     */
    @Override
    public void calcularEfecto(PoblacionEspecie poblacion, Map<String, Double> parametros) {
        System.out.println("La Rana Moctezuma: " + poblacion.getNombre());

        double contaminacion = parametros.getOrDefault("contaminacion", 0.0);
        double invasoras = parametros.getOrDefault("especiesInvasoras", 0.0);
        if (contaminacion > 0.4 || invasoras > 0.4) {
            System.out.println("¡Amenaza para la Rana!");
            double saludActual = poblacion.getSalud();
            poblacion.setSaludPromedio(saludActual * 0.80);

        } else {
            poblacion.setSaludPromedio(Math.min(1.0, poblacion.getSalud() * 1.05));
        }
    }
}
