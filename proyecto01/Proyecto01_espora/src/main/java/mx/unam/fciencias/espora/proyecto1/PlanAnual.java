package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase PlanAnual que implementa a InteresEstrategia.
 * 
 * Esta clase representa al plan anual de nuestro sistema
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PlanAnual implements InteresEstrategia {

    private static final double TASA_ANUAL = 0.08;
    private static final double SALDO_PROMEDIO_ANUAL = 50000.0;

    /**
     * Metodo para calcular el interes en el Plan Anual
     * @param cuenta La cuenta sobre la cual se calculara el interes
     * @return El interes calculado
     */
    @Override
    public double calcularInteres(Cuenta cuenta) {

        boolean mesDoce = cuenta.mesAniversario();
        double saldoPromedio = cuenta.getSaldoPromedioAnual();

        if (mesDoce && saldoPromedio >= SALDO_PROMEDIO_ANUAL) {
            double interes = cuenta.getSaldo() * TASA_ANUAL;
            cuenta.reiniciarPromedioAnual();
            return interes;
        } else {
            if (mesDoce){
                cuenta.reiniciarPromedioAnual();
            }
            return 0.0;
        }
    }    
}
 