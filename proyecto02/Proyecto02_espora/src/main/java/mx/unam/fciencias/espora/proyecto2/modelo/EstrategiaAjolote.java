package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.Map;

/**
 *
 * Estrategia biologica para el ajolote. Ajusta la salud de la poblacion
 * segun contaminacion y calidad del agua.
 *
 */
public class EstrategiaAjolote implements EfectoEstrategia {

    /**
     * Calcula el efecto de la contaminacion y calidad del agua sobre la poblacion.
     * @param poblacion Poblacion objetivo.
     * @param parametros Parametros ambientales (contaminacion, calidadAgua, ...).
     */
    @Override
    public void calcularEfecto(PoblacionEspecie poblacion, Map<String, Double> parametros) {
        System.out.println("El Ajolote: " + poblacion.getNombre());

        double contaminacion = parametros.getOrDefault("contaminacion", 0.0);
        double calidadAgua = parametros.getOrDefault("calidadAgua", 1.0); 

        if (contaminacion > 0.5 || calidadAgua < 0.4) {
            System.out.println("El ajolote enfrenta condiciones adversas (contaminacion/agua). ");
            double saludActual = poblacion.getSalud();
            poblacion.setSaludPromedio(saludActual * 0.85); 
        } else {
            System.out.println("Condiciones favorables para el ajolote.");
            double saludActual = poblacion.getSalud();
            poblacion.setSaludPromedio(saludActual * 1.02);
        }
        
        System.out.println("La nueva salud de " + poblacion.getNombre() + ": " + poblacion.getSalud());
    }
}
