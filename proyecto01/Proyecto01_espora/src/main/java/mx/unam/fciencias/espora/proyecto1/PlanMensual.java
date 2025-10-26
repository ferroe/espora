package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase PlanMensual que implementa a InteresEstrategia.
 * 
 * Esta clase representa al plan mensual de nuestro sistema
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PlanMensual implements InteresEstrategia {

    private static final double TASA_MENSUAL = 0.05;
    private static final double SALDO_MINIMO_MENSUAL = 1000.0;

    /**
     * Metodo para calcular el interes en el Plan Mensual
     * @param cuenta La cuenta sobre la cual se calculara el interes
     * @return El interes calculado
     */
    @Override
    public double calcularInteres(Cuenta cuenta) {
        if (cuenta.getSaldo() >= SALDO_MINIMO_MENSUAL) {
            double interes = cuenta.getSaldo() * TASA_MENSUAL;
            return interes;
        } else {
            return 0.0;
        }
    }
 }
