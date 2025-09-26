package mx.unam.fciencias.espora.practica3;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase para los paquetes
 * 
 * Clase que representa un paquete de herramientas ninja.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Paquete {

    private String nombre;
    private List<Herramienta> herramientas = new ArrayList<Herramienta>();
    private double pesoTotal = 0.0;

    /*
     * Metodo para darle un nombre al paquete.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
     * Metodo para agregar las herramientas al paquete.
     */
    public void setHerramientas(List<Herramienta> herramientas) {
        this.herramientas = herramientas;
        for (Herramienta herramienta : herramientas) {
            this.pesoTotal += herramienta.getPeso();
        }
    }

    /*
     * Metodo para obtener el peso total del paquete.
     */
    public double getPesoTotal() {
        return pesoTotal;
    }

    /*
     * Metodo para imprimir la informacion del paquete.
     */
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("--- " + this.nombre + " ---\n");
        for (Herramienta herramienta : this.herramientas) {
            cadena.append(herramienta + "\n");
        }
        cadena.append("Peso total: ").append(String.format("%.2f", this.pesoTotal)).append(" kg\n");
        return cadena.toString();
    }
}
