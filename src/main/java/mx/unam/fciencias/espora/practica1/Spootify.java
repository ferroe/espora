package mx.unam.fciencias.espora.practica1;
import java.util.LinkedList;
import java.util.List;

public class Spootify implements Sujeto {

    private LinkedList<Cliente> clientes;
    private List<String> recomendaciones;

    public Spootify() {
        this.clientes = new LinkedList<>();
        this.recomendaciones = new LinkedList<>();
        recomendaciones.add("Tu recomendación del mes es: Álbum: Eyes Wide Open- Twice");
        recomendaciones.add("Tu recomendación del mes es: Artista: Taylor Swift");
        recomendaciones.add("Tu recomendación del mes es: Canción: I love you- Billie Eilish");
        recomendaciones.add("Tu recomendación del mes es: Podcast: Las Alucines");
        recomendaciones.add("Tu recomendación del mes es: Álbum: Map of the Soul: 7- BTS");
        recomendaciones.add("Tu recomendación del mes es: Artista: Bad Bunny");
        recomendaciones.add("Tu recomendación del mes es: Canción: Earthquake- Jisoo");
        recomendaciones.add("Tu recomendación del mes es: Podcast: Entiende tu mente");
        recomendaciones.add("Tu recomendación del mes es: Álbum: 5-Star- Stray Kids");
        recomendaciones.add("Tu recomendación del mes es: Artista: Wonstein");
        recomendaciones.add("Tu recomendación del mes es: Canción: Mago- G-Friend");
        recomendaciones.add("Tu recomendación del mes es: Podcast: Radio Ambulante");
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
