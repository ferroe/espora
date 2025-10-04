package mx.unam.fciencias.espora.practica4;

/**
 * Clase para AlbumAdapter.
 * 
 * Esta clase implementa la interfaz ProductoCatalogo 
 * y el el adapter para la clase Album.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class AlbumAdapter implements ProductoCatalogo {

    private Album album;

    /**
     * Método constructor AlbumAdapter.
     * @param album Devuelve el album.
     */
    public AlbumAdapter(Album album) {
        this.album = album;
    }  

    /**
     * Metodo getter del nombre del album.
     * @return Devuelve el nombre del album.
     */
    @Override
    public String getNombre() {
        return this.album.getNombre();
    }

    /**
     * Metodo getter del genero musical del album,
     * @return Devuelve el genero musical del album.
     */
    @Override
    public String getGenero() {
        return this.album.getGeneroMusical().getNombre();
    }

    /**
     * Metodo getter del precio del album.
     * @return Devuelve el precio del album.
     */
    @Override
    public double getPrecio() {
        return this.album.getPrecioVenta();
    }

    /**
     * Metodo para consultar el album y sus caracteristicas.
     * @return Devuelve un String con las caracteristicas del album.
     */
    @Override
    public String consultarProducto() {
    String precioFormateado = String.format("%.2f", this.album.getPrecioVenta());
    return "--- ÁLBUM DE MÚSICA ---\n" +
           "Título: " + this.album.getNombre() + "\n" +
           "Artista: " + this.album.getArtista() + "\n" +
           "Género: " + this.album.getGeneroMusical().getNombre() + "\n" +
           "Año de Estreno: " + this.album.getYearEstreno() + "\n" +
           "Precio: $" + precioFormateado;
    }
}
