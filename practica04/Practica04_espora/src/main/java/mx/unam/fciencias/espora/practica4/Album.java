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
    private double precioVenta;

    /**
     * Método constructor de la clase Album.
     * @param nombre Representa el nombre del album.
     * @param artista Representa al artista que hizo el album.
     * @param generoMusical Representa al genero musical que pertenece el album.
     * @param yearEstreno Representa el año en que se estreno el album.
     * @param precioVenta Representa el precio de venta del album.
     */
    public Album(String nombre, String artista, GeneroMusical generoMusical,
                 Year yearEstreno, double precioVenta) {
        this.nombre = nombre;
        this.artista = artista;
        this.generoMusical = generoMusical;
        this.yearEstreno = yearEstreno;
        this.precioVenta = precioVenta;
    }

    /**
     * Metodo getter del nombre del album.
     * @return El nombre del album
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo getter del artista del album
     * @return El nombre del arista del album
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Metodo getter del genero musical del album
     * @return El genero musical del album
     */
    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    /**
     * Metodo getter del año de estreno del album
     * @return El año que se estreno el album
     */
    public Year getYearEstreno() {
        return yearEstreno;
    }

    /**
     * Metodo getter del precio de venta del album
     * @return El precio de venta del album
     */
    public double getPrecioVenta() {
        return precioVenta;
    }   
}
