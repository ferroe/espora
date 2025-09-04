package mx.unam.fciencias.espora.practica1;

/**
 * Clase que implementa la estrategia de tarifa para el plan normal de Thisney.
 * 
 * @author Espora
 * @version 1.0
 */

public class TarifaThisney implements TarifaEstrategia {

    /**
     * Este método retorna la tarifa que se cobra por el plan normal de Thisney.
     * 
     * @param subscripcion La suscripción del usuario.
     * @return La tarifa a cobrar de acuerdo a los meses suscrito.
     */
    @Override
    public float cobrar(Suscripcion subscripcion) {
        int meses = subscripcion.getMeses();
        int tarifa;
        if (meses <= 3) {
            tarifa = 130;
        } else {
            tarifa = 160;
        }
        return tarifa;
    }
}
