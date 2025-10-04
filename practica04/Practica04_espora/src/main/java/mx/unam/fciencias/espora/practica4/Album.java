package mx.unam.fciencias.espora.practica4;

import java.time.Year;

/**
 * Clase Album.
 * 
 * Esta clase representa a un album de nuestro sistema
 * con sus atributos que lo definen.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Album {

    private String nombre;
    private String artista;
    private GeneroMusical generoMusical;
    private Year yearEstreno;
    private double precio;

    /**
     * Constructor de la clase Album.
     * @param nombre Representa el nombre del album.
     * @param artista Representa al artista que hizo el album.
     * @param generoMusical Representa al genero musical que pertenece el album.
     * @param yearEstreno Representa el año en que se estreno el album.
     * @param precio Representa el precio de venta del album.
     */
    public Album(String nombre, String artista, GeneroMusical generoMusical,
                 Year yearEstreno, double precio) {
        this.nombre = nombre;
        this.artista = artista;
        this.generoMusical = generoMusical;
        this.yearEstreno = yearEstreno;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del album.
     * @return El nombre del album
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el artista del album
     * @return El nombre del arista del album
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Obtiene el genero musical del album
     * @return El genero musical del album
     */
    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    /**
     * Obtiene el año de estreno del album
     * @return El año que se estreno el album
     */
    public Year getYearEstreno() {
        return yearEstreno;
    }

    /**
     * Obtiene el precio de venta del album
     * @return El precio de venta del album
     */
    public double getPrecio() {
        return precio;
    }   
}
