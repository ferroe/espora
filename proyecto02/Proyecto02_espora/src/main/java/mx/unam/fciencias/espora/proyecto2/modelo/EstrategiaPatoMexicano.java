package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.Map;

/**
 *
 * Estrategia biologica para el pato mexicano. Afecta tamanio y salud
 * segun nivel de agua y presencia de especies invasoras.
 *
 */
public class EstrategiaPatoMexicano implements EfectoEstrategia {

    /**
     * Calcula el efecto de nivel de agua e invasoras sobre la poblacion.
     * @param poblacion Poblacion objetivo.
     * @param parametros Parametros ambientales (nivelAgua, especiesInvasoras, ...).
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
            System.out.println("Hay un nuevo tamano: " + poblacion.getTamanio());

        } else {
            System.out.println("Nivel de especies invasoras bajo (" + invasoras + ").");
        }
        
        if (nivelAgua < 0.3) {
            System.out.println("El nivel de agua esta bajo (" + nivelAgua + ")");
            double saludActual = poblacion.getSalud();
            poblacion.setSaludPromedio(saludActual * 0.88);
            System.out.println("La nueva salud es: " + poblacion.getSalud());
        }
    }
}
