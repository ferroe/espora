package mx.unam.fciencias.espora.practica2;

/**
 * Clase para GomitasAro
 * 
 * Esta clase representa a las gomitas de aro que se pondran 
 * en los ingredientes extra junto con sus atributos y métodos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class GomitasAro extends IngredienteDecorador {

    /**
     * Atributo que representa la base del helado.
     */
    private Helado helado;

    /**
     * Constructor de la clase GomitasAro.
     * @param helado La base del helado que tendrá ingredientes extra.
     */
    public GomitasAro(Helado helado) {
        this.helado = helado;
    }

    /**
     * EEste metodo obtiene la descripcion del helado.
     * @return Devuelve la descripcion del helado con gomitas de aro.
     */
    public String getDescripcion() {
        return helado.getDescripcion() + ", Gomitas de aro";
    }

    /**
     * Este metodo del costo del helado con gomitas de aro.
     * @return Devuelve el costo del helado con gomitas de aro.
     */
    public double costo() {
        return 10.00 + helado.costo();
    }

    /**
     * Este método define cómo se prepara el producto.
     */
    @Override
    public void preparar() {
        helado.preparar();        
        System.out.println("-> Añadiendo ingrediente: Gomitas de aro");
    }
}
