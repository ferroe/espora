package mx.unam.fciencias.espora.practica1;

/**
 * Esta interfaz define la estrategia para el cobro de la tarifa por cada plan.
 * 
 * @author Espora
 * @version 1.0
 */

public interface TarifaEstrategia {

    /**
     * Este método cobra la tarifa de acuerdo al plan del usuario.
     * 
     * @return la tarifa.
     */
    public float cobrar(Suscripcion suscripcion);
}
