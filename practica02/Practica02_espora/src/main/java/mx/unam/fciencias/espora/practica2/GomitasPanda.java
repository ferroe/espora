package mx.unam.fciencias.espora.practica2;

/**
 * Clase para GomitasPanda
 * 
 * Esta clase representa a las gomitas panda sus atributos y métodos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class GomitasPanda extends IngredienteDecorador {
    
    private Helado helado;

    /**
     * Constructor de la clase GomitasPanda.
     * @param helado La base del helado que tendrá ingredientes extra.
     */
    public GomitasPanda(Helado helado) {
        this.helado = helado;
    }

    /**
     * Este metodo obtiene la descripcion del helado.
     * @return Devuelve la descripcion del helado con gomitas de panda.
     */
    public String getDescripcion() {
        return helado.getDescripcion() + ", Gomitas de Panda";
    }

    /**
     * Este metodo del costo del helado con gomitas de panda.
     * @return Devuelve el costo del helado con gomitas de panda.
     */
    public double costo() {
        return 10.00 + helado.costo();
    }

    @Override
    public void preparar() {
        helado.preparar();        
        System.out.println("-> Añadiendo ingrediente: Gomitas de Panda");
    }
}
