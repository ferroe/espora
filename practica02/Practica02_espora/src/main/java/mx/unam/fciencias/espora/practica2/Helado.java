package mx.unam.fciencias.espora.practica2;

/**
 * Clase abstracta para los helados.
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class Helado implements Producto {
    
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

    @Override
    public String getInfoTicket() {
        return getDescripcion();
    }

    @Override
    public void preparar() {
        // Esta es la implementación por defecto para los sabores base.
        System.out.println("Sirviendo base: " + getDescripcion());
    }
}
