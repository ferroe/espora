package mx.unam.fciencias.espora.proyecto1;

/**
 * Clase que representa un seguro antifraude para una cuenta bancaria
 * @author Equipo Espora
 * @version 1.0
 */

public class SeguroAntifraude extends ServicioDecorador {

    /**
     * Constructor del seguro antifraude
     * @param cuenta La cuenta del cliente
     */
    public SeguroAntifraude(Cuenta cuenta) {
        super(cuenta);
    }

    /**
     * Metodo comprar con deteccion de fraude
     * @param monto El monto de la compra
     * @return El resultado de la compra
     */
    @Override
    public boolean comprar(double monto) {
        if (esCompraFraudulenta(monto)) {
            String msj = "ALERTA: La compra de $" + monto + " ha sido rechazada por posible fraude.";
            System.out.println(msj);
            super.cuentaDecorada.registrarOperacion(msj);
            return false;
        }
        return super.cuentaDecorada.comprar(monto);
    }

    /**
     * Metodo privado para la deteccion de fraude
     * @param monto El monto de la compra
     * @return El resultado de la deteccion de fraude
     */
    private boolean esCompraFraudulenta(double monto) {
        return monto > 4500;
    }
    
}