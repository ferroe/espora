package mx.unam.fciencias.espora.proyecto2.controlador;

/**
 *
 * Interfaz que define las operaciones que el controlador del simulador
 * debe exponer a la vista para manejar la navegacion y las acciones sobre
 * las zonas del ecosistema.
 *
 * @author Equipo Espora
 * @version 1.0
 */
public interface SimuladorControladorInterfaz {

    /**
     * Solicita la navegacion a la vista de detalle de una zona.
     * @param nombreZona Nombre de la zona a mostrar en detalle.
     */
    void solicitarNavegacionADetalle(String nombreZona);

    /**
     * Solicita la navegacion de regreso al tablero principal.
     */
    void solicitarNavegacionATablero();

    /**
     * Limpia la zona indicada, aplicando acciones de conservacion.
     * @param nombreZona Nombre de la zona a limpiar.
     */
    void limpiarZona(String nombreZona);

    /**
     * Repuebla la zona indicada con ajolotes.
     * @param nombreZona Nombre de la zona donde repoblar.
     */
    void repoblarAjolotes(String nombreZona);

    /**
     * Restaura la flora de la zona indicada.
     * @param nombreZona Nombre de la zona cuya flora se restaura.
     */
    void restaurarFlora(String nombreZona);

    /**
     * Simula tirar basura en la zona indicada, causando deterioro.
     * @param nombreZona Nombre de la zona donde se tira basura.
     */
    void tirarBasura(String nombreZona);

    /**
     * Simula la introduccion de tilapias en la zona indicada.
     * @param nombreZona Nombre de la zona donde se introducen tilapias.
     */
    void introducirTilapias(String nombreZona);
}