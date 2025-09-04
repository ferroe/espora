package mx.unam.fciencias.espora.practica1;

/**
 * Esta clase implementa la estrategia de tarifa para el plan de
 * Hvo.
 * 
 * @author Espora
 * @version 1.0
 */

public class TarifaHvo implements TarifaEstrategia {

    /**
     * Este método retorna la tarifa que se cobra por el plan de Hvo.
     * 
     * @param subscripcion La suscripción del usuario.
     * @return La tarifa a de acuerdo a los meses suscrito.
     */
    @Override
    public float cobrar(Suscripcion subscripcion) {
        int meses = subscripcion.getMeses();
        int tarifa;
        if (meses <= 3) {
            tarifa = 0;
        } else {
            tarifa = 140;
        }
        return tarifa;
    }
}
