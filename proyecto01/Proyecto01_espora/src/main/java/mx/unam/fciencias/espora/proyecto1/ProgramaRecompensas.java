package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase que representa un programa de recompensas
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ProgramaRecompensas extends ServicioDecorador {

    private int puntosAcumulados;

    /**
     * Constructor del programa de recompensas
     * @param cuenta La cuenta del cliente
     */
    public ProgramaRecompensas(Cuenta cuenta) {
        super(cuenta);
        this.puntosAcumulados = 0;
    }

    /**
     * Metodo comprar con acumulacion de puntos
     * @param monto El monto de la compra
     * @return El resultado de la compra
     */
    @Override
    public boolean comprar(double monto) {
        boolean exito = super.cuentaDecorada.comprar(monto);
        if (exito) {
            acumularPuntos(monto);
        }
        return exito;
    }

    /**
     * Método auxiliar para calcular y acumular los puntos
     * @param monto El monto de la compra exitosa
     */
    private void acumularPuntos(double monto) {
        int puntosGanados = (int) (monto / 10.0);
        if (puntosGanados > 0) {
            this.puntosAcumulados += puntosGanados;
            String mensaje = "Recompensas: Ganaste " + puntosGanados + " puntos. Total acumulado: " + this.puntosAcumulados;
            System.out.println(mensaje);
            super.cuentaDecorada.registrarOperacion(mensaje);
        }
    }

    /**
     * Consulta los puntos acumulados
     * @return El total de puntos acumulados
     */
    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }
}
