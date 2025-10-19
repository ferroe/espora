package mx.unam.fciencias.espora.practica4;

/**
 * Clase GeneroPelicula.
 * 
 * Es el enum que contiene a los generos de peliculas 
 * que estan disponibles en nuestro sistema.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public enum GeneroPelicula implements Genero {

    /**
     * Generos de Peliculas disponibles.
     */
    AVENTURA("Aventura"),
    CIENCIA_FICCION("Ciencia Ficcion"),
    FANTASIA("Fantasia"),
    ANIMADA("Animada");

    private final String nombre;

    /**
     * Constructor de la clase GeneroPelicula.
     * @param nombre El nombre del genero de la pelicula.
     */
    GeneroPelicula(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del genero de la pelicula.
     * @return El nombre del genero de la pelicula.
     */
    public String getNombre() {
        return nombre;
    }   
}
