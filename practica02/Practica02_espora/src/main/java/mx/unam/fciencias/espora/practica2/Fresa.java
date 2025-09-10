package mx.unam.fciencias.espora.practica2;

/**
 * Esta es una clase que representa al sabor Fresa de un helado.
 * La cual extiende de la clase abstracta Helado.
 */
public class HeladoFresa extends Helado {

    /**
     * Método constructor que inicializa a la descripción del helado sabor Fresa.
     */
    public HeladoFresa() {
        descripcion = "Helado sabor Fresa";
    }

    /**
     * Método que devuelve el costo del helado sabor Fresa.
     * @return el costo del helado sabor Fresa.
     */
    @Override
    public double getCosto() {
        return 50.0;
    }
}
    