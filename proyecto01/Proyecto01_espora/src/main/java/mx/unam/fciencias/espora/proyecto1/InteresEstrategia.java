package mx.unam.fciencias.espora.proyecto1;

/**
 * Interfaz para las estrategias de cálculo de interés
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface InteresEstrategia {
    
    /**
     * Método para calcular el interés según la estrategia implementada.
     * 
     * @param cuenta La cuenta sobre el cual se calculará el interés.
     * @return El interés calculado.
     */
    double calcularInteres(Cuenta cuenta);
}
