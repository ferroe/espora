// Paquete: mx.unam.fciencias.espora.proyecto2.vista
package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControlador;

public class TableroZonas extends GridPane {

    private SimuladorControlador controlador;

    // Cambia el constructor
    public TableroZonas(SimuladorControlador controlador) {
        this.controlador = controlador; // Guarda la referencia
        configurarLayout();
        cargarZonas();
    }

    private void configurarLayout() {
        // Configura el GridPane para que sea un 2x2
        this.setPadding(new Insets(10)); // Espaciado interior
        this.setHgap(10); // Espaciado horizontal entre celdas
        this.setVgap(10); // Espaciado vertical entre celdas
        this.setAlignment(Pos.CENTER);

        // Aquí podrías definir las 4 celdas del 2x2
        // (Aunque se definen solas al añadir los elementos)
    }

    private void cargarZonas() {
        // ¡AQUÍ ESTÁ LA MAGIA!
        // 1. Leemos el Modelo (nuestro Composite)
        // Asumimos que Ecosistema tiene un método para obtener las zonas
        
        // Supongamos que tu `Ecosistema` tiene una raíz `Zona` y esa tiene 4 hijos (las zonas)
        // O si `Ecosistema` mismo tiene las 4 zonas, ajústalo.
        // Vamos a simular que tienes 4 zonas hard-codeadas por ahora:
        
        // TODO: Reemplaza esto con tu lógica real del modelo
        // Por ejemplo: List<ZonaEcosistema> zonas = ecosistema.getXochimilcoRaiz().getHijos();
        // int i = 0; for (ZonaEcosistema zona : zonas) { ... }
        
        // --- Simulación de 4 Zonas ---
        VBox zonaNorte = crearPanelZona("Zona Norte");
        VBox zonaSur = crearPanelZona("Zona Sur");
        VBox zonaEste = crearPanelZona("Zona Este");
        VBox zonaOeste = crearPanelZona("Zona Oeste");
        
        // 2. Colocamos las Vistas (JavaFX) en el GridPane
        this.add(zonaNorte, 0, 0); // Columna 0, Fila 0
        this.add(zonaSur, 1, 0);   // Columna 1, Fila 0
        this.add(zonaEste, 0, 1);  // Columna 0, Fila 1
        this.add(zonaOeste, 1, 1); // Columna 1, Fila 1
    }

    /**
     * Método de ayuda para crear el panel de una zona.
     * Eventualmente, esto debería ser su propia clase (ej. PanelZona.java)
     * y debería recibir un objeto `ZonaEcosistema` (del Modelo).
     */
    private VBox crearPanelZona(String nombreZona) {
        VBox panel = new VBox();
        panel.setPadding(new Insets(15));
        panel.setSpacing(10);
        panel.setAlignment(Pos.CENTER);
        panel.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-background-color: #f4f4f4;");

        Label lblNombre = new Label(nombreZona);
        lblNombre.setFont(new Font("Arial", 20));
        
        Label lblEstado = new Label("Estado: Saludable ✅"); // Placeholder

        panel.getChildren().addAll(lblNombre, lblEstado);

        // Aquí agregamos la navegación a la "Pantalla 2"
        panel.setOnMouseClicked(event -> {
            controlador.solicitarNavegacionADetalle(nombreZona);
        });

        return panel;
    }
}
