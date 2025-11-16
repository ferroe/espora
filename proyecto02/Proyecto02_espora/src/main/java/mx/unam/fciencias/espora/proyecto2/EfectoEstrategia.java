package mx.unam.fciencias.espora.proyecto2;

import java.util.Map;

/**
 * Esta interfaz es la estrategia de efecto
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public interface EfectoEstrategia {

    /**
     * Calcula el efecto de la estrategia en la poblacion
     * @param parametros Los parametros ambientales que afectan a la poblacion
     */
    public void calcularEfecto(PoblacionEspecie poblacion, Map<String, Double> parametros);
    
}
