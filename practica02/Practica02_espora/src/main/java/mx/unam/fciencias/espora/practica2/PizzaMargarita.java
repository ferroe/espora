package mx.unam.fciencias.espora.practica2;

/**
 * Clase para PizzaMargarita
 * 
 * Esta clase representa a una pizza margarita.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PizzaMargarita extends Pizza {

    /**
     * Constructor de la clase que representa las características de una pizza margarita.
     */
    public PizzaMargarita() {
        super(22,"Margarita", "Pizza con tomate, albahaca y queso parmesano", 150.00);
    }

    /**
     * Método que indica si quiere una pizza vegetariana.
     */
    @Override
    public boolean quierePizzaVegetariana() {
        return true;
    }

    /**
     * Método que indica que se está colocando queso parmesano en la pizza.
     */
    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso parmesano...");
    }

    /**
     * Método que indica que no lleva proteína ya que es vegetariana.
     */
    @Override
    public void colocarProteina() {};
}
