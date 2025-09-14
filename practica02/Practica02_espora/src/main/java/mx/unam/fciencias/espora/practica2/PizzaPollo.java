package mx.unam.fciencias.espora.practica2;

/**
 * Clase para PizzaPollo
 * 
 * Esta clase representa a una pizza de pollo.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PizzaPollo extends Pizza {

    /**
     * Constructor de la clase que representa las características de una pizza de pollo.
     */
    public PizzaPollo(){
        super(25, "Pizza de Pollo", "Pizza con salsa verde, queso cotage y pollo", 105.00);
    }

    /**
     * Método que indica que se está colocando queso cotage en la pizza.
     */
    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso cotage...");
    }

    /**
     * Método que indica que se está colocando pollo deshebrado en la pizza.
     */
    @Override
    public void colocarProteina() {
        System.out.println("Colocando pollo deshebrado...");
    }
}
