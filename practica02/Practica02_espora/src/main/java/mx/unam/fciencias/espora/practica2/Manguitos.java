package mx.unam.fciencias.espora.practica2;

/**
 * Clase para Manguitos
 * 
 * Esta clase representa a los manguitos que se pondran 
 * en los ingredientes extra junto con sus atributos y métodos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Manguitos extends IngredienteDecorador {
    
    private Helado helado;

    /**
     * Constructor de la clase Manguitos.
     * @param helado La base del helado que tendrá ingredientes extra.
     */
    public Manguitos(Helado helado) {
        this.helado = helado;
    }

    /**
     * Este metodo obtiene la descripcion del helado.
     * @return Devuelve la descripcion del helado con manguitos.
     */
    public String getDescripcion() {
        return helado.getDescripcion() + ", Manguitos";
    }

    /**
     * Este metodo del costo del helado con manguitos.
     * @return Devuelve el costo del helado con manguitos.
     */
    public double costo() {
        return 10.00 + helado.costo();
    }  
}
