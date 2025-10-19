package mx.unam.fciencias.espora.practica4;

import java.util.ArrayList;
import java.util.List;  

/**
 * Clase que representa una saga de productos (películas, series, etc.).
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Saga extends Producto {

    /**
     * Lista de productos que conforman la saga.
     */
    private List<Producto> productos = new ArrayList<Producto>();

    /**
     * Constructor de la clase Saga.
     * @param nombre Nombre correspondiente a la saga.
     * @param director Director de la saga.
     * @param genero Género al que pertenece la saga.
     * @param sinopsis Sinopsis de la saga.
     */
    public Saga(String nombre, String director, GeneroPelicula genero, String sinopsis) {
        super(nombre, director, genero, sinopsis);
        this.productos = new ArrayList<Producto>();
    }

    /**
     * Añade un producto a la saga.
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Elimina un producto de la saga.
     * @param producto El producto a eliminar.
     */
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    /**
     * Obtiene la lista de productos en la saga.
     * @return Lista de los productos en la saga.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Obtiene la duración total de la saga.
     * @return Duración total de la saga.
     */
    @Override
    public int getDuracion() {
        int duracionTotal = 0;
        for (Producto producto : productos) {
            duracionTotal += producto.getDuracion();
        }
        return duracionTotal;
    }

    /**
     * Obtiene el precio total de la saga aplicando un descuento del 5%.
     * @return Precio total de la saga con el descuento aplicado.
     */
    @Override
    public double getPrecio() {
        double precioTotal = 0.0;
        for (Producto producto : productos) {
            precioTotal += producto.getPrecio();
        }
        precioTotal *= 0.95;
        return precioTotal;
    }

    /**
     * Imprime la información de la saga y sus productos.
     * @return Información de la saga en formato String.
     */
    @Override
    public String imprimirProducto() {
        String infoSaga = "--- Informacion de la Saga ---\n";
        infoSaga += "Nombre: " + nombre + "\n";
        infoSaga += "Director: " + director + "\n";
        infoSaga += "Duracion total: " + getDuracion() + " minutos\n";
        infoSaga += "Genero: " + genero.getNombre() + "\n";
        infoSaga += "Sinopsis: " + sinopsis + "\n";
        infoSaga += "Precio total: $" + getPrecio() + "\n";
        infoSaga += "Productos en la saga:\n\n";
        for (Producto producto : productos) {
            infoSaga += producto.imprimirProducto() + "\n";
        }
        return infoSaga;
    }
}
