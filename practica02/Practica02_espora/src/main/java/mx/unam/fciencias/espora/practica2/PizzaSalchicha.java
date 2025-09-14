package mx.unam.fciencias.espora.practica2;

/**
 * Clase para PizzaSalchicha
 * 
 * Esta clase representa a una pizza de salchicha.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class PizzaSalchicha extends Pizza {

    /**
     * Constructor de la clase que representa las características de una pizza de salchicha.
     */
    public PizzaSalchicha(){
        super(21, "Pizza de Salchicha", "Pizza con aderezo, queso manchego y salchicha", 110.00);
    }

    /**
     * Método que indica que se está colocando queso manchego en la pizza.
     */
    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso manchego...");
    }

    /**
     * Método que indica que se está colocando salchicha en la pizza.
     */
    @Override
    public void colocarProteina() {
        System.out.println("Colocando salchicha...");
    }
}
