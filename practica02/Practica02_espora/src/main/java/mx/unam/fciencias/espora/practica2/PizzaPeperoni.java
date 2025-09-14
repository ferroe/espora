package mx.unam.fciencias.espora.practica2;

public class PizzaPeperoni extends Pizza {

    public PizzaPeperoni(){
        super(27, "Pizza de Peperoni", "Pizza con salsa de tomate, queso oaxaca y mucho peperoni", 99.00);
    }

    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso oaxaca...");
    }

    @Override
    public void colocarProteina() {
        System.out.println("Colocando peperoni...");
    }
}
