package mx.unam.fciencias.espora.practica3;

/**
 * Clase para Botiquin
 * 
 * Esta clase hace referencia a la herramienta botiquín que puede ser incluida en los paquetes.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Botiquin extends Herramienta {

    /**
     * Constructor de la clase Botiquin.
     * 
     */
    public Botiquin() {
        super("Botiquín", 1.0);
    }

    /**
     * Método get que obtiene el nombre del botiquín.
     * @return el nombre del botiquín.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método get que obtiene el peso del botiquín.
     * @return el peso del botiquín.
     */
    public double getPeso() {
        return peso;
    }
}
