package mx.unam.fciencias.espora.practica2;

/**
 * Esta es una clase que representa al sabor Vainilla de un helado.
 * La cual extiende de la clase abstracta Helado.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class HeladoVainilla extends Helado {

    /**
     * Método constructor que inicializa a la descripción del helado sabor Vainilla.
     */
    public HeladoVainilla() {
        descripcion = "Helado sabor Vainilla";
    }

    /**
     * Método que devuelve el costo del helado sabor Vainilla.
     * @return el costo del helado sabor Vainilla.
     */
    @Override
    public double getCosto() {
        return 50.0;
    }
}
