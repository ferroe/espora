package mx.unam.fciencias.espora.practica4;

/**
 * Clase GeneroMusical.
 * 
 * Es el enum que contiene a los generos musicales 
 * que estan disponibles en nuestro sistema.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public enum GeneroMusical implements Genero{

    /**
     * Generos Musicales disponibles.
     */
    KPOP("K-POP"),
    REGIONAL_MEXICANO("Regional Mexicano"),
    BALADA("Balada");

    private final String nombre;

    /**
     * Método constructor de la clase GeneroMusical.
     * @param nombre El nombre del genero musical.
     */
    GeneroMusical(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter del nombre del genero musical.
     * @return El nombre del genero musical.
     */
    public String getNombre() {
        return nombre;
    }   
}
