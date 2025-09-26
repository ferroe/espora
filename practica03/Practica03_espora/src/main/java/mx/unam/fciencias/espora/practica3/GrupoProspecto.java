package mx.unam.fciencias.espora.practica3;

import java.util.Hashtable;

/**
 * Clase que representa al GrupoProspecto que implementa a Coleccion.
 * 
 * Se tiene un constructor con los 10 prospectos requeridos, y se usa 
 * Coleccion para tener su propio iterador.
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public class GrupoProspecto implements Coleccion {

    private Hashtable<String, Prospecto> prospectos;

    /**
     * Método constructor que crea a los Prospectos y le da sus valores.
     */
    public GrupoProspecto() {
        prospectos = new Hashtable<>();

        agregarProspecto(new Prospecto("Ricardo", 19, "Osomaki", 3));
        agregarProspecto(new Prospecto("Pablo", 25, "Mortalika", 1));
        agregarProspecto(new Prospecto("Juan", 14, "Naca", 2));
        agregarProspecto(new Prospecto("Erik", 17, "Akipichi", 3));
        agregarProspecto(new Prospecto("Gael", 12, "Fuchiha", 3));
        agregarProspecto(new Prospecto("Pato", 29, "Akipichi", 2));
        agregarProspecto(new Prospecto("Emanuel", 27, "Mortalika", 1));
        agregarProspecto(new Prospecto("Miky", 10, "Osomaki", 2));
        agregarProspecto(new Prospecto("Emi", 18, "Naca", 2));
        agregarProspecto(new Prospecto("Pedro", 21, "Akipichi", 1));
        agregarProspecto(new Prospecto("Jimmy", 23, "Osomaki", 3));
        agregarProspecto(new Prospecto("Carlitos", 1, "Naca", 1));
    }

    /**
     * Método auxiliar para agregar a los prospectos a la HashTable.
     * @param p Es el objeto Prospecto que se va a agregar a la coleccion.
     */
    private void agregarProspecto(Prospecto p) {
        prospectos.put(p.getNombre(), p);
    }

    /**
     * Método de la interfaz Colleccion.
     * @return el iterador de Prospectos.
     */
    @Override
    public Iterator crearIterador() {
        return new ProspectoIterator(prospectos);
    }   

}
