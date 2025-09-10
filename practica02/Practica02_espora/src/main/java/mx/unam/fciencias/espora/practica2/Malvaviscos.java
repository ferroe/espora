package mx.unam.fciencias.espora.practica2;

/**
 * Clase para Malvaviscos
 * 
 * Esta clase representa un malvavisco con sus atributos y métodos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Malvaviscos extends IngredienteDecorador {
    
    private Helado helado;

    /**
     * Constructor de la clase Malvaviscos
     * @param helado Es el nombre del atributo helado.
     */
    public Malvaviscos(Helado helado) {
        this.helado = helado;
    }

    /**
     * Este metodo get que obtiene la descripcion del helado 
     * @return Devuelve la descripcion del helado con malvaviscos.
     */
    public String getDescripcion() {
        return helado.getDescripcion() + ", Malvaviscos";
    }

    /**
     * Este metodo del costo del helado con malvaviscos
     * @return Devuelve el costo del helado con malvaviscos
     */
    public double costo() {
        return 10.00 + helado.costo();
    }  
}
