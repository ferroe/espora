package mx.unam.fciencias.espora.practica3;

/**
 * Clase abstracta para Herramienta
 * 
 * Esta clase hace referencia a las herramientas que puede ser incluidas en los paquetes.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class Herramienta {

    /**
     * Atributos que pertenecen a las herramientas.
     */
    protected String nombre;
    protected double peso;

    /**
     * Constructor de la clase Herramienta.
     * @param nombre el nombre de la herramienta.
     * @param peso el peso de la herramienta.
     */
    public Herramienta(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * Método get que obtiene el nombre de la herramienta.
     * @return el nombre de la herramienta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método get que obtiene el peso de la herramienta.
     * @return el peso de la herramienta.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Método toString que devuelve una representación en cadena de la herramienta.
     * @return una cadena que representa la herramienta.
     */
    @Override
    public String toString() {
        return "Herramienta: " + getNombre() + ", Peso: " + getPeso() + " kg";
    }
}
