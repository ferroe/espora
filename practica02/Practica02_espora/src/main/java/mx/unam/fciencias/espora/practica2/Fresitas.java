package mx.unam.fciencias.espora.practica2;

/**
 * Clase para Fresitas
 * 
 * Esta clase representa las fresitas de ingredientes extra 
 * con sus atributos y métodos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class Fresitas extends IngredienteDecorador {
    
    private Helado helado;

    /**
     * Constructor de la clase Fresitas.
     * @param helado La base del helado que tendrá ingredientes extra.
     */
    public Fresitas(Helado helado) {
        this.helado = helado;
    }

    /**
     * Este metodo obtiene la descripcion del helado.
     * @return Devuelve la descripcion del helado con fresitas.
     */
    public String getDescripcion() {
        return helado.getDescripcion() + ", Fresitas";
    }

    /**
     * Este metodo del costo del helado con fresitas.
     * @return Devuelve el costo del helado con fresitas.
     */
    public double costo() {
        return 10.00 + helado.costo();
    }
}
