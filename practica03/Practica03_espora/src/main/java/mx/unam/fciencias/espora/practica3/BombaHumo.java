package mx.unam.fciencias.espora.practica3;

/**
 * Clase para BombaHumo
 * 
 * Esta clase hace referencia a la herramienta bomba de humo que puede ser incluida en los paquetes.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class BombaHumo extends Herramienta {

    /**
     * Constructor de la clase BombaHumo.
     * 
     */
    public BombaHumo() {
        super("Bomba de Humo", 0.2);
    }

    /**
     * Método get que obtiene el nombre de la bomba de humo.
     * @return el nombre de la bomba de humo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método get que obtiene el peso de la bomba de humo.
     * @return el peso de la bomba de humo.
     */
    public double getPeso() {
        return peso;
    }

}
