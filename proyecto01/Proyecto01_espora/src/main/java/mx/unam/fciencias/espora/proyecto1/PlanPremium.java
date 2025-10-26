package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase PlanPremium que implementa a InteresEstrategia.
 * 
 * Esta clase representa al plan premium de nuestro sistema
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PlanPremium implements InteresEstrategia {

    private static final double TASA_PREMIUM = 0.13;
    private static final double SALDO_MINIMO_PREMIUM = 500000.0;

    /**
     * Metodo para calcular el interes en el planPremium
     * @param cuenta La cuenta sobre la cual se calculara el interes
     * @return El interes calculado
     */
    @Override
    public double calcularInteres(Cuenta cuenta) {
        if (cuenta.getSaldo() >= SALDO_MINIMO_PREMIUM) {
            double interes = cuenta.getSaldo() * TASA_PREMIUM;
            return interes;
        } else {
            return 0.0;
        }
    }
}
