package mx.unam.fciencias.espora.practica3;

/**
 * Clase para Kunai
 * 
 * Esta clase representa a la herramienta kunai que puede ser incluida en los paquetes.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Kunai extends Herramienta { 

    /**
     * Constructor de la clase Kunai.
     * 
     */
    public Kunai() {
        super("Kunai", 0.5);
    }

    /**
     * Método get que obtiene el nombre del kunai.
     * @return el nombre del kunai.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método get que obtiene el peso del kunai.
     * @return el peso del kunai.
     */
    public double getPeso() {
        return peso;
    }
}
