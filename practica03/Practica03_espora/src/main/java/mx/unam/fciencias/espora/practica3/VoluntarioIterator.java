package mx.unam.fciencias.espora.practica3;

/**
 * Clase VoluntarioIterator que implementa a Iterator.
 * 
 * Esta clase recorre el arreglo de Voluntario.
 * 
 * @author Equipo Espora
 * @version 1.0
 */
public class VoluntarioIterator implements Iterator{

    private Voluntario[] voluntarios;

    private int indice = 0;

    /**
     * Método constructor que recibe el arreglo a recorrer.
     * @param voluntarios Son los ninjas voluntarios
     */
    public VoluntarioIterator(Voluntario[] voluntarios) {
        this.voluntarios = voluntarios;
    }

    /**
     * Nos indica si el indice aun esta dentro del limite del arreglo
     * @return false cuando no hay mas elementos, true si hay mas elementos.
     */
    @Override
    public boolean hasNext() {
        if (indice >= voluntarios.length || voluntarios[indice] == null) {
            return false;
        } else {
            return true;
        }
    }   
    /**
     * Da el voluntario en la posicion actual y luego lo incrementa.
     * @return El siguiente object Voluntario.
     */
    @Override
    public Object next() {
        Voluntario voluntario = voluntarios[indice];
        indice++;
        return voluntario;
    }
}
