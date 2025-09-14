package mx.unam.fciencias.espora.practica2;

public class PizzaHawaiana extends Pizza {
    
    public PizzaHawaiana() {
        super(3,"Hawaiana", "Pizza con jamón, piña y queso", 180.00);
    }

    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso mozzarella...");
    }

    @Override
    public void colocarProteina() {
        System.out.println("Colocando jamón...");
    }
}
