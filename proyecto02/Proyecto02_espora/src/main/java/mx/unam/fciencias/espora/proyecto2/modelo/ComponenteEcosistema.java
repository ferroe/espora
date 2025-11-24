package mx.unam.fciencias.espora.proyecto2.modelo;

/**
 *
 * Interfaz que representa un componente del ecosistema. Puede ser una zona
 * o una poblacion. Define las operaciones basicas que el arbol de componentes
 * debe soportar.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public interface ComponenteEcosistema {

    /**
     * Actualiza el estado del componente en base a los parametros recibidos.
     * @param parametro Parametros ambientales o de simulacion.
     */
    public void actualizar(ModeloParametros parametro);

    /**
     * Obtiene el nombre del componente.
     * @return Nombre del componente.
     */
    public String getNombre();

    /**
     * Obtiene la salud agregada del componente.
     * @return Valor de salud.
     */
    public double getSalud();

    /**
     * Obtiene el tamanio o escala del componente.
     * @return Tamano en unidades de simulacion.
     */
    public int getTamanio();

    /**
     * Obtiene una descripcion del estado actual del componente.
     * @return Cadena representando el estado.
     */
    public String getEstado();

    /**
     * Pausa la actividad del componente (si aplica).
     */
    public void pausa();

    /**
     * Reanuda la actividad del componente (si aplica).
     */
    public void reanudar();    
}
