package mx.unam.fciencias.espora.proyecto1;

/**
 * Interfaz InteresEstrategia.
 * 
 * Esta clase representa a un album de nuestro sistema
 * con sus atributos que lo definen.
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
