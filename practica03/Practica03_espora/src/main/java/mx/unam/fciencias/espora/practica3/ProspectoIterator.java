package mx.unam.fciencias.espora.practica3;

import java.util.Hashtable;

/**
 * Clase ProspectoIterator que implementa a Iterator.
 * Es el Iterador para la HashTaable de Prospectos.
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class ProspectoIterator implements Iterator{
    
    private java.util.Iterator<Prospecto> iteradorInterno;

    /**
     * Método constructor de ProspectoIterator.
     * @param prospectos Es la HashTable con los prospectos(aspirantes).
     */
    public ProspectoIterator(Hashtable<String, Prospecto> prospectos) {
        this.iteradorInterno = prospectos.values().iterator();
    }

    /**
     * Verifica si hay mas elementos o si ya esta completo.
     */
    @Override
    public boolean hasNext() {
        return iteradorInterno.hasNext();
    }

    /**
     * Pide al iterador interno el siguiente elemento.
     */
    @Override
    public Object next() {
        return iteradorInterno.next();
    }
}
