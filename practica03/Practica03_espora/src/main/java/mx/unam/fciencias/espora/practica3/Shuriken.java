package mx.unam.fciencias.espora.practica3;

/**
 * Clase para Shuriken
 * 
 * Esta clase hace referencia a la herramienta shuriken que puede ser incluida en los paquetes.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Shuriken extends Herramienta {


    /**
     * Constructor de la clase Shuriken.
     * 
     */
    public Shuriken() {
        super("Shuriken", 0.3);
    }

    /**
     * Método get que obtiene el nombre del shuriken.
     * @return el nombre del shuriken.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método get que obtiene el peso del shuriken.
     * @return el peso del shuriken.
     */
    public double getPeso() {
        return peso;
    }

}
