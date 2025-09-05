package mx.unam.fciencias.espora.practica1;
import java.util.LinkedList;
import java.util.List;

public class Hvo implements Sujeto {

    private LinkedList<Cliente> clientes;
    private List<String> recomendaciones;

    public Hvo() {
        this.clientes = new LinkedList<>();
        this.recomendaciones = new LinkedList<>();
        recomendaciones.add("Tu recomendación del mes es: El Conjuro");
        recomendaciones.add("Tu recomendación del mes es: El Conjuro 2");
        recomendaciones.add("Tu recomendación del mes es: El Conjuro 3");
        recomendaciones.add("Tu recomendación del mes es: El Conjuro 4");
        recomendaciones.add("Tu recomendación del mes es: Anabelle");
        recomendaciones.add("Tu recomendación del mes es: Anabelle 2 La creación");
        recomendaciones.add("Tu recomendación del mes es: Anabelle 3 Vuelve a casa");
        recomendaciones.add("Tu recomendación del mes es: La Monja");
        recomendaciones.add("Tu recomendación del mes es: La Monja 2");
        recomendaciones.add("Tu recomendación del mes es: Rec");
        recomendaciones.add("Tu recomendación del mes es: Rec 2");
        recomendaciones.add("Tu recomendación del mes es: Rec 3 Génesis");
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
