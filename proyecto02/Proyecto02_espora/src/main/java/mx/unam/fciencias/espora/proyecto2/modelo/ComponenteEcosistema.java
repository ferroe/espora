package mx.unam.fciencias.espora.proyecto2.modelo;
/**
 * La interfaz ComponenteEcosistema 
 * de nuestro ecosistema Xochimilco
 * 
 * @author Equipo Espora
 * @version 1.0
 */

public interface ComponenteEcosistema {

    /**
     * Actualiza el estado del componente del ecosistema
     * @param parametro El parametro ambiental 
     */
    public void actualizar(ModeloParametros parametro);

    /**
     * El nombre del componente del ecosistema
     */
    public String getNombre();

    /**
     * La salud del ecosistema
     */
    public double getSalud();

    /**
     * El tamano del ecosistema
     */
    public int getTamanio();

    /**
     * El estado del componente del ecosistema
     */
    public String getEstado();

    /**
     * Pausa la actividad del ecosistema
     */
    public void pausa();

    /**
     * Reanuda la actividad del ecosistema
     */
    public void reanudar();    
}
