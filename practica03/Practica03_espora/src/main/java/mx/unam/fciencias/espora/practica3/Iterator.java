package mx.unam.fciencias.espora.practica3;

/**
 * Interfaz para Iterator
 * 
 * Esta interfaz es la de iterator.
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public interface Iterator {

    /**
     * Verifica si aun hay elementos por recorrer
     * @return true si aun hay elementos, false si ya no hay.
     */
    public boolean hasNext();

    /**
     * Da el siguiente elemento de una coleccion.
     * @return El siguiente elemento.
     */
    public Object next();   
}
