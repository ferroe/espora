package mx.unam.fciencias.espora.practica4;

/**
 * Clase abstracta que representa un producto dentro del catálogo.
 * Implementa la interfaz ProductoCatalogo.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class Producto implements ProductoCatalogo {

    protected String nombre;
    protected String director;
    protected int duracion;
    protected GeneroPelicula genero;
    protected String sinopsis;
    protected double precio;

    /**
     * Constructor de la clase Producto.
     * 
     * @param nombre   Nombre del producto.
     * @param director Director de la saga/película.
     * @param genero   Género del producto.
     * @param sinopsis Sinopsis de la saga/película.
     */
    public Producto(String nombre, String director, GeneroPelicula genero, String sinopsis) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el director de la saga/película.
     * @return El director de la saga/película.
     */
    public String getDirector() {
        return director;
    }

    /** 
     * Obtiene la duración del producto.
     */
    public abstract int getDuracion();

    /** 
     * Obtiene el género del producto.
     * @return El género del producto.
     */
    public GeneroPelicula getGenero() {
        return genero;
    }

    /**
     * Obtiene la sinopsis de la saga/película.
     * @return La sinopsis de la saga/película.
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * Obtiene el precio del producto.
     */
    public abstract double getPrecio();

    /**
     * Imprime el producto.
     */
    public abstract String imprimirProducto();
}
