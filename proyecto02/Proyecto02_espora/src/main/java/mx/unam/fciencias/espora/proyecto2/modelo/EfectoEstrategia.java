package mx.unam.fciencias.espora.proyecto2.modelo;

import java.util.Map;

/**
 *
 * Interfaz para estrategias que calculan el efecto ambiental sobre una poblacion.
 *
 */
public interface EfectoEstrategia {

    /**
     * Calcula y aplica el efecto de la estrategia sobre la poblacion.
     * @param poblacion Poblacion objetivo.
     * @param parametros Mapa con parametros ambientales relevantes.
     */
    public void calcularEfecto(PoblacionEspecie poblacion, Map<String, Double> parametros);
    
}
