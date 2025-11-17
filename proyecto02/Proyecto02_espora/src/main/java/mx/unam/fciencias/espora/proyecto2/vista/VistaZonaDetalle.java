// Paquete: mx.unam.fciencias.espora.proyecto2.vista
package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControlador;

public class VistaZonaDetalle extends BorderPane {

    private SimuladorControlador controlador;

    // Componentes de la UI
    private Label lblNombreZona;
    private Button btnVolver;
    private VBox panelEspecies; // Panel "Efecto" (Izquierda)
    private VBox panelAcciones;

    // Botones de acción
    private Button btnTirarBasura;
    private Button btnRestaurarFlora;
    // ... (aquí irían todos los demás botones)

    /**
     * Constructor que inyecta el Controlador.
     * @param controlador El controlador principal de la aplicación.
     */
    public VistaZonaDetalle(SimuladorControlador controlador) {
        this.controlador = controlador;
        
        inicializarComponentes();
        configurarLayout();
        conectarEventos();
    }

    /**
     * Crea todas las instancias de los componentes de la UI.
     */
    private void inicializarComponentes() {
        // Título y botón de volver
        lblNombreZona = new Label("Cargando...");
        lblNombreZona.setFont(new Font("Arial", 24));
        btnVolver = new Button("← Volver al Tablero");

        // Panel Izquierdo ("Efecto" - tus Observadores)
        // TODO: Este panel debería ser una clase separada (PanelEspecies)
        panelEspecies = new VBox(new Label("Aquí irá la lista de especies (Efecto)"));
        panelEspecies.setPadding(new Insets(10));
        panelEspecies.setSpacing(8);

        // Panel Derecho ("Causa" - tus acciones)
        // TODO: Este panel debería ser una clase separada (PanelAcciones)
        btnTirarBasura = new Button("Tirar Basura");
        btnRestaurarFlora = new Button("Restaurar Flora Acuática");
        
        panelAcciones = new VBox(
            new Label("Acciones de Zona (Causa):"),
            btnTirarBasura,
            btnRestaurarFlora
        );
        panelAcciones.setPadding(new Insets(10));
        panelAcciones.setSpacing(8);
    }

    /**
     * Organiza los componentes en el layout principal (BorderPane).
     */
    private void configurarLayout() {
        // Contenedor superior para el título y el botón de volver
        VBox topContainer = new VBox(btnVolver, lblNombreZona);
        topContainer.setSpacing(10);
        topContainer.setPadding(new Insets(10));
        topContainer.setAlignment(Pos.CENTER_LEFT);

        this.setTop(topContainer);
        this.setLeft(panelEspecies);
        this.setRight(panelAcciones);
    }

    /**
     * Conecta los eventos de la UI (clics) a los métodos del Controlador.
     * Aquí es donde la Vista le habla al Controlador.
     */
    private void conectarEventos() {
        // 1. Navegación
        btnVolver.setOnAction(event -> {
            controlador.solicitarNavegacionATablero();
        });

        // 2. Acciones
        btnRestaurarFlora.setOnAction(event -> {
            String zonaActual = lblNombreZona.getText();
            controlador.manejarAccionRestaurarFlora(zonaActual);
        });

        btnTirarBasura.setOnAction(event -> {
            String zonaActual = lblNombreZona.getText();
            // TODO: Crear este método en el SimuladorControlador
            // controlador.manejarAccionTirarBasura(zonaActual);
            System.out.println("Acción: Tirar basura en " + zonaActual);
        });
    }

    /**
     * Método público llamado por el Controlador para actualizar esta vista
     * con los datos de la zona seleccionada.
     */
    public void cargarDatosZona(String nombreZona) {
        lblNombreZona.setText(nombreZona);
        
        // TODO:
        // Aquí es donde le pediríamos al Modelo (a través del Controlador)
        // los datos de esta zona para actualizar el 'panelEspecies'.
        // Por ahora, solo actualizamos el título.
    }
}   
