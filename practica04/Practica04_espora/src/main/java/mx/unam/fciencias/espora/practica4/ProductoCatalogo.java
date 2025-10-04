package mx.unam.fciencias.espora.practica4;

/**
 * Interfaz que define los métodos para conocer la información necesaria
 * de un producto en el catálogo.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface ProductoCatalogo {

    /**
     * Obtiene el nombre del producto.
     */
    public String getNombre();

    /**
     * Obtiene el género del producto.
     */
    public Genero getGenero();

    /**
     * Obtiene el precio del producto.
     */
    public double getPrecio();

    /**
     * Imprime el producto.
     */
    public String imprimirProducto();
}
