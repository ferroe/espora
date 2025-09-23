package mx.unam.fciencias.espora.practica3;

/**
 * Clase para PapelBomba
 * 
 * Esta clase hace referencia a la herramienta papel bomba que puede ser incluida en los paquetes.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PapelBomba extends Herramienta {

    /**
     * Constructor de la clase PapelBomba.
     * 
     */
    public PapelBomba() {
        super("Papel Bomba", 0.1);
    }

    /**
     * Método get que obtiene el nombre del papel bomba.
     * @return el nombre del papel bomba.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método get que obtiene el peso del papel bomba.
     * @return el peso del papel bomba.
     */
    public double getPeso() {
        return peso;
    }

}
