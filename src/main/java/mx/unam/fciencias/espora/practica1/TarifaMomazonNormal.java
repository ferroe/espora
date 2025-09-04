package mx.unam.fciencias.espora.practica1;

/**
 * Esta clase implementa la estrategia de tarifa para el plan normal de Momazon.
 * 
 * @author Espora
 * @version 1.0
 */

public class TarifaMomazonNormal implements TarifaEstrategia {

    /**
     * Este método retorna la tarifa que se cobra por el plan normal de Momazon.
     * 
     * @return $110
     */
    @Override
    public float cobrar() {
        return 110;
    }
}
