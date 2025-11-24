package mx.unam.fciencias.espora.proyecto2.controlador;

import mx.unam.fciencias.espora.proyecto2.vista.XochilotitoUI;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;

/**
 *
 * Implementacion basica del controlador del simulador. Se encarga de
 * coordinar la navegacion entre vistas y delegar acciones del usuario
 * hacia el modelo del ecosistema.
 *
 */
public class SimuladorControlador implements SimuladorControladorInterfaz {

    private EcosistemaInterfaz modelo;
    private XochilotitoUI vistaPrincipal;

    /**
     * Crea una instancia del controlador con el modelo y la vista principal.
     * @param modelo Modelo del ecosistema utilizado por el simulador.
     * @param vistaPrincipal Vista principal que controla la navegacion.
     */
    public SimuladorControlador(EcosistemaInterfaz modelo, XochilotitoUI vistaPrincipal) {
        this.modelo = modelo;
        this.vistaPrincipal = vistaPrincipal;
    }

    /**
     * Solicita la navegacion a la vista de detalle para la zona indicada.
     * @param nombreZona Nombre de la zona seleccionada.
     */
    public void solicitarNavegacionADetalle(String nombreZona) {
        vistaPrincipal.navegarAVistaDetalle(nombreZona);
    }

    /**
     * Solicita la navegacion de regreso al tablero principal.
     */
    public void solicitarNavegacionATablero() {
        vistaPrincipal.navegarATablero();
    }
    
    /**
     * Maneja la accion de restaurar la flora en la zona indicada. Por ahora
     * realiza un paso de simulacion para propagar cambios.
     * @param nombreZona Nombre de la zona donde se restaurara la flora.
     */
    public void manejarAccionRestaurarFlora(String nombreZona) {
        System.out.println("Accion: Restaurar flora en " + nombreZona);
        modelo.simularPasoDelTiempo();
    }

    /**
     * Aplica la limpieza en la zona indicada y realiza un paso de simulacion.
     * @param nombreZona Nombre de la zona a limpiar.
     */
    @Override
    public void limpiarZona(String nombreZona) {
        modelo.limpiarZona(nombreZona);
        modelo.simularPasoDelTiempo();
    }

    /**
     * Repuebla ajolotes en la zona indicada y realiza un paso de simulacion.
     * @param nombreZona Nombre de la zona donde repoblar.
     */
    @Override
    public void repoblarAjolotes(String nombreZona) {
        modelo.repoblarEspecie(nombreZona, "Ajolote");
        modelo.simularPasoDelTiempo();
    }

    /**
     * Restaura la flora en la zona indicada y realiza un paso de simulacion.
     * @param nombreZona Nombre de la zona cuya flora se restaura.
     */
    @Override
    public void restaurarFlora(String nombreZona) {
        modelo.restaurarFlora(nombreZona);
        modelo.simularPasoDelTiempo();
    }

    /**
     * Simula tirar basura en la zona indicada y realiza un paso de simulacion.
     * @param nombreZona Nombre de la zona donde se tira basura.
     */
    @Override
    public void tirarBasura(String nombreZona) {
        modelo.tirarBasura(nombreZona);
        modelo.simularPasoDelTiempo();
    }

    /**
     * Simula la introduccion de tilapias en la zona indicada.
     * @param nombreZona Nombre de la zona donde se introducen tilapias.
     */
    @Override
    public void introducirTilapias(String nombreZona) {
        modelo.introducirInvasoras(nombreZona);
        modelo.simularPasoDelTiempo();
    }
}
