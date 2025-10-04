package mx.unam.fciencias.espora.practica4;

/**
 * Clase que representa un producto del catalogo de tipo Película.
 * Extiende la clase abstracta Producto.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Pelicula extends Producto {

    /**
     * Constructor de la clase Pelicula.
     * @param nombre Nombre de la película.
     * @param director Director de la película.
     * @param genero Género de la película.
     * @param sinopsis Sinopsis de la película.
     * @param duracion Duración de la película.
     * @param precio Precio de la película.
     */
    public Pelicula(String nombre, String director, GeneroPelicula genero, String sinopsis, int duracion, double precio) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.duracion = duracion;
        this.precio = precio;
    }

    /**
     * Obtiene la duración de la película.
     * @return Duración de la película.
     */
    @Override
    public int getDuracion() {
        return duracion;
    }

    /**
     * Obtiene el precio de la película.
     * @return Precio de la película.
     */
    @Override
    public double getPrecio() {
        return precio;
    }

    /**
     * Imprime la información de la película.
     * @return Información de la película en formato String.
     */
    @Override
    public String imprimirProducto() {
        String infoPeli = "--- Informacion de la Película ---\n";
        infoPeli += "Nombre: " + nombre + "\n";
        infoPeli += "Director: " + director + "\n";
        infoPeli += "Duracion: " + duracion + " mins\n";
        infoPeli += "Genero: " + genero + "\n";
        infoPeli += "Sinopsis: " + sinopsis + "\n";
        infoPeli += "Precio: $" + precio;
        return infoPeli;
    }
}
