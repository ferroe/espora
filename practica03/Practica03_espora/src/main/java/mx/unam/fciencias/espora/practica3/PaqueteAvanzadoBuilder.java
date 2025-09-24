package mx.unam.fciencias.espora.practica3;

/**
 * Clase para construir un paquete avanzado.
 * 
 * Esta clase construye un paquete avanzado con las herramientas
 * especificadas.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PaqueteAvanzadoBuilder extends PaqueteBuilder {

    /**
     * Constructor por defecto que inicializa el nombre del paquete.
     */
    public PaqueteAvanzadoBuilder() {
        this.nombre = "Paquete Avanzado";
    }

    /**
     * Metodo para construir el paquete avanzado.
     */
    public void construirPaquete() {
        for (int i = 0; i < 2; i++) {
            addHerramienta(new Shuriken());
        }
        for (int i = 0; i < 3; i++) {
            addHerramienta(new PapelBomba());
        }
        for (int i = 0; i < 2; i++) {
            addHerramienta(new BombaHumo());
        }
        for (int i = 0; i < 2; i++) {
            addHerramienta(new Botiquin());
        }
    }    
}
