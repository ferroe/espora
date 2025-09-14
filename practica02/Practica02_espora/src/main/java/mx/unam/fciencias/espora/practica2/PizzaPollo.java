package mx.unam.fciencias.espora.practica2;

public class PizzaPollo extends Pizza {

    public PizzaPollo(){
        super(25, "Pizza de Pollo", "Pizza con salsa verde, queso cotage y pollo", 105.00);
    }

    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso cotage...");
    }

    @Override
    public void colocarProteina() {
        System.out.println("Colocando pollo deshebrado...");
    }
}
