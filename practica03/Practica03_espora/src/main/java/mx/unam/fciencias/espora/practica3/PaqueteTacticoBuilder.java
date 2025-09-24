package mx.unam.fciencias.espora.practica3;

/**
 * Clase para construir un paquete tactico.
 * 
 * Esta clase construye un paquete tactico con las herramientas
 * especificadas.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PaqueteTacticoBuilder extends PaqueteBuilder {

    /**
     * Constructor por defecto que inicializa el nombre del paquete.
     */
    public PaqueteTacticoBuilder() {
        this.nombre = "Paquete Tactico";
    }

    /**
     * Metodo para construir el paquete tactico.
     */
    public void construirPaquete() {
        for (int i = 0; i < 3; i++) {
            addHerramienta(new Kunai());
        }
        for (int i = 0; i < 2; i++) {
            addHerramienta(new Shuriken());
        }
        for (int i = 0; i < 4; i++) {
            addHerramienta(new PapelBomba());
        }
        for (int i = 0; i < 2; i++) {
            addHerramienta(new BombaHumo());
        }
    }
}
