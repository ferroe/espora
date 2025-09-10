package mx.unam.fciencias.espora.practica2;

/**
 * Clase para Kiwis
 * 
 * Esta clase representa a los kiwis que se pondran 
 * en los ingredientes extra junto con sus atributos y métodos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Kiwis extends IngredienteDecorador {
    
    private Helado helado;

    /**
     * Constructor de la clase Kiwis
     * @param helado Es el nombre del atributo helado.
     */
    public Kiwis(Helado helado) {
        this.helado = helado;
    }

    /**
     * Este metodo get que obtiene la descripcion del helado 
     * @return Devuelve la descripcion del helado con kiwis
     */
    public String getDescripcion() {
        return helado.getDescripcion() + ", Kiwis";
    }

    /**
     * Este metodo del costo del helado con kiwis
     * @return Devuelve el costo del helado con kiwis
     */
    public double costo() {
        return 10.00 + helado.costo();
    }  
}
