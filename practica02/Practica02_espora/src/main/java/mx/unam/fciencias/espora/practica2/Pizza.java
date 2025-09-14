package mx.unam.fciencias.espora.practica2;

public abstract class Pizza {

    protected int idProducto;
    protected String nombrePizza;
    protected String descripcion;
    protected double precio;

    public Pizza(int idProducto, String nombrePizza, String descripcion, double precio) {
        this.idProducto = idProducto;
        this.nombrePizza = nombrePizza;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void prepararPizza() {
        prepararMasa();
        aplanarMasa();
        colocarSalsaDeTomate();
        colocarQueso();
        colocarEspecias();
        if (!QuierePizzaVegetariana()) {
            colocarProteina();
        }
        hornear();
        esperarCoccion();
        sacarDelHorno();
        empaquetar();
    }

    public void prepararMasa() {
        System.out.println("Preparando la masa de la pizza...");
    }

    public void aplanarMasa() {
        System.out.println("Aplanando la masa de la pizza...");
    }

    public void colocarSalsaDeTomate() {
        System.out.println("Colocando salsa de tomate...");
    }

    public abstract void colocarQueso();

    public void colocarEspecias() {
        System.out.println("Colocando especias...");
    }

    public abstract void colocarProteina();

    public void hornear() {
        System.out.println("Horneando la pizza...");
    }

    public void esperarCoccion() {
        System.out.println("Esperando a que la pizza se cocine...");
    }

    public void sacarDelHorno() {
        System.out.println("Sacando la pizza del horno...");
    }

    public void empaquetar() {
        System.out.println("Empaquetando la pizza...");
    }

    public boolean QuierePizzaVegetariana() {
        return false;
    }
}
