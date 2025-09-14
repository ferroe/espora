package mx.unam.fciencias.espora.practica2;

public class PizzaSalchicha extends Pizza {

    public PizzaSalchicha(){
        super(21, "Pizza de Salchicha", "Pizza con aderezo, queso manchego y salchicha", 110.00);
    }

    @Override
    public void colocarQueso() {
        System.out.println("Colocando queso manchego...");
    }

    @Override
    public void colocarProteina() {
        System.out.println("Colocando salchicha...");
    }
}
