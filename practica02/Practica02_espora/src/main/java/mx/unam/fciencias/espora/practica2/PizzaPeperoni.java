package mx.unam.fciencias.espora.practica2;

/**
 * Clase para PizzaPeperoni
 * 
 * Esta clase representa a una pizza de peperoni.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PizzaPeperoni extends Pizza {

    /**
     * Constructor de la clase que representa las características de una pizza de peperoni.
     */
    public PizzaPeperoni(){
        super(27, "Pizza de Peperoni", "Pizza con salsa de tomate, queso oaxaca y mucho peperoni", 99.00);
    }

    /**
     * Método que indica que se está colocando queso oaxaca en la pizza.
     */
    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso oaxaca...");
    }

    /**
     * Método que indica que se está colocando peperoni en la pizza.
     */
    @Override
    public void colocarProteina() {
        System.out.println("Colocando peperoni...");
    }
}
