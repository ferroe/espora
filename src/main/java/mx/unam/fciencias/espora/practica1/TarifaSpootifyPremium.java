package mx.unam.fciencias.espora.practica1;

/**
 * Esta clase implementa la estrategia de tarifa para el plan premium de Spootify.
 * 
 * @author Espora
 * @version 1.0
 */

public class TarifaSpootifyPremium implements TarifaEstrategia {
    
    /**
     * Este método retorna la tarifa que se cobra por el plan premium de Spootify.
     * 
     * @return $80
     */
    @Override
    public float cobrar(Suscripcion suscripcion) {
        return 80;
    }
}
