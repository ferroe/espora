package mx.unam.fciencias.espora.practica2;

/**
 * Clase para PizzaHawaiana
 * 
 * Esta clase representa a una pizza hawaiana.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PizzaHawaiana extends Pizza {
    
    /**
     * Constructor de la clase que representa las características de una pizza hawaiana.
     */
    public PizzaHawaiana() {
        super(3,"Hawaiana", "Pizza con jamón, piña y queso", 180.00);
    }

    /**
     * Método que indica que se está colocando queso mozzarella en la pizza.
     */
    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso mozzarella...");
    }

    /**
     * Método que indica que se está colocando jamón en la pizza.
     */
    @Override
    public void colocarProteina() {
        System.out.println("Colocando jamón...");
    }
}
