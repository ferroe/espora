package mx.unam.fciencias.espora.proyecto2;

import java.util.Map;

/**
 * Esta es la estrategia para el ajolote, que implementa la
 * clase EfectoEstrategia
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class EstrategiaAjolote implements EfectoEstrategia {

    /**
     * Metodo que calcula el efecto de la estrategia de la poblacion
     * en el que el ajolote reacciona con la contaminacion y calidad del agua
     * 
     * @param poblacion La poblacion a la que se le aplica el efecto
     * @param parametros los parametros ambientales que afectan a la poblacion
     */
    @Override
    public void calcularEfecto(PoblacionEspecie poblacion, Map<String, Double> parametros) {
        
        System.out.println("El Ajolote: " + poblacion.getNombre());

        double contaminacion = parametros.getOrDefault("contaminacion", 0.0);
        double calidadAgua = parametros.getOrDefault("calidadAgua", 1.0); 

        if (contaminacion > 0.5 || calidadAgua < 0.4) {
            
            System.out.println("El ajolote enfrenta las siguientes condiciones Contaminación/Calidad Agua MALAS.");
            
            double saludActual = poblacion.getSalud();
            poblacion.setSaludPromedio(saludActual * 0.85); 

        } else {
            
            System.out.println("El ajolote enfrenta las siguientes condiciones Contaminación/Calidad Agua BUENAS.");
            
            double saludActual = poblacion.getSalud();
            poblacion.setSaludPromedio(saludActual * 1.02);
        }
        
        System.out.println("La nueva salud de " + poblacion.getNombre() + ": " + poblacion.getSalud());
    }
}
