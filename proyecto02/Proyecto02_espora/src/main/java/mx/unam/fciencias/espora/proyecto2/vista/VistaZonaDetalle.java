package mx.unam.fciencias.espora.proyecto2.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import mx.unam.fciencias.espora.proyecto2.controlador.SimuladorControladorInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.EcosistemaInterfaz;
import mx.unam.fciencias.espora.proyecto2.modelo.ZonaEcosistema;

public class VistaZonaDetalle extends BorderPane {

    private SimuladorControladorInterfaz controlador;
    private EcosistemaInterfaz ecosistema;
    private Label lblNombreZona;
    private PanelEspecie panelEspecies;

    public VistaZonaDetalle(SimuladorControladorInterfaz controlador, EcosistemaInterfaz ecosistema) {
        this.controlador = controlador;
        this.ecosistema = ecosistema;
        
        // Cargar CSS
        this.getStylesheets().add(getClass().getResource("/estilos/detalle.css").toExternalForm());

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // --- TOP (Header) ---
        VBox topBox = new VBox(15);
        topBox.setPadding(new Insets(20, 30, 10, 30)); // Márgenes
        
        Button btnVolver = new Button("← Volver");
        btnVolver.getStyleClass().add("boton-volver");
        btnVolver.setOnAction(e -> controlador.solicitarNavegacionATablero());
        
        lblNombreZona = new Label("Cargando...");
        lblNombreZona.getStyleClass().add("titulo-zona");
        
        topBox.getChildren().addAll(btnVolver, lblNombreZona);
        this.setTop(topBox);

        // --- CENTER (Especies) ---
        panelEspecies = new PanelEspecie(ecosistema);
        this.setCenter(panelEspecies);

        // --- RIGHT (Panel de Control) ---
        crearPanelLateral();
    }

    private void crearPanelLateral() {
        VBox panelLateral = new VBox(15);
        panelLateral.getStyleClass().add("panel-lateral");
        panelLateral.setPrefWidth(300);
        
        // Margen externo para que no pegue con el borde
        BorderPane.setMargin(panelLateral, new Insets(10, 30, 30, 10));

        Label lblTitulo = new Label("Panel de Control");
        lblTitulo.getStyleClass().add("subtitulo-seccion");

        // Botones con iconos (simulados con emoji) y clases CSS
        Button btnBasura = crearBoton("🗑️ Tirar Basura", "btn-rojo");
        btnBasura.setOnAction(e -> controlador.tirarBasura(lblNombreZona.getText()));

        Button btnTilapias = crearBoton("🐟 Introducir Tilapias", "btn-naranja");
        btnTilapias.setOnAction(e -> controlador.introducirTilapias(lblNombreZona.getText()));

        Button btnLimpiar = crearBoton("✨ Limpiar Zona", "btn-azul");
        btnLimpiar.setOnAction(e -> controlador.limpiarZona(lblNombreZona.getText()));

        Button btnRepoblar = crearBoton("❤️ Repoblar Ajolotes", "btn-morado");
        btnRepoblar.setOnAction(e -> controlador.repoblarAjolotes(lblNombreZona.getText()));

        Button btnFlora = crearBoton("🌿 Restaurar Flora", "btn-verde");
        btnFlora.setOnAction(e -> controlador.restaurarFlora(lblNombreZona.getText()));

        panelLateral.getChildren().addAll(
            lblTitulo, 
            btnBasura, btnTilapias, // Malos
            btnLimpiar, btnRepoblar, btnFlora // Buenos
        );
        
        this.setRight(panelLateral);
    }

    private Button crearBoton(String texto, String claseCss) {
        Button btn = new Button(texto);
        btn.getStyleClass().addAll("boton-accion", claseCss);
        btn.setMaxWidth(Double.MAX_VALUE);
        return btn;
    }

    public void cargarDatosZona(String nombreZona) {
        this.lblNombreZona.setText(nombreZona);
        ZonaEcosistema zona = ecosistema.buscarZona(nombreZona);
        if (zona != null) {
            panelEspecies.setZonaObjetivo(zona);
        }
    }
}