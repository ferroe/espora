package mx.unam.fciencias.espora.practica1;
import java.util.LinkedList;
import java.util.List;

public class Thisney implements Sujeto {

    private LinkedList<Cliente> clientes;
    private List<String> recomendaciones;

    public Thisney() {
        this.clientes = new LinkedList<>();
        this.recomendaciones = new LinkedList<>();

        recomendaciones.add("Tu recomendación del mes es: Frozen");
        recomendaciones.add("Tu recomendación del mes es: Intensamente");
        recomendaciones.add("Tu recomendación del mes es: La Bella y la Bestia");
        recomendaciones.add("Tu recomendación del mes es: Dumbo");
        recomendaciones.add("Tu recomendación del mes es: Coco");
        recomendaciones.add("Tu recomendación del mes es: Elementos");
        recomendaciones.add("Tu recomendación del mes es: Ratatouille");
        recomendaciones.add("Tu recomendación del mes es: Encanto");
        recomendaciones.add("Tu recomendación del mes es: Rápidos y furiosos");
        recomendaciones.add("Tu recomendación del mes es: Avatar");
        recomendaciones.add("Tu recomendación del mes es: Zootopia");
        recomendaciones.add("Tu recomendación del mes es: Los Vengadores");
    }

    /**
     * Este método hace el registro de un observador.
     * @param o El observador el cual se desea registrar.
     */
    public void registrar(Observador o) {
        clientes.add((Cliente) o);
        System.out.println("El cliente " + o + " ha sido registrado.");
    }
    
    /**
     * Este método hace la desuscripción de un observador.
     * @param o El observador el cual se desea desuscribir.
     */
    public void desuscribir(Observador o) {
        clientes.remove((Cliente) o);
        System.out.println("El cliente " + o + " ha sido desuscrito.");
    }

    public void notificar() { 
        for (Cliente cliente : clientes) {
            cliente.actualizar(this,  getRecomendacion());
        }
    }



    public LinkedList<Cliente> getClientes() {
        return clientes;
    }
}
