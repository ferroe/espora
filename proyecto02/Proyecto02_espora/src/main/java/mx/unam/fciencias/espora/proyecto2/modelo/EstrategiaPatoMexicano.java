package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.Map;

/**
 * Esta es la estrategia para el pato mexicano, que implementa la
 * clase EfectoEstrategia
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class EstrategiaPatoMexicano implements EfectoEstrategia {

    /**
     * Metodo que calcula el efecto de la estrategia de la poblacion
     * en el que el pato mexicano reacciona con el nivel del agua y especies invasoras
     * 
     * @param poblacion La poblacion a la que se le aplica el efecto
     * @param parametros los parametros ambientales que afectan a la poblacion
     */
    @Override
    public void calcularEfecto(PoblacionEspecie poblacion, Map<String, Double> parametros) {

        System.out.println("El Pato Mexicano: " + poblacion.getNombre());

        double nivelAgua = parametros.getOrDefault("nivelAgua", 0.0);
        double invasoras = parametros.getOrDefault("especiesInvasoras", 0.0);
        
        if (invasoras > 0.6) {
            System.out.println("Hay muchas especies invasoras (" + invasoras + ")");
            int tamanioActual = poblacion.getTamanio();
            poblacion.setTamanio((int)(tamanioActual * 0.85));
            System.out.println("Hay un nuevo tamaño: " + poblacion.getTamanio());

        } else {
            System.out.println("Hay un nivel de especies invasoras BAJO (" + invasoras + ").");
        }
        
        if (nivelAgua < 0.3) {
            System.out.println("El nivel de agua esta bajo (" + nivelAgua + ")");
            double saludActual = poblacion.getSalud();
            poblacion.setSaludPromedio(saludActual * 0.88);
            System.out.println("La nueva salud es: " + poblacion.getSalud());
        }
    }
}
