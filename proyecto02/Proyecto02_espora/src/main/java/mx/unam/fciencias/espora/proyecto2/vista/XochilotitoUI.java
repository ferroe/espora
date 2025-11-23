package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControlador;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz; // Interfaz
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaLoader; // Loader

public class XochilotitoUI extends Application {

    private Stage primaryStage;
    private Scene escenaTablero;
    private Scene escenaDetalle;
    private VistaZonaDetalle detalleView;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // 1. Cargar Modelo (Usando Loader e Interfaz)
        EcosistemaInterfaz ecosistema = EcosistemaLoader.cargarDefault();

        // 2. Crear Controlador
        SimuladorControlador controlador = new SimuladorControlador(ecosistema, this);

        // 3. Crear Vistas (Inyectando Controlador e Interfaz del Modelo)
        TableroZonas tableroView = new TableroZonas(controlador, ecosistema);
        detalleView = new VistaZonaDetalle(controlador, ecosistema);

        // 4. Configurar Escenas
        escenaTablero = new Scene(tableroView, 800, 600);
        escenaDetalle = new Scene(detalleView, 800, 600);

        primaryStage.setTitle("Xochilotito - Simulador");
        primaryStage.setScene(escenaTablero);
        primaryStage.show();
    }

    public void navegarAVistaDetalle(String nombreZona) {
        detalleView.cargarDatosZona(nombreZona);
        primaryStage.setScene(escenaDetalle);
    }

    public void navegarATablero() {
        primaryStage.setScene(escenaTablero);
    }

    public static void main(String[] args) {
        launch(args);
    }
}