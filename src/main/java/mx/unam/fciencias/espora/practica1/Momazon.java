package mx.unam.fciencias.espora.practica1;
import java.util.LinkedList;
import java.util.List;

public class Momazon implements Sujeto {

    private LinkedList<Cliente> clientes;
    private List<String> recomendaciones;

    public Momazon() {
        this.clientes = new LinkedList<>();
        this.recomendaciones = new LinkedList<>();
        recomendaciones.add("Tu recomendación del mes es: Yo soy Betty, la fea");
        recomendaciones.add("Tu recomendación del mes es: Fear the Walking Dead");
        recomendaciones.add("Tu recomendación del mes es: El Buen Doctor");
        recomendaciones.add("Tu recomendación del mes es: A él no le gustas tanto");
        recomendaciones.add("Tu recomendación del mes es: Chespirito");
        recomendaciones.add("Tu recomendación del mes es: Terrifier 3");
        recomendaciones.add("Tu recomendación del mes es: Mentiras la serie");
        recomendaciones.add("Tu recomendación del mes es: 2012");
        recomendaciones.add("Tu recomendación del mes es: El que no gana no ama");
        recomendaciones.add("Tu recomendación del mes es: Newtopia");
        recomendaciones.add("Tu recomendación del mes es: Remi");
        recomendaciones.add("Tu recomendación del mes es: El diario de una princesa");
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

    /**
     * Este método notifica a todos los observadores que están registrados.
     */
    public void notificar() { 
        for (Cliente cliente : clientes) {
            cliente.actualizar(this, getRecomendacion());
        }
    }

    public String getRecomendacion() {
        for(int i=0; i<recomendaciones.size(); i++){
            return recomendaciones.get(i);
        }
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }
}
