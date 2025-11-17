// Paquete: mx.unam.fciencias.espora.proyecto2
// (O en el paquete 'view' si lo mueven ahí)
package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mx.unam.fciencias.espora.proyecto2.modelo.Ecosistema;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControlador;
import mx.unam.fciencias.espora.proyecto2.vista.TableroZonas;
import mx.unam.fciencias.espora.proyecto2.vista.VistaZonaDetalle;

// El único cambio es aquí: el nombre de la clase
public class XochilotitoUI extends Application {

    private Stage primaryStage;
    private Scene escenaTablero;
    private Scene escenaDetalle;

    private VistaZonaDetalle detalleView;
    private SimuladorControlador controlador;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // 1. Crear el Modelo
        Ecosistema ecosistema = new Ecosistema(); 
        // TODO: Inicializar el ecosistema con Zonas y Poblaciones
        
        // 2. Crear el Controlador
        controlador = new SimuladorControlador(ecosistema, this);

        // 3. Crear las Vistas y PASARLES el Controlador
        // Esta línea ahora coincide con el constructor de TableroZonas
        TableroZonas tableroView = new TableroZonas(controlador); 
        detalleView = new VistaZonaDetalle(controlador);
        
        escenaTablero = new Scene(tableroView, 800, 600);
        escenaDetalle = new Scene(detalleView, 800, 600);

        primaryStage.setTitle("Xochilotito - Simulador de Ecosistema");
        primaryStage.setScene(escenaTablero); // Empezamos en el tablero
        primaryStage.show();
    }

    /**
     * Cambia la escena para mostrar la Vista de Detalle de una zona.
     */
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