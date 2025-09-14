package mx.unam.fciencias.espora.practica2;

/**
 * Clase abstracta para los helados.
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class Helado implements Producto {

    /**
     * Atributo que representa la descripción del helado.
     */
    protected String descripcion = "Helado desconocido";

    /**
     * Este método regresa la descripción del helado.
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Este método regresa el costo del helado.
     */
    public abstract double costo();

    /**
     * Este método regresa la información del helado para el ticket.
     */
    @Override
    public String getInfoTicket() {
        return getDescripcion();
    }

    /**
     * Método que sirve como base para los sabores de helado.
     */
    @Override
    public void preparar() {
        System.out.println("Sirviendo base: " + getDescripcion());
    }
}
