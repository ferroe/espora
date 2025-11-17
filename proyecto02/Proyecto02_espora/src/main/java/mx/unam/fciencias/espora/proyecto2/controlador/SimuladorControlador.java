package mx.unam.fciencias.espora.proyecto2.controlador;

import mx.unam.fciencias.espora.proyecto2.vista.XochilotitoUI;
import mx.unam.fciencias.espora.proyecto2.modelo.Ecosistema;

public class SimuladorControlador {

    private Ecosistema modelo;
    private XochilotitoUI vistaPrincipal;

    // El Controlador es "inyectado" con el Modelo y la Vista principal
    public SimuladorControlador(Ecosistema modelo, XochilotitoUI vistaPrincipal) {
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
        // 1. Llama al Modelo para que ejecute la lógica
        // modelo.restaurarFlora(nombreZona); 
        // 2. El modelo se actualiza y notifica a los Observadores (la Vista)
    }
}
