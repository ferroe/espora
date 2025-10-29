package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase PlanAnual que implementa a InteresEstrategia.
 * Esta clase define la estrategia para calcular el interés
 * anual de acuerdo con el proyecto
 *
 * @author Equipo Espora
 * @version 1.0
 */
public class PlanAnual implements InteresEstrategia {

    private static final double TASA_ANUAL = 0.08;
    private static final double SALDO_PROMEDIO_ANUAL_MINIMO = 50000.0;
    private static final int MESES_DEL_CICLO = 12;

    /**
     * Metodo para calcular el interes en el Plan Anual.
     * @param cuenta La cuenta sobre la cual se calculara el interes.
     * @return El interes calculado.
     */
    @Override
    public double calcularInteres(Cuenta cuenta) {

        int mesesCiclo = cuenta.getMesesPromedio();

        if (mesesCiclo == MESES_DEL_CICLO) {
            
            double sumaSaldos = cuenta.getSumaSaldosPromedio();
            double saldoPromedio = sumaSaldos / MESES_DEL_CICLO;

            double interesGenerado = 0.0;

            if (saldoPromedio >= SALDO_PROMEDIO_ANUAL_MINIMO) {
                interesGenerado = cuenta.getSaldo() * TASA_ANUAL;
            }


            cuenta.reiniciarPromedioAnual();

            return interesGenerado;

        } else {
            return 0.0;
        }
    }
}
