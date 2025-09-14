package mx.unam.fciencias.espora.practica2;

/**
 * Interfaz para los productos de la pizzeria.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface Producto {

    /**
     * Este método trae la información del producto para el ticket.
     */
    public String getInfoTicket();

    /**
     * Este método define el costo del producto.
     */
    public double costo();

    /**
     * Este método define cómo se prepara el producto.
     */
    public void preparar();
}
