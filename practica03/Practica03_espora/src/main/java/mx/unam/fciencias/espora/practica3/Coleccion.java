package mx.unam.fciencias.espora.practica3;

/**
 * Interfaz para Coleccion
 * 
 * Esta interfaz obliga a las clases que la implementan a 
 * proporcionar un metodo.
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public interface Coleccion {
    
    /**
     * Crea y devuelve al iterador para la coleccion.
     * @return un objeto de tipo Iterador.
     */
    public Iterator crearIterador();
}
