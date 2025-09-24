package mx.unam.fciencias.espora.practica3;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta para construir los paquetes de herramientas.
 * 
 * Esta clase define los métodos necesarios para construir un paquete de herramientas.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class PaqueteBuilder {

    protected String nombre;
    protected List<Herramienta> herramientas = new ArrayList<Herramienta>();

    /**
     * Metodo para añadir herramientas al paquete.
     */
    public PaqueteBuilder addHerramienta(Herramienta herramienta) {
        this.herramientas.add(herramienta);
        return this;
    }

    /**
     * Metodo para obtener el paquete construido.
     * 
     * @return el paquete construido.
     */
    public Paquete getPaquete() {
        Paquete paquete = new Paquete();
        paquete.setNombre(this.nombre);
        paquete.setHerramientas(this.herramientas);
        return paquete;
    }
}
