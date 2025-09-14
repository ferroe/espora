package mx.unam.fciencias.espora.practica2;

/**
 * Clase para ChispasChocolate
 * 
 * Esta clase representa a las chispas de chocolate que se pondran 
 * en los ingredientes extra junto con sus atributos y métodos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class ChispasChocolate extends IngredienteDecorador {

    /**
     * Atributo que representa la base del helado.
     */
    private Helado helado;

    /**
     * Constructor de la clase ChispasChocolate
     * @param helado La base del helado que tendrá ingredientes extra
     */
    public ChispasChocolate(Helado helado) {
        this.helado = helado;
    }

    /**
     * Este metodo obtiene la descripcion del helado 
     * @return Devuelve la descripcion del helado con chispas de chocolate.
     */
    public String getDescripcion() {
        return helado.getDescripcion() + ", Chispas de chocolate";
    }

    /**
     * Este metodo del costo del helado con chispas de chocolate
     * @return Devuelve el costo del helado con chispas de chocolate
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
        System.out.println("-> Añadiendo ingrediente: Chispas de chocolate");
    }
}
