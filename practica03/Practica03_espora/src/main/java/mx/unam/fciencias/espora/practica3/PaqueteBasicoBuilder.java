package mx.unam.fciencias.espora.practica3;

/**
 * Clase para construir un paquete basico.
 * 
 * Esta clase construye un paquete basico con las herramientas
 * especificadas.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PaqueteBasicoBuilder extends PaqueteBuilder {

    /**
     * Constructor por defecto que inicializa el nombre del paquete.
     */
    public PaqueteBasicoBuilder() {
        this.nombre = "Paquete Básico";
    }

    /**
     * Metodo para construir el paquete basico.
     */
    public void construirPaquete() {
        addHerramienta(new Kunai());
        addHerramienta(new Shuriken());
        addHerramienta(new Botiquin());
    }
}
