package mx.unam.fciencias.espora.practica2;

public class PizzaMargarita extends Pizza {

    public PizzaMargarita() {
        super(22,"Margarita", "Pizza con tomate, albahaca y queso parmesano", 150.00);
    }

    @Override
    public boolean quierePizzaVegetariana() {
        return true;
    }

    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso parmesano...");
    }

    @Override
    public void colocarProteina() {};
}
