package mx.unam.fciencias.espora.practica2;

public abstract class Pizza implements Producto {

    /**
     * Atributos de la clase Pizza que representan las caracteristicas de una pizza.
     */
    protected String tipoMasa = "Napolitana";
    protected int idProducto;
    protected String nombrePizza;
    protected String descripcion;
    protected double costo;

    /**
     * Constructor de la clase Pizza
     * 
     * @param idProducto  Identificador del producto.
     * @param nombrePizza Nombre de la pizza.
     * @param descripcion Descripción de la pizza.
     * @param costo       Costo de la pizza.
     */
    public Pizza(int idProducto, String nombrePizza, String descripcion, double costo) {
        this.idProducto = idProducto;
        this.nombrePizza = nombrePizza;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    /**
     * Método template para preparar la pizza.
     * Este método define los pasos para preparar una pizza.
     */
    @Override
    public void preparar() {
        prepararMasa();
        aplanarMasa();
        colocarSalsaDeTomate();
        colocarQueso();
        colocarEspecias();
        if (!quierePizzaVegetariana()) {
            colocarProteina();
        }
        hornear();
        esperarCoccion();
        sacarDelHorno();
        empaquetar();
    }

    /**
     * Método que indica que se está preparando la masa de la pizza.
     */
    public void prepararMasa() {
        System.out.println("Preparando la masa estilo: " + this.tipoMasa + "...");
    }

    /**
     * Método que indica que se está aplanando la masa de la pizza.
     */
    public void aplanarMasa() {
        System.out.println("Aplanando la masa de la pizza...");
    }

    /**
     * Método que indica que se está colocando salsa de tomate en la pizza.
     */
    public void colocarSalsaDeTomate() {
        System.out.println("Colocando salsa de tomate...");
    }

    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Indica que tipo de queso se está colocando en la pizza.
     */
    public abstract void colocarQueso();

    /**
     * Método que indica que se están colocando especias en la pizza.
     */
    public void colocarEspecias() {
        System.out.println("Colocando especias...");
    }

    /**
     * Método abstracto que debe ser implementado por las subclases.
     * Indica que tipo de proteína se está colocando en la pizza.
     */
    public abstract void colocarProteina();

    /**
     * Método que indica que se está horneando la pizza.
     */
    public void hornear() {
        System.out.println("Horneando la pizza...");
    }

    /**
     * Método que indica que se está esperando la cocción de la pizza.
     */
    public void esperarCoccion() {
        System.out.println("Esperando a que la pizza se cocine...");
    }

    /**
     * Método que indica que se está sacando la pizza del horno.
     */
    public void sacarDelHorno() {
        System.out.println("Sacando la pizza del horno...");
    }

    /**
     * Método que indica que se está empaquetando la pizza.
     */
    public void empaquetar() {
        System.out.println("Empaquetando la pizza...");
    }

    /**
     * Método que indica si la pizza es vegetariana.
     * Por defecto, las pizzas no son vegetarianas.
     *
     * @return false, indicando que la pizza no es vegetariana.
     */
    public boolean quierePizzaVegetariana() {
        return false;
    }

    /**
     * Método que devuelve la información de la pizza para el ticket.
     *
     * @return Nombre de la pizza.
     */
    @Override
    public String getInfoTicket() {
        return this.nombrePizza;
    }

    /**
     * Método que devuelve el costo de la pizza.
     *
     * @return Costo de la pizza.
     */
    @Override
    public double costo() {
        return this.costo;
    }

    /**
     * Método para que el cliente pueda elegir el tipo de masa de su pizza.
     *
     * @return El tipo de masa elegido.
     */
    public void setTipoMasa(String tipoMasa) {
        this.tipoMasa = tipoMasa;
    }
}
