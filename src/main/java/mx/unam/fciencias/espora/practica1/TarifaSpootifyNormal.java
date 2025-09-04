package mx.unam.fciencias.espora.practica1;

/**
 * Esta clase implementa la estrategia de tarifa para el plan normal de Spootify.
 * 
 * @author Espora
 * @version 1.0
 */

public class TarifaSpootifyNormal implements TarifaEstrategia {

    /**
     * Este método retorna la tarifa que se cobra por el plan normal de Spootify.
     * 
     * @return $0
     */
    @Override
    public float cobrar() {
        return 0;
    }
}
