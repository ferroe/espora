package mx.unam.fciencias.espora.practica1;

/**
 * Esta clase implementa la estrategia de tarifa para el plan de
 * un dispositivo de Memeflix.
 * 
 * @author Espora
 * @version 1.0
 */

public class TarifaMemeflixUno implements TarifaEstrategia {

    /**
     * Este método retorna la tarifa que se cobra por el plan de un
     * dispositivo de Memeflix.
     * 
     * @return $120
     */
    @Override
    public float cobrar(Suscripcion suscripcion) {
        return 120;
    }
}
