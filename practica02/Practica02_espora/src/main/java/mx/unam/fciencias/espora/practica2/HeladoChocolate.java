package mx.unam.fciencias.espora.practica2;

/**
 * Esta es una clase que representa al sabor Chocolate de un helado.
 * La cual extiende de la clase abstracta Helado.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class HeladoChocolate extends Helado {

    /**
     * Método constructor que inicializa a la descripción del helado sabor Chocolate.
     */
    public HeladoChocolate() {
        descripcion = "Helado sabor Chocolate";
    }

    /**
     * Método que devuelve el costo del helado sabor Chocolate.
     * @return el costo del helado sabor Chocolate.
     */
    @Override
    public double costo() {
        return 50.0;
    }

    @Override
    public String getInfoTicket() {
        return getDescripcion() + " $" + costo();
    }
}
