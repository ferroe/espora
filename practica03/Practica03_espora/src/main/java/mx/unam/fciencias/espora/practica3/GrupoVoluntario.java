package mx.unam.fciencias.espora.practica3;

/**
 * Clase que representa al GrupoVoluntario que implementa a Coleccion.
 * 
 * Se tiene un constructor con los 5 ninjas voluntarios requeridos, y se usa 
 * Coleccion para tener su propio iterador.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class GrupoVoluntario implements Coleccion {

    private Voluntario[] voluntarios;

    /**
     * Constructor de GrupoVoluntario con los Ninjas voluntarios.
     */
    public GrupoVoluntario() {
        voluntarios = new Voluntario[5];

        voluntarios[0] = new Voluntario("Isaac", 35, "Mortalika", "Chunin", 6);
        voluntarios[1] = new Voluntario("Alfredo", 19, "Naca", "Genin", 4);
        voluntarios[2] = new Voluntario("Virginia", 50, "Osomaki", "Jonin", 5);
        voluntarios[3] = new Voluntario("Fernando", 20, "Fuchiha", "Chunin", 5);
        voluntarios[4] = new Voluntario("Janeth", 21, "Akipichi", "Jonin", 6);
    }

    /**
     * Método de la interfaz Colleccion.
     * @return el iterador de Voluntarios.
     */
    @Override
    public Iterator crearIterador() {
        return new VoluntarioIterator(voluntarios);
    }   
}
