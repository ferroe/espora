package mx.unam.fciencias.espora.practica2;

/**
 * Clase abstracta para los ingredientes decoradores.
 * Extiende de Helado.
 * @author Equipo Espora
 * @version 1.0
 */

public abstract class IngredienteDecorador extends Helado {

    /**
     * Este método regresa la descripción del helado con el ingrediente extra.
     */
    public abstract String getDescripcion();
}
