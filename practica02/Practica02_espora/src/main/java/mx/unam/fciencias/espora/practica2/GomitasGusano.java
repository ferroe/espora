package mx.unam.fciencias.espora.practica2;

/**
 * Clase para GomitasGusano
 * 
 * Esta clase representa a las gomitas de gusano de ingredientes extra 
 * con sus atributos y métodos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class GomitasGusano extends IngredienteDecorador {
    
    private Helado helado;

    /**
     * Constructor de la clase GomitasGusano.
     * @param helado La base del helado que tendrá ingredientes extra.
     */
    public GomitasGusano(Helado helado) {
        this.helado = helado;
    }

    /**
     * Este metodo obtiene la descripcion del helado.
     * @return Devuelve la descripcion del helado con gomitas de gusano.
     */
    public String getDescripcion() {
        return helado.getDescripcion() + ", Gomitas de Gusano";
    }

    /**
     * Este metodo del costo del helado con gomitas de gusano.
     * @return Devuelve el costo del helado con gomitas de gusano.
     */
    public double costo() {
        return 10.00 + helado.costo();
    }

    @Override
    public void preparar() {
        helado.preparar();        
        System.out.println("-> Añadiendo ingrediente: Gomitas de Gusano");
    }
}
