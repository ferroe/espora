package mx.unam.fciencias.espora.practica1;
import java.util.LinkedList;
import java.util.List;

public class Memeflix implements Sujeto {
    
    private LinkedList<Cliente> clientes;
    private List<String> recomendaciones;

    public Memeflix() {
        this.clientes = new LinkedList<>();
        this.recomendaciones = new LinkedList<>();
        recomendaciones.add("Tu recomendación del mes es: Sin senos sí hay paraíso");
        recomendaciones.add("Tu recomendación del mes es: La buena mala madre");
        recomendaciones.add("Tu recomendación del mes es: Sing ven y canta");
        recomendaciones.add("Tu recomendación del mes es: Si la vida te da mandarinas");
        recomendaciones.add("Tu recomendación del mes es: Wednesday");
        recomendaciones.add("Tu recomendación del mes es: Black Pink The Movie");
        recomendaciones.add("Tu recomendación del mes es: Parásitos");
        recomendaciones.add("Tu recomendación del mes es: Princesa Mononoke");
        recomendaciones.add("Tu recomendación del mes es: El increíble castillo vagabundo");
        recomendaciones.add("Tu recomendación del mes es: Los increíbles");
        recomendaciones.add("Tu recomendación del mes es: Jefe en pañales");
        recomendaciones.add("Tu recomendación del mes es: Shrek");
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
