package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControlador;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaLoader;

/**
 *
 * Aplicacion JavaFX que inicia la interfaz del simulador Xochilotito.
 * Crea modelo, controlador y vistas principales.
 *
 */
public class XochilotitoUI extends Application {

    private Stage primaryStage;
    private Scene escenaTablero;
    private Scene escenaDetalle;
    private VistaZonaDetalle detalleView;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        EcosistemaInterfaz ecosistema = EcosistemaLoader.cargarDefault();

        SimuladorControlador controlador = new SimuladorControlador(ecosistema, this);

        TableroZonas tableroView = new TableroZonas(controlador, ecosistema);
        detalleView = new VistaZonaDetalle(controlador, ecosistema);

        escenaTablero = new Scene(tableroView, 800, 600);
        escenaDetalle = new Scene(detalleView, 800, 600);

        primaryStage.setTitle("Xochilotito - Simulador");
        primaryStage.setScene(escenaTablero);
        primaryStage.show();
    }

    /**
     * Navega a la vista de detalle y carga los datos de la zona.
     * @param nombreZona Nombre de la zona a mostrar.
     */
    public void navegarAVistaDetalle(String nombreZona) {
        detalleView.cargarDatosZona(nombreZona);
        primaryStage.setScene(escenaDetalle);
    }

    /**
     * Navega de regreso al tablero principal.
     */
    public void navegarATablero() {
        primaryStage.setScene(escenaTablero);
    }

    public static void main(String[] args) {
        launch(args);
    }
}