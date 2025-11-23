package mx.unam.fciencias.espora.proyecto2.controlador;

import mx.unam.fciencias.espora.proyecto2.vista.XochilotitoUI;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;

public class SimuladorControlador implements SimuladorControladorInterfaz {

    private EcosistemaInterfaz modelo;
    private XochilotitoUI vistaPrincipal;

    // El Controlador es "inyectado" con el Modelo y la Vista principal
    public SimuladorControlador(EcosistemaInterfaz modelo, XochilotitoUI vistaPrincipal) {
        this.modelo = modelo;
        this.vistaPrincipal = vistaPrincipal;
    }

    // --- MÉTODOS DE NAVEGACIÓN ---

    /**
     * La Vista (ej. TableroZonas) llama a esto cuando se hace clic en una zona.
     */
    public void solicitarNavegacionADetalle(String nombreZona) {
        // Aquí puedes agregar lógica, ej. cargar datos en el modelo
        
        // 1. Llama a la Vista Principal para que cambie la escena
        vistaPrincipal.navegarAVistaDetalle(nombreZona);
    }

    /**
     * La Vista (ej. VistaZonaDetalle) llama a esto para volver.
     */
    public void solicitarNavegacionATablero() {
        vistaPrincipal.navegarATablero();
    }
    
    // --- MÉTODOS DE ACCIÓN DEL USUARIO ---

    /**
     * La Vista (ej. VistaZonaDetalle) llama a esto cuando se presiona un botón.
     */
    public void manejarAccionRestaurarFlora(String nombreZona) {
        System.out.println("Acción: Restaurar flora en " + nombreZona);
        
        // Aquí llamarías al método del modelo en el futuro:
        // modelo.restaurarFlora(nombreZona);
        
        // Por ahora, para probar que el Observer funciona, forzamos un tick:
        modelo.simularPasoDelTiempo();
    }

    @Override
    public void limpiarZona(String nombreZona) {
        modelo.limpiarZona(nombreZona);
        modelo.simularPasoDelTiempo();
    }

    @Override
    public void repoblarAjolotes(String nombreZona) {
        modelo.repoblarEspecie(nombreZona, "Ajolote");
        modelo.simularPasoDelTiempo();
    }

    @Override
    public void restaurarFlora(String nombreZona) {
        modelo.restaurarFlora(nombreZona);
        modelo.simularPasoDelTiempo();
    }

    @Override
    public void tirarBasura(String nombreZona) {
        modelo.tirarBasura(nombreZona);
        modelo.simularPasoDelTiempo();
    }

    @Override
    public void introducirTilapias(String nombreZona) {
        modelo.introducirInvasoras(nombreZona);
        modelo.simularPasoDelTiempo();
    }
}
