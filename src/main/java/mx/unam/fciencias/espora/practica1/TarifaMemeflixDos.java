package mx.unam.fciencias.espora.practica1;

/**
 * Esta clase implementa la estrategia de tarifa para el plan de
 * dos dispositivos de Memeflix.
 * 
 * @author Espora
 * @version 1.0
 */

public class TarifaMemeflixDos implements TarifaEstrategia {

    /**
     * Este método retorna la tarifa que se cobra por el plan de dos
     * dispositivos de Memeflix.
     * 
     * @return $170
     */
    @Override
    public float cobrar(Suscripcion suscripcion) {
        return 170;
    }
}
